package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.Produto;
import util.ConexaoBanco;

public class ProdutoDao {

    private Connection con;

    public ProdutoDao() {
        this.con = new ConexaoBanco().getConnection();
    }

    // Cadastro:
    public void cadastrar(Produto p) throws SQLException {
        
        String query;
        query = "INSERT INTO tbproduto (descricao, quantidade, valor) VALUES (?, ?, ?);";

        PreparedStatement st = con.prepareStatement(query);
        st.setString(1, p.getDescricao()  );
        st.setInt   (2, p.getQuantidade() );
        st.setDouble(3, p.getValor()      );

        st.execute();
        st.close();
        con.close();
    }

    public List<Produto> pesquisar() throws SQLException, Exception {
        
        List<Produto> lista = new ArrayList();
        String query = "SELECT * FROM tbproduto";
        
        PreparedStatement st = con.prepareStatement(query);
        
        ResultSet rs = st.executeQuery();
        
        while(rs.next()) {            
            Produto prod = new Produto();
            
            prod.setIdProduto   ( rs.getInt   ("idProduto")  );
            prod.setDescricao   ( rs.getString("descricao")  );
            prod.setQuantidade  ( rs.getInt   ("quantidade") );
            prod.setValor       ( rs.getDouble("valor")      );
            
            lista.add(prod);            
        }   
        return lista;
    }

    public List<Produto> pesquisarProduto(String descricao) throws SQLException, Exception {
        List<Produto> lista = new ArrayList();
        String query = "SELECT * FROM tbproduto WHERE descricao = '" + descricao + "'";
        
        PreparedStatement st = con.prepareStatement(query);
        
        ResultSet rs = st.executeQuery();
        
        while(rs.next()) {            
            Produto prod = new Produto();
            
            prod.setIdProduto   ( rs.getInt   ("idProduto")  );
            prod.setDescricao   ( rs.getString("descricao")  );
            prod.setQuantidade  ( rs.getInt   ("quantidade") );
            prod.setValor       ( rs.getDouble("valor")      );
            
            lista.add(prod);            
        } 
        return lista;
    }
    
}