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

import dao.MaterialDAO;
import dao.UsuarioDAO;
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
		
		//INSTANCIANDO MODELS
		ModelUsuario usr = new ModelUsuario();
		ModelMaterial mtr = new ModelMaterial();

		int idu = 1;
		String usuario = request.getParameter("usuario");
		String senha = request.getParameter("senha");
		
		PrintWriter out = response.getWriter();
		response.setContentType("text/html");
		
		if (op == 1) //CADASTRO DE USUÁRIO
		{
			usr.setNome(request.getParameter("nome"));
			usr.setSenha(request.getParameter("senha"));
			usr.setUsuario(request.getParameter("usuario"));
			usr.setEmail(request.getParameter("email"));
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
			
			mtrDao.BuscaMaterialDAO(mtr);	//FUNÇÃO QUE VERIFICA SE O MATERIAL ESTÁ NO BANCO
			
			if (mtrDao.BuscaMaterialDAO(mtr)){		//SE ESTE MATERIAL JÁ TIVER, APENAS ESCREVE '0'
				out.println("0");
			}else {									//SENÃO, ESCREVE '1'... 
				out.println("1");
				mtrDao.CadastraMaterialDAO(mtr);	//... E CADASTRA O MATERIAL NOVO
			}
		}
		
		else if(op == 3) //FAZER LOGIN
		{
			//String usuario = request.getParameter("usuario");
			//String senha = request.getParameter("senha");

			usr.setUsuario(usuario);
			usr.setSenha(senha);

			usrDao.BuscarUsuarioDAO(usr);
			usrDao.MudaStatusUsuarioDAO(usr);

			
			boolean vazio = usrDao.BuscarUsuarioDAO(usr);

			if (vazio) {
				out.println("1");
			} else {
				out.println("0");
			}
		}
		
		else if(op == 4) //REMOVER USUÁRIO
		{
			usrDao.RemoverUsuarioDAO(id);
		}
		
		else if(op == 5) //REMOVER MATERIAL
		{
			mtrDao.RemoverMaterialDAO(id);
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
			String pn = request.getParameter("partnumber");
			
			mtr.setPart_number(request.getParameter("partnumber"));
			mtr.setQuantidade(Integer.parseInt(request.getParameter("quantidade")));
			
			mtrDao.BuscaMaterialDAO(mtr);
			
			if (mtrDao.BuscaMaterialDAO(mtr)){		
				mtrDao.InserirMaterialDAO(mtr);
				out.println("1");
			}else {									 
				out.println("0");
			}
			
		}
		
		if(op == 8) //RETIRAR MATERIAL
		{
			String pn = request.getParameter("partnumber");
			
			mtr.setPart_number(request.getParameter("partnumber"));
			mtr.setQuantidade(Integer.parseInt(request.getParameter("quantidade")));
	
			mtrDao.BuscaMaterialDAO(mtr);
			
			if (mtrDao.BuscaMaterialDAO(mtr)){		
				mtrDao.RetirarMaterialDAO(mtr);
				out.println("1");
			}else {									 
				out.println("0");
			}
		}
		
		if(op == 9) //SAIR DO SISTEMA
		{
			usr.setUsuario(usuario);
			usr.setSenha(senha);
			
			usrDao.SairSistemaUsuarioDAO(usr);
		}
		
		
		
	}

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	//DOPOST
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
