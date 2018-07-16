package com.cg.mypaymentapp.test;

import java.math.BigDecimal;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import com.cg.mypaymentapp.beans.Customer;
import com.cg.mypaymentapp.beans.Wallet;
import com.cg.mypaymentapp.exception.InvalidInputException;
import com.cg.mypaymentapp.service.WalletService;
import com.cg.mypaymentapp.service.WalletServiceImpl;

public class TestClass {
	WalletService service;
	{
		service = new WalletServiceImpl();
	}

	
	 @BeforeClass public static void setUpBeforeClass() throws Exception { }
	 
	 @AfterClass public static void tearDownAfterClass() throws Exception { }
	 
	 @Before public void setUp() throws Exception { }
	 
	 @After public void tearDown() throws Exception { }
	 
	@Test
	public void test() {
		// fail("Not yet implemented");
	}

	@Test
	public void name() {
		Map<String, Customer> data = new HashMap<String, Customer>();
		Customer cust1 = new Customer("Amit", "9900112212", new Wallet(
				new BigDecimal(9000)));
		data.put("9900112212", cust1);
	//	service = new WalletServiceImpl();
		assertEquals(cust1.getName(), "Amit");
	}

	@Test
	public void mobilenum() {
		Map<String, Customer> data = new HashMap<String, Customer>();
		Customer cust2 = new Customer("Ajay", "9963242422", new Wallet(
				new BigDecimal(6000)));
		data.put("9963242422", cust2);
		assertEquals(cust2.getMobileNo(), "9963242422");
	}
	@Test(expected=InvalidInputException.class)
	public void test8() throws SQLException
	{
		service.showBalance("1456145616314");
	}
	@Test
	public void wallet() {
		Map<String, Customer> data = new HashMap<String, Customer>();
		Customer cust3 = new Customer("Yogini", "9922950519", new Wallet(
				new BigDecimal(7000)));
		data.put("9922950519", cust3);
	
		Wallet w1=cust3.getWallet();
		assertEquals(w1.getBalance(), new BigDecimal(7000));
	}
	@Test
	public void namenull() {
		Map<String, Customer> data = new HashMap<String, Customer>();
		Customer cust1 = new Customer(null, "9900112212", new Wallet(
				new BigDecimal(9000)));
		data.put("9900112212", cust1);
		assertNull(cust1.getName());
	}
	@Test
	public void test5()
	{
		Map<String, Customer> data = new HashMap<String, Customer>();
		Customer cust1 = new Customer("RAO", null, new Wallet(
				new BigDecimal(9000)));
		data.put("9900112212", cust1);

		assertNull(cust1.getMobileNo());
	}
	@Test
	public void test6()
	{
		Map<String, Customer> data = new HashMap<String, Customer>();
		Customer cust1 = new Customer("RAO","9900112212", new Wallet(null));
		data.put("9900112212", cust1);
		assertNotNull(cust1.getWallet());
	}
@Test(expected=InvalidInputException.class)
public void test7() throws SQLException
{
	service.showBalance("79874774747474");
}
@Test
public void wallet1() {
	Map<String, Customer> data = new HashMap<String, Customer>();
	Customer cust4 = new Customer("RAM", "7842280695", new Wallet(
			new BigDecimal(7000)));
	data.put("7842280695", cust4);

	Wallet w1=cust4.getWallet();
	assertEquals(w1.getBalance(), new BigDecimal(7000));
}
@Test
public void test9()
{
	Map<String, Customer> data = new HashMap<String, Customer>();
	Customer cust1 = new Customer("SRIKANTH", null, new Wallet(
			new BigDecimal(9000)));
	assertNull(cust1.getMobileNo());
}
@Test(expected=InvalidInputException.class)
public void test10() throws SQLException
{
	service.showBalance("011454854250154");
}
@Test
public void test13() {
	Map<String, Customer> data = new HashMap<String, Customer>();
	Customer cust2 = new Customer("Ajay", "9963242422", new Wallet(
			new BigDecimal(6000)));
	data.put("9963242422", cust2);
	assertEquals(cust2.getMobileNo(), "9963242422");
}
@Test
public void test14()
{
	Map<String, Customer> data = new HashMap<String, Customer>();
	Customer cust1 = new Customer("RAO", null, new Wallet(
			new BigDecimal(9000)));
	data.put("9900112212", cust1);

	assertNull(cust1.getMobileNo());
}
@Test
public void test15() {
	Map<String, Customer> data = new HashMap<String, Customer>();
	Customer cust1 = new Customer("Trivedi", "9900112212", new Wallet(
			new BigDecimal(9000)));
	data.put("9900112212", cust1);
	assertEquals(cust1.getName(), "Trivedi");
}


}
