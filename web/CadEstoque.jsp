<%@page import="model.CItem"%>
<%@page import="dao.ItemDAO"%>
<%@page import="model.CArmazem"%>
<%@page import="dao.ArmazemDAO"%>
<%@page import="dao.ArmazemDAO"%>
<%@page import="model.CUser"%>
<%@page import="dao.UserDAO"%>
<%@page import="java.util.List"%>
<%@page import="dao.UserArmazemDAO"%>
<%@page import="model.Aluguel"%>

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
		 		<span lang="pt-br">CADASTRE UM REGISTRO DO ESTOQUE</span><br>
		 		
		 		<form method="post" action="CadEstoque">
		 			<span lang="pt-br">ITEM</span><br>
                                        <select name="item">
					<% ItemDAO dao = new ItemDAO();
                                        List<CItem> itens = dao.consulta();
                                         for (CItem i : itens) {
					%>
                                        <option value="<%=i.getId()%>"><%=i.getNome()%></option>
					  
					<%} %>
                                        </select><br>
					<span lang="pt-br">OPERACAO</span><br>
                                        <input type="radio" name="operacao" value="entrada"> Entrada<br>
                                        <input type="radio" name="operacao" value="saida"> Saida<br>
					<span lang="pt-br">QUANTIDADE</span><br>
					<input name="quantidade" type="numeric" style="width: 180px"><br>
                                        <span lang="pt-br">MOTIVO</span><br>
					<input name="motivo" type="numeric" style="width: 180px"><br>
					<input name="acao" type="submit" value="Cadastrar"></form>
                                        <a href="cadastros.html">Voltar</a>
			</article>
		</section>
		
		<footer>
		  	<p>Footer</p>
		</footer>
	
	</body>
</html>
