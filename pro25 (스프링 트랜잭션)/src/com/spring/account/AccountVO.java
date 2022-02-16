package com.spring.account;

public class AccountVO {
	private String accounNo;
	private String custName;
	private int balance;
	
	public AccountVO() {
		
	}
	
	public AccountVO(String accountNo, String custName, int balance) {
		this.accounNo = accountNo;
		this.custName = custName;
		this.balance = balance;
	}

	public String getAccounNo() {
		return accounNo;
	}

	public void setAccounNo(String accounNo) {
		this.accounNo = accounNo;
	}

	public String getCustName() {
		return custName;
	}

	public void setCustName(String custName) {
		this.custName = custName;
	}

	public int getBalance() {
		return balance;
	}

	public void setBalance(int balance) {
		this.balance = balance;
	}
}
