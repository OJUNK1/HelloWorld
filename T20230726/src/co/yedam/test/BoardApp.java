package co.yedam.test;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;

public class BoardApp {

	List<Board> boardList = new ArrayList<>();

	BoardApp() {
		readFromFile();
	}

	public int getNextNo() {
		int boardNo = 0;
		for (int i = 0; i < boardList.size(); i++) {
			if (boardList.get(i).getBoardNo() > boardNo) {
				boardNo = boardList.get(i).getBoardNo();
			}
		}
		return boardNo + 1;
	}

	// 등록
	public boolean register(Board board) {
		if (boardList.add(board)) {
			return true;
		}
		return false;
	}

	// 수정
	public boolean modify(Board board) {
		for (int i = 0; i < boardList.size(); i++) {
			if (boardList.get(i).getBoardNo() == board.getBoardNo()) {
				boardList.get(i).setContent(board.getContent());
				return true;
			}
		}
		return false;
	}

	// 조회
	Board search(int boardNo) {
		for (int i = 0; i < boardList.size(); i++) {
			if (boardNo == boardList.get(i).getBoardNo()) {
				Board obj = boardList.get(i);
				System.out.println(obj);
				return obj;
			}
		}
		System.out.println("해당 글번호에 해당하는 게시물이 없습니다.");
		return null;
	}

	// 삭제
	public boolean remove(int boardNo) {
		for (int i = 0; i < boardList.size(); i++) {
			if (boardList.get(i).getBoardNo() == boardNo) {
				boardList.remove(i);
				return true;
			}
		}
		return false;
	}

	// 목록
	public List<Board> list() {
		return boardList;
	}

	// 입력스트림
	public void readFromFile() {
		try {
			FileInputStream fis = new FileInputStream("c:/Temp/boardList.dat");
			ObjectInputStream ois = new ObjectInputStream(fis);

			boardList = (List<Board>) ois.readObject();
			ois.close();
			fis.close();

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	// 출력스트림
	public void storeToFile() {
		try {
			FileOutputStream fos = new FileOutputStream("c:/Temp/boardList.dat");
			ObjectOutputStream oos = new ObjectOutputStream(fos);
			oos.writeObject(boardList);
			oos.flush();
			oos.close();
			fos.flush();
			fos.close();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
