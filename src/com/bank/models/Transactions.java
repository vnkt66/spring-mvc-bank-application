package com.bank.models;

import java.util.*;

public class Transactions {

	private int id;
	private int userId;
	private Date date;
	private int amount;
	
	public Transactions() { }
	
	public Transactions(int id,int userId, Date date, int amount) {
		this.id = id;
		this.userId = userId;
		this.date = date;
		this.amount = amount;
	}
	
	public int getId() {
		return this.id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	public int getUserId() {
		return this.userId;
	}
	
	public void setUserId(int userId) {
		this.userId = userId;
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