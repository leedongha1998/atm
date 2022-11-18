package main;

import java.util.ArrayList;

public class User {
	private String name;
	private int age;
	private String accountNumber;
	private int accountPassword;
	
	ArrayList<User> userInfos = new ArrayList<>();
	
	public User(){
		
	}
	public User(String name,int age,String accountNumber,int accountPassword) {
		this.name=name;
		this.age=age;
		this.accountNumber=accountNumber;
		this.accountPassword=accountPassword;
	}
	public String getName() {
		return name;
	}
	public int getAge() {
		return age;
	}
	public String getAccountNumber() {
		return accountNumber;
	}
	public int getAccountPassword() {
		return accountPassword;
	}
	public void setName(String name) {
		this.name=name;
	}
	public void setAge(int age) {
		this.age=age;
	}
	public void setAccountNumber(String accountNumber) {
		this.accountNumber=accountNumber;
	}
	public void setAccountPassword(int accountPassword) {
		this.accountPassword=accountPassword;
	}
	
	@Override
	public String toString() {
		return "User [name=" + name + ", age=" + age + ", accountNumber=" + accountNumber + ", accountPassword="
				+ accountPassword +"]";
	}
	public String createAccountNum() {
		StringBuilder sb = new StringBuilder();
		for (int i=0;i<14;i++) {
			sb.append((int) (Math.random()*10));
		}
		return sb.toString();
		
	}
	
}

