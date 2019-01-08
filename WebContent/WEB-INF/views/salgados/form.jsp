<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Cadastrando livro</title>
</head>
<style>
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
		<h1>Adicionar Livro</h1>
		</div>
		<form action="/BibliotecaS/livros" method="post">

			<div class="row">
				<div class="col-25">
					<label for="fname">T�tulo</label>
				</div>
				<div class="col-75">
				<input type="text" id="fname" name="titulo"placeholder="Ex: A culpa � da estrelas.">
				</div>
			</div>

			<div class="row">
				<div class="col-25">
					<label for="lname">Autor</label>
				</div>
				<div class="col-75">
					<input type="text" id="lname" name="autor" placeholder="Ex: John Green">
				</div>
			</div>

			<div class="row">
				<div class="col-25">
					<label for="country">Editora</label>
				</div>
				<div class="col-75">
					<input type="text" id="lname" name="editora"placeholder="Ex: E. P. Dutton">
				</div>
			</div>


			<div class="row">
				<div class="col-25">
					<label for="country">Ano de publica��o</label>
				</div>
				<div class="col-75">
					<input type="text" id="lname" name="anoPub" maxlength="14"placeholder="Ex: 2012">
				</div>
			</div>

			<div class="row">
				<div class="col-25">
					<label for="country">Edi��o</label>
				</div>
				<div class="col-75">
					<input type="text" id="lname" name="edicao"placeholder=" Ex: 1">
				</div>
			</div>

			<div class="row">
				<input type="submit" value="Cadastrar">
			</div>
		</form>
	</div>

	

</style>
</body>
</html>