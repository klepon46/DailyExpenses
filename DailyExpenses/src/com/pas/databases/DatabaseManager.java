package com.pas.databases;

import java.sql.SQLException;
import java.util.List;

import com.j256.ormlite.dao.GenericRawResults;
import com.j256.ormlite.dao.RuntimeExceptionDao;
import com.pas.bean.Expenses;

import android.content.Context;


public class DatabaseManager  {

	static private DatabaseManager instance;
	private DatabaseHelper helper;
	
	static public void init(Context ctx){
		if(instance==null)
			instance = new DatabaseManager();
	}
	
	public DatabaseManager() {
		
	}
	
	static public DatabaseManager getInstance(){
		return instance;
	}
	
	
	public DatabaseManager(Context ctx) {
		helper = new DatabaseHelper(ctx);
	}

	private DatabaseHelper getHelper(){
		return helper;
	}
	
	
	public String  getTotalExpenses(){
		
		String sum = "";
		RuntimeExceptionDao<Expenses, Integer> expensesDao =
				getHelper().getExpensesDao();
		GenericRawResults<String[]> rawResults =
				expensesDao.queryRaw("select sum(expensesAmount) from Expenses");
		try {
			List<String[]> results = rawResults.getResults();
			for(String[] resultArray : results){
				sum = resultArray[0];
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return sum;
	}
	
}
