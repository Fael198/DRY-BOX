<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

	<jsp:useBean id="model" class="model.ModelUsuario" />

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<script type="text/javascript"src = "Scripts/interfaceScripts.js"></script>
<link rel="stylesheet" href="estilo/estiloInterface.css">
<link rel="icon" href="imagens/icone-adv.ico" type="image/x-icon" />
<title>Advantech - DRY BOX Controller</title>
</head>
<body>

	<img id='logo' src="imagens/logo.png" alt="LOGO">
	
	<!-- <button id="btnSair" onclick='sair()'>Sair</button> -->

<!-- MENU -->
<ul>
	<!-- Aba de Material -->
  <li class="dropdown">
  	<a href="#" class="dropbtn">Material</a>
  	<div class="dropdown-content">
      <a href="cadastrarPeca.jsp">Cadastrar Pe�a No Estoque</a>
      <a href="inserirPeca.jsp">Inserir</a>
      <a href="darbaixaPeca.jsp">Dar Baixa</a>
    </div>
  </li>
  
  <!-- Aba de Usu�rios -->
  <li class="dropdown">
  	<a href="#" class="dropbtn">Usu�rios </a>
  	<div class="dropdown-content">
      <a href="cadastrarUsuario.jsp">Cadastro de novo usu�rio</a>
      <a href="removerUsuario.jsp">Remover Usu�rio</a>
      <a href="listarUsuarios.jsp">Exibir Usu�rios Cadastrados</a>
    </div>
  </li>
  
  <!-- Aba de Estoque -->
  <li class="dropdown">
  	<a href="estoque.jsp" class="dropbtn">Estoque</a>
  </li>
  
  <!-- Aba de Historico -->
  <li class="dropdown">
  	<a href="historico.jsp" class="dropbtn">Hist�rico de Movimenta��o</a>
  </li>
</ul> 

</br>
<!-- 
<form>
    <label for="search"></label></td>
    <input type="text" name="search" id='search' placeholder="Buscar..."></td>
</form>

 -->
</body>
</html>