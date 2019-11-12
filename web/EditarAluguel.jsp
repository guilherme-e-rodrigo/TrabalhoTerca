
<%@page import="model.CArmazem"%>
<%@page import="dao.ArmazemDAO"%>
<%@page import="model.CUser"%>
<%@page import="dao.UserDAO"%>
<%@page import="dao.UserDAO"%>
<%@page import="java.util.List"%>
<%@page import="model.Aluguel"%>
<%@page import="dao.UserArmazemDAO"%>
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
    Aluguel aluguel = new Aluguel();
    aluguel = (Aluguel) request.getAttribute("aluguel");
    System.out.println("Id:"+aluguel.getId_aluguel());
%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Edicao de Aluguel</title>
        <link rel="stylesheet" type="text/css" href="css/Editar.css">
        <link href="bootstrap/css/bootstrap.min.css" rel="stylesheet" type="text/css"/>
        <script language="JavaScript" src="js/scripts.js"></script>    
    </head>
    <body>
        <div align="center">
            
        <br>
        <br>
        <div class="form">
            <form action="CadAluguel" method="post" >
            <table>
                <tr>   
                    <td> ID:</td> <td>  <input type="text" name="id"  value="<%= aluguel.getId_aluguel()%>"  readonly="true" required  /></td>
                </tr>
                <tr>   
                    <td> Usuario:</td> 
                    <td><select name="usuario">
					<% UserDAO dao = new UserDAO();
                                        List<CUser> users = dao.consulta();
						int x = 0;
                                         for (CUser c : users) {
                                             System.out.println("Usuario : "+c.getNome());
                                             System.out.println("ID : "+c.getId());
					%>
                                        <option value="<%=c.getId()%>"><%=c.getNome()%></option>
					  
					<%} %>
                                        </select><br>
                    </td>
                </tr>
                <tr>
                    <td> Armazem: </td> 
                    <td><select name="armazem">
					<% ArmazemDAO daoA = new ArmazemDAO();
                                        List<CArmazem> armazens = daoA.consulta();
                                         for (CArmazem a : armazens) {
                                             System.out.println("Armazem : "+a.getNome());
                                             System.out.println("ID : "+a.getId());
					%>
                                        <option value="<%=a.getId()%>"><%=a.getNome()%></option>
					  
					<%} %>
                                        </select><br>
                    </td>
                </tr>
                <tr>
                    <td> Data de Aluguel: </td> <td><input type="date" name="dataaluguel" value="<%=aluguel.getDataaluguel()%>"required /></td>
                </tr>
               </table>
            <br>

            <input type="submit"  value="Alterar" name="acao" style="background-color: green" class="button btn-success" />
            <a href="GerenciarAluguel.jsp"> <input type="button" value="Cancelar" style="background-color: red" class="button btn-danger"
        </div>
    </body>
</html>
