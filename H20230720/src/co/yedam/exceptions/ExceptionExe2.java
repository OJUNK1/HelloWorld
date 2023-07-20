package co.yedam.exceptions;

import java.util.Scanner;

public class ExceptionExe2 {
	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		System.out.print("이름>> ");
		String name = scn.nextLine();
		boolean run = true;
		int age = 0;
		while (run) {
			try {
				System.out.print("나이>> ");
				age = Integer.parseInt(scn.nextLine());
				break;

			} catch (NumberFormatException n) {
				System.out.println("숫자만 입력가능합니다");
//				continue; 없어도 계속 반복됨.
			}
		}
		
		System.out.print("주소>> ");
		String addr = scn.nextLine();

		System.out.printf("이름은 %s, 나이는 %d, 주소는 %s", name, age, addr);
		run = false;
	}

}
