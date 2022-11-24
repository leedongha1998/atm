package main;

public class Bank {
	private String bankName;
	private long balance; //잔액
	private long deposit;//입금액
	private long withdrawal;//출금액
	

	public Bank() {
		super();
		
	}
	public Bank(String bankName, long balance, long deposit, long withdrawal) {
		super();
		this.bankName = bankName;
		this.balance = balance;
		this.deposit = deposit;
		this.withdrawal = withdrawal;
		
	}
	public String getBankName() {
		return bankName;
	}
	public void setBankName(String bankName) {
		this.bankName = bankName;
	}
	public long getBalance() {
		return balance;
	}
	public void setBalance(long balance) {
		this.balance = balance;
	}
	public long getDeposit() {
		return deposit;
	}
	public void setDeposit(long deposit) {
		this.deposit = deposit;
	}
	public long getWithdrawal() {
		return withdrawal;
	}
	public void setWithdrawal(long withdrawal) {
		this.withdrawal = withdrawal;
	}


	@Override
	public String toString() {
		return "Bank [bankName=" + bankName + ", balance=" + balance + ", deposit=" + deposit + ", withdrawal="
				+ withdrawal + ", accountNumber="  + "]";
	}
	

	
	
} 
