# Lista 7 JSP
Pesquisa na base de dados usando a classe HttpServlet;

>

# Ambiente

* JSP
* mySql
* Maven
* Apache Tomcat

>

## Criação da Base de Dados

CREATE DATABASE bdteste;

USE dbteste;

CREATE TABLE `tbproduto` (
  `idProduto` int(11) NOT NULL AUTO_INCREMENT,
  `descricao` varchar(45) NOT NULL,
  `quantidade` int(11) NOT NULL,
  `valor` decimal(6,2) NOT NULL,
  PRIMARY KEY (`idProduto`)
) ;
