package co.yedam.collect;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class HashMapExe {
	// Map 컬렉션 키와 값으로 구성.
	// 키는 중복 저장 불가, 값은 중복 저장 가능. p.571
	public static void main(String[] args) {
		Map<String, Integer> map //
				= new HashMap<String, Integer>();

		map.put("홍길동", 80);
		map.put("김길동", 85);
		map.put("박길동", 88);
		map.put("홍길동", 90);
		// 홍길동이 80점에서 90점으로 변경. 값

		map.remove("홍길동");

		if (map.containsKey("김길동")) {
			Integer result = map.get("김길동");
			System.out.println("김길동의 점수: " + result);
		}

		// 반복된 요소 출력.
		Set<String> keys = map.keySet(); // key에 해당되는 값만 set 컬렉션에 저장.
		for (String key : keys) {
			Integer val = map.get(key);
			System.out.printf("key: %s, val: %d\n", key, val);
		}
		
		// key, value 한 쌍을 entry라고 함.
		Set<Entry<String, Integer>> entrySet = map.entrySet(); // Key, Value => {Key, Value} 반환
		for (Entry<String, Integer> entry : entrySet) {
			String key = entry.getKey();
			Integer val = entry.getValue();
			System.out.printf("key: %s, val: %d\n", key, val);
		}
		System.out.println("end of prog.");
	}
}
