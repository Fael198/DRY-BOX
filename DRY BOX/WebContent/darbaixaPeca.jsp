<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<script type="text/javascript"src = "Scripts/interfaceScripts.js"></script>
<link rel="stylesheet" href="estilo/estiloInterface.css">
<link rel="icon" href="imagens/icone-adv.ico" type="image/x-icon" />
<title>Dar Baixa Material</title>
</head>
<body>

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
  
   <!-- Aba de Estoque -->
  <li class="dropdown">
  	<a href="#" class="dropbtn">Estoque</a>
  	<div class="dropdown-content">
      <a href="estoque.jsp">Consultar Peças Do Estoque</a>    
    </div>
  </li>
  </ul>

	</br></br>
	<div id='bordaConteudo'>
		<div id='titulo' >Dar Baixa em Material</div>
		
		<form action="DB_srv" method="post">
		    <table id="tabelaRetMaterial" cellspacing="20" cellpadding="1">
		        <tr>
		            <td><label for="partnumberR"></label></td>
		            <td><input type="text" name="partnumberR" id="partnumberR" placeholder="Part Number..." required></td>
		        </tr>
		        <tr>
		            <td><label for="quantidadeR"></label></td>
		            <td><input type="number" name="quantidadeR" id="quantidadeR" placeholder="Quantidade..." step="1" required></td>
		        </tr>
		    </table>
		</form>
		
		<button onclick='abrirConBaixa()' id="retirarMat" type="submit">DAR BAIXA</button>
	</div>
	
	<div id="popupContent"> 
		<div id="popup"></br >
			Você deseja DAR BAIXA no material do estoque?</br ></br >
			</br >
			<button onclick="retirarMat()"> CONFIRMAR</button>
			<button onclick="abrirConBaixa()"> CANCELAR</button>
		</div>
	</div>
	
</body>
</html>