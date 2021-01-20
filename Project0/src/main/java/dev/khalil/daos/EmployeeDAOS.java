package dev.khalil.daos;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import JDBC.JDBCconnection;
import dev.khalil.entities.User;

public class EmployeeDAOS implements EmployeeDAOSInterface {

	Connection conn = JDBCconnection.getConnection();

	public boolean signUp(User user) {
		try {
			String sql = "call add_user(?,?,?)";
			CallableStatement cs = conn.prepareCall(sql);
			cs.setString(1, user.getName());
			cs.setString(2, user.getUserName());
			cs.setString(3, user.getPassword());
			cs.execute();
			return true;
		} catch (SQLException e) {

			e.printStackTrace();

		}
		return false;
	}

	@Override
	public User signIn(User user) {
		try {
			String sql = "Select * from users where username = ? AND passowrd = ?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, user.getUserName());
			ps.setString(2, user.getPassword());

			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				user.setUserID(rs.getInt("ID"));
				user.setName(rs.getString("NAME"));
				user.setUserName(rs.getString("USERNAME"));
				user.setPassword(rs.getString("PASSOWRD"));
				return user;
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public List<User> getAllUsers() {
		List<User> userList = new ArrayList<User>();

		try {

			String sql = "Select * from users";
			PreparedStatement ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {

				User user = new User();
				user.setUserID(rs.getInt("ID"));
				user.setName(rs.getString("NAME"));
				user.setUserName(rs.getString("USERNAME"));
				user.setPassword(rs.getString("PASSOWRD"));
				userList.add(user);
			}
			return userList;

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return null;
	}

	public boolean deleteUser(String userName) {

		try {

			String sql = "delete users where username = ?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, userName);
			ps.executeQuery();
			return true;

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return false;
	}

	@Override
	public boolean updateuserName(String puserName, String nuserName) {
		// TODO Auto-generated method stub

		try {

			String sql = "update users set username=? where username = ?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, nuserName);
			ps.setString(2, puserName);
			ps.executeQuery();
			return true;

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return false;

	}

	@Override
	public boolean updatePassword(String userName, String pass) {
		try {

			String sql = "update users set password = ? where username = ?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, pass);
			ps.setString(2, userName);
			ps.executeQuery();
			return true;

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}

}
