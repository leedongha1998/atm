package main;

import java.util.ArrayList;

import javax.swing.JOptionPane;

public class Main {
	


	
	public static void main(String[] args) {	
		User user = new User();
		User user1= new User("임성현", 25, "12345678912345", 1121);
		user.userInfos.add(user1);
		
		
		boolean bool =true;
		while(bool) {


			
			String[] service_list= {
					"1.입금/출금",
					"2.통장정리",
					"3.계좌송금",
					"4.분실신고",
					"5.회원가입"
			};

			String[] DW_1= {
					"1.입금",
					"2.출금",
					"3.뒤로가기"
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

			switch(choose) 
			{
			case "1.입금/출금" :
			{
				String DW_service=(String) JOptionPane.showInputDialog(
						null,
						"이용하실 서비스를 선택하십시오.",
						"성&동ATM",
						JOptionPane.INFORMATION_MESSAGE,
						null,
						DW_1,
						"선택"	
						);

				switch(DW_service) 
				{
				case "1.입금":
				{
					String[] buttons = {"하나은행", "국민은행", "신한은행", "우리은행","기업은행","그 외 은행"};
			        int num = JOptionPane.showOptionDialog(null, "사용하시는 은행을 선택하십시오.", "신원확인창.",
			                JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE, null, buttons, "하나은행");
			        switch(num)
			        {
			        case 0:{
			        		String accountNum=JOptionPane.showInputDialog(null,"계좌번호입력창","***-******-***** 형식으로 입력하시오.");
			        		if(user.getAccountNumber().contains(accountNum)) {
			        			int accountPass=(Integer.parseInt(JOptionPane.showInputDialog(null,"비밀번호입력창","비밀번호 4자리를 입력하시오.")));
			        			if(user.getAccountPassword()==accountPass) {
			        				System.out.println("만세");
			        			}
			        		}else {
			        			System.out.println("비밀번호가 틀렸습니다.");
			        			break;
			        		}
			        		
			        		}
			        case 1:{
			        	break;
	        		}
			        case 2:{
			        	break;
	        		}
			        case 3:{
			        	break;
	        		}
			        case 4:{
			        	break;
	        		}
			        case 5:{
			        	System.out.println("성&동 ATM에서 지원하지않는 은행사 입니다.\n다음에 다시 방문해주세요.");
	        		}
			      }
					break;					
				}
				case "2.출금":{
					break;
				}
				case "3.뒤로가기":
				{
					System.out.println("방문해주셔서 감사합니다.\n 다음에 다시 방문해주세요.");
					break;
				}
				}
				break;
			}
			case "2.통장정리":
			{
				System.out.println("통장정리");
				break;
				
			}
			case "3.계좌송금":
			{
				System.out.println("계좌송금");
				break;
			}
			case "4.분실신고":
			{
				System.out.println("분실신고");
				break;
			}
			case "5.회원가입":
			{	
				
				String name=JOptionPane.showInputDialog(null,"이름입력창","이름을 입력하시오.");
				int age=(Integer.parseInt(JOptionPane.showInputDialog(null,"나이입력창","나이를 입력하시오.")));
				String account=user.createAccountNum();
				JOptionPane.showInternalMessageDialog(null, "새로운 계좌번호는 "+account+" 입니다,", "계좌번호창",JOptionPane.PLAIN_MESSAGE );
				int password=(Integer.parseInt(JOptionPane.showInputDialog(null,"비밀번호","원하시는 비밀번호를 입력하시오.")));
				User user2 = new User(name, age, account, password);
				user.userInfos.add(user2);
			}
			
		}	
			
			bool=false;
	}
	
		for(User u:user.userInfos) {
			System.out.println(u);
		}
 }
	
}
