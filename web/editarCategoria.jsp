
<%@page import="model.CCategoria"%>
<%@page import="model.CCategoria"%>
<%-- 
    Document   : editar
    Created on : 29/09/2017, 11:31:42
    Author     : Jr
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="javax.servlet.*"%>
<%@page import="javax.servlet.http.*"%>
<link href="bootstrap/css/bootstrap.min.css" rel="stylesheet" type="text/css"/>
<% //estou criando uma variável do mesmo do tipo do atributo 
    CCategoria categoria = new CCategoria();
    categoria = (CCategoria) request.getAttribute("categoria");
    System.out.println("Id:"+categoria.getId());
%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Edicao de categoria</title>
        <link rel="stylesheet" type="text/css" href="css/Editar.css">
        <link href="bootstrap/css/bootstrap.min.css" rel="stylesheet" type="text/css"/>
        <script language="JavaScript" src="js/scripts.js"></script>    
    </head>
    <body>
        <div align="center">
            
        <br>
        <br>
        <div class="form">
            <form action="CadCategoria" method="post" >
            <table>
                <tr>   
                    <td> ID:</td> <td>  <input type="text" name="id"  value="<%= categoria.getId()%>"  readonly="true" required  /></td>
                </tr>
                <tr>   
                    <td> Nome:</td> <td>  <input type="text" name="Nome" value="<%= categoria.getNome()%>"required  /></td>
                </tr>
                <tr>
                    <td> Descricao </td> <td><textarea name="Descricao"  value="<%=categoria.getDescricao()%>" required/></textarea></td>
                </tr>
               </table>
            <br>

            <input type="submit"  value="Alterar" name="acao" style="background-color: green" class="button btn-success" />
            <a href="GerenciarCategoria.jsp"> <input type="button" value="Cancelar" style="background-color: red" class="button btn-danger"
        </div>
    </body>
</html>
