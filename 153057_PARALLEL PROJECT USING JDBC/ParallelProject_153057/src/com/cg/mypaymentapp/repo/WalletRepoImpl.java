package com.cg.mypaymentapp.repo;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

import com.cg.mypaymentapp.beans.Customer;
import com.cg.mypaymentapp.beans.Wallet;

public class WalletRepoImpl implements WalletRepo {
	private Map<String, Customer> data = new HashMap<String, Customer>();

	public WalletRepoImpl(Map<String, Customer> data) {
		super();
		this.data = data;
	}

	Connection con;

	public WalletRepoImpl() {
		try {

			this.con = DriverManager.getConnection(
					"jdbc:mysql://localhost:3306/test", "root", "corp123");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public boolean save(Customer customer) {
		String query = "insert into Customer(name,mobilenum,wallet) values(?,?,?)";
		try {
		
			PreparedStatement pstmt;
			pstmt = con.prepareStatement(query);
			pstmt.setString(1, customer.getName());
			pstmt.setString(2, customer.getMobileNo());
			Wallet w=customer.getWallet();
			BigDecimal bal=w.getBalance();
			pstmt.setBigDecimal(3, bal);
			pstmt.execute();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// data.put(customer.getMobileNo(), customer);
		return true;
	}

	public Customer findOne(String mobilenum1) {

		String query = "select *  from Customer where mobilenum= ?";
		Customer cu=null;
		try {
			PreparedStatement stmt1;
			stmt1 = con.prepareStatement(query);
		stmt1.setString(1, mobilenum1);
		ResultSet rs = stmt1.executeQuery();
		while (rs.next()) {
			cu=new Customer();
			// if (rs.getString(2).equals(mobilenum1)) {
			cu.setMobileNo(rs.getString(2));
			cu.setName(rs.getString(1));
			Wallet w1=new Wallet();
			w1.setBalance(rs.getBigDecimal(3));
			cu.setWallet(w1);
	
		}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return cu;
	}

	@Override
	public Customer  update(Customer cu1) {
		String query = "UPDATE Customer SET wallet =? where mobilenum=?";
		try {
			PreparedStatement stmt = con.prepareStatement(query);
			Wallet w1 = cu1.getWallet();
			BigDecimal wallet = w1.getBalance();
			stmt.setBigDecimal(1, wallet);
			String mobilenum = cu1.getMobileNo();
			stmt.setString(2, mobilenum);
			stmt.executeUpdate();
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
return cu1;
	}
}