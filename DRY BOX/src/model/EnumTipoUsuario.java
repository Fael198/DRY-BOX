package model;

public enum EnumTipoUsuario {
	ADMINISTRADOR("Administrador"), COMUM("Comum");
	
	private String tipo;
		
		EnumTipoUsuario(String tipo)
		{
			this.tipo = tipo;
		}
		
		public String getTipo()
		{
			return tipo;
		}
}
