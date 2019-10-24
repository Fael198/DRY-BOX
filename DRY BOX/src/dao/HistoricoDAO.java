package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import model.ModelHistorico;
import model.ModelMaterial;
import util.Conexao;

public class HistoricoDAO {

private Conexao con;
	
	public HistoricoDAO() //CRIA A CONEX�O COM O BANCO DE DADOS
	{
		con = new Conexao();
	}
	
	public void CadastraMovimentacaoDAO(ModelHistorico his) {
		Connection conex = con.conectar();
		
		try {
			PreparedStatement ca = conex.prepareStatement("INSERT INTO historico VALUES (0,?,?,?,NOW(),?)");

			ca.setString(1, his.getPart_number());
			ca.setInt(2, his.getQuantidade());
			ca.setInt(3, his.getMovimentadoPor());
			ca.setString(4, his.getTipoMovimentacao());
			
			ca.execute();
			
		} catch (Exception e) {
			System.out.println("Erro: HistoricoDAO" + e.getMessage());

		}
	}
	
	public ArrayList<ModelHistorico> listaHistoricoDAO() {
		Connection conex = con.conectar();

		try {
			PreparedStatement ca = conex.prepareStatement("SELECT * FROM historico ORDER BY movimentadoEm DESC");		//Apresenta os dados cadastrados no histórico..
			ResultSet res = ca.executeQuery();																						//.. em ordem à data de movimentação mais recente.
			ArrayList<ModelHistorico> listaHis = new ArrayList<ModelHistorico>();
			while (res.next()) {
				ModelHistorico his = new ModelHistorico();
				his.setId(res.getInt("id"));
				his.setPart_number(res.getString("partnumber"));
				his.setQuantidade(res.getInt("qtd"));
				his.setMovimentadoPor(res.getInt("movimentadoPor"));
				his.setMovimentadoEm(res.getTimestamp("movimentadoEm"));
				his.setTipoMovimentacao(res.getString("tipoMovimentacao"));
				
				listaHis.add(his);

			}

			return listaHis;
		} catch (Exception e) {
			System.out.println("Erro: HistoricoDAO (listaHistoricoDAO). " + e.getMessage());
			return null;
		}
	}
}
