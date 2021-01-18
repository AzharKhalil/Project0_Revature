package JDBC;

import java.sql.Connection;
import java.sql.DriverManager;

public class JDBCconnection {

	private static Connection conn = null;
	public static Connection getConnection() {
		try {
			
			if(conn == null) {
				
				Class.forName("oracle.jdbc.driver.OracleDriver");
				String endpoint = "revature-projects.cr4e7pifzmvz.us-east-1.rds.amazonaws.com";
				String url = "jdbc:oracle:thin:@" + endpoint + ":1521:ORCL";
				String username = "azhar";
				String password = "azhar1234";
				
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
