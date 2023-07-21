package co.yedam.collect;

import java.util.Hashtable;
import java.util.Map;
import java.util.Scanner;

public class HashTableExe {
	public static void main(String[] args) {
		Map<String, String> users //
				= new Hashtable<String, String>();

		users.put("spring", "12");
		users.put("summer", "123");
		users.put("fall", "1234");
		users.put("winter", "12345");

		Scanner scn = new Scanner(System.in);
		boolean run = true;

		while (run) {
			System.out.println("아이디와 비밀번호를 입력하세요");
			System.out.println("ID>> ");
			String id = scn.nextLine();
			System.out.println("PW>> ");
			String pw = scn.nextLine();

			if (users.containsKey(id)) {
				if (users.get(id).equals(pw)) {
					System.out.println("로그인 성공..");
					run = false;
				} else {
					System.out.println("비밀번호가 다릅니다..");
				}
			} else {
				System.out.println("아이디가 존재하지 않습니다..");
			}

		} // end of while.
		
		System.out.println("프로그램을 시작합니다.");
	}
}
