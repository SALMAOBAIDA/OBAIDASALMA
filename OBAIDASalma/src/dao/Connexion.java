package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Connexion {

	public static Connection con;
	public static Statement stm;
	
	public static void Connect() throws ClassNotFoundException, SQLException
	{
		Class.forName("com.mysql.jdbc.Driver");
		String url="jdbc:mysql://localhost/saalmaaobaida";
		con=DriverManager.getConnection(url, "root", "");
		stm=con.createStatement();
	}
	
	public static int Maj(String sql) throws SQLException
	{
		return stm.executeUpdate(sql);
	}
	
	public static ResultSet Select(String sql) throws SQLException
	{
		return stm.executeQuery(sql);
	}
	
	public static void Disconnect() throws SQLException
	{
		stm.close();
		con.close();
	}
}
