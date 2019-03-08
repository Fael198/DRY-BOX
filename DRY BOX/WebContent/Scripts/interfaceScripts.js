//CADASTRAR USUÁRIO
function cadastraUsuario() 
{
	var nome = document.getElementById("nome").value;
	var senha = document.getElementById("senha").value;
	var usuario = document.getElementById("usuario").value;
	var email = document.getElementById("email").value;
	
	var ca = new XMLHttpRequest();
	ca.onreadystatechange = function() {
		if (ca.readyState == 4)
			alert("Usuario Cadastrado com Sucesso!");
	}

	ca.open("GET", "DB_srv?id=0&op=1"+"&nome="+nome+"&senha="+senha+"&usuario="+usuario+"&email="+email, true);
	ca.send();
}

//CADASTRAR MATERIAL
function cadastraMaterial() 
{
	var partnumber = document.getElementById("partnumber").value;
	var quantidade = document.getElementById("quantidade").value;
	var localizacao = document.getElementById("localizacao").value;
	var descricao = document.getElementById("descricao").value;
	var quantidadeMin = document.getElementById("quantidadeMin").value;
	var quantidadeMax = document.getElementById("quantidadeMax").value;
	
	if(partnumber == "" || quantidade == "" || localizacao == "" || descricao == "" || quantidadeMin == "" || quantidadeMax == ""){
		alert("Preencha os dados obrigatorios!");
	}else {
		
		var ca = new XMLHttpRequest();
		ca.onreadystatechange = function() {
			if (ca.readyState == 4){
				if(ca.responseText == 1){
					alert("Material Cadastrado com Sucesso!");
					window.location.href = "estoque.jsp";
					
				}else if(ca.responseText == 0) {
					alert("Material ja esta cadastrado!");
				}else {
					alert("Erro no cadastro!");
				}
			}
		}

		ca.open("GET", "DB_srv?id=0&op=2"+"&partnumber="+partnumber+"&quantidade="+quantidade+"&localizacao="+localizacao+"&descricao="+descricao+"&quantidadeMin="+quantidadeMin+"&quantidadeMax="+quantidadeMax, true);
		ca.send();
	}	
}

//LISTAR MATERIAL
function listaMat() {

	var ca = new XMLHttpRequest();
	ca.onreadystatechange = function() {
		if (ca.readyState == 4)
			document.getElementById("saida").innerHTML = ca.responseText;
	}

	ca.open("GET", "DB_srv?id=0&op=6", true);
	ca.send();

}

//REMOVER MATERIAL
function removerMat(id) {
	var ca = new XMLHttpRequest();

	ca.onreadystatechange = function() {
		if (ca.readyState == 4)
			listaMat();
	}

	ca.open("GET", "DB_srv?op=5&id="+id, true);
	ca.send();
}

//INSERIR MATERIAL
function inserirMat() {

	var partnumber = document.getElementById("partnumberI").value;
	var quantidade = document.getElementById("quantidadeI").value;
	
	if(partnumber == '' || quantidade == ''){
		
		alert("Preencha os campos obrigatorios!");
	}else {
		
		var ca = new XMLHttpRequest();
		ca.onreadystatechange = function() {
			if (ca.readyState == 4){
				if(ca.responseText == 1){
					alert("Quantidade Alterada!");
					window.location.href = "estoque.jsp";
				} else {
					alert("Part Number nao cadastrado!");
				}
			}
		}
		ca.open("GET","DB_srv?id=0&op=7"+"&partnumber="+partnumber+"&quantidade="+quantidade, true);
		ca.send();
	}	
}

//RETIRAR MATERIAL
function retirarMat() {

	var partnumber = document.getElementById("partnumberR").value;
	var quantidade = document.getElementById("quantidadeR").value;
	
	if(partnumber == '' || quantidade == ''){
		
		alert("Preencha os campos obrigatorios!");
	}else {
	
		var ca = new XMLHttpRequest();
		ca.onreadystatechange = function() {
			if (ca.readyState == 4){
				if(ca.responseText == 1){
					alert("Quantidade Alterada!");
					window.location.href = "estoque.jsp";
				} else {
					alert("Part Number nao cadastrado!");
				}
			}
		}
		ca.open("GET","DB_srv?id=0&op=8"+"&partnumber="+partnumber+"&quantidade="+quantidade, true);
		ca.send();
	}
}

//ABRE JANELA PARA MODIFICAR UM MATERIAL DO ESTOQUE
function janelaModificar(id){
	if (document.getElementById("EstoquePopup").style.display == 'block') {
		document.getElementById("EstoquePopup").style.display = 'none';
		document.getElementById("popupContent").style.display = 'none';
	}

	else {
		document.getElementById("EstoquePopup").style.display = 'block';
		document.getElementById("popupContent").style.display = 'block';
	}
}

//POPUP DE CONFIRMAÇÃO DE INSERÇÃO
function abrirConInserir(){
	
	var partnumber = document.getElementById("partnumberI").value;
	var quantidade = document.getElementById("quantidadeI").value;
	
	if(partnumber == '' || quantidade == ''){
		
		alert("Preencha os campos obrigatorios!");
	}else {
	
		if (document.getElementById("popup").style.display == 'block') {
			document.getElementById("popup").style.display = 'none';
			document.getElementById("popupContent").style.display = 'none';
		}
	
		else {
			document.getElementById("popup").style.display = 'block';
			document.getElementById("popupContent").style.display = 'block';
		}
	}
}

//POPUP DE CONFIRMAÇÃO DE BAIXA
function abrirConBaixa(){
	
	var partnumber = document.getElementById("partnumberR").value;
	var quantidade = document.getElementById("quantidadeR").value;
	
	if(partnumber == '' || quantidade == ''){
		
		alert("Preencha os campos obrigatorios!");
	}else {
	
		if (document.getElementById("popup").style.display == 'block') {
			document.getElementById("popup").style.display = 'none';
			document.getElementById("popupContent").style.display = 'none';
		}
	
		else {
			document.getElementById("popup").style.display = 'block';
			document.getElementById("popupContent").style.display = 'block';
		}
	}
}
