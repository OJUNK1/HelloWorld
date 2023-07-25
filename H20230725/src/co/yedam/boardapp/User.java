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
	String name;
	String id;
	String pw;

	public User() {
		readUserFromFile();
	}

	List<User> users = new ArrayList<>();

	boolean login(String id, String pw) {
		if (users.contains(id)) {
			if (users..equals(pw)) {
				return true; // 로그인 성공
			}
		} else {
			return false; // 로그인 실패
		}
		return false; // 사용자 id 존재하지 않음
	}

	boolean signUp(String id, String pw) {
		if (!users.contains(id)) {
			users.add(id, pw);
			return true;
		}
		return false;
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
		this.pw = pw;
	}

	public List<User> getUsers() {
		return users;
	}

	public void setUsers(List<User> users) {
		this.users = users;
	}

	// 출력스트림
	public void storeUsertoFile() {
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
