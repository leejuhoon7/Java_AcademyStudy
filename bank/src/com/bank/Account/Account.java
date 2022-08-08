package com.bank.Account;

import java.sql.Date; // 년/월/일 , java,util.date -> 년/월/일/시/분/초

public class Account {

	private String accountId;
	private String memberId;
	private int balance;
	private Date credate;
	
	
	
	public String getAccountId() {
		return accountId;
	}
	public void setAccountId(String accountId) {
		this.accountId = accountId;
	}
	public String getMemberId() {
		return memberId;
	}
	public void setMemberId(String memberId) {
		this.memberId = memberId;
	}
	public int getBalance() {
		return balance;
	}
	public void setBalance(int balance) {
		this.balance = balance;
	}
	public Date getCredate() {
		return credate;
	}
	public void setCredate(Date credate) {
		this.credate = credate;
	}
}
