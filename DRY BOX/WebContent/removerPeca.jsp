<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<script type="text/javascript" src="Scripts/interfaceScripts.js"></script>
<link rel="stylesheet" href="estilo/estiloInterface.css">
<!-- <link rel="icon" href="imagens/icone-adv.ico" type="image/x-icon" /> -->
<title>Remover Material</title>
</head>
<body>

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

		<!-- Aba de Usu�rios -->
		<li class="dropdown"><a href="#" class="dropbtn">Usu�rios </a>
			<div class="dropdown-content">
				<a href="cadastrarUsuario.jsp">Cadastrar</a> 
				<a href="removerUsuario.jsp">Remover</a> 
				<a href="usuarios.jsp">Exibir Usu�rios Cadastrados</a>
			</div></li>

		<!-- Aba de Estoque -->
		<li class="dropdown">
			<a href="estoque.jsp" class="dropbtn">Estoque</a>
		</li>

		<!-- Aba de Historico -->
		<li class="dropdown">
			<a href="historico.jsp" class="dropbtn">Hist�rico de Movimenta��o</a>
		</li>
	</ul>

	<br />
	<br />
	<div id='bordaConteudo'>
		<div id='titulo'>Remover Material</div>

		<form action="DB_srv" method="post">
			<table id="tabelaRetMaterial" cellspacing="20" cellpadding="1">
				<tr>
					<td><label for="partnumberR"></label></td>
					<td><input type="text" name="partnumberR" id="partnumberR"
						placeholder="Part Number..." required></td>
				</tr>
			</table>
		</form>

		<button onclick='abrirConRemover()' id="removerMat" type="submit">REMOVER</button>
	</div>

	<div id="popupContent">
		<div id="popup">
			<br /> Voc� deseja REMOVER o material do estoque?<br />
			<br /> <br />
			<button onclick="removerMat()">CONFIRMAR</button>
			<button onclick="abrirConRemover()">CANCELAR</button>
		</div>
	</div>

</body>
</html>