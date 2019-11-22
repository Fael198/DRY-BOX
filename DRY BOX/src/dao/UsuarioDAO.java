package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import model.ModelHistorico;
import model.ModelUsuario;
import util.Conexao;

public class UsuarioDAO {
	
	private Conexao con;
	
	public UsuarioDAO() //CRIA A CONEX�O COM O BANCO DE DADOS
	{
		con = new Conexao();
	}
	
	public boolean BuscarUsuarioDAO(ModelUsuario usr) {
		Connection conex = con.conectar();

		try {
			
			//Verifica se usuario está cadastrado
			PreparedStatement ca = conex.prepareStatement("SELECT id, usuario FROM usuario WHERE usuario=? and senha=?");	//Comando SQL (SELECT)
			ca.setString(1, usr.getUsuario());
			ca.setString(2, usr.getSenha());
			ca.execute();

			// Executando o Query do BD
			ResultSet c = ca.executeQuery();
			int row = 0;// variável que vai contar as linhas (row) do BD
			while (c.next()) {
				row++;
			}

			System.out.println(row);

			// Validação
			if (row == 1) {
				return true;
			} else {
				return false;
			}

		} catch (Exception e) {
			System.out.println("Erro: UsuarioDAO (BuscaUsuarioDAO)" + e.getMessage());			//Mensagem de erro
			return false;
		}
	}
	
	public boolean BuscarNomeUsuarioDAO(ModelUsuario usr) {
		Connection conex = con.conectar();

		try {
			
			//Verifica se usuario está cadastrado
			PreparedStatement ca = conex.prepareStatement("SELECT id, usuario FROM usuario WHERE usuario=?");	//Comando SQL (SELECT)
			ca.setString(1, usr.getUsuario());
			ca.execute();

			// Executando o Query do BD
			ResultSet c = ca.executeQuery();
			int row = 0;// variável que vai contar as linhas (row) do BD
			while (c.next()) {
				row++;
			}

			System.out.println(row);

			// Validação
			if (row == 1) {
				return true;
			} else {
				return false;
			}

		} catch (Exception e) {
			System.out.println("Erro: UsuarioDAO (BuscaNomeUsuarioDAO)" + e.getMessage());			//Mensagem de erro
			return false;
		}
	}
	
	public String BuscarTipoDAO(ModelUsuario usr) {
		Connection conex = con.conectar();
		
		try {
			PreparedStatement ca = conex.prepareStatement("SELECT usuario.tipo FROM usuario WHERE usuario = ?");
			ca.setString(1, usr.getUsuario());
			
			ResultSet res = ca.executeQuery(); // parei aqui
			res.next();
			
			String tipo = res.getString("tipo");
			//System.out.println(tipo);

			return tipo;
		
		} catch(Exception e) {
			System.out.println("Erro: UsuarioDAO (BuscaTipoDAO)" + e.getMessage());			//Mensagem de erro
			return "Erro!";
		}
	}
	
	public void CadastraUsuarioDAO(ModelUsuario usr) {
		Connection conex = con.conectar();
		
		try {
			PreparedStatement ca = conex.prepareStatement("INSERT INTO usuario VALUES (0,?,?,?,?,?,0)");	//Comando SQL (INSERT)

			ca.setString(1, usr.getNome());
			ca.setString(2, usr.getSenha());
			ca.setString(3, usr.getUsuario());
			ca.setString(4, usr.getEmail());
			ca.setString(5, usr.getTipo());
			ca.execute();
			
		} catch (Exception e) {
			System.out.println("Erro: UsuarioDao(CadastraUsuarioDAO)" + e.getMessage());				//Mensagem de erro
		}
	}
	
	public List<ModelUsuario> BuscaTipoUsuario(String usuario, String senha, String tipo) {
		Connection conex = con.conectar();
		
		try {
		PreparedStatement ca = conex.prepareStatement("SELECT usuario.usuario, usuario.senha, usuario.tipo FROM usuario WHERE usuario = ? and senha = ? and tipo = ?");
		
		ResultSet res = ca.executeQuery();
		ArrayList<ModelUsuario> listaUsu = new ArrayList<ModelUsuario>();
		while (res.next()) {
			ModelUsuario usu = new ModelUsuario();
			usu.setNome(res.getString(usuario));
			usu.setSenha(res.getString(senha));
			usu.setTipo(res.getString(tipo));
			listaUsu.add(usu);
		}
		
		return listaUsu;
		
		
		} catch (Exception e) {
			System.out.println("" + e.getMessage());
			return null;
		}
		
	}
	
	public void RemoverUsuarioDAO(ModelUsuario usr)
	{
		Connection conex = con.conectar();

		try {
			PreparedStatement ca = conex.prepareStatement("DELETE FROM usuario WHERE usuario=?");
			ca.setString(1, usr.getUsuario());
			ca.execute();
		} catch (Exception e) {
			System.out.println("Erro: UsuarioDAO (RemoverUsuarioDAO)" + e.getMessage());
		}
	}
	
	public void MudaStatusUsuarioDAO(ModelUsuario usr)
	{
		Connection conex = con.conectar();
		
		try {
			PreparedStatement ca = conex.prepareStatement("UPDATE usuario SET status = 1 WHERE usuario=? and senha=?");
			ca.setString(1, usr.getUsuario());
			ca.setString(2, usr.getSenha());
			ca.execute();
			
		} catch (Exception e) {
			System.out.println("Deu ruim" + e.getMessage());

		}
	}
	
	public void SairSistemaUsuarioDAO(ModelUsuario usr) 
	{
		Connection conex = con.conectar();
		
		try {
			PreparedStatement ca = conex.prepareStatement("UPDATE usuario SET status = 0 WHERE usuario=? and senha=?");
			ca.setString(1, usr.getUsuario());
			ca.setString(2, usr.getSenha());
			ca.execute();
			
		} catch (Exception e) {
			System.out.println("Deu ruim" + e.getMessage());

		}
	}
	
	public ArrayList<ModelUsuario> listaUsuarioDAO() {
		Connection conex = con.conectar();

		try {
			PreparedStatement ca = conex.prepareStatement("SELECT * FROM usuario");		
			ResultSet res = ca.executeQuery();																						
			ArrayList<ModelUsuario> listaUsr = new ArrayList<ModelUsuario>();
			while (res.next()) {
				ModelUsuario usr = new ModelUsuario();
				usr.setNome(res.getString("nome"));
				usr.setSenha(res.getString("senha"));
				usr.setUsuario(res.getString("usuario"));
				usr.setEmail(res.getString("email"));
				usr.setTipo(res.getString("tipo"));
				
				listaUsr.add(usr);
			}

			return listaUsr;
		} catch (Exception e) {
			System.out.println("Erro: UsuarioDAO (listaUsuarioDAO). " + e.getMessage());
			return null;
		}
	}
}
