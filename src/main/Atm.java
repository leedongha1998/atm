package main;

import java.util.ArrayList;

import javax.swing.JOptionPane;

/**
 * 
 * Atm logic 처리
 *
 */
public class Atm {

	

	
	/**
	 * 
	 *  atm 시작페이지
	 */
	public String startAtm() {
		String[] service_list= {
				"1.입금/출금",
				"2.통장정리",
				"3.계좌송금",
				"4.분실신고",
				"5.회원가입",
				"6.종료"
			};
		String choose=(String) JOptionPane.showInputDialog(
		null,
		"이용하실 서비스를 선택하십시오.",
		"성&동ATM",
		JOptionPane.INFORMATION_MESSAGE,
		null,
		service_list,
		"선택"
		);
		return choose;
	}
	/**
	 * 
	 * 입/출금 선택창
	 */
	public String dw() {
		String[] dw_list= {
				"1.입금",
				"2.출금",
				"3.뒤로가기"
		};
		String dw_choose=(String) JOptionPane.showInputDialog(
				null,
				"이용하실 서비스를 선택하십시오.",
				"성&동ATM",
				JOptionPane.INFORMATION_MESSAGE,
				null,
				dw_list,
				"선택"
				);
		return dw_choose;
	}
	/**
	 * 
	 * 알림창
	 */
	public void alert(String alert) {
		JOptionPane.showInternalMessageDialog(null,alert, "안내창",JOptionPane.PLAIN_MESSAGE );
	}
	/**
	 * 
	 * 
	 */
	public int chooseBank() {
		String [] bank= {"하나은행","국민은행","신한은행","그 외 은행"};
		int num = JOptionPane.showOptionDialog(null, "사용하시는 은행을 선택하십시오.", "신원확인창.",
                JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE, null,bank, "하나은행");
		return num;
	}
	/**
	 * 
	 * 본인확인절차
	 * 
	 */
	public User certificate(ArrayList<User> userInfos) {
		
		String accountNum=JOptionPane.showInputDialog(null,"계좌번호입력창","***-******-***** 형식으로 입력하시오.");
		 for(User u:userInfos) {
			 if(u.getAccountNumber().equals(accountNum)) {
				 
				 int accountPass=(Integer.parseInt(JOptionPane.showInputDialog(null,"비밀번호입력창","비밀번호 4자리를 입력하시오.")));
				 if(u.getAccountPassword()==accountPass) {
					User user=new User(u.getBankName(),u.getBalance(), u.getDeposit(), u.getWithdrawal(), u.getName(), u.getAge(), accountNum, accountPass,userInfos);
					return user;
				 }else {
					 alert("정보가 일치하지 않습니다.");
				 }
			 }
		 }
		return null;
	}
	/**
	 * 입금절차
	 */
	public void deposit(User user) {
			long deposit=(Long.parseLong(JOptionPane.showInputDialog(null,"입금액","입금하실 금액을 입력하시오.")));
			 user.setBalance(user.getBalance()+deposit); 
			 JOptionPane.showInternalMessageDialog(null, "잔액은 "+user.getBalance()+"원 입니다.", "안내창",JOptionPane.PLAIN_MESSAGE );
	}
	/**
	 * 
	 * 송금절차
	 */
	public void withdrawal(User user) {
		long withdrawal=(Long.parseLong(JOptionPane.showInputDialog(null,"출금액","출금하실 금액을 입력하시오.")));
		if(user.getBalance()<withdrawal) {
			alert("잔액이 부족합니다.");
		}else {
			Hana hana= new Hana();
			Gookmin gookmin= new Gookmin();
			Sinhan sinhan= new Sinhan();
			switch(chooseBank()) {
			case 0:{
				user.setBalance((long) (user.getBalance()-(withdrawal*(1+hana.getCommission()))));
				break;
			}
			case 1:{
				user.setBalance((long) (user.getBalance()-(withdrawal*(1+gookmin.getCommission()))));
				break;
			}
			case 2:{
				user.setBalance((long) (user.getBalance()-(withdrawal*(1+sinhan.getCommission()))));
				break;
			}
			}
			
		}
	}
	
	public void reportLose() {
		
	}
}

	
