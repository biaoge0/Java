package org.lxy.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import org.lxy.exception.AccountException;

/**
 * 没有使用ThreadLocal
 * @author menglanyingfei
 * @date 2017-5-4
 */
public class _AccountDaoImpl /* implements AccountDao */ {
	
	// 从accountOut账户转出money
	public void accountOut(Connection con, String accountOut, double money) throws SQLException, AccountException {
		String sql = "update account set money=money-? where name=?";
		
		PreparedStatement pst = con.prepareStatement(sql);
		pst.setDouble(1, money);
		pst.setString(2, accountOut);
		int row = pst.executeUpdate();
		
		if (row == 0) {
			throw new AccountException("转出失败");
		}
		pst.close();
	}

	// 从accountIn账户转入money
	public void accountIn(Connection con, String accountIn, double money) throws SQLException, AccountException {
		String sql = "update account set money=money+? where name=?";
		
		PreparedStatement pst = con.prepareStatement(sql);
		pst.setDouble(1, money);
		pst.setString(2, accountIn);
		int row = pst.executeUpdate();
		
		if (row == 0) {
			throw new AccountException("转入失败");
		}
		pst.close();
	}

}




















