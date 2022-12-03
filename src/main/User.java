package main;

import java.util.ArrayList;

public class User extends Bank {
	private String name;
	private int age;
	private String accountNumber;
	private int accountPassword;
	ArrayList<User> userInfos = new ArrayList<>();
	
	
	public User() {
		super();
	}

	public User(String bankName, long balance, long deposit, long withdrawal) {
		super(bankName, balance, deposit, withdrawal);
	}

	public User(String bankName, long balance, long deposit, long withdrawal, String name, int age,
			String accountNumber, int accountPassword, ArrayList<User> userInfos) {
		super(bankName, balance, deposit, withdrawal);
		this.name = name;
		this.age = age;
		this.accountNumber = accountNumber;
		this.accountPassword = accountPassword;
		this.userInfos = userInfos;
	}
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getAccountNumber() {
		return accountNumber;
	}

	public void setAccountNumber(String accountNumber) {
		this.accountNumber = accountNumber;
	}

	public int getAccountPassword() {
		return accountPassword;
	}

	public void setAccountPassword(int accountPassword) {
		this.accountPassword = accountPassword;
	}

	public ArrayList<User> getUserInfos() {
		return userInfos;
	}




	public void setUserInfos(ArrayList<User> userInfos) {
		this.userInfos = userInfos;
	}




	@Override
	public String toString() {
		return "User [name=" + name + ", age=" + age + ", accountNumber=" + accountNumber + ", accountPassword="
				+ accountPassword + ", userInfos=" + userInfos + "]";
	}




	public String createAccountNum() {
		StringBuilder sb = new StringBuilder();
		for (int i=0;i<14;i++) {
			sb.append((int) (Math.random()*10));
		}
		return sb.toString();
		
	}
	
}

