
<%@page import="model.CArmazem"%>
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
    CArmazem armazem = new CArmazem();
    armazem = (CArmazem) request.getAttribute("armazem");
    System.out.println("Id:"+armazem.getId());
%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Edicao de armazem</title>
        <link rel="stylesheet" type="text/css" href="css/Editar.css">
        <link href="bootstrap/css/bootstrap.min.css" rel="stylesheet" type="text/css"/>
        <script language="JavaScript" src="js/scripts.js"></script>    
    </head>
    <body>
        <div align="center">
            
        <br>
        <br>
        <div class="form">
            <form action="CadArmazem" method="post" >
            <table>
                <tr>   
                    <td> ID:</td> <td>  <input type="text" name="id"  value="<%= armazem.getId()%>"  readonly="true" required  /></td>
                </tr>
                <tr>   
                    <td> Nome:</td> <td>  <input type="text" name="Nome" value="<%= armazem.getNome()%>"required  /></td>
                </tr>
                <tr>
                    <td> Capacidade: </td> <td><input type="text" name="Capacidade"  value="<%=armazem.getCapacidade()%>" required/></td>
                </tr>
                <tr>
                    <td> Localizacao: </td> <td><input type="text   " name="Localizacao" value="<%=armazem.getLocalizacao()%>"required /></td>
                </tr>
               </table>
            <br>

            <input type="submit"  value="Alterar" name="acao" style="background-color: green" class="button btn-success" />
            <a href="GerenciarItem.jsp"> <input type="button" value="Cancelar" style="background-color: red" class="button btn-danger"
        </div>
    </body>
</html>
