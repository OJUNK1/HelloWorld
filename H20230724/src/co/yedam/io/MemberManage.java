package co.yedam.io;

import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;

public class MemberManage {
	// 추가, 수정, 삭제, 목록, 종료(저장)
	List<Member> members = new ArrayList<>();

	MemberManage() throws FileNotFoundException {
//		try {
//			FileReader fr = new FileReader("c:/Temp/members.txt");
//			BufferedReader br = new BufferedReader(fr);
//
//			while (true) {
//				String str = br.readLine();
//				// str = " 권오준 대구 010-9928 ";
//				if (str == null) {
//					break;
//				}
//				String[] data = str.split(" ");
//				members.add(new Member(data[0], data[1], data[2]));
//			}
//			System.out.println("members 추가완료.");
//			
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
		FileInputStream fis;
		try {
			fis = new FileInputStream("c:/Temp/members.db");
			ObjectInputStream ois = new ObjectInputStream(fis);
			members = (List<Member>) ois.readObject();
			ois.close();
			fis.close();

		} catch (Exception e) {
			// TODO Auto-generated catch block
//			e.printStackTrace();
		}
	}

	// 추가
	boolean addMember(Member member) {
		return members.add(member);
	}

	// 수정
	boolean editMember(Member member) {
		for (int i = 0; i < members.size(); i++) {
			if (members.get(i).getName().equals(member.getName())) {
//				members.get(i).setAddr(member.getAddr());
				members.get(i).setPhone(member.getPhone());
				return true;
			}
		}
		return false;
	}

	// 삭제
	boolean delMember(String name) {
		for (int i = 0; i < members.size(); i++) {
			if (members.get(i).getName().equals(name)) {
				members.remove(i);
				return true;
			}
		}
		return false;
	}

	// 목록
	List<Member> list() {
		return members;

	}

	// 저장
	void save1() {
		try {
			FileOutputStream fos = new FileOutputStream("c:/Temp/members.db");
			ObjectOutputStream oos = new ObjectOutputStream(fos);
			oos.writeObject(members);
			oos.flush();
			oos.close();
			fos.flush();
			fos.close();
			
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	void save() {
		try {
			FileWriter fw = new FileWriter("c:/Temp/members.txt");
			BufferedWriter br = new BufferedWriter(fw);
			/// 여기에 들어간 내용을 전부 members에 넣기
			for (Member member : members) {
				String data = member.getName() + " " + member.getAddr() + " " + member.getPhone();
				br.write(data + "\n");
			}
			br.flush();
			br.close();
			fw.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
