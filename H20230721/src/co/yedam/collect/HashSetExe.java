package co.yedam.collect;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class HashSetExe {
	public static void main(String[] args) {
		Set<String> set = new HashSet<>();

		set.add("Apple");
		set.add("Banana");
		set.add("Cherry");
		set.add("Apple");

		// 반복문.
		Iterator<String> iter = set.iterator(); // 반복자 반환.
		while (iter.hasNext()) {
			String str = iter.next();
			System.out.println(str);
		}

		// 확장 for 통한 반복.
		for (String fruit : set) {
			System.out.println(fruit);
		}

		set.remove("Apple");
		set.clear(); // 전체 요소 제거.

		if (set.isEmpty()) {
			System.out.println("set 비어있음.");
		}

		// 크기. 중복된 값은 저장하지 않는다.
		System.out.println("set 크기: " + set.size());

		// 1~10 임의의 5개 번호를 lotto 저장.
		Set<Integer> lotto = new HashSet<>();
		while (lotto.size() < 5) {
			int temp = (int) (Math.random() * 10) + 1;
			System.out.println(temp);
			lotto.add(temp);
		}
		System.out.println(lotto);
	}
}
