package co.yedam;

import java.util.Scanner;

public class WhileLoopExe {
	static Scanner scn = new Scanner(System.in);
	static int balance = 50000;
	public static void main(String[] args) {		
		boolean run = true;		
		// 은행: 1. 입금 2. 출금 3. 잔액 4. 종료
		// 제한 금액 : 10만원, 현재 금액 50000원/ 5만원 초과 금액은 입금 불가
		// 현재 금액이 4만원 있을 때, 4만 5천원 출금은 불가능 -> 마이너스 통장 X
		while (run) {
			System.out.println("1.입금 2.출금 3.잔액 4.종료");
			System.out.print("선택>> ");
			int menu = Integer.parseInt(scn.nextLine());

			switch (menu) {
			case 1:
				deposit();
				break;
			case 2:
				withdraw();
				break;
			case 3:
				check();
				break;
			case 4:
				run = false;
				break;
			default:
				System.out.println("메뉴를 다시 선택하세요");
			}
		}
		System.out.println("End of prog.");
	} 	// end of main()

	public static void deposit() {
		System.out.println("입금 금액을 입력>> ");
		int withdraw = Integer.parseInt(scn.nextLine());
		if (balance + withdraw <= 100000) {
			balance = balance + withdraw;
		} else {
			System.out.print("보유 한도 금액은 10만원 입니다. 현재 금액은 " + balance + "원입니다\n");
		}
	}

	public static void withdraw() {
		System.out.println("출금 급액을 입력 >> ");
		int deposit = Integer.parseInt(scn.nextLine());
		if (balance - deposit > 0 ) {
			balance = balance - deposit;
		} else {
			System.out.printf("현재 잔액 %d원 입니다. 현재 잔액보다 많은 금액을 인출할 수 없습니다.\n", balance);
		}
	}

	public static void check() {
		System.out.printf("현재 잔액은 %d원 입니다\n", balance);
	}
}	