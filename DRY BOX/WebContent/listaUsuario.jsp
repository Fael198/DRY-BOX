<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>


<jsp:useBean id="model" class="model.ModelUsuario" />

<table>
	<tr id="topo">
		<td><h2>Nome</h2></td>
		<td><h2>Usuario</h2></td>
		<td><h2>Email</h2></td>
		<td><h2>Tipo de Usuário</h2></td>
	</tr>
	
	<c:forEach var="usuario" items="${listaUsr}" varStatus="c">
	
		<tr>
			<td><c:out value="${usuario.nome}" /></td>
			<td><c:out value="${usuario.usuario}" /></td>
			<td><c:out value="${usuario.email}" /></td>
			<td><c:out value="${usuario.tipo}" /></td>
			<!-- <td id="remUsr" onclick="abrirPopup()">Remover</td> -->
		</tr>
		
		<div id='popupUsr'>
			Você irá REMOVER o usuario
			<c:out value="${usuario.nome}" />
			do sistema!</br>
			<br /> Deseja continuar?<br />
			<br />
			<br />
		
			<button
				onclick="removerUsr(<c:out value="${usuario.id_usuario}"/>)">CONFIRMAR</button>
			<button onclick="abrirPopup()">CANCELAR</button>
		</div>
		
	</c:forEach>
	
</table>