package co.yedam.friend;

//친구의 연락처 관리 app.
//일반적인 정보: 이름, 연락처.
//회사사람- 회사정보: 회사, 부서, 학교사람- 학교정보: 학교명, 전공
// System.out.println() : 콘솔 x
public class AddressApp {
	Friend[] friends = new Friend[10]; // 저장공간.
	ComFriend[] comFriends = new ComFriend[10];
	UnivFriend[] univFriends = new UnivFriend[10];
	int addNum = 0;

	// 추가. addFriend()
	public boolean addFriend(Friend friend) {
		if (addNum > 10) {
			return false;
		}
		friends[addNum++] = friend;
		return true;
	}

	public boolean addFriendC(ComFriend friend) {
		if (addNum > 10) {
			return false;
		}
		comFriends[addNum++] = friend;
		return true;
	}

	public boolean addFriendU(UnivFriend friend) {
		if (addNum > 10) {
			return false;
		}
		univFriends[addNum++] = friend;
		return true;
	}

	// 조회. findFriend() : 친구이름중에는 동일한 이름이 없음.
	public int findFriend(String name) {
		for (int i = 0; i < addNum; i++) {
			if (friends[i] != null && friends[i].getName().equals(name)) {
				System.out.println("이름: " + name + ", 폰번호: " + friends[i].getPhone());
				return 0;
			}
		}
		return 1;
	}

	public int findFriendC(String name) {
		for (int i = 0; i < addNum; i++) {
			if (friends[i] != null && comFriends[i].getName().equals(name)) {
				System.out.println("이름: " + name + ", 폰번호: " + comFriends[i].getPhone());
				return 0;
			}
		}
		return 1;
	}

	public int findFriendU(String name) {
		for (int i = 0; i < addNum; i++) {
			if (friends[i] != null && univFriends[i].getName().equals(name)) {
				System.out.println("이름: " + name + ", 폰번호: " + univFriends[i].getPhone());
				return 0;
			}
		}
		return 1;
	}

	// 수정. editFriend() : 친구의 연락처 수정.
	public boolean editFriend(String name, String phone) {
		for (int i = 0; i < addNum; i++) {
			if (friends[i] != null && friends[i].getName().equals(name)) {
				friends[i].setPhone(phone);
				return true;
			}
		}
		return false;
	}

	public boolean editFriendC(String name, String phone) {
		for (int i = 0; i < addNum; i++) {
			if (comFriends[i] != null && comFriends[i].getName().equals(name)) {
				comFriends[i].setPhone(phone);
				return true;
			}
		}
		return false;
	}

	public boolean editFriendU(String name, String phone) {
		for (int i = 0; i < addNum; i++) {
			if (univFriends[i] != null && univFriends[i].getName().equals(name)) {
				univFriends[i].setPhone(phone);
				return true;
			}
		}
		return false;
	}

	// 삭제. delFriend() : 친구의 정보 삭제.
	public boolean delFriend(String name) {
		for (int i = 0; i < addNum; i++) {
			if (friends[i] != null && friends[i].getName().equals(name)) {
				friends[i] = null;
				return true;
			}
		}
		return false;
	}

	public boolean delFriendC(String name) {
		for (int i = 0; i < addNum; i++) {
			if (friends[i] != null && comFriends[i].getName().equals(name)) {
				comFriends[i] = null;
				return true;
			}
		}
		return false;
	}

	public boolean delFriendU(String name) {
		for (int i = 0; i < addNum; i++) {
			if (friends[i] != null && univFriends[i].getName().equals(name)) {
				univFriends[i] = null;
				return true;
			}
		}
		return false;
	}

	// 목록. freindList() : 친구목록.
	public Friend[] friendList() {
		return friends;
	}

	public ComFriend[] friendListC() {
		return comFriends;
	}

	public UnivFriend[] friendListU() {
		return univFriends;
	}
}
