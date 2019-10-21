<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<script type="text/javascript"src = "Scripts/interfaceScripts.js"></script>
<link rel="stylesheet" href="estilo/estiloInterface.css">
<link rel="icon" href="imagens/icone-adv.ico" type="image/x-icon" />
<title>Peças no Estoque</title>
</head>
<body onload='listaMat()'>

<img id='logo' src="imagens/logo.png" alt="LOGO">

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
</ul>
</br></br>

<div id='saida'></div>

<div id="popupContent">
	<div id="EstoquePopup">
		</br>
		O que deseja fazer?
		</br></br></br></br>
		<button>INSERIR</button>
		<button>DAR BAIXA</button>
		<button>MODIFICAR</button>
		<button>REMOVER</button>
		<button onclick="janelaModificar(0)">CANCELAR</button>
	</div>
</div>

</body>
</html>