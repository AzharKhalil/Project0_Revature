package dev.khalil.daos;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

import dev.khalil.entities.Admin;

public class AdminDAOS extends EmployeeDAOS {

	public boolean signUp(Admin admin) {

		try {

			String sql = "call add_admin(?, ?, ?)";
			CallableStatement cs = conn.prepareCall(sql);
			cs.setString(1, admin.getName());
			cs.setString(2, admin.getUserName());
			cs.setString(3, admin.getPassword());
			cs.execute();
			return true;

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	} 
	
	
	public Admin signIn(Admin admin) {
		try {
			String sql = "select * from admins where username= ? AND passoword = ?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, admin.getUserName());
			ps.setString(2, admin.getPassword());
			ResultSet rs = ps.executeQuery();
			
			if(rs.next()) {
				admin.setAdminId(rs.getInt("ID"));
				admin.setName(rs.getString("NAME"));
				admin.setUserName(rs.getString("USERNAME"));
				admin.setPassword(rs.getString("PASSOWORD"));
				return admin;
			}
			
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		
		
		
		
		return null;
	} 
	

}
