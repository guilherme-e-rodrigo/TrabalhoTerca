
<%@page import="model.CUser"%>
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
    CUser user = new CUser();
    user = (CUser) request.getAttribute("user");
    System.out.println("Id:"+user.getId());
%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Edicao de usuario</title>
        <link rel="stylesheet" type="text/css" href="css/Editar.css">
        <link href="bootstrap/css/bootstrap.min.css" rel="stylesheet" type="text/css"/>
        <script language="JavaScript" src="js/scripts.js"></script>    
    </head>
    <body>
        <div align="center">
            
        <br>
        <br>
        <div class="form">
            <form action="CadUser" method="post" >
            <table>
                <tr>   
                    <td> ID:</td> <td>  <input type="text" name="id"  value="<%= user.getId()%>"  readonly="true" required  /></td>
                </tr>
                <tr>   
                    <td> Nome:</td> <td>  <input type="text" name="Nome" value="<%= user.getNome()%>"required  /></td>
                </tr>
                <tr>    
                    <td> CPF: </td> <td><input type="text" name="Cpf"  value="<%=user.getCpf()%>" required/></td>
                </tr>
                <tr>
                    <td> Login: </td> <td><input type="text" name="Login"  value="<%=user.getLogin()%>" required/></textarea></td>
                </tr>
                <tr>
                    <td> Senha: </td> <td><input type="text" name="Senha"  value="<%=user.getPassword()%>" required/></textarea></td>
                </tr>
               </table>
            <br>

            <input type="submit"  value="Alterar" name="acao" style="background-color: green" class="button btn-success" />
            <a href="GerenciarCategoria.jsp"> <input type="button" value="Cancelar" style="background-color: red" class="button btn-danger"
        </div>
    </body>
</html>
