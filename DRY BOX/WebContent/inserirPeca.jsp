<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<jsp:useBean id="model" class="model.ModelUsuario" />

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<script type="text/javascript" src="Scripts/interfaceScripts.js"></script>
<link rel="stylesheet" href="estilo/estiloInterface.css">
<!-- <link rel="icon" href="imagens/icone-adv.ico" type="image/x-icon" /> -->
<title>Inserir Material</title>
</head>
<body onload="menu()">

	<!-- <img id='logo' src="imagens/logo.png" alt="LOGO"> -->


	<!-- MENU -->
	<div id="menu"></div>
	
	<br />
	<br />
	<div id='bordaConteudo'>
		<div id='titulo'>Inserir Material</div>

		<form action="DB_srv" method="post">
			<table id="tabelaInsMaterial" cellspacing="20" cellpadding="1">
				<tr>
					<td><label for="partnumberI"></label></td>
					<td><input type="text" name="partnumberI" id="partnumberI"
						placeholder="Part Number..." required></td>
				</tr>
				<tr>
					<td><label for="quantidadeI"></label></td>
					<td><input type="number" name="quantidadeI" id="quantidadeI"
						placeholder="Quantidade..." step="1" required></td>
				</tr>
			</table>
		</form>

		<button onclick='abrirConInserir()' id="inserirMat" type="submit">INSERIR</button>
	</div>

	<div id="popupContent">
		<div id="popup">
			<br /> Você deseja INSERIR na quantidade do material no estoque?<br />
			<br /> <br />
			<button onclick="inserirMat()">CONFIRMAR</button>
			<button onclick="abrirConInserir()">CANCELAR</button>

		</div>
	</div>
</body>
</html>