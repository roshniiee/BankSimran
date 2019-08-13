package com.service;

import com.dao.BankDAO;
import com.entity.Customer;

public class BankService {
	BankDAO bankDao = new BankDAO();

	public Customer getByAccountNumber(long AccNo) {
		Customer customer = bankDao.getByAccountNumber(AccNo);
		return customer;

	}

	public void createAccount(Customer customer) {
		bankDao.beginTransaction();
		bankDao.createAccount(customer);
		bankDao.commitTransaction();
	}

	public float showBalance(long accNo) {
		bankDao.beginTransaction();
		float balance = bankDao.showBalance(accNo);
		bankDao.commitTransaction();
		return balance;
	}

	public void deposit(Customer cust) {
		bankDao.beginTransaction();
		bankDao.deposit(cust);
		bankDao.commitTransaction();

	}

	public void withdraw(Customer custom) {
		bankDao.beginTransaction();
		bankDao.withdraw(custom);
		bankDao.commitTransaction();
	}

	public void fundTransfer(Customer sourceCust, Customer destiCust) {
		bankDao.beginTransaction();
		bankDao.fundTransfer(sourceCust,destiCust);
		bankDao.commitTransaction();
	}

	public void printTransactions() {

	}
}
