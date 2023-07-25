package co.yedam.boardapp;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class User implements Serializable {
	String id;
	String name;
	String pw;

	String logId;
	String logPw;

	List<User> users = new ArrayList<>();

	public User(String id, String name, String pw) {
		this.id = id;
		this.pw = pw;
		this.name = name;
	}

	public User() {
		readUserFromFile();
	}

	boolean login(String id, String pw) {
		for (User user : users) {
			if (user.getId().equals(id)) {
				if (user.getPw().equals(pw)) {
					logId = id;
					logPw = pw;
					return true; // 로그인 성공
				} else {
					return false; // 로그인 실패
				}
			}
		}
		return false; // 사용자 id 존재하지 않음
	}

	boolean signUp(String id, String name, String pw) {
		for (User user : users) {
			if (user.getId().equals(id)) {
				return false; // 이미 등록된 id 존재해 회원가입에 실패
			}
		}
		User newUser = new User(id, name, pw);
		users.add(newUser);
		return true; // 회원가입 성공
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getPw() {
		return pw;
	}

	public void setPw(String pw) {
		if (logId != null && logPw != null) {
			for (User user : users) {
				if (user.getId().equals(logId) && user.getPw().equals(logPw)) {
					user.setPw(pw);
					System.out.println("비밀번호를 수정했습니다.");
					return;
				}
			}
			System.out.println("비밀번호 수정에 실패했습니다.");
		}
	}

	public List<User> getUsers() {
		return users;
	}

	public void setUsers(List<User> users) {
		this.users = users;
	}

	// 출력스트림
	public void storeUserToFile() {
		try {
			FileOutputStream fos = new FileOutputStream("c:/Temp/userList.txt");
			ObjectOutputStream oos = new ObjectOutputStream(fos);
			oos.writeObject(users);
			oos.flush();
			oos.close();
			fos.flush();
			fos.close();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	// 입력스트림
	public void readUserFromFile() {
		FileInputStream fis;
		try {
			fis = new FileInputStream("c:/Temp/userList.txt");
			ObjectInputStream ois = new ObjectInputStream(fis);

			users = (List<User>) ois.readObject();
			ois.close();
			fis.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
