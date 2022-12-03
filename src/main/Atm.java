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
					 User user=new User(u.getBankName(),u.getBalance(), u.getDeposit(), u.getWithdrawal(), u.getName(), u.getAge(), accountNum, accountPass,u.userInfos);
					 return user;
				 }else {
					 alert("정보가 일치하지 않습니다.");
				 }
			}
		}return null;
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
	public void withdrawalHana(User user) {
		Hana hana= new Hana();
		alert("수수료는 "+hana.getCommission()+"% 입니다.");
		long withdrawal=(Long.parseLong(JOptionPane.showInputDialog(null,"출금액","출금하실 금액을 입력하시오.")));
		if(user.getBalance()<=withdrawal) {
			alert("잔액이 부족합니다.");
		}else {
			user.setBalance((long) (user.getBalance()-withdrawal*(1+hana.getCommission())));
			alert("잔액은 "+user.getBalance()+"입니다.");
			alert("방문해주셔서 감사합니다. 다음에 다시 방문해주세요.");
		}
	}
	
	public void withdrawalGookmin(User user) {
		Gookmin gookmin= new Gookmin();
		alert("수수료는 "+gookmin.getCommission()+"% 입니다.");
		long withdrawal=(Long.parseLong(JOptionPane.showInputDialog(null,"출금액","출금하실 금액을 입력하시오.")));
		if(user.getBalance()<=withdrawal) {
			alert("잔액이 부족합니다.");
		}else {
			user.setBalance((long) (user.getBalance()-withdrawal*(1+gookmin.getCommission())));
			alert("잔액은 "+user.getBalance()+"입니다.");
			alert("방문해주셔서 감사합니다. 다음에 다시 방문해주세요.");
		}
	}
	
	public void withdrawalSinhan(User user) {
		Sinhan sinhan= new Sinhan();
		alert("수수료는 "+sinhan.getCommission()+"% 입니다.");
		long withdrawal=(Long.parseLong(JOptionPane.showInputDialog(null,"출금액","출금하실 금액을 입력하시오.")));
		if(user.getBalance()<=withdrawal) {
			alert("잔액이 부족합니다.");
		}else {
			user.setBalance((long) (user.getBalance()-withdrawal*(1+sinhan.getCommission())));
			alert("잔액은 "+user.getBalance()+"입니다.");
			alert("방문해주셔서 감사합니다. 다음에 다시 방문해주세요.");
		}
	}
	

	/**
	 * 
	 * 분실신고
	 */
	public void reportLose(User user) {
		String accountNum=JOptionPane.showInputDialog(null,"분실신고창","분실신고 하실 계좌번호를 입력하십시오.");
		int index=0;
		for(User u:user.userInfos) {
			if(accountNum.equals(u.getAccountNumber())) {
				int password=(Integer.parseInt(JOptionPane.showInputDialog(null, "분실신고창", "계좌비밀번호를 입력하십시오.", JOptionPane.PLAIN_MESSAGE)));
				if(password==u.getAccountPassword()) {
					int check=JOptionPane.showConfirmDialog(null, "계좌정보가 삭제처리됩니다. 정말 삭제하시겠습니까?","확인창", JOptionPane.OK_CANCEL_OPTION);
					if(check==0) {
						user.userInfos.remove(index);
						alert(u.getName()+"님의 계좌번호가 삭제되었습니다.");
					}else {
						alert("방문해주셔서 감사합니다. 다음에 다시 방문해주세요.");
						break;
					}
				}
			}index++;
		}
	}
	
	/**
	 * 계좌송금
	 */
	public User remittance(ArrayList<User> userInfos) {
		String accountNum1=JOptionPane.showInputDialog(null,"계좌송금창","본인의 계좌번호를 입력하십시오.");//송금하는 계좌
		for(User i:userInfos) {
			if(accountNum1.equals(i.getAccountNumber())) {
				int password1=(Integer.parseInt(JOptionPane.showInputDialog(null,"계좌비밀번호를 입력하십시오.")));
				if(password1==i.getAccountPassword()) {
					String accountNum2=JOptionPane.showInputDialog(null,"계좌송금창", "송금보내시는 계좌번호를 입력하십시오.");//송금받는 게좌
					for(User z:userInfos) {
						if(accountNum2.equals(z.getAccountNumber())) {
							long remittance=(Long.parseLong(JOptionPane.showInputDialog(null,"송금창","송금하실 금액을 입력하십시오.", JOptionPane.PLAIN_MESSAGE)));
							if(i.getBalance()<remittance) {
								alert("잔액이 부족합니다.");
							}else {
								i.setBalance(i.getBalance()-remittance);
								z.setBalance(z.getBalance()+remittance);
								alert(i.getName()+"님의 송금 후 잔액은 "+i.getBalance()+"원 입니다.");
								alert(z.getName()+"님의 송금받은 후 잔액은 "+z.getBalance()+"원 입니다.");
								alert("방문해주셔서 감사합니다. 다음에 다시 방문해주세요.");
								break;
							}

						}
					}
				}
			}
		}return null;
	}
}

	
