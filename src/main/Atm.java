package main;

import java.util.ArrayList;
import java.util.regex.Pattern;

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
	
//	public User certificate(ArrayList<User> userInfos,String bankName) {
//		boolean check=false;
//		String accountNum=JOptionPane.showInputDialog(null,"계좌번호입력창","***-******-***** 형식으로 입력하시오.");
//		for(User u:userInfos) {
//			System.out.println(u.getAccountNumber());
//			if(u.getAccountNumber().equals(accountNum)) {
//				if(u.getBankName().equals(bankName)) {
//					 int accountPass=(Integer.parseInt(JOptionPane.showInputDialog(null,"비밀번호입력창","비밀번호 4자리를 입력하시오.")));
//					 if(u.getAccountPassword()==accountPass) {
//						 User user=new User(u.getBankName(),u.getBalance(), u.getDeposit(), u.getWithdrawal(), u.getName(), u.getAge(), accountNum, accountPass,u.userInfos);
//						 return user; 
//						 }else {
//							 alert("정보가 일치하지 않습니다.");
//							 break;
//						 }
//				 	}else {
//				 		continue;
//				 }
//			}else {
//				continue;
//			}
//		}return null;
//	}




	public User certificate(ArrayList<User> userInfos,String bankName) {
		String accountNum=JOptionPane.showInputDialog(null,"계좌번호입력창","***-******-***** 형식으로 입력하시오.");
		for(int i=0;i<userInfos.size();i++) {
			if(userInfos.get(i).getAccountNumber().equals(accountNum)) {
					if(userInfos.get(i).getBankName().equals(bankName)) {
						int accountPass=(Integer.parseInt(JOptionPane.showInputDialog(null,"비밀번호입력창","비밀번호 4자리를 입력하시오.")));
						if(userInfos.get(i).getAccountPassword()==accountPass) {
							 User user=new User(userInfos.get(i).getBankName(),userInfos.get(i).getBalance(), userInfos.get(i).getDeposit(),userInfos.get(i).getWithdrawal(), userInfos.get(i).getName(), userInfos.get(i).getAge(), accountNum, accountPass,userInfos.get(i).userInfos);
							 return user; 
						}else {
							alert("정보가 일치하지 않습니다.");
							break;
						}
					}else {
						alert("정보가 일치하지 않습니다.");
						break;
					}
			}
			else {
				if(userInfos.size()==i+1) {
					alert("일치하는 정보가 없습니다.");
				}else {
					continue;
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
			if(deposit>1000000) {
				alert("하루 입금 가능액이 초과되었습니다. 하루 최대 입금 가능액:1000000원");
			}else {
				user.setBalance(user.getBalance()+deposit);
				alert("입금 후 잔액은 "+user.getBalance()+" 입니다.");
				alert("방문해주셔서 감사합니다. 다음에 다시 방문해주세요.");
				
			}
			
	}
	/**
	 * 
	 * 출금절차 
	 */
	public void withdrawal(User user,double commission) {
		
		alert("수수료는 "+commission+"% 입니다.");
		long withdrawal=(Long.parseLong(JOptionPane.showInputDialog(null,"출금액","출금하실 금액을 입력하시오.")));
		if(user.getBalance()<withdrawal) {
			alert("잔액이 부족합니다.");
		}else {
			if(withdrawal>1000000) {
				alert("하루 송금 가능액이 초과되었습니다. 하루 최대 송금 가능액:1000000원");
			}else {
				user.setBalance((long) (user.getBalance()-withdrawal*(1+commission)));
				alert("잔액은 "+user.getBalance()+"입니다.");
				alert("방문해주셔서 감사합니다. 다음에 다시 방문해주세요.");
			}
			
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
				int password=(Integer.parseInt(JOptionPane.showInputDialog(null, "계좌비밀번호를 입력하십시오.", "분실신고창", JOptionPane.PLAIN_MESSAGE)));
				if(password==u.getAccountPassword()) {
					int check=JOptionPane.showConfirmDialog(null, "계좌정보가 삭제처리됩니다. 정말 삭제하시겠습니까?","확인창", JOptionPane.OK_CANCEL_OPTION);
					if(check==0) {
						user.userInfos.remove(index);
						alert(u.getName()+"님의 계좌번호가 삭제되었습니다.");
						alert("방문해주셔서 감사합니다. 다음에 다시 방문해주세요.");
						break;
					}else {
						alert("방문해주셔서 감사합니다. 다음에 다시 방문해주세요.");//계좌삭제 반대
						break;
					}
				}else {
					alert("정보가 일치하지 않습니다.");//비밀번호 불일치
				}
			}else {
				if(user.userInfos.size()==index+1) {
					alert("일치하는 정보가 없습니다");// 계좌번호 불일치
				}else {
				continue;
				}
			}
			index++;
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
	
	/**
	 * 정규표현식 
	 */
	public boolean matches(String pattern,String str) {
		boolean result=Pattern.matches(pattern, str);
		return result;
	}
	
	/**
	 * 
	 * 회원가입
	 */
	public void creatAccount(User user) {
		int bankName=chooseBank();
		String bankNames=null;
		switch(bankName) {
		case 0:{
			 bankNames="하나은행";
			break;
		}
		case 1:{
			 bankNames="국민은행";
			break;
		}
		case 2:{
			 bankNames="신한은행";
			break;
		}
		case 3:{
			alert("저희 ATM에서 회원가입 불가능한 은헹입니다.");
			break;
		}
		}
		String name=JOptionPane.showInputDialog(null,"이름입력창","이름을 입력하시오.");
		if(matches("^[가-힣]*$",name)==true){
				String age=JOptionPane.showInputDialog(null,"나이입력창","나이를 입력하시오.");
				if(matches("^[0-9]*$",age)==true){
				int	a=Integer.parseInt(age);
				if(a>110||a<10) {
					alert("가입 가능한 연령이 아닙니다.");//가능한 가입 나이 초과
					return;
					}
					else {
						String account=user.createAccountNum();
						alert("새로운 계좌번호는 "+account+" 입니다,");
						String password=JOptionPane.showInputDialog(null,"비밀번호","원하시는 비밀번호를 입력하시오.");
						if(matches("^[0-9]*$",password)) {
							int p=Integer.parseInt(password);
							if(p>9999||p<1000) {
								alert("비밀번호양식은 숫자 4자리입니다.");//비밀번호 숫자 제한
								return;
								}
								else {
									User user2 = new User(bankNames, 0, 0, 0, name, age, account, password, null);
									user.userInfos.add(user2);
									alert("선택하신 은행:"+bankNames+"\n"+"회원님 성함:"+name+"\n"+"나이:"+age+"\n"+"계좌번호:"+account+"\n"+"계좌비밀번호:"+password+" 입니다");
									alert("방문해주셔서 감사합니다. 다음에 다시 방문해주세요.");
									return;
								}
						}else {
							alert("정보를 잘못 입력하셨습니다.");//비밀번호 문자로 입력
							return;
						}
					}
				}		
				else {
					alert("나이 정보를 잘못입력하셨습니다");//나이 문자로 입력
					return;
				}
			}else {
				alert("이름은 한글로 작성해야합니다.");//이름 영어 입력
				return;
			}
		}
	}
	
