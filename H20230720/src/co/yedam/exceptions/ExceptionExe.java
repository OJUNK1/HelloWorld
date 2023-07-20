package co.yedam.exceptions;

import java.util.Scanner;

public class ExceptionExe {
	public static void main(String[] args) {
		// NullPointException.
		Scanner scn = new Scanner(System.in);
		String str = null;
		str = "홍길동";
		int age = 0;
		// try 블럭에서 예외가 발생하면, 프로그램을 강제종료 시키지말고 catch 블럭에 정의된 코드를 실행시키기.
		try {
			System.out.println(str.toString());
			age = Integer.parseInt(scn.nextLine());
			System.out.println("이름은 " + str + ", 나이는" + age);
		} catch (NullPointerException | NumberFormatException e) {
			System.out.println("예외가 발생.");
//		} catch (NumberFormatException n) {
//			System.out.println("Format 예외가 발생.");
		} finally {
			scn.close(); // 리소스 반환.
		}

		try {
			exceptionMethod();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		System.out.println("End of prog.");
	}

	public static void exceptionMethod() throws ClassNotFoundException {
		// 예외처리의 책임을 메소드를 호출한 영역으로 떠넘기기.
		Class cls = Class.forName("java.lang.String");
	}
}
