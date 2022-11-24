package main;

public class Hana extends Bank {

	private double commission=0.05;
	public Hana() {
		super();
	}

	public Hana(String bankName, long balance, long deposit, long withdrawal) {
		super(bankName, balance, deposit, withdrawal);
	}

	public Hana(String bankName, long balance, long deposit, long withdrawal, double commision) {
		super(bankName, balance, deposit, withdrawal);
		this.commission = commision;
	}

	public double getCommission() {
		return commission;
	}

	@Override
	public String toString() {
		return "Hana [commision=" + commission + ", getBankName()=" + getBankName() + ", getBalance()=" + getBalance()
				+ ", getDeposit()=" + getDeposit() + ", getWithdrawal()=" + getWithdrawal() + ", toString()="
				+ super.toString() + "]";
	}
	
 
}
