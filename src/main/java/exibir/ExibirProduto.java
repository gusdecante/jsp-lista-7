package exibir;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.SQLException;
import java.util.List;

import com.google.gson.Gson;

import dao.ProdutoDao;
import model.Produto;
//import dao.ProdutoDao;

public class ExibirProduto extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        
        /*
        resp.setContentType("text/html");
        resp.setCharacterEncoding("UTF-8");

        PrintWriter saida = resp.getWriter();

        String nome = req.getParameter("nome");

        saida.println("<html>");
        saida.println("<body>");
        saida.println("<p>Teste de Servlet</p>");
        saida.println("</body>");
        saida.println("</html>");

        saida.flush();
        saida.close();
        */

        resp.setContentType("application/json");
        resp.setCharacterEncoding("UTF-8");



        PrintWriter saida = resp.getWriter();
        String algo =(String) req.getParameter("nameForm");
        
        try {
            ProdutoDao dao = new ProdutoDao();
            List<Produto> lstProd = dao.pesquisarProduto(algo);        
            String produtoJsonStr = new Gson().toJson(lstProd);
            saida.println(produtoJsonStr);

        } catch (SQLException e) {
            saida.println("<p>Erro " + e.getMessage() + "</p>");
            
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        //Produto prod = new Produto();
        //prod.setIdProduto(5);
        //prod.setDescricao("Prato de vidro");
        //prod.setQuantidade(10);
        //prod.setValor(15.99);
        //prod.setDescricao((String)request.getParameter("nameForm"));
        //String produtoJsonStr = new Gson().toJson(prod);

        //saida.println(produtoJsonStr);
        //saida.println(algo);

        saida.flush();
        saida.close();
    }
    
}