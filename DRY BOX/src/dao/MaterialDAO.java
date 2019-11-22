package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import model.ModelMaterial;
import util.Conexao;

public class MaterialDAO {
	
	private Conexao con;
	
	public MaterialDAO() //CRIA A CONEX�O COM O BANCO DE DADOS
	{
		con = new Conexao();
	}
	
	public boolean BuscaMaterialDAO(ModelMaterial mtr) {
		Connection conex = con.conectar();

		try {
			PreparedStatement ca = conex.prepareStatement("SELECT id, partnumber FROM material WHERE partnumber=?");
			ca.setString(1, mtr.getPart_number());
			ca.execute();

			// Executando o Query do BD
			ResultSet c = ca.executeQuery();
			int row = 0; // vari�vel que vai contar as linhas (row) do BD
			while (c.next()) {
				row++;
			}

			System.out.println(row);

			// valida��o
			if (row == 1) {
				return true;
			} else {
				return false;
			}

		} catch (Exception e) {
			System.out.println("Erro: MatereialDAO (BuscaMaterialDAO)." + e.getMessage());
			return false;
		}
	}
	
	public void CadastraMaterialDAO(ModelMaterial mtr) {
		Connection conex = con.conectar();
		
		try {
			PreparedStatement ca = conex.prepareStatement("INSERT INTO material VALUES (0,?,?,?,?,?,?,?,NOW(),0,NOW(),0,NOW(),0,NOW(),0,NOW(),0)");

			ca.setString(1, mtr.getPart_number());
			ca.setInt(2, mtr.getQuantidade());
			ca.setString(3, mtr.getLocalizacao());
			ca.setString(4, mtr.getDescricao());
			ca.setInt(5, mtr.getQuantidadeMin());
			ca.setInt(6, mtr.getQuantidadeMax());
			ca.setInt(7, mtr.getCriadoPor());
			
			ca.execute();
			
		} catch (Exception e) {
			System.out.println("Erro: MaterialDAO (CadastraMaterialDAO)" + e.getMessage());

		}
	}
	
	public ArrayList<ModelMaterial> listaMaterialDAO() {
		Connection conex = con.conectar();

		try {
			PreparedStatement ca = conex.prepareStatement("SELECT * FROM material");
			ResultSet res = ca.executeQuery();
			ArrayList<ModelMaterial> listaMat = new ArrayList<ModelMaterial>();
			while (res.next()) {
				ModelMaterial mat = new ModelMaterial();
				mat.setId_material(res.getInt("id"));
				mat.setPart_number(res.getString("partnumber"));
				mat.setQuantidade(res.getInt("quantidade"));
				mat.setLocalizacao(res.getString("localizacao"));
				mat.setDescricao(res.getString("descricao"));
				mat.setQuantidadeMin(res.getInt("quantidadeMin"));
				mat.setQuantidadeMax(res.getInt("quantidadeMax"));
				listaMat.add(mat);

			}

			return listaMat;
		} catch (Exception e) {
			System.out.println("Erro: MaterialDAO (ListarMaterialDAO). " + e.getMessage());
			return null;
		}
	}
	
	public void RemoverMaterialDAO(ModelMaterial mtr) {

		Connection conex = con.conectar();

		try {
			PreparedStatement ca = conex.prepareStatement("DELETE FROM material WHERE partnumber=?");
			ca.setString(1, mtr.getPart_number());
			ca.execute();
		} catch (Exception e) {
			System.out.println("Erro: MaterialDAO (RemoverMaterialDAO)" + e.getMessage());
		}
	}
	
	public void InserirMaterialDAO(ModelMaterial mtr) {

		Connection conex = con.conectar();

		try {
			PreparedStatement ca = conex.prepareStatement("UPDATE material SET quantidade = quantidade+? WHERE partnumber=?");
			ca.setInt(1, mtr.getQuantidade());
			ca.setString(2, mtr.getPart_number());
			ca.execute();
		} catch (Exception e) {
			System.out.println("Erro: MaterialDAO (InserirMaterialDAO)" + e.getMessage());
		}
	}
	
	public void RetirarMaterialDAO(ModelMaterial mtr) {

		Connection conex = con.conectar();

		try {
			PreparedStatement ca = conex.prepareStatement("UPDATE material SET quantidade = quantidade-? WHERE partnumber=?");
			ca.setInt(1, mtr.getQuantidade());
			ca.setString(2, mtr.getPart_number());
			ca.execute();
		} catch (Exception e) {
			System.out.println("Erro: MaterialDAO ( RetirarMaterialDAO)" + e.getMessage());
		}
	}
	
	public void AlterarMaterialDAO(ModelMaterial mtr) {

		Connection conex = con.conectar();

		try {
			PreparedStatement ca = conex.prepareStatement("UPDATE material SET quantidade=?, localizacao=?, descricao=?, quantidadeMin=?, quantidadeMax=? WHERE partnumber=?");
			ca.setInt(1, mtr.getQuantidade());
			ca.setString(2, mtr.getLocalizacao());
			ca.setString(3, mtr.getDescricao());
			ca.setInt(4, mtr.getQuantidadeMin());
			ca.setInt(5, mtr.getQuantidadeMax());
			ca.setString(6, mtr.getPart_number());
			ca.execute();
		} catch (Exception e) {
			System.out.println("Erro: MaterialDAO (AlterarMaterialDAO)" + e.getMessage());
		}
	}
}
