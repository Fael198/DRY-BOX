<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<script type="text/javascript" src="Scripts/interfaceScripts.js"></script>
<link rel="stylesheet" href="estilo/estiloInterface.css">
<!-- <link rel="icon" href="imagens/icone-adv.ico" type="image/x-icon" /> -->
<title>Cadastro de Usuario</title>
</head>
<body onload="menu()">

	<!-- <img id='logo' src="imagens/logo.png" alt="LOGO"> -->


	<!-- MENU -->
	<div id="menu"></div>
	
	<br />
	<br />


	<div id='bordaConteudo'>
		<div id='titulo'>Cadastro de Usuários</div>

		<br />

		<form action="" method="post">
			<table id="tabela" cellspacing="20" cellpadding="1">
				<tr>
					<td><input type="text" name="nome" id="nome" size="30"
						placeholder="Nome..." required>
					<td>
				</tr>
				<tr>
					<td><input type="password" name="senha" id="senha" size="30"
						placeholder="Senha..." required>
					<td>
				</tr>
				<tr>
					<td><input type="text" name="usuario" id="usuario" size="30"
						placeholder="Usuario..." required>
					<td>
				</tr>
				<tr>
					<td><input type="text" name="email" id="email" size="30"
						placeholder="Email..." required>
					<td>
				</tr>
				<tr>
					<td>Tipo de Usuário: <select id="tipo">
							<option value=""></option>
							<option value="Administrador">Administrador</option>
							<option value="Comum">Comum</option>
					</select>
					</td>
				</tr>
			</table>
		</form>

		<button onclick='cadastraUsuario()' id="cadastrarUsu" type="submit">CADASTRAR</button>
	</div>

	<!-- <img id='logo' src="imagens/logo.png" alt="LOGO"> -->
</body>
</html>