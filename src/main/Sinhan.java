package main;

public class Sinhan extends Bank{
	private double commission=0.4;

	public Sinhan() {
		super();
	
	}

	public Sinhan(String bankName, long balance, long deposit, long withdrawal) {
		super(bankName, balance, deposit, withdrawal);
	
	}

	public Sinhan(String bankName, long balance, long deposit, long withdrawal, double commission) {
		super(bankName, balance, deposit, withdrawal);
		this.commission = commission;
	}
	

	public double getCommission() {
		return commission;
	}

	@Override
	public String toString() {
		return "Sinhan [commission=" + commission + ", getBankName()=" + getBankName() + ", getBalance()="
				+ getBalance() + ", getDeposit()=" + getDeposit() + ", getWithdrawal()=" + getWithdrawal()
				+ ", toString()=" + super.toString() + "]";
	}
	
	
}
