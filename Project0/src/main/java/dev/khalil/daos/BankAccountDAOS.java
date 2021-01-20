package dev.khalil.daos;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import JDBC.JDBCconnection;
import dev.khalil.entities.BankAccount;
import dev.khalil.entities.User;

public class BankAccountDAOS {

	Connection conn = JDBCconnection.getConnection();

	public boolean createAccount(BankAccount bac) {
		try {
			String sql = "Call add_account(? , ?, ?)";
			CallableStatement cs = conn.prepareCall(sql);
			cs.setString(1, Double.toString(bac.getBalance()));
			cs.setString(2, Integer.toString(bac.getPin()));
			cs.setString(3, Integer.toString(bac.getUserId()));
			cs.execute();
			return true;

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return false;
	}

	public List<BankAccount> getAccountsbyId(int id) {

		List<BankAccount> bankList = new ArrayList<BankAccount>();

		try {
			String sql = "select * from bank_account where user_id = ?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, Integer.toString(id));
			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				BankAccount ba = new BankAccount();
				ba.setBankId(rs.getInt("ID"));
				ba.setBalance(rs.getDouble("BALANCE"));
				ba.setUserId(rs.getInt("USER_ID"));
				ba.setPin(rs.getInt("PIN"));

				bankList.add(ba);

			}

			return bankList;

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return null;

	}

	public List<BankAccount> getAllAcounts() {

		List<BankAccount> bankList = new ArrayList<BankAccount>();
		try {

			String sql = "select * from bank_account";
			PreparedStatement ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();

			while (rs.next()) {

				BankAccount ba = new BankAccount();
				ba.setBankId(rs.getInt("ID"));
				ba.setBalance(rs.getDouble("BALANCE"));
				ba.setUserId(rs.getInt("USER_ID"));
				ba.setPin(rs.getInt("PIN"));

				bankList.add(ba);

			}
			return bankList;

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return null;
	}

	public boolean deposit(BankAccount ba) {

		try {

			String sql = "update bank_account set balance = ? where id = ?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, Double.toString(ba.getBalance()));
			ps.setString(2, Integer.toString(ba.getBankId()));
			ps.executeQuery();
			return true;

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return false;
	}

	public boolean withdraw(BankAccount ba) {

		try {

			String sql = "update bank_account set balance = ? where id =? ";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, Double.toString(ba.getBalance()));
			ps.setString(2, Integer.toString(ba.getBankId()));
			ps.executeQuery();
			return true;

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return false;

	}

	public boolean deleteAccount(int accNum) {

		try {
			String sql = "delete bank_account where id = ?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, Integer.toString(accNum));
			ps.executeQuery();
			return true;
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return false;
	}

	public boolean updatePin(int accNum, int pin) {
	
		try {
			String sql = "update bank_account set pin = ? where id = ?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, Integer.toString(pin));
			ps.setString(2, Integer.toString(accNum));
			ps.executeQuery();
			return true;
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		
		
		
		return false;
	}

}
