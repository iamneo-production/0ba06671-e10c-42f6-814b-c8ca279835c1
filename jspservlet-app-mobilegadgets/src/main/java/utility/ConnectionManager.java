package utility;

import java.sql.*;

public class ConnectionManager{
	Connection con;
	// static DriverManager manager;

    public ConnectionManager(){}
	public Connection getConnection() throws Exception{
		Class.forName("com.mysql.jdbc.Driver");
		con = DriverManager.getConnection("jdbc:mysql://localhost/nikitha","root","examly");
		return con;
	}
}