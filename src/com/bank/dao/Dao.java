package com.bank.dao;

import javax.sql.DataSource;

public interface Dao {
	void transferAmount(DataSource datasource);
	int updateAccount(DataSource datasource);
	int getBalance(DataSource datasource);
}
