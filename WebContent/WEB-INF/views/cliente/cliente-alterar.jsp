<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<c:import url="../menu.jsp"></c:import>

<h1>Alterar Cliente</h1>
	<form action="/DonnaGula/cliente/alterar" method="post">
		<div>
		
			<input type="hidden" readonly="readonly" name="id" value="${cliente.id}">
		</div>
		
		<div>
			<label>Nome: </label> 
			<input type="text" name="nome" value="${cliente.nome}">
		</div>
		<div>
			<label>Endereço: </label> 
			<input type="text" name="endereco"value="${cliente.endereco}">
		</div>
		<div>
			<label>Email: </label> 
			<input type="text" name="email"value="${cliente.email}">
		</div>
		<div>
			<label>Contato: </label> 
			<input type="text" name="contato"value="${cliente.contato}">
		</div>
		<div>
			<label>Cartao: </label> 
			<input type="text" name="cartao"value="${cliente.cartao}">
		</div>
		<div>
			<label>Senha: </label> 
			<input type="text" name="senha"value="${cliente.senha}">
		</div>
			<button type="submit">Alterar</button>
		</div>
	</form>
</body>
</html>