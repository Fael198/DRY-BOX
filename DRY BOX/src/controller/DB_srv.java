package controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.HistoricoDAO;
import dao.MaterialDAO;
import dao.UsuarioDAO;
import model.ModelHistorico;
import model.ModelMaterial;
import model.ModelUsuario;

@MultipartConfig(fileSizeThreshold = 1024 * 1024 * 2, // 2MB
		maxFileSize = 1024 * 1024 * 10, // 10MB
		maxRequestSize = 1024 * 1024 * 50) // 50MB

@WebServlet("/DB_srv")
public class DB_srv extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public DB_srv() {
        super();
    }

    //DOGET
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		System.out.println("SERVELET FOI");

		int id = Integer.parseInt(request.getParameter("id"));
		int op = Integer.parseInt(request.getParameter("op"));
		
		//INSTANCIANDO DAO'S
		UsuarioDAO usrDao = new UsuarioDAO();
		MaterialDAO mtrDao = new MaterialDAO();
		HistoricoDAO hisDao = new HistoricoDAO();
		
		//INSTANCIANDO MODELS
		ModelUsuario usr = new ModelUsuario();
		ModelMaterial mtr = new ModelMaterial();
		ModelHistorico his = new ModelHistorico();

		int idu = 1;
		
		PrintWriter out = response.getWriter();
		response.setContentType("text/html");
		
		if (op == 1) //CADASTRO DE USUï¿½RIO
		{
			usr.setNome(request.getParameter("nome"));
			usr.setSenha(request.getParameter("senha"));
			usr.setUsuario(request.getParameter("usuario"));
			usr.setEmail(request.getParameter("email"));
			usr.setTipo(request.getParameter("tipo"));
			usrDao.CadastraUsuarioDAO(usr);
		}
		
		else if(op == 2) //CADASTRO DE MATERIAL
		{
			String pn = request.getParameter("partnumber");
			
			mtr.setPart_number(pn);
			mtr.setQuantidade(Integer.parseInt(request.getParameter("quantidade")));
			mtr.setLocalizacao(request.getParameter("localizacao"));
			mtr.setDescricao(request.getParameter("descricao"));
			mtr.setQuantidadeMin(Integer.parseInt(request.getParameter("quantidadeMin")));
			mtr.setQuantidadeMax(Integer.parseInt(request.getParameter("quantidadeMax")));
			mtr.setCriadoPor(idu);
			//mtr.setModificadoPor(idu);
			//mtr.setInseridoPor(idu);
			//mtr.setDadoBaixaPor(idu);
			//mtr.setDadoBaixaPor(idu);
			//mtr.setRemovidoPor(idu);
			
			//Cadastrando no Histï¿½rico
			his.setPart_number(pn);
			his.setQuantidade(Integer.parseInt(request.getParameter("quantidade")));
			his.setMovimentadoPor(idu);
			his.setTipoMovimentacao("cadastrado");
			//////////////////////////
			
			mtrDao.BuscaMaterialDAO(mtr);	//FUNï¿½ï¿½O QUE VERIFICA SE O MATERIAL ESTÃ� NO BANCO
			
			if (mtrDao.BuscaMaterialDAO(mtr)){		//SE ESTE MATERIAL JÃ� TIVER, APENAS ESCREVE '0'
				out.println("0");
			}else {									//SENÃƒO, ESCREVE '1'... 
				out.println("1");
				mtrDao.CadastraMaterialDAO(mtr);	//... E CADASTRA O MATERIAL NOVO
				hisDao.CadastraMovimentacaoDAO(his);//... ADICIONA O CADASTRO NO HISTORICO
			}
		}
		
		else if(op == 3) //FAZER LOGIN
		{
			String usuario = request.getParameter("usuario");
			String senha = request.getParameter("senha");

			usr.setUsuario(usuario);
			usr.setSenha(senha);

			usrDao.BuscarUsuarioDAO(usr);
			//usrDao.MudaStatusUsuarioDAO(usr);

			
			boolean vazio = usrDao.BuscarUsuarioDAO(usr);

			if (vazio) {
				out.println("1");
			} else {
				out.println("0");
			}
		}
		
		else if(op == 4) //REMOVER USUï¿½RIO
		{
			usr.setUsuario(request.getParameter("nomeUsuario"));
			
			usrDao.BuscarNomeUsuarioDAO(usr);
			
			if (usrDao.BuscarNomeUsuarioDAO(usr)){				//SE O USUARIO EXISTIR...
				usrDao.RemoverUsuarioDAO(usr);				//... REMOVE O USUARIO...
				out.println("1");							//... E RETORNA '1'
			}else {									 
				out.println("0");							//...SENï¿½O RETORNA '0' INDICANDO QUE O MATERIAL SOLICITADO AINDA Nï¿½O SE ENCONTRA CADASTRADO!
			}
		}
		
		else if(op == 5) //REMOVER MATERIAL
		{
			mtr.setPart_number(request.getParameter("partnumber"));
			
			mtrDao.BuscaMaterialDAO(mtr);
			
			//Inserindo no Historico
			his.setPart_number(request.getParameter("partnumber"));
			his.setMovimentadoPor(idu);
			his.setTipoMovimentacao("removido");
			////////////////////////
			
			if (mtrDao.BuscaMaterialDAO(mtr)){				//SE O MATERIAL EXISTIR...
				mtrDao.RemoverMaterialDAO(mtr);				//... REMOVE O MATERIAL...
				out.println("1");							//... E RETORNA '1'
				hisDao.CadastraMovimentacaoDAO(his);		//ADICIONA REMOÇÃO NO HISTORICO
			}else {									 
				out.println("0");							//...SENï¿½O RETORNA '0' INDICANDO QUE O MATERIAL SOLICITADO AINDA Nï¿½O SE ENCONTRA CADASTRADO!
			}
			
			
		}
		
		if (op == 6) //LISTA DE MATERIAL
		{
			ArrayList<ModelMaterial> listaMaterial = mtrDao.listaMaterialDAO();

			request.setAttribute("listaMat", listaMaterial);
			RequestDispatcher listaMat;

			listaMat = request.getRequestDispatcher("listaMaterial.jsp");
			listaMat.forward(request, response);

		}
		
		if(op == 7) //INSERIR MATERIAL
		{
			mtr.setPart_number(request.getParameter("partnumber"));
			mtr.setQuantidade(Integer.parseInt(request.getParameter("quantidade")));
			
			//Inserindo no Historico
			his.setPart_number(request.getParameter("partnumber"));
			his.setQuantidade(Integer.parseInt(request.getParameter("quantidade")));
			his.setMovimentadoPor(idu);
			his.setTipoMovimentacao("inserido");
			////////////////////////
			
			mtrDao.BuscaMaterialDAO(mtr);
			
			if (mtrDao.BuscaMaterialDAO(mtr)){				//SE O MATERIAL EXISTIR...
				mtrDao.InserirMaterialDAO(mtr);				//... INSERE A QUANTIDADE...
				out.println("1");							//... E RETORNA '1'
				hisDao.CadastraMovimentacaoDAO(his);		//ADICIONA INSERï¿½ï¿½O NO HISTORICO
			}else {									 
				out.println("0");							//...SENï¿½O RETORNA '0' INDICANDO QUE O MATERIAL SOLICITADO AINDA Nï¿½O SE ENCONTRA CADASTRADO!
			}
			
		}
		
		if(op == 8) //RETIRAR MATERIAL
		{			
			mtr.setPart_number(request.getParameter("partnumber"));
			mtr.setQuantidade(Integer.parseInt(request.getParameter("quantidade")));
	
			//Inserindo no Historico
			his.setPart_number(request.getParameter("partnumber"));
			his.setQuantidade(Integer.parseInt(request.getParameter("quantidade")));
			his.setMovimentadoPor(idu);
			his.setTipoMovimentacao("retirado (baixa)");
			////////////////////////
			
			mtrDao.BuscaMaterialDAO(mtr);
			
			if (mtrDao.BuscaMaterialDAO(mtr)){		
				mtrDao.RetirarMaterialDAO(mtr);
				out.println("1");
				hisDao.CadastraMovimentacaoDAO(his);
			}else {									 
				out.println("0");
			}
		}
		
		if(op == 9) //LISTAR HISTORICO
		{
			ArrayList<ModelHistorico> listaHistorico = hisDao.listaHistoricoDAO();

			request.setAttribute("listaHis", listaHistorico);
			RequestDispatcher listaHis;

			listaHis = request.getRequestDispatcher("listaHistorico.jsp");
			listaHis.forward(request, response);
		}
		
		if(op == 10) //LISTAR USUARIO
		{
			ArrayList<ModelUsuario> listaUsuario = usrDao.listaUsuarioDAO();

			request.setAttribute("listaUsr", listaUsuario);
			RequestDispatcher listaUsr;

			listaUsr = request.getRequestDispatcher("listaUsuario.jsp");
			listaUsr.forward(request, response);
		}
		
		if(op == 11)
		{
			String usuario = request.getParameter("usuario");
			
			usr.setUsuario(usuario);
			
			//usrDao.BuscarTipoDAO(usr);
			
			String tipo = usrDao.BuscarTipoDAO(usr);
			System.out.println("Aqui: "+tipo);

			if (tipo.equals("Comum")) {
				System.out.println("1");
				out.println("1");
			} else if(tipo.equals("Administrador")){
				System.out.println("0");
				out.println("0");
			} else {
				System.out.println("Erro!");
				out.print("Erro!");
			}
			
		}
		
		if(op == 12) //EXIBE MENU
		{
			RequestDispatcher menu;

			menu = request.getRequestDispatcher("menu.jsp");
			menu.forward(request, response);
		}
		
		if(op == 13) //EXIBE MENU PARA O USUARIO COMUM
		{
			RequestDispatcher menuComum;

			menuComum = request.getRequestDispatcher("menuComum.jsp");
			menuComum.forward(request, response);
		}
		
	}

	

	
	//DOPOST
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
