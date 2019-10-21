function entrar()
{
	var usuario = document.getElementById("login").value;
	var senha = document.getElementById("senha").value;
	
	var ca = new XMLHttpRequest();
	ca.onreadystatechange = function()
	{
		if(ca.readyState == 4){
			if(ca.responseText == 1){
				alert("Bem vindo " +usuario+ "!");
				window.location.href = "Interface.jsp";
			}	
			else
				alert("USUARIO NAO CADASTRADO!");
		}
		
	}
	
	ca.open("GET","DB_srv?id=0&op=3"+"&usuario="+usuario+"&senha="+senha, true);
	ca.send();
}