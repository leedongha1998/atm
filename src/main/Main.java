package main;

import java.util.ArrayList;

import javax.swing.JOptionPane;

public class Main {
	
	public static ArrayList<String> bankAccountNumber=new ArrayList<String>();
	public static ArrayList<String> bankAccountPassword=new ArrayList<String>();

	
	public static void main(String[] args) {	
		User user = new User();
		user.userMap.put("임성현", 1234);
		System.out.println(user.userMap);
		
		
		boolean bool =true;
		bankAccountNumber.add("010-250702-87307");
		bankAccountPassword.add("7244");
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
			        		if(bankAccountNumber.contains(accountNum)) {
			        			String accountPass=JOptionPane.showInputDialog(null,"비밀번호입력창","비밀번호 4자리를 입력하시오.");
			        			if(bankAccountPassword.contains(accountPass)) {
			        				
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
				if(user.userMap.containsKey(name)) {
					JOptionPane.showMessageDialog(null, "이미 가입된 회원입니다.");
					user.setName(JOptionPane.showInputDialog(null,"이름입력창","이름을 입력하시오."));
					
				}else {
					System.out.println("회원가입 시작합니다.");
					user.setName(JOptionPane.showInputDialog(null,"이름입력창","이름을 입력하시오."));
					user.setAccountPassword(Integer.parseInt(JOptionPane.showInputDialog(null,"비밀번호","비밀번호를 입력하시오.")));
					user.userMap.put(user.getName(), user.getAccountPassword());
				}
			}
		}	
			System.out.println(user.userMap);
			bool=false;
	}
	
  }
}

