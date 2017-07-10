package br.ufc.pelotonmonitor.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseDao {

	public Connection connectionDatabaseDefault(String ip, String port, String password) throws ClassNotFoundException, SQLException{
		Class.forName("org.postgresql.Driver");
		Connection connection = DriverManager
				.getConnection("jdbc:postgresql://"+ip+":"+port+"/","default_database", "");
		return connection;
	}
	
	public Connection connectionDatabaseMeta(String ip, String port, String password) throws ClassNotFoundException, SQLException{
		Class.forName("org.postgresql.Driver");
		Connection connection = DriverManager
				.getConnection("jdbc:postgresql://"+ip+":"+port+"/","pg_catalog", "");
		return connection;
	}
	
	
	
}
