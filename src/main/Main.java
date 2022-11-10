package main;


import javax.swing.JOptionPane;
public class Main {

	public static void main(String[] args) {	
		boolean bool =true;
		while(bool) {
			
			System.out.println("성&동ATM");
			System.out.println("1.입금");
			System.out.println("2.출금");
			System.out.println("3.통장정리");
			System.out.println("4.계좌송금");
			System.out.println("5.분실신고");
			
			String[] service_list= {
					"1.입금/출금",
					"2.통장정리",
					"3.계좌송금",
					"4.분실신고"
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
				case "1.입금":{
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
		}	
		
			bool=false;
	}
	
  }

}
