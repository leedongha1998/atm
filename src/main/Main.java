package main;

public class Main {
	


	
	public static void main(String[] args) {	
		User user = new User();
		User user1 = new User("국민은행", 100000000, 0, 0, "임성현", 25, "12345678912345", 1111, null);
		User user3 = new User("하나은행", 12000, 0, 0, "이동하", 25, "54321987654321", 1234, null);
		User user4 = new User("신한은행", 1122000, 0, 0, "이성하", 25, "12345678998765", 1234, null);
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
	}
	
}























