package com.bank.controller;
 
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.sql.DataSource;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.*;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.bank.models.*;
import com.bank.dao.*;
 

@Controller
public class TransactionView {
	
	@Autowired
	private DataSource dataSource;
	
	@RequestMapping(value = "/transfer", method = RequestMethod.POST)
	public String send() {
		DaoImplementation dao = new DaoImplementation();
		
		dao.transferAmount(dataSource);
		
		@SuppressWarnings("unused")
		int updated = dao.updateAccount(dataSource);
		
		return "redirect:welcome.html";
	}
 
	@RequestMapping(value = "/transfer", method = RequestMethod.GET)
	public String transfer() {
		return "transfer";
	}
	
	@RequestMapping("/welcome")
	public ModelAndView view() {
		
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			if (dataSource.getConnection() != null) {
				con = dataSource.getConnection();
				
				pstmt = con.prepareStatement("select * from "
				         + "transactions where user_id = 1");
				
				rs = pstmt.executeQuery();
				
				List<Transactions> transactions = new ArrayList<Transactions>();
				
				while (rs.next()) {
					int id = rs.getInt("id");
					int user_id = rs.getInt("user_id");
					Date date = rs.getDate("date");
					int amount = rs.getInt("amount");
					
					transactions.add(new Transactions(id, user_id, date, amount));
					
				}
				
				Boolean paginate = transactions.size() > 5 ? true : false;
				
				DaoImplementation dao = new DaoImplementation();
				
				int AccountBalance = dao.getBalance(dataSource);
				
//				int AccountBalance = transactions.stream().mapToInt(Transactions::getAmount).reduce(0, (t1, t2) -> t1 + t2); 
				
				
				List<Transactions> lastTransactions;
				ModelAndView mv = new ModelAndView();
				if(paginate) {
					lastTransactions = transactions.subList(transactions.size() - 5, transactions.size());
				} else {
					lastTransactions = transactions;
				}
				
				mv.addObject("transactions", lastTransactions);
				mv.addObject("accountBalance", AccountBalance);
				mv.setViewName("welcome");
				
				return mv;
			} else {

				return new ModelAndView("welcome", "message", "Failed to connect database.");
			}
		} catch (SQLException e) {
			e.printStackTrace();

			return new ModelAndView("welcome", "message", "Failed to connect database.");
		}
	}
}