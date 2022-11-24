package main;

public class Gookmin extends Bank {

	private double commission=0.3;

	public Gookmin() {
		super();

	}

	public Gookmin(String bankName, long balance, long deposit, long withdrawal) {
		super(bankName, balance, deposit, withdrawal);

	}
	public Gookmin(String bankName, long balance, long deposit, long withdrawal, double commission) {
		super(bankName, balance, deposit, withdrawal);
		this.commission = commission;
	}
	

	public double getCommission() {
		return commission;
	}

	@Override
	public String toString() {
		return "Gookmin [commission=" + commission + ", getBankName()=" + getBankName() + ", getBalance()="
				+ getBalance() + ", getDeposit()=" + getDeposit() + ", getWithdrawal()=" + getWithdrawal()
				+ ", toString()=" + super.toString() + "]";
	}
	
	
}
