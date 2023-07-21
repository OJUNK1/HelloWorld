package co.yedam.collect.board;

import java.util.Hashtable;
import java.util.Map;

public class UserApp {

	Map<String, String> users //
			= new Hashtable<String, String>();

	UserApp() {
		users.put("user1", "1111");
		users.put("user2", "2222");
		users.put("user3", "3333");
	}

	boolean login(String id, String pw) {
		if (users.containsKey(id)) {
			if (users.get(id).equals(pw)) {
				return true; // 로그인 성공
			} else {
				return false; // 로그인 실패 
			}
		}
		return false; // 사용자 id 존재하지 않음.
	}
}