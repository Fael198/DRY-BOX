<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<script type="text/javascript" src="Scripts/interfaceScripts.js"></script>
<link rel="stylesheet" href="estilo/estiloInterface.css">
<!-- <link rel="icon" href="imagens/icone-adv.ico" type="image/x-icon" /> -->
<title>Alterar dados de Usuário</title>
</head>
<body onload="menu()">

	<!-- <img id='logo' src="imagens/logo.png" alt="LOGO"> -->


	<!-- MENU -->
	<div id="menu"></div>
	<br />
	<br />


	<div id='bordaConteudo'>
		<div id='titulo'>Alterar dados de Usuário</div>

		<br />

		<form action="DB_srv" method="post">
			<table id="tabelaAltUsr" cellspacing="20" cellpadding="1">
				<tr>
					<td><label for="usuario"></label></td>
					<td><input type="text" name="usuario" id="usuario"
						size="30" placeholder="Nome de Usuario..." required>
					<td>
				</tr>
				<tr>
					<td><label for="nome"></label></td>
					<td><input type="text" name="nome" id="nome"
						size="30" placeholder="Nome..." required>
					<td>
				</tr>
				<tr>
					<td><label for="senha"></label></td>
					<td><input type="password" name="senha" id="senha"
						size="30" placeholder="Senha..." required>
					<td>
				</tr>
				<tr>
					<td><label for="email"></label></td>
					<td><input type="text" name="email" id="email"
						size="30" placeholder="Email..." required>
					<td>
				</tr>
			</table>
		</form>

		<br />
		<button onclick='alterarUsuario()' id="alterarUsr" type="submit">ALTERAR</button>
	</div>

	<!-- <img id='logo' src="imagens/logo.png" alt="LOGO"> -->
</body>
</html>