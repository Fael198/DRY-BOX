<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<script type="text/javascript" src="Scripts/interfaceScripts.js"></script>
<link rel="stylesheet" href="estilo/estiloInterface.css">
<!-- <link rel="icon" href="imagens/icone-adv.ico" type="image/x-icon" /> -->
<title>Usuários Cadastrados</title>
</head>
<body onload='listaUsr()'>

	<!-- <img id='logo' src="imagens/logo.png" alt="LOGO"> -->

	<!-- MENU -->
	<ul>
		<!-- Aba de Material -->
		<li class="dropdown"><a href="#" class="dropbtn">Material</a>
			<div class="dropdown-content">
				<a href="cadastrarPeca.jsp">Cadastrar</a> 
				<a href="removerPeca.jsp">Remover</a>
				<a href="inserirPeca.jsp">Inserir</a> 
				<a href="darbaixaPeca.jsp">Dar Baixa</a>
			</div></li>

		<!-- Aba de Usuários -->
		<li class="dropdown"><a href="#" class="dropbtn">Usuários </a>
			<div class="dropdown-content">
				<a href="cadastrarUsuario.jsp">Cadastrar</a> 
				<a href="removerUsuario.jsp">Remover</a> 
				<a href="listarUsuarios.jsp">Exibir Usuários Cadastrados</a>
			</div></li>

		<!-- Aba de Estoque -->
		<li class="dropdown">
			<a href="estoque.jsp" class="dropbtn">Estoque</a>
		</li>

		<!-- Aba de Historico -->
		<li class="dropdown">
			<a href="historico.jsp" class="dropbtn">Histórico de Movimentação</a>
		</li>
	</ul>
	<br />
	<br />

	<div id='saidaUsr'></div>

</body>
</html>