package co.yedam.collect;

import java.util.ArrayList;
import java.util.List;

public class ArrayListExe {
	public static void main(String[] args) {
		List<String> list = new ArrayList<String>();
		list.add("홍길동");
		list.add("김길동");
		list.add("박길동");
		for (int i = 0; i < 15; i++) {
			list.add(String.valueOf(i));
		}
//      list.add(10); 		에러발생, String만 가능.
//		list.add(new Friend("홍길동", "010-1111"));

		String obj = (String) list.get(0); // 배열일 때는 list[0] , class이므로 get 메소드로 해당하는 객체를 호출.
		list.set(0, "Hong"); // list[0] = "Hong"; 의미
		System.out.println("크기: " + list.size());
		list.remove(0); // list[0] = null;
		System.out.println("크기: " + list.size());
		obj = list.get(0); // 값이 비워지면서 뒤에서부터 하나씩 당겨 "김길동" 출력됨
		// list.clear(); 전부 삭제됨.
		System.out.println(obj);
		
		
		
		for (int i = 0; i < list.size(); i++) {
			System.out.printf("[%d]의 위치값 %s \n", i, list.get(i));
		}
//		Integer num = (Integer) list.get(1);     // 매우 불편
//		System.out.println((obj + ", " + num));
	}
}
