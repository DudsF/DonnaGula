<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
body {
	background-image: url("http://weekon.com.ar/wp-content/uploads/2016/12/biblio-web.jpg");
    background-repeat: no-repeat;
	background-size: 1366px 655px;
}

* {
	box-sizing: border-box;
}

input[type=text], select, textarea {
	width: 90%;
	padding: 12px;
	border: 1px solid #ccc;
	border-radius: 5px;
	resize: vertical;
}
input[type=password], select, textarea {
	width: 90%;
	padding: 12px;
	border: 1px solid #ccc;
	border-radius: 5px;
	resize: vertical;
}
label {
	padding: 12px 12px 12px 0;
	display: inline-block;
}

input[type=submit] {
	background-color: #333;
	color: white;
	padding: 12px 20px;
	border: none;
	border-radius: 4px;
	cursor: pointer;
	float: right;
}

input[type=submit]:hover {
	background-color: LightCoral;
}

.container {
 	position: absolute;
    top: 50%;
    left: 50%;
    width: 45%;
    transform: translateY(-50%) translateX(-50%);
	center;
	border-radius: 5px;
	background-color: #ccc;
	padding: 20px;
}
.centralizado {
	text-align: center;
	margin: 0 auto;
}

.col-25 {
	float: left;
	width: 25%;
	margin-top: 8px;
}

.col-75 {
	float: left;
	width: 70%;
	margin-top: 5px;
}


.row:after {
	content: "";
	display: table;
	clear: both;
}

@media screen and (max-width: 600px) {
	.col-25, .col-75, input[type=submit] {
		width: 100%;
		margin-top: 0;
	}

	
}
</style>
</head>
<body>

<c:import url="../menu.jsp"></c:import>

	<div class="container">
	<div class="centralizado">
	<h1>Alterar Pedido </h1>
		<form action="/DonnaGula/Carrinho/carrinho-alterar" method="post">
		
	<label for="fname">Doce</label>
				</div>
				
				<div class="col-75">
				<select name="doces.id">
				<c:forEach var="doces" items="${doce }">
					<option value="${doces.id }">${doces.nome }</option>
				</c:forEach>
				</select>
				<div class="col-25">
					<label for="fname">Quantidade</label>
				</div>
				<div class="col-75">
					<select name="carrinho.id">
				<option value="${carrinho.quantidade}"selected>0</option> 
  				<option value="${carrinho.quantidade}">1</option> 
 				<option value="${carrinho.quantidade}" >2</option>
				</select>
		</div>
		</div>
		
		<div class="row">
		
				<div class="col-25">
					<label for="fname">Salgados</label>
				</div>
				
				<div class="col-75">
				<select name="salgados.id">
				<c:forEach var="salgados" items="${salgado }">
				<option value="${salgados.id }">${salgados.nome }</option>		
				</select>
				<div class="col-25">
					<label for="fname">Quantidade</label>
				</div>
				<div class="col-75">
				<select name="carrinho.id">
				<c:forEach var="carrinho.id" items="${carrinho }">
  				<option value="${carrinho.id}"selected>0</option> 
 				<div class="col-75">
 				
 				</div>
				</c:forEach>
				</c:forEach>
				</select>
				</div>
		</div>
		<div class="row">
		
				<td><a href="/DonnaGula/cliente/remover?id=$"> Forma de Pagamento </a></td>
				
				<input type="submit" value="Finalizar Pedido">
			</div>
	</form>
	</div>
</form>
</body>
</html>