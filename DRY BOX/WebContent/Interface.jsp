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
<!-- 
	<div>Cadastro de Usuário</div>
	
	<form action="" method="post">
	    <table id="tabela" cellspacing="20" cellpadding="1">
	        <tr>
	            <td><label for="nome">Nome: </label></td>
	            <td><input type="text" name="nome" id="nome" size="25" required><td>
	        </tr>
	        <tr>
	            <td><label for="senha">Senha: </label></td>
	            <td><input type="password" name="senha" id="senha" size="25" required><td>
	        </tr>
	        <tr>
	            <td><label for="usuario">Usuario: </label></td>
	            <td><input type="text" name="usuario" id="usuario" size="25" required><td>
	        </tr>
	        <tr>
	            <td><label for="email">Email: </label></td>
	            <td><input type="text" name="email" id="email" size="25" required><td>
	        </tr>
	    </table>
	</form>
	
	<button onclick='cadastraUsuario()' id="cadastrarUsu" type="submit">CADASTRAR</button>
	
	</br></br>

	<div id='saida'></div>
	
-->
<!-- MENU -->
<ul>
	<!-- Aba de Material -->
  <li class="dropdown">
  	<a href="#" class="dropbtn">Material</a>
  	<div class="dropdown-content">
      <a href="cadastrarPeca.jsp">Cadastrar Peça No Estoque</a>
      <a href="inserirPeca.jsp">Inserir</a>
      <a href="darbaixaPeca.jsp">Dar Baixa</a>
    </div>
  </li>
  
  <!-- Aba de Usuários -->
  <li class="dropdown">
  	<a href="#" class="dropbtn">Usuários </a>
  	<div class="dropdown-content">
      <a href="cadastrarUsuario.jsp">Cadastro de novo usuário</a>
      <a href="removerUsuario.jsp">Remover Usuário</a>
      <a href="listarUsuarios.jsp">Exibir Usuários Cadastrados</a>
    </div>
  </li>
  
  <!-- Aba de Estoque -->
  <li class="dropdown">
  	<a href="estoque.jsp" class="dropbtn">Estoque</a>
  </li>
  
  <li class="dropdown">
  	<a href="historico.jsp" class="dropbtn">Histórico de Movimentação</a>
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