package co.yedam.api;

import java.util.HashSet;
import java.util.Set;

public class ObjectExe {
	public static void main(String[] args) {

		Object obj1 = new Object();
		Object obj2 = new Object();
		boolean result = obj1.equals(obj2);
		System.out.println(result);

		Member mem1 = new Member(1001, "홍길동");
		Member mem2 = new Member(1002, "김길동");
		result = mem1.equals(mem2);
		System.out.println(result);
		
		Set<Member> set = new HashSet<>();
		
		//논리적으로 동등한 객체임을 판별할 때
		// hashCode, equals 정의.
		set.add(new Member(1001, "홍길동"));
		set.add(new Member(1002, "홍길동"));
		set.add(new Member(1003, "박길동"));
		set.add(new Member(1001, "홍길동"));
		
		for(Member str : set) {
			System.out.println(str.toString());
		}

		printRect();

	}

	public static void printRect() {
		// 1
		// 2 3
		// 4 5 6
		// 7 8 9 10 반복문
		String num = "";
		int number = 0;
		for (int i = 0; i < 4; i++) {
			for (int j = 0; j <= i; j++) {
				if (i >= j) {
					number++;
					num += number + " ";
				}
			}
			System.out.println(num);
			num = "";
			continue;
		}

	}

}
