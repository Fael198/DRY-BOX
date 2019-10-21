package model;

import java.util.Date;

public class ModelHistorico {
	
	private int id;
	private String part_number;
	private int quantidade;			//quantidade alocada durante a movimentação
	private int movimentadoPor;
	private Date movimentadoEm;
	private String tipoMovimentacao;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getPart_number() {
		return part_number;
	}
	public void setPart_number(String part_number) {
		this.part_number = part_number;
	}
	public int getQuantidade() {
		return quantidade;
	}
	public void setQuantidade(int quantidade) {
		this.quantidade = quantidade;
	}
	public int getMovimentadoPor() {
		return movimentadoPor;
	}
	public void setMovimentadoPor(int movimentadoPor) {
		this.movimentadoPor = movimentadoPor;
	}
	public Date getMovimentadoEm() {
		return movimentadoEm;
	}
	public void setMovimentadoEm(Date movimentadoEm) {
		this.movimentadoEm = movimentadoEm;
	}
	public String getTipoMovimentacao() {
		return tipoMovimentacao;
	}
	public void setTipoMovimentacao(String tipoMovimentacao) {
		this.tipoMovimentacao = tipoMovimentacao;
	}
	
}
