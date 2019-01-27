<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
<title>Carrinho</title>
</head>
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
	padding: 10px 10px;
	border: none;
	border-radius: 4px;
	cursor: pointer;
	float: right;
	margin-top: 8px;
	
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
	margin-left: 1px;

}

.col-75 {
	float: left;
	width: 30%;
	margin-top: 5px;
}
.col-76 {
	float: left;
	width: 15%;
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
<style>
body {
  font-family: Arial;
}

* {
  box-sizing: border-box;
}

form.example input[type=text] {
  padding: 10px;
  font-size: 17px;
  border: 1px solid grey;
  float: left;
  width: 80%;
  background: #f1f1f1;
}

form.example button {
  float: right;
  width: 30%;
  padding: 10px;
  background: #2196F3;
  color: white;
  font-size: 17px;
  border: 1px solid grey;
  border-left: none;
  cursor: pointer;
}

form.example button:hover {
  background: #0b7dda;
}

form.example::after {
  content: "";
  clear: both;
  display: table;
}
</style>
</head>
<body>
<c:import url="../menu.jsp"></c:import>

	<div class="container">
	<div class="centralizado">
		<h1>Realize seus pedidos!</h1>
		</div>
		<form action="/DonnaGula/Carrinho/" method="post">
			
	<div class="row">
			
				<div class="col-25">
					<label for="fname">Doce</label>
				</div>
				
				<div class="col-75">
				<select name="doces.id">
				<c:forEach var="doces" items="${doce }">
					<option value="${doces.id }">${doces.nome }</option>
				</c:forEach>
				</select>
				</div>
				
				<div class="col-25">
					<label for="fname">Quantidade</label>
				</div>
				
				<div class="col-76">
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
					</c:forEach>		
				</select>
				</div>
				
				<div class="col-25">
					<label for="fname">Quantidade</label>
				</div>
				
				<div class="col-76">
				<select name="carrinho.id">
				
  				<option value="${carrinho.id}"selected>0</option> 
  				<option value="${carrinho.quantidade}">1</option> 
 				<option value="${carrinho.quantidade}" >2</option>
				</select>

				</div>
		</div>
		<div class="row">
				<input type="submit" value="Escolha sua forrma de pagamento">
				<input type="submit" value="Finalizar Pedido">
			</div>
	</form>
	</div>
</body>
</html>