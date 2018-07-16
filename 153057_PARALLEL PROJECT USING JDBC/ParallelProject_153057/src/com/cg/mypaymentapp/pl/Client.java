package com.cg.mypaymentapp.pl;

import java.math.BigDecimal;
import java.sql.SQLException;
import java.util.Scanner;

import com.cg.mypaymentapp.beans.Customer;
import com.cg.mypaymentapp.exception.InsufficientBalanceException;
import com.cg.mypaymentapp.exception.InvalidInputException;
import com.cg.mypaymentapp.service.WalletService;
import com.cg.mypaymentapp.service.WalletServiceImpl;

public class Client {
	public static void main(String[] args) throws SQLException {
		Scanner sc = new Scanner(System.in);
		String ans;
		WalletService service;
		{
			service = new WalletServiceImpl();
		}
		do {
			System.out.println("***WELCOME TO RAO BANK***");
			System.out.println("Enter your choice");
			System.out.println("1.Create Account");
			System.out.println("2.Show Balance");
			System.out.println("3.Fund Transfer");
			System.out.println("4.Deposit Ammount");
			System.out.println("5.Withdraw Amount");
			int num = sc.nextInt();
			switch (num) {
			case 1:
				System.out.println("Enter Your name");
				String name = sc.next();
				System.out.println("Enter Mobile Number");
				String number = sc.next();
				System.out.println("Enter Amount");
				BigDecimal amount = sc.nextBigDecimal();
				Customer cu = service.createAccount(name, number, amount);
			
				if(cu==null){
					throw new InvalidInputException("Invalid mobile no ");
				}
				else{
					System.out.println("Account created successfully");
					System.out.println(cu);
					
				}
				break;
			case 2:
				System.out.println("Pls Enter Your  mobile number");
				String mobileno = sc.next();
				Customer cu1 = service.showBalance(mobileno);
				System.out.println(cu1);
				break;
			case 3:
				System.out.println("Enter your mobile number");
				String sourceMobileNo = sc.next();
				System.out
						.println("Enter the mobile number you want to transfer");
				String targetMobileNo = sc.next();
				System.out.println("Enter the amount you want to transfer");
				amount = sc.nextBigDecimal();
				Customer cu2 = service.fundTransfer(sourceMobileNo,
						targetMobileNo, amount);
				System.out.println(cu2);
				break;
			case 4:
				System.out.println("Enter mobile number do u want to deposit");
				String mobileNo = sc.next();
				System.out.println("Enter amount do u want to deposit");
				BigDecimal amount1 = sc.nextBigDecimal();
				Customer cu3 = service.depositAmount(mobileNo, amount1);
				System.out.println(cu3);
				break;
			case 5:
				System.out.println("Enter mobile number do u want to withdraw");
				String mobileNo1 = sc.next();
				System.out.println("Enter amount do u want to withdraw");
				BigDecimal amount2 = sc.nextBigDecimal();
				Customer cu4 = service.withdrawAmount(mobileNo1, amount2);
				if(cu4==null)throw new InsufficientBalanceException("Insufficient Balance");
				else{System.out.println("Amount withdrawn successfully");
					System.out.println(cu4);
				}
				
				break;
			}
			System.out.println("Do you want to continue");
			ans = sc.next();
		} while ((ans.equals("Yes")) | (ans.equals("y")) | (ans.equals("yes")));
	}
}
