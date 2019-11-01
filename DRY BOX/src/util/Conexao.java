package util;

import java.sql.Connection;
import java.sql.DriverManager;

public class Conexao {
	public Conexao()
	{
	}

	public Connection conectar()
	{
		try
		{
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/dry box","root","root");
			return con;
		}
		catch(ClassNotFoundException e)
		{
			System.out.println("Sem driver "+e.getMessage());
			return null;
		}
		catch(Exception e)
		{
			System.out.println("Nao conectou "+e.getMessage());
			return null;
		}
	}
}
