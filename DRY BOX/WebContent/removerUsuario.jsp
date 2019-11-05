<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<script type="text/javascript" src="Scripts/interfaceScripts.js"></script>
<link rel="stylesheet" href="estilo/estiloInterface.css">
<!-- <link rel="icon" href="imagens/icone-adv.ico" type="image/x-icon" /> -->
<title>Remover Usu�rio</title>
</head>
<body onload="menu()">

	<!-- <img id='logo' src="imagens/logo.png" alt="LOGO"> -->


	<!-- MENU -->
	<div id="menu"></div>

	<br />
	<br />
	<div id='bordaConteudo'>
		<div id='titulo'>Remover Usu�rio</div>

		<form action="DB_srv" method="post">
			<table id="tabelaRetMaterial" cellspacing="20" cellpadding="1">
				<tr>
					<td><label for="nomeUsuario"></label></td>
					<td><input type="text" name="nomeUsuario" id="nomeUsuario"
						placeholder="Nome de Usu�rio..." required></td>
				</tr>
			</table>
		</form>

		<button onclick='abrirConRemoverU()' id="removerUsu" type="submit">REMOVER</button>
	</div>

	<div id="popupContent">
		<div id="popup">
			<br /> Voc� deseja REMOVER o usuario do sistema?<br />
			<br /> <br />
			<button onclick="removerUsu()">CONFIRMAR</button>
			<button onclick="abrirConRemoverU()">CANCELAR</button>
		</div>
	</div>

</body>
</html>