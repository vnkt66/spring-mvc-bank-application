package com.bank.models;

import java.util.*;

public class Transaction {
	private int id;
	private Date date;
	private int amount;
	
	public Transaction() { }
	
	public Transaction(int id, Date date, int amount) {
		this.id = id;
		this.date = date;
		this.amount = amount;
	}
	
	public int getId() {
		return this.id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	public Date getDate() {
		return this.date;
	}
	
	public void setDate(Date date) {
		this.date = date;
	}
	
	public int getAmount() {
		return this.amount;
	}
	
	public void setAmount(int amount) {
		this.amount = amount;
	}
}
