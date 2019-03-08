package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import model.ModelMaterial;
import model.ModelUsuario;
import util.Conexao;

public class UsuarioDAO {
	
	private Conexao con;
	
	public UsuarioDAO() //CRIA A CONEXÃO COM O BANCO DE DADOS
	{
		con = new Conexao();
	}
	
	public boolean BuscarUsuarioDAO(ModelUsuario usr) {
		Connection conex = con.conectar();

		try {
			PreparedStatement ca = conex.prepareStatement("SELECT id, usuario FROM usuario WHERE usuario=? and senha=?");
			ca.setString(1, usr.getUsuario());
			ca.setString(2, usr.getSenha());
			ca.execute();

			// Executando o Query do BD
			ResultSet c = ca.executeQuery();
			int row = 0; // variável que vai contar as linhas (row) do BD
			while (c.next()) {
				row++;
			}

			System.out.println(row);

			// validação
			if (row == 1) {
				return true;
			} else {
				return false;
			}

		} catch (Exception e) {
			System.out.println("Erro na alteração." + e.getMessage());
			return false;
		}
	}
	
	public void CadastraUsuarioDAO(ModelUsuario usr) {
		Connection conex = con.conectar();
		
		try {
			PreparedStatement ca = conex.prepareStatement("INSERT INTO usuario VALUES (0,?,?,?,?,0)");

			ca.setString(1, usr.getNome());
			ca.setString(2, usr.getSenha());
			ca.setString(3, usr.getUsuario());
			ca.setString(4, usr.getEmail());
			ca.execute();
			
		} catch (Exception e) {
			System.out.println("Deu ruim" + e.getMessage());

		}
	}
	
	public void RemoverUsuarioDAO(int id)
	{
		Connection conex = con.conectar();
		
		try {
			
			PreparedStatement ca = conex.prepareStatement("DELETE FROM usuario WHERE id=?");
			ca.setInt(1, id);
			ca.execute();
			
		} catch (Exception e) {
			System.out.println("Erro na remoção." + e.getMessage());
		}
	}
}
