<%@page import="model.CCategoria"%>
<%@page import="dao.CategoriaDAO"%>
<%@page import="java.util.List"%>
<%@page import="model.CArmazem"%>
<%@page import="dao.ArmazemDAO"%>

<!DOCTYPE html>
<html lang="en">
<head>
<title>Open Web Storage</title>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<style>

body {
  font-family: Arial, Helvetica, sans-serif;
}

/* Style the header */
header {
  background-color: #666;
  padding: 10px;
  text-align: left;
  font-size: 35px;
  color: white;
  width: 100%;
}

/* Create two columns/boxes that floats next to each other */
nav {
  float: left;
  width: 30%;
  height: auto; /* only for demonstration, should be removed */
  background: #ccc;
  padding: 20px;
}

/* Style the list inside the menu */
nav ul {
  list-style-type: none;
  padding: 0;
}

article {
  float: left;
  padding: 20px;
  width: 100%;
  background-color: #f1f1f1;
/*  height: 300px; /*only for demonstration, should be removed */
}

/* Clear floats after the columns */
section:after {
  content: "";
  display: table;
  clear: both;
}

/* Style the footer */
footer {
  background-color: #777;
  padding: 10px;
  text-align: center;
  width: 100%;
  color: white;
}

/* Responsive layout - makes the two columns/boxes stack on top of each other instead of next to each other, on small screens */
@media (max-width: 600px) {
  nav, article {
    width: 70%;
 /*   height: auto;*/
  }
}
.auto-style1 {
	/*margin-left: 2px;*/
}
table, th, td {
  border: 1px solid black;
}
a:link, a:visited {
  background-color: #3c3c3c;
  color: white;
  padding: 14px 25px;
  text-align: center;
  text-decoration: none;
  display: inline-block;
}

a:hover, a:active {
  background-color: #3c3c3c;
}
.auto-style2 {
	text-align: center;
}
</style>
</head>
	<body>
	
		<header 				>
	  		<h2 class="auto-style1">CONTROLE DE ESTOQUE BAGOZZI</h2>
		</header>
	
		<section style="height:auto">  
		 	<article class="auto-style2">
		 		<span lang="pt-br">Gerenciar Categorias</span><br>
		 		
	<table class="table table-hover">
      <thead>
          <tr class="bg-info">
         	<th>ID</th>
               <th>Nome</th>
               <th>Descricao</th>
               <th>Editar</th>
               <th>Excluir</th>
                <!--<th>Excluir</th>-->
      </tr>
      <tbody>
          <% CategoriaDAO dao = new CategoriaDAO();
                List<CCategoria> categorias = dao.consulta();
                int x = 0;
                for (CCategoria c : categorias) {
            %>
            
            <form action="CadCategoria" method="Post">
            <tr>
                    <td><%=c.getId()%></td>
                    <td><%=c.getNome()%></td>
                    <td><%=c.getDescricao()%></td>
                        
                       
                    <td><input type="submit" value="Editar" name="acao" class="btn btn-outline-info" > </td>
                    <input type="hidden" name="id_editar" value="<%=c.getId()%>"  id="<%= "id_item"+x%>"  >
                    <td><input type="submit" value="Excluir" name="acao" class="btn btn-outline-info" onclick="return confirmaExcluir('id_item<%= x %>')"> </td>
                    
                    
                    </tr>
            </form>   
       
      </tbody>
      <% x++;}%> 
    </table>
    <a href="gerenciamento.html">Voltar</a>
      </thead>
			</article>
		</section>
		
		<footer>
		  	<p>Footer</p>
		</footer>
	
	</body>
</html>
