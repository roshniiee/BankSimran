package com.dao;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import com.entity.Customer;

public class BankDAO {
	Customer customer = new Customer();
	EntityManager entity = UtilJava.getEntityManager();

	public Customer getByAccountNumber(long accNo) {
		customer = entity.find(Customer.class, accNo);
		return customer;
	}

	public void createAccount(Customer customer) {
		entity.persist(customer);

	}

	public Float showBalance(long accNo) {

		customer = entity.find(Customer.class, accNo);

		return customer.getBalance();

	}

	public void deposit(Customer cust) {
		entity.merge(cust);
	}

	public void withdraw(Customer custom) {
		entity.merge(custom);
	}

	public void fundTransfer(Customer sourceCust, Customer destiCust) {
		entity.merge(sourceCust);
		entity.merge(destiCust);
	}

	public void printTransactions() {

	}

	public void commitTransaction() {
		entity.getTransaction().commit();

	}

	public void beginTransaction() {
		entity.getTransaction().begin();

	}
}
