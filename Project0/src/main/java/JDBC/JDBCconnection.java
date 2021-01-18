package JDBC;

import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Properties;

public class JDBCconnection {

	private static Connection conn = null;
	public static Connection getConnection() {
		
		Properties pros = new Properties();
		
		try {
			
			if(conn == null) {
				
				Class.forName("oracle.jdbc.driver.OracleDriver");
				
				String url = pros.getProperty("url");
				String username = pros.getProperty("userName");
				String password = pros.getProperty("password");
				
				conn = DriverManager.getConnection(url, username, password);
				return conn;
				
			}
			else {
				return conn;
			}
			
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		
		return null;
		
	}
	
	public static void main(String[] args) {
		System.out.println(getConnection());
	}
}
