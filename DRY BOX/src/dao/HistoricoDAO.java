package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;

import model.ModelHistorico;
import util.Conexao;

public class HistoricoDAO {

private Conexao con;
	
	public HistoricoDAO() //CRIA A CONEXÃO COM O BANCO DE DADOS
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
}
