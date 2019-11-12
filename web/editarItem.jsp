
<%@page import="java.util.List"%>
<%@page import="model.CCategoria"%>
<%@page import="dao.CategoriaDAO"%>
<%@page import="model.CItem"%>
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
    CItem item = new CItem();
    item = (CItem) request.getAttribute("item");
    System.out.println("Id:"+item.getId());
%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Edicao de item</title>
        <link rel="stylesheet" type="text/css" href="css/Editar.css">
        <link href="bootstrap/css/bootstrap.min.css" rel="stylesheet" type="text/css"/>
        <script language="JavaScript" src="js/scripts.js"></script>    
    </head>
    <body>
        <div align="center">
            
        <br>
        <br>
        <div class="form">
            <form action="CadItem" method="post" >
            <table>
                <tr>   
                    <td> ID:</td> <td>  <input type="text" name="id"  value="<%= item.getId()%>"  readonly="true" required  /></td>
                </tr>
                <tr>   
                    <td> Nome:</td> <td>  <input type="text" name="Nome" value="<%= item.getNome()%>"required  /></td>
                </tr>
                <tr>
                    <td> Descricao: </td> <td><input type="text" name="Descricao"  value="<%=item.getDescricao()%>" required/></td>
                </tr>
                <tr>
                    <td> Medida: </td> <td><input type="text" name="Medida" value="<%=item.getMedidas()%>"required /></td>
                </tr>
                <tr>
                    <td> Forma de armazenamento: </td> <td><input type="text" name="Armazenamento" value="<%=item.getForma_armazenamento()%>"required /></td>
                </tr>
                <tr>
                    <td> Categoria: </td> 
                    <td><select name="categoria">
					<% CategoriaDAO dao = new CategoriaDAO();
                                        List<CCategoria> categorias = dao.consulta();
						int x = 0;
                                         for (CCategoria c : categorias) {
                                             System.out.println("Categoria : "+c.getNome());
                                             System.out.println("ID : "+c.getId());
					%>
                                        <option value="<%=c.getId()%>"><%=c.getNome()%></option>
					  
					<%} %>
                                        </select><br>
                    </td>
                </tr>
               </table>
            <br>

            <input type="submit"  value="Alterar" name="acao" style="background-color: green" class="button btn-success" />
            <a href="GerenciarItem.jsp"> <input type="button" value="Cancelar" style="background-color: red" class="button btn-danger"
        </div>
    </body>
</html>
