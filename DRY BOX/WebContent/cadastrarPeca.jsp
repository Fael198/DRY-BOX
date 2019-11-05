<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<script type="text/javascript" src="Scripts/interfaceScripts.js"></script>
<link rel="stylesheet" href="estilo/estiloInterface.css">
<!-- <link rel="icon" href="imagens/icone-adv.ico" type="image/x-icon" /> -->
<title>Cadastro de Material</title>
</head>
<body onload="menu()">

	<!-- <img id='logo' src="imagens/logo.png" alt="LOGO"> -->


	<!-- MENU -->
	<div id="menu"></div>
	<br />
	<br />


	<div id='bordaConteudo'>
		<div id='titulo'>Cadastro de Peça No Estoque</div>

		<br />

		<form action="DB_srv" method="post">
			<table id="tabelaCadMaterial" cellspacing="20" cellpadding="1">
				<tr>
					<td><label for="partnumber"></label></td>
					<td><input type="text" name="partnumber" id="partnumber"
						size="30" placeholder="Part Number..." required>
					<td>
				</tr>
				<tr>
					<td><label for="quantidade"></label></td>
					<td><input type="text" name="quantidade" id="quantidade"
						size="30" placeholder="Quantidade..." required>
					<td>
				</tr>
				<tr>
					<td><label for="localizacao"></label></td>
					<td><input type="text" name="localizacao" id="localizacao"
						size="30" placeholder="Localização..." required>
					<td>
				</tr>
				<tr>
					<td><label for="descricao"></label></td>
					<td><input type="text" name="descricao" id="descricao"
						size="30" placeholder="Descrição..." required>
					<td>
				</tr>
				<tr>
					<td><label for="quantidadeMin"></label></td>
					<td><input type="text" name="quantidadeMin" id="quantidadeMin"
						size="30" placeholder="Quantidade Mínima..." required>
					<td>
				</tr>
				<tr>
					<td><label for="quantidadeMax"></label></td>
					<td><input type="text" name="quantidadeMax" id="quantidadeMax"
						size="30" placeholder="Quantidade Máxima..." required>
					<td>
				</tr>
			</table>
		</form>

		<br />
		<button onclick='cadastraMaterial()' id="cadastrarMat" type="submit">CADASTRAR</button>
	</div>

	<!-- <img id='logo' src="imagens/logo.png" alt="LOGO"> -->
</body>
</html>