package com.cg.mypaymentapp.service;

import java.math.BigDecimal;
import java.sql.SQLException;

import com.cg.mypaymentapp.beans.Customer;

public interface WalletService {

	Customer createAccount(String name, String number, BigDecimal amount) throws SQLException;

	Customer showBalance(String mobileno) throws SQLException;

	Customer fundTransfer(String sourceMobileNo, String targetMobileNo,
			BigDecimal amount) throws SQLException;

	Customer depositAmount(String mobileNo, BigDecimal amount1) throws SQLException;

	Customer withdrawAmount(String mobileNo1, BigDecimal amount2) throws SQLException;
	
}
