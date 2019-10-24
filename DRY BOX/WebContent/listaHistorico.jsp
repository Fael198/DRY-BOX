<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>


<jsp:useBean id="model" class="model.ModelHistorico" />

<table id="tabelaHistorico">

	<tr id="topo">
		<td><h2>P / N</h2></td>
		<td><h2>Quantidade</h2></td>
		<td><h2>Usuario</h2></td>
		<td><h2>Data e hora de modificação</h2></td>
		<td><h2>Movimentação</h2></td>
	</tr>

	<c:forEach var="historico" items="${listaHis}">

		<tr>
			<td><c:out value="${historico.part_number}" /></td>
			<td><c:out value="${historico.quantidade}" /></td>
			<td><c:out value="${historico.movimentadoPor}" /></td>
			<td><c:out value="${historico.movimentadoEm}" /></td>
			<td><c:out value="${historico.tipoMovimentacao}" /></td>
		</tr>

	</c:forEach>

</table>