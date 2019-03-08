<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>


<jsp:useBean id="model" class="model.ModelMaterial" />

<table>
	<tr>
	<!-- 
		<h1>PE�AS EM ESTOQUE</h1>
	</tr>
	</br></br>
	<td><h2>P/N</h2></td>
	<td><h2>QUANTIDADE</h2></td>
	<td><h2>LOCALIZA��O</h2></td>
	<td id="des"><h2>DESCRI��O</h2></td>
	-->


	<c:forEach var="material" items="${listaMat}">

		<tr>
			<td id="selecionarMat" onclick="janelaModificar(<c:out value="${material.id_material}" />)">
				<img id="imgEditar" src="imagens/imgEditar.png">
			</td>
			
			<td id="pnLista"><c:out value="${material.part_number}" /></br></br>
				Quantidades:</br>
				Estoque: <c:out value="${material.quantidade}" />
				| m�nima: <c:out value="${material.quantidadeMin}" />
				| m�xima: <c:out value="${material.quantidadeMax}"/></td>
			
			<td id="locLista">Localiza��o: </br><c:out value="${material.localizacao}"/></td>
			
		</tr>
		
		<div id='popup'>
			Voc� ir� REMOVER o material <c:out value="${material.part_number}"/> do estoque!</br></br>
			Deseja continuar?</br></br></br>
			
			<button onclick="removerMat(<c:out value="${material.id_material}"/>)" >CONFIRMAR</button>
			<button onclick="abrirCon()" >CANCELAR</button>
		</div>

	</c:forEach>
	
	

</table>