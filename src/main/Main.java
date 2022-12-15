package main;

public class Main {
	


	
	public static void main(String[] args) {	
		User user = new User();
		User user1 = new User("국민은행", 100000000, 0, 0, "임성현", 25, "12345678912345", 1111, null);
		User user3 = new User("하나은행", 12000, 0, 0, "이동하", 25, "54321987654321", 1234, null);
		User user4 = new User("신한은행", 1122000, 0, 0, "이동하", 25, "12345678998765", 1234, null);
		user.userInfos.add(user1);
		user.userInfos.add(user3);
		user.userInfos.add(user4);
		Atm atm= new Atm();
		

		Hana hana= new Hana();
		Gookmin gookmin= new Gookmin();
		Sinhan sinhan= new Sinhan();
		
		
		
		switch(atm.startAtm()) {
		case "1.입금/출금":{
			
			switch(atm.dw()) {
			case "1.입금":{
				switch(atm.chooseBank()) {
				case 0 :{
					User userCheck=atm.certificate(user.userInfos, "하나은행");
					if(userCheck!=null) {
						atm.deposit(userCheck);
					}else {
						break;
					}
					break;
					}
				case 1 :{
					User userCheck=atm.certificate(user.userInfos, "국민은행");
					if(userCheck!=null) {
						atm.deposit(userCheck);
					}else {
						break;
					}
					break;
					}
				case 2 :{
					User userCheck=atm.certificate(user.userInfos, "신한은행");
					if(userCheck!=null) {
						atm.deposit(userCheck);
					}else {
						break;
					}
					break;
					}
				case 3 :{
					atm.alert("저희 ATM에서 지원하지 않는 은행사입니다.");
					break;
					}
				}break;
			}
			case "2.출금":{
				switch(atm.chooseBank()) {
				case 0 :{
					User userCheck=atm.certificate(user.userInfos,"하나은행");
					if(userCheck!=null) {
						atm.withdrawal(userCheck,hana.getCommission());
						break;
					}else {
						break;
					}

					}
				case 1 :{
					User userCheck=atm.certificate(user.userInfos,"국민은행");
					if(userCheck!=null) {
						atm.withdrawal(userCheck,gookmin.getCommission());
						break;
					}else {
						break;
					}

					}
				case 2 :{
					User userCheck=atm.certificate(user.userInfos,"신한은행");
					if(userCheck!=null) {
						atm.withdrawal(userCheck,sinhan.getCommission());
						break;
					}else {
						break;
					}

					}
				case 3 :{
					atm.alert("저희 ATM에서 지원하지 않는 은행사입니다. ");
					break;
					}
				}break;
			}
			case "3.뒤로가기":{
				atm.startAtm();
				}
			}
		}
		case "2.통장정리":{
			break;
		}
		case "3.계좌송금":{
			atm.remittance(user.userInfos);
			break;
		}
		case "4.분실신고":{
			atm.reportLose(user);
			break;
		}
		case "5.회원가입":{
			atm.creatAccount(user);
			break;
		}
		case "6.종료":{
			atm.alert("방문해주셔서 감사합니다. 다음에 다시 방문해주세요.");
			break;
		}
		}
		
//		while(bool) {
//
//
//			


//

//
//			switch(choose) 
//			{
//			case "1.입금/출금" :
//			{

//

//				case "2.출금":{
//					String[] buttons = {"하나은행", "국민은행", "신한은행","그 외 은행"};
//					 int num = JOptionPane.showOptionDialog(null, "사용하시는 은행을 선택하십시오.", "신원확인창.",
//				                JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE, null, buttons, "하나은행");
//			        switch(num)
//			        {
//			        //하나은행
//			        case 0:{
//			        	String accountNum=JOptionPane.showInputDialog(null,"계좌번호입력창","***-******-***** 형식으로 입력하시오.");
//			        if(user1.getAccountNumber().contains(accountNum)) {
//			        	int accountPass=(Integer.parseInt(JOptionPane.showInputDialog(null,"비밀번호입력창","비밀번호 4자리를 입력하시오.")));
//			        	if(user1.getAccountPassword()==accountPass) {
//			        		long withdrawal=(Long.parseLong(JOptionPane.showInputDialog(null,"출금액","출금하실 금액을 입력하시오.")));
//			        		
//			        		if(user1.getBalance()<withdrawal) {
//			        			 JOptionPane.showInternalMessageDialog(null, "잔액이 부족합니다.", "안내창",JOptionPane.PLAIN_MESSAGE );
//			        		}else {
//			        				user1.setBalance((long) (user1.getBalance()-(withdrawal*(1+hana.getCommission()))));
//			        				JOptionPane.showInternalMessageDialog(null, "잔액은 "+user1.getBalance()+"원 입니다.", "안내창",JOptionPane.PLAIN_MESSAGE );
//			        				break;
//			        		}
//			        		}else {
//			        			JOptionPane.showInternalMessageDialog(null, "입력하신 정보가 틀렸습니다.", "경고창",JOptionPane.PLAIN_MESSAGE );
//				        		break;
//			        		}
//			        	}else {
//			        		JOptionPane.showInternalMessageDialog(null, "입력하신 정보가 틀렸습니다.", "경고창",JOptionPane.PLAIN_MESSAGE );
//			        		break;
//			        	}
//			        }
//			        //국민은행
//			        case 1:{
//			        	String accountNum=JOptionPane.showInputDialog(null,"계좌번호입력창","***-******-***** 형식으로 입력하시오.");
//				        if(user1.getAccountNumber().contains(accountNum)) {
//				        	int accountPass=(Integer.parseInt(JOptionPane.showInputDialog(null,"비밀번호입력창","비밀번호 4자리를 입력하시오.")));
//				        	if(user1.getAccountPassword()==accountPass) {
//				        		long withdrawal=(Long.parseLong(JOptionPane.showInputDialog(null,"출금액","출금하실 금액을 입력하시오.")));
//			        	if(user1.getBalance()<withdrawal) {
//			        		JOptionPane.showInternalMessageDialog(null, "잔액이 부족합니다.", "안내창",JOptionPane.PLAIN_MESSAGE );
//			        	}else {
//			        		user1.setBalance((long) (user1.getBalance()-(withdrawal*(1+gookmin.getCommission()))));
//			        		JOptionPane.showInternalMessageDialog(null, "잔액은 "+user1.getBalance()+"원 입니다.", "안내창",JOptionPane.PLAIN_MESSAGE );
//	        				break;
//			        			}
//				        	}else {
//				        		JOptionPane.showInternalMessageDialog(null, "입력하신 정보가 틀렸습니다.", "경고창",JOptionPane.PLAIN_MESSAGE );
//				        		break;
//				        	}
//				        }else {
//				        	JOptionPane.showInternalMessageDialog(null, "입력하신 정보가 틀렸습니다.", "경고창",JOptionPane.PLAIN_MESSAGE );
//				        	break;
//				        }
//			        }
//			        //신한은행
//			        case 2:{
//			        	String accountNum=JOptionPane.showInputDialog(null,"계좌번호입력창","***-******-***** 형식으로 입력하시오.");
//				        if(user1.getAccountNumber().contains(accountNum)) {
//				        	int accountPass=(Integer.parseInt(JOptionPane.showInputDialog(null,"비밀번호입력창","비밀번호 4자리를 입력하시오.")));
//				        	if(user1.getAccountPassword()==accountPass) {
//				        		long withdrawal=(Long.parseLong(JOptionPane.showInputDialog(null,"출금액","출금하실 금액을 입력하시오.")));
//				        		if(user1.getBalance()<withdrawal) {
//				        			JOptionPane.showInternalMessageDialog(null, "잔액이 부족합니다.", "안내창",JOptionPane.PLAIN_MESSAGE );
//				        		}else {
//				        			user1.setBalance((long) (user1.getBalance()-(withdrawal*(1+sinhan.getCommission()))));
//				        			JOptionPane.showInternalMessageDialog(null, "잔액은 "+user1.getBalance()+"원 입니다.", "안내창",JOptionPane.PLAIN_MESSAGE );
//			        				break;
//				        		}
//				        	}else {
//				        		JOptionPane.showInternalMessageDialog(null, "입력하신 정보가 틀렸습니다.", "경고창",JOptionPane.PLAIN_MESSAGE );
//				        		break;
//				        	}
//				        }else {
//				        	JOptionPane.showInternalMessageDialog(null, "입력하신 정보가 틀렸습니다.", "경고창",JOptionPane.PLAIN_MESSAGE );
//				        	break;
//				        }
//			        }
//			        //그 외
//			        case 3:{
//			        	JOptionPane.showInternalMessageDialog(null, "성&동 ATM에서 지원하지않는 은행사 입니다.\n다음에 다시 방문해주세요.", "안내창",JOptionPane.PLAIN_MESSAGE );
//			        	break;
//	        		}
//			      }
//				}
//				case "3.뒤로가기":
//				{
//					JOptionPane.showInternalMessageDialog(null, "방문해주셔서 감사합니다.\n 다음에 다시 방문해주세요.", "안내창",JOptionPane.PLAIN_MESSAGE );
//					break;
//				}
//				}
//				break;
//			}
//			case "2.통장정리":
//			{
//				System.out.println("통장정리");
//				break;
//				
//			}
//			case "3.계좌송금":
//			{
//
//				String accountNum1=JOptionPane.showInputDialog(null,"계좌송금창","본인의 계좌번호를 입력하십시오.");//송금하는 계좌
//				for(User i:user.userInfos) {
//					if(accountNum1.equals(i.getAccountNumber())) {
//						int password1=(Integer.parseInt(JOptionPane.showInputDialog(null,"계좌비밀번호를 입력하십시오.")));
//						if(password1==i.getAccountPassword()) {
//							String accountNum2=JOptionPane.showInputDialog(null,"계좌송금창", "송금보내시는 계좌번호를 입력하십시오.");//송금받는 게좌
//							for(User z:user.userInfos) {
//								if(accountNum2.equals(z.getAccountNumber())) {
//									long remittance=(Long.parseLong(JOptionPane.showInputDialog(null,"송금창","송금하실 금액을 입력하십시오.", JOptionPane.PLAIN_MESSAGE)));
//									if(i.getBalance()<remittance) {
//										System.out.println("잔액이 부족합니다.");
//										JOptionPane.showMessageDialog(null,"잔액이 부족합니다.","안내창",JOptionPane.WARNING_MESSAGE);
//									}else {
//										i.setBalance(i.getBalance()-remittance);
//										z.setBalance(z.getBalance()+remittance);						
//									}
//									JOptionPane.showMessageDialog(null,i.getName()+"님의 송금 후 잔액은 "+i.getBalance()+"원 입니다.","안내창",JOptionPane.PLAIN_MESSAGE);
//									JOptionPane.showMessageDialog(null,z.getName()+"님의 송금받은 후 잔액은 "+z.getBalance()+"원 입니다.","안내창",JOptionPane.PLAIN_MESSAGE);
//								}
//							}
//						}
//					}
//				}
//
//				break;
//			}
//			case "4.분실신고":
//			{
//				String accountNum=JOptionPane.showInputDialog(null,"분실신고창","분실신고 하실 계좌번호를 입력하십시오.");
//				int index=0;
//				for(User u:user.userInfos) {
//					if(accountNum.equals(u.getAccountNumber())) {
//						int password=(Integer.parseInt(JOptionPane.showInputDialog(null, "분실신고창", "계좌비밀번호를 입력하십시오.", JOptionPane.PLAIN_MESSAGE)));
//						if(password==u.getAccountPassword()) {
//							int check=JOptionPane.showConfirmDialog(null, "계좌정보가 삭제처리됩니다. 정말 삭제하시겠습니까?","확인창", JOptionPane.OK_CANCEL_OPTION);
//							if(check==0) {
//								user.userInfos.remove(index);
//								JOptionPane.showInternalMessageDialog(null, "삭체처리 됐습니다.");
//							}else {
//								JOptionPane.showInternalMessageDialog(null, "다시오십시오.");
//								break;
//							}
//						}
//					}index++;
//					System.out.println(u.getAccountNumber());
//				}
//				break;
//			}
//			case "5.회원가입":
//			{	
//				String bankName=JOptionPane.showInputDialog(null,"은행입력창","사용하실 은행을 선택하십시오.");
//				String name=JOptionPane.showInputDialog(null,"이름입력창","이름을 입력하시오.");
//				int age=(Integer.parseInt(JOptionPane.showInputDialog(null,"나이입력창","나이를 입력하시오.")));
//				String account=user.createAccountNum();
//				JOptionPane.showInternalMessageDialog(null, "새로운 계좌번호는 "+account+" 입니다,", "계좌번호창",JOptionPane.PLAIN_MESSAGE );
//				int password=(Integer.parseInt(JOptionPane.showInputDialog(null,"비밀번호","원하시는 비밀번호를 입력하시오.")));
//				User user2 = new User(bankName, 0, 0, 0, name, age, account, password, null);
//				user.userInfos.add(user2);
//			}
//			
//		}	
//			
//			bool=false;
//	}
	

 }
	
}























