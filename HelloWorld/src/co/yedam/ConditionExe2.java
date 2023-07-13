package co.yedam;

import java.util.Scanner;

public class ConditionExe2 {
	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		while(true) {
			System.out.println("메뉴를 선택하세요(숫자를 입력)>> ");
			System.out.println("1.로그인 2.로그아웃 3.회원가입 4.종료");
			String menu = scn.nextLine();
			
			//switch, if else 구문 사용 해 숫자 1 입력시 login 2 logout 3 signup 4 종료
			// "1" => equals, 1 => == 
		}
		System.out.println("end of prog.");
	} // end of main();
	
	public static void login() {
		System.out.println("로그인 메뉴입니다.");
	}
	public static void logout() {
		System.out.println("로그아웃 메뉴입니다.");
	}
	public static void signup() {
		System.out.println("회원가입 메뉴입니다.");
	}
}
