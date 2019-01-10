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
<title>Listagem de aluno</title>
</head>
<body>
<c:import url= "../menu.jsp"></c:import>
<c:import url="../cabecalho.jsp" />

<div class="container">
	<div class="centralizado">
		<h1>Lista de alunos</h1>
		</div>
<table id="customers">
		<thead>
			<tr>
				<th>Id</th>
				<th>Matricula</th>
				<th>Nome</th>
				<th>CPF</th>
				<th>Data de Nascimento</th>
				<th>Endere�o</th>
			</tr>
			
		</thead>
		<tbody>
			<c:forEach var="aluno" items="${alunos }">
				<tr>
				
					<td>${aluno.id }</td>
					<td>${aluno.matricula }</td>
					<td>${aluno.nome }</td>
					<td>${aluno.CPF }</td>
					<td> <fmt:formatDate value="${aluno.dataNascimento.time}"
        pattern="dd/MM/yyyy" /> </td>
					
					<td>${aluno.endereco }</td>
					<td><a href="/BibliotecaS/alunos/remover?id=${aluno.id }"> remover </a></td>
				</tr>
				
			</c:forEach>

		</tbody>

	</table>
	</div>
</body>
</html>