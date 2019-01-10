<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<style>

#customers {
    font-family: "Trebuchet MS", Arial, Helvetica, sans-serif;
    border-collapse: collapse;
    width: 100%;
    top: 50%;
    left: 50%;
    center;
    
     
}

#customers td, #customers th {
    border: 1px solid black;
    padding: 10px;
}

#customers tr:nth-child{background-color: #F6CED8;}

#customers tr:hover {background-color: lavender;}

#customers th {
	
    padding-top: 12px;
    padding-bottom: 12px;
    text-align: left;
    background-color: LightCoral;
    color: white;
    }
    
    
    .container {
 	position: absolute;
    top: 50%;
    left: 50%;
    width: 50%;
    transform: translateY(-50%) translateX(-50%);
	center;
	border-radius: 5px;
	background-color: #ccc;
	padding: 20px;
}
.centralizado {
	-webkit-text-stroke-width: 1px; 
    -webkit-text-stroke-color: #000;
	text-align: center;
	color: LightCoral ;
}
</style>
<title>Cardápio</title>
</head>
<body>
<c:import url= "../menu.jsp"></c:import>
<c:import url="../cabecalho.jsp" />

<div class="container">
	<div class="centralizado">
		<h1>Cardápio de Salgados</h1>
		</div>
<table id="customers">
		<thead>
			<tr>
				<th>Id</th>
				<th>Nome</th>
				<th>Recheio</th>
				<th>Preço</th>
			</tr>
			
		</thead>
		<tbody>
			<c:forEach var="salgados" items="${salgados }">
				<tr>
				
					<td>${salgados.id }</td>
					<td>${salgados.nome }</td>
					<td>${salgados.recheio }</td>
					<td>${salgados.preco }</td>
					<td><a href="/DonnaGula/salgados/remover?id=${salgados.id }"> remover </a></td>
				</tr>
				
			</c:forEach>

		</tbody>

	</table>
	</div>
</body>
</html>