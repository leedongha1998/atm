package main;

import java.util.HashMap;
import java.util.Map;

public class User {
	private String name;
	private String age;
	private String accountNumber;
	private int accountPassword;
	
	Map<String,Integer> userMap = new HashMap<>();
	public User(){
		
	}
	public User(String name,String age,String accountNumber,int accountPassword) {
		this.name=name;
		this.age=age;
		this.accountNumber=accountNumber;
		this.accountPassword=accountPassword;
	}
	public String getName() {
		return name;
	}
	public String getAge() {
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
	public void setAge(String age) {
		this.age=age;
	}
	public void setAccountNumber(String accountNumber) {
		this.accountNumber=accountNumber;
	}
	public void setAccountPassword(int accountPassword) {
		this.accountPassword=accountPassword;
	}
	
}

