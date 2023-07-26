package co.yedam.boardpkg;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class BoardApp implements BoardService {
	List<Board> boardList = new ArrayList<>();
	List<User> userList = new ArrayList<>();

	BoardApp() {
		readFromFile();
	}

	void readFromFile() {
		try {
			FileReader fr1 = new FileReader("c:/Temp/userList.txt");
			FileReader fr2 = new FileReader("c:/Temp/boardList.txt");

			BufferedReader br = new BufferedReader(fr1);
			while (true) {
				String str = br.readLine();
				if (str == null)
					break;
				String[] data = str.split(" ");
				userList.add(new User(data[0], data[1], data[2]));
			}
			br = new BufferedReader(fr2);
			while (true) {
				String str = br.readLine();
				if (str == null)
					break;
				String[] data = str.split(" ");
				boardList.add(new Board(Integer.parseInt(data[0]), data[1], data[2], data[3], data[4]));
			}
			br.close();
			fr2.close();
			fr1.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void saveToFile() {
		try {
			FileWriter fw1 = new FileWriter("c:/Temp/userList.txt");
			FileWriter fw2 = new FileWriter("c:/Temp/boardList.txt");
			for (User user : userList) {
				fw1.write(user.getUserId() + " " + user.getUserName() + " " + user.getUserPw() + " ");
			}
			for (Board brd : boardList) {
				fw2.write(brd.getBrdNo() + " " + brd.getTitle() + " " + brd.getContent() + " " + brd.getWriter() + " "
						+ brd.getWriteDate() + " ");
			}
			fw1.flush();
			fw1.close();
			fw2.flush();
			fw2.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public int getNextNo() {
		int boardNo = 0;
		for (int i = 0; i < boardList.size(); i++) {
			if (boardList.get(i).getBrdNo() > boardNo) {
				boardNo = boardList.get(i).getBrdNo();
			}
		}
		return boardNo + 1;
	}

	// 로그인 기능.
	public boolean login(String id, String pw) {
		for (User user : userList) {
			if (user.getUserId().equals(id)) {
				if (user.getUserPw().equals(pw)) {
					return true; // 로그인 성공
				} else {
					return false; // 비밀번호 틀림
				}
			}
		}
		return false; // 존재하지 않는 아이디
	}

	// 글등록.
	public boolean addBoard(Board board) {
		if (boardList.add(board)) {
			return true;
		}
		return false;
	}

	// 글수정.
	public boolean editBoard(Board board) {
		for (int i = 0; i < boardList.size(); i++) {
			if (boardList.get(i).getBrdNo() == board.getBrdNo()) {
				boardList.get(i).setContent(board.getContent());
				return true;
			}
		}
		return false;
	}

	// 글삭제.
	public boolean delBoard(int brdNo) {
		for (int i = 0; i < boardList.size(); i++) {
			if (boardList.get(i).getBrdNo() == brdNo) {
				boardList.remove(i);
				return true;
			}
		}
		return false;
	}

	// 글목록.
	public List<Board> boardList() {
		return boardList;
	}

	// 개인정보수정.
	public boolean modInfo(User user) {
		for (int i = 0; i < userList.size(); i++) {
			if (userList.get(i).getUserId().equals(user.getUserId())) {
				userList.get(i).setUserId(user.getUserId());
				userList.get(i).setUserPw(user.getUserPw());
				return true;
			}
		}
		return false;
	}

	public void exit() {
		saveToFile();

	}

}
