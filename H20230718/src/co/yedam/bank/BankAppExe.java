package co.yedam.bank;

import java.util.Scanner;

public class BankAppExe {
	public static void main(String[] args) {

		boolean run = true;
		Scanner scn = new Scanner(System.in);

		String accountNo = "";
		int depo = 0;
		int withD = 0;

		BankApp app = BankApp.getInstance(); // new BankApp();
		
		while (run) {
			System.out.println("1.등록 2.입금 3.출금 4.잔액 5.계좌목록 6.종료");
			System.out.println("메뉴 입력> ");
			int menu = Integer.parseInt(scn.nextLine());
			if (menu == 1) { // 등록메뉴
				System.out.println("계좌번호를 등록> ");
				accountNo = scn.nextLine();
				System.out.println("예금주명을 입력> ");
				String accountName = scn.nextLine();
				System.out.println("입금액을 입력> ");
				depo = Integer.parseInt(scn.nextLine());
				app.registerAccount(new Account(accountNo, accountName, depo));
			} else if (menu == 2) { // 입금메뉴
				System.out.println("계좌번호를 입력> ");
				accountNo = scn.nextLine();
				System.out.println("입금금액을 입력> ");
				depo = Integer.parseInt(scn.nextLine());
				int result = app.deposit(accountNo, depo);
				if (result == 0) {
					System.out.println("입금금액 " + depo + "원이 처리되었습니다.");
				} else {
					System.out.println("계좌번호를 다시 입력하십시오.");
				}
			} else if (menu == 3) {
				System.out.println("계좌번호를 입력> ");
				accountNo = scn.nextLine();
				System.out.println("출금금액을 입력> ");
				withD = Integer.parseInt(scn.nextLine());
				int result = app.withDraw(accountNo, withD);
				if (result == 0) {
					System.out.println("출금금액 " + withD + "원이 처리되었습니다.");
				} else {
					System.out.println("계좌번호를 다시 입력하십시오.");
				}
			} else if (menu == 4) {
				System.out.println("계좌번호를 입력 > ");
				accountNo = scn.nextLine();
				app.checkBalance(accountNo);
			} else if (menu == 5) {
				System.out.println("계좌번호를 입력> ");
				accountNo = scn.nextLine();
				app.accountList(accountNo);
			} else if (menu == 6) {
				System.out.println("종료버튼입니다");
				run = false;
			}
		}
		System.out.println("end of prog.");
	}
}
