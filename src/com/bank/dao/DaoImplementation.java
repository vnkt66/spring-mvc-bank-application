package com.bank.dao;

import javax.sql.DataSource;


import java.sql.SQLException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class DaoImplementation implements Dao{
	
	
	Connection con = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;
	
	@Override
	public void transferAmount(DataSource dataSource) {
		try {
			if (dataSource.getConnection() != null) {
				con = dataSource.getConnection();
				
				pstmt = con.prepareStatement("insert into transactions (user_id, amount)"
				         + "values(1, 1000)");
				
				@SuppressWarnings("unused")
				int effected = pstmt.executeUpdate();
				
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	@Override
	public int getBalance(DataSource dataSource) {
		int AccountBalance = 0;
		try {
			if (dataSource.getConnection() != null) {
				con = dataSource.getConnection();
				
				pstmt = con.prepareStatement("select balance from account where user_id = 1");
				
				rs = pstmt.executeQuery();
				
				while (rs.next()) {
					AccountBalance = rs.getInt("balance");
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return AccountBalance;
	}

	@Override
	public int updateAccount(DataSource dataSource) {
		int updated = 0;
		try {
			if (dataSource.getConnection() != null) {
				con = dataSource.getConnection();
				int balance = getBalance(dataSource);
				
				pstmt = con.prepareStatement("UPDATE account SET balance = ? - 1000 WHERE user_id = 1");
				pstmt.setInt(1, balance);
				updated = pstmt.executeUpdate();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return updated;
	}
}
