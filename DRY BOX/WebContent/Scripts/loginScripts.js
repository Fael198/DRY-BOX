function entrar()
{
	var usuario = document.getElementById("login").value;
	var senha = document.getElementById("senha").value;
	
	var ca = new XMLHttpRequest();
	ca.onreadystatechange = function()
	{
		if(ca.readyState == 4){
			if(ca.responseText == 1){
				document.getElementById("popupLogado").style.display = 'block';
				document.getElementById("popupContent").style.display = 'block';
			}	
			else
			{
				document.getElementById("popupErro").style.display = 'block';
				document.getElementById("popupContentErro").style.display = 'block';
			}
		}
		
	}
	
	ca.open("GET","DB_srv?id=0&op=3"+"&usuario="+usuario+"&senha="+senha, true);
	ca.send();
}

function fecharErro() {
	document.getElementById("popupErro").style.display = 'none';
	document.getElementById("popupContentErro").style.display = 'none';
}

function verificarAcesso(){
	var usuario = document.getElementById("login").value;
	
	var ca = new XMLHttpRequest();
	ca.onreadystatechange = function()
	{
		if(ca.readyState == 4){
			if(ca.responseText == 1){
				alert("Bem vindo Usuario!");
				window.location.href = "InterfaceC.jsp";
				
			} else if(ca.responseText == 0) {
				alert("Bem vindo Administrador!");
				window.location.href = "Interface.jsp"
			}else {
				alert("Erro!");
			}
		}
	}
	ca.open("GET","DB_srv?id=0&op=11"+"&usuario="+usuario, true);
	ca.send();
	
}