package co.yedam.boardapp;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;

public class BoardApp {
	List<Board> boards = new ArrayList<>();
//	Board board = new Board();

	public BoardApp() {
		readBoardFromFile();
	}



	// 추가
	boolean addBoard(Board board) {

		if (boards.add(board)) {
			return true;
		}
		return false;
	}

	// 수정
	boolean editBoard(int boardNo, String content) {
		for (int i = 0; i < boards.size(); i++) {
			if (boardNo == boards.get(i).getBoardNo()) {
				boards.get(i).setContent(content);
				return true;
			}
		}
		return false;
	}

	// 삭제
	boolean delBoard(int boardNo) {
		for (int i = 0; i < boards.size(); i++) {
			if (boardNo == boards.get(i).getBoardNo()) {
				boards.remove(i);
				return true;
			}
		}
		return false;
	}

	// 조회
	Board getBoard(int boardNo) {
		for (int i = 0; i < boards.size(); i++) {
			if (boardNo == boards.get(i).getBoardNo()) {
				Board obj = boards.get(i);
				System.out.println(obj);
				return obj;
			}
		}
		System.out.println("해당 글번호에 해당하는 게시물이 없습니다.");
		return null;
	}

	// 목록
	List<Board> boardList() {
		return boards;
	}
	
	

	// 출력 스트림
	public void storeBoardToFile() {
		try {
			FileOutputStream fos = new FileOutputStream("c:/Temp/boardList.txt");
			ObjectOutputStream oos = new ObjectOutputStream(fos);
			oos.writeObject(boards);
			oos.flush();
			oos.close();
			fos.flush();
			fos.close();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	// 입력 스트림
	public void readBoardFromFile() {
		try {
			FileInputStream fis = new FileInputStream("c:/Temp/boardList.txt");
			ObjectInputStream ois = new ObjectInputStream(fis);

			boards = (List<Board>) ois.readObject();
			ois.close();
			fis.close();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
