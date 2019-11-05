<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<script type="text/javascript" src="Scripts/interfaceScripts.js"></script>
<link rel="stylesheet" href="estilo/estiloInterface.css">
<!-- <link rel="icon" href="imagens/icone-adv.ico" type="image/x-icon" /> -->
<title>Peças no Estoque</title>
</head>
<body onload='listaMat(),menuComum()'>

	<!-- <img id='logo' src="imagens/logo.png" alt="LOGO"> -->

	<!-- MENU -->
	<div id="menuComum"></div>

	<div id='saida'></div>

	<div id="popupContent">
		<div id="EstoquePopup">
			<br /> O que deseja fazer? <br />
			<br />
			<br />
			<br />
			<button>INSERIR</button>
			<button>DAR BAIXA</button>
			<button>MODIFICAR</button>
			<button>REMOVER</button>
			<button onclick="janelaModificar(0)">CANCELAR</button>
		</div>
	</div>

</body>
</html>