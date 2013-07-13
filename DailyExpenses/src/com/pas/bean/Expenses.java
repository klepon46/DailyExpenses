package com.pas.bean;

import java.math.BigDecimal;
import java.util.Date;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

@DatabaseTable(tableName="Expenses")
public class Expenses {

	@DatabaseField(generatedId=true, canBeNull=false)
	private int expensesId;
	
	@DatabaseField(canBeNull = false)
	private String expensesCode;
	
	@DatabaseField
	private String expensesDesc;
	
	@DatabaseField
	private Date expensesDate;
	
	@DatabaseField
	private BigDecimal expensesAmount;
	
	public Expenses() {
		// TODO Auto-generated constructor stub
	}

	public Expenses(String expensesCode, String expensesDesc,
			Date expensesDate, BigDecimal expensesAmount) {
		super();
		this.expensesCode = expensesCode;
		this.expensesDesc = expensesDesc;
		this.expensesDate = expensesDate;
		this.expensesAmount = expensesAmount;
	}

	@Override
	public String toString() {
		return "Expenses [expensesId=" + expensesId + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + expensesId;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Expenses other = (Expenses) obj;
		if (expensesId != other.expensesId)
			return false;
		return true;
	}
	
}
