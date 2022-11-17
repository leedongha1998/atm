package main;

public class Bank {
	private String bankName;
	private long balance; //잔액
	private long deposit;//입금액
	private long withdrawal;//출금액
	
	public Bank() {
		
	}
	public Bank(String bankName,long balance,long deposit,long withdrawal) {
		this.bankName=bankName;
		this.balance=balance;
		this.deposit=deposit;
		this.withdrawal=withdrawal;
	}
	
	public String getBankName() {
		return bankName;
	}
	public long getBalance() {
		return balance;
	}
	public long getDeposit() {
		return deposit;
	}
	public long getWithdrawal() {
		return withdrawal;
	}
	public void setBankName(String bankName) {
		this.bankName=bankName;
	}
	public void setBalance(long balance) {
		this.balance=balance;
	}
	public void setDeposit(long deposit) {
		this.deposit=deposit;
	}
	public void setWithdrawal(long withdrawal) {
		this.withdrawal=withdrawal;
	}
	
	
} 
