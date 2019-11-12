
<%@page import="java.util.List"%>
<%@page import="model.CItem"%>
<%@page import="dao.ItemDAO"%>
<%@page import="model.CEstoque"%>
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
    
    CEstoque estoque = new CEstoque();
    estoque = (CEstoque) request.getAttribute("estoque");
    System.out.println("Id:"+estoque.getId());
%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Edicao de Estoque</title>
        <link rel="stylesheet" type="text/css" href="css/Editar.css">
        <link href="bootstrap/css/bootstrap.min.css" rel="stylesheet" type="text/css"/>
        <script language="JavaScript" src="js/scripts.js"></script>    
    </head>
    <body>
        <div align="center">
            
        <br>
        <br>
        <div class="form">
            <form action="CadEstoque" method="post" >
            <table>
                <tr>   
                    <td> ID:</td> <td>  <input type="text" name="id"  value="<%= estoque.getId()%>"  readonly="true" required  /></td>
                </tr>
                <tr>
                    <td> Item: </td>
                    <td>
                        <input type="text" name="id_item" value="<%=estoque.getId_item()%>">
                        </select>
                    </td>
                </tr>
                <tr>
                    <td>OPERACAO</td><br>
                    <td>
                        <input type="radio" name="operacao" value="entrada"> Entrada<br>
                        <input type="radio" name="operacao" value="saida"> Saida<br></td>
                </tr>
                <tr>   
                    <td> Quantidade:</td> <td>  <input type="text" name="quantidade" value="<%= estoque.getQtd()%>"required  /></td>
                </tr>
                <tr>
                    <td> Motivo: </td> <td><input type="text" name="motivo"  value="<%=estoque.getMotivo()%>" required/></td>
                </tr>
                
               </table>
            <br>

            <input type="submit"  value="Alterar" name="acao" style="background-color: green" class="button btn-success" />
            <a href="GerenciarEstoque.jsp"> <input type="button" value="Cancelar" style="background-color: red" class="button btn-danger"
        </div>
    </body>
</html>
