package co.yedam;

import java.util.Scanner;

public class ConditionExe2 {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        while (true) {
            System.out.println("메뉴를 선택하세요(숫자를 입력)>> ");
            System.out.println("1.로그인 2.로그아웃 3.회원가입 4.종료");
            String menu = scn.nextLine();

            switch (menu) {
                case "1":
                    login();
                    break;
                case "2":
                    logout();
                    break;
                case "3":
                    signup();
                    break;
                case "4":
                   quit();
        
       
            }
        }
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

	public static void quit( ) {
		 System.out.println("프로그램을 종료합니다.");
	}
}