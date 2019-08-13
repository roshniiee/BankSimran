package com.ui;

import java.util.Random;
import java.util.Scanner;

import com.entity.Customer;
import com.service.BankService;

public class User {
	Random random = new Random();
	BankService bankService = new BankService();
	Customer customer = new Customer();
	Scanner scan = new Scanner(System.in);

	public void createAccount() {
		System.out.println("Customer Application");
		System.out.println("---------------------------------------");
		System.out.println("Enter Your Full Name:");
		String name = scan.next();
		customer.setName(name);
		System.out.println("Enter Your Mobile Number:");
		long phone = scan.nextLong();
		customer.setPhoneNumber(phone);
		System.out.println("Enter Your 12 Digit Aadhar Number:");
		long aadhar = scan.nextLong();
		customer.setAadharNumber(aadhar);
		long accNo = random.nextInt(1000000000);
		customer.setAccountNumber(accNo);
		customer.setBalance(500);
		System.out.println("Your Initial Balance: " + customer.getBalance());
		System.out.println("Your Account Number : " + customer.getAccountNumber());
		System.out.println("Your Account is created Successfully!!");
		bankService.createAccount(customer);

	}

	public void showBalance() {
		System.out.println("Enter Your Account Number:");
		long accNo = scan.nextLong();
		float balance = bankService.showBalance(accNo);
		System.out.println("Your Balance is:" + balance);
	}

	public void deposit() {
		System.out.println("Enter Account Number:");
		long accno = scan.nextLong();
		Customer cust = bankService.getByAccountNumber(accno);
		float initialBalance = cust.getBalance();
		System.out.println("enter Amount to be Deposited:");
		int amount = scan.nextInt();
		float finalBalance = initialBalance + amount;
		cust.setBalance(finalBalance);
		bankService.deposit(cust);

	}

	public void withdraw() {
		System.out.println("Enter Account Number:");
		long acc = scan.nextLong();
		Customer c = bankService.getByAccountNumber(acc);
		float initialBal = c.getBalance();
		System.out.println("enter amount to be withdrawed:");
		int amt = scan.nextInt();
		float finalbal = initialBal - amt;
		c.setBalance(finalbal);
		bankService.withdraw(c);
	}

	public void fundTransfer() {
System.out.println("Enter your AccountNumber:");
long sourceAccNo=scan.nextLong();
System.out.println("enter the AccountNumber:");
long destinationAccNo=scan.nextLong();
Customer sourceCust = bankService.getByAccountNumber(sourceAccNo);
float SourceinitialBalance = sourceCust.getBalance();
System.out.println("enter Amount to be transfered:");
int tfamount = scan.nextInt();
Customer DestiCust = bankService.getByAccountNumber(destinationAccNo);
float DestinationinitialBalance = DestiCust.getBalance();
float sourceFinalbal=SourceinitialBalance-tfamount;
float destinationFinalbal=DestinationinitialBalance+tfamount;
sourceCust.setBalance(sourceFinalbal);
DestiCust.setBalance(destinationFinalbal);
bankService.fundTransfer(sourceCust,DestiCust);
	}

	public void printTransactions() {

	}

}
