<%@page import="java.util.List"%>
<%@page import="dao.CategoriaDAO"%>
<%@page import="model.CCategoria"%>

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
		 		<span lang="pt-br">CADASTRE UM ITEM</span><br>
		 		
		 		<form method="post" action="CadItem">
		 			<span lang="pt-br">NOME</span><br>
					<input name="Nome" type="text" style="width: 180px"><br>
					<span lang="pt-br">DESCRICAO</span><br>
					<textarea name="Descricao"></textarea><br>
					<span lang="pt-br">FORMA DE ARMAZENAMENTO</span><br>
					<input name="Armazenamento" type="text" style="width: 180px"><br>
                                        <span lang="pt-br">ID DA CATEGORIA</span><br>
					<select name="categoria">
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
                                        
					<span lang="pt-br">MEDIDAS</span><br>
					<input name="Medidas" type="text" style="width: 180px"><br><br>
					<input name="Submit" type="submit" value="submit"></form>
                                        <a href="cadastros.html">Voltar</a>
			</article>
		</section>
		
		<footer>
		  	<p>Footer</p>
		</footer>
	
	</body>
</html>
