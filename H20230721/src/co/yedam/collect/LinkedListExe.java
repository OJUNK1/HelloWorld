package co.yedam.collect;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class LinkedListExe {
	public static void main(String[] args) {
		// arrayList에서 객체를 한개를 제거하면 뒤에꺼들이 한칸씩 앞으로 당겨서 빈자리를 채워주는 형식이라면
		// LinkedList는 객체를 한개 제거하거나 삽입하면, 앞뒤 링크만 변경되고 나머지 링크는 변경되지않음.

		List<String> list = new ArrayList<>();

		List<String> lnk = new LinkedList<>();

		long start = System.currentTimeMillis();
		for (int i = 0; i < 100000; i++) {
			list.add(0, String.valueOf(i));
		}
		long end = System.currentTimeMillis();
		System.out.println("ArrayList 걸린시간: " + (end - start));
		
		
		start = System.currentTimeMillis();
		for (int i = 0; i < 100000; i++) {
			lnk.add(0, String.valueOf(i));
		}
		end = System.currentTimeMillis();
		System.out.println("LinkList 걸린시간: " + (end - start));

	}
}
