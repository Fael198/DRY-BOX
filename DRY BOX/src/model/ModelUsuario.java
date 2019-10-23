package model;

public class ModelUsuario {
	private int id_usuario;
	private String nome;
	private String senha;
	private String usuario;
	private String email;
	private String tipo;
	private boolean status;
	private int criadoPor;
	private String criadoEm;
	private int modificadoPor;
	private String modificadoEm;
	private int removidoPor;
	private String removidoEm;
	
	
	//GET E SET
	public int getId_usuario() {
		return id_usuario;
	}
	public void setId_usuario(int id_usuario) {
		this.id_usuario = id_usuario;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getSenha() {
		return senha;
	}
	public void setSenha(String senha) {
		this.senha = senha;
	}
	public String getUsuario() {
		return usuario;
	}
	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getTipo() {
		return tipo;
	}
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	public boolean isStatus() {
		return status;
	}
	public void setStatus(boolean status) {
		this.status = status;
	}
	public int getCriadoPor() {
		return criadoPor;
	}
	public void setCriadoPor(int criadoPor) {
		this.criadoPor = criadoPor;
	}
	public String getCriadoEm() {
		return criadoEm;
	}
	public void setCriadoEm(String criadoEm) {
		this.criadoEm = criadoEm;
	}
	public int getModificadoPor() {
		return modificadoPor;
	}
	public void setModificadoPor(int modificadoPor) {
		this.modificadoPor = modificadoPor;
	}
	public String getModificadoEm() {
		return modificadoEm;
	}
	public void setModificadoEm(String modificadoEm) {
		this.modificadoEm = modificadoEm;
	}
	public int getRemovidoPor() {
		return removidoPor;
	}
	public void setRemovidoPor(int removidoPor) {
		this.removidoPor = removidoPor;
	}
	public String getRemovidoEm() {
		return removidoEm;
	}
	public void setRemovidoEm(String removidoEm) {
		this.removidoEm = removidoEm;
	}
	
	
	
}
