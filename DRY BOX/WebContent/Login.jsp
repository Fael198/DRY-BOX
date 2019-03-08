<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link rel="stylesheet" href="estilo/estiloLogin.css">
<script type="text/javascript"src = "Scripts/loginScripts.js"></script>
<link rel="icon" href="imagens/icone-adv.ico" type="image/x-icon" />
<title>Advantech - DRY BOX Controller 1.1</title>
</head>
<body>

	<div>DRY BOX</div>

	<form action="" method="post">
	    <table id="tabela" cellspacing="20" cellpadding="1">
	        <tr>
	            <td><label for="login">Usuário: </label></td>
	            <td><input type="text" name="login" id="login" placeholder="Nome de Usuário.." required><td>
	        </tr>
	        <tr>
	            <td><label for="senha">Senha: </label></td>
	            <td><input type="password" name="senha" id="senha" placeholder="Sua Senha.." required><td>
	        </tr>
	    </table>
	</form>
	
	<button onclick='entrar()' id="confirmar" type="submit">CONFIRMAR</button>
    
<img id='logo' src="imagens/logo.png" alt="LOGO">
</body>
</html>