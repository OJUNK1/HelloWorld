package co.yedam.collect.board;

import java.util.ArrayList;
import java.util.List;

public class BoardApp {
	// 게시글 저장을 위한 컬렉션. arrayList
	List<Board> boards = new ArrayList<>();
	Board board = new Board();

	// 추가
	boolean addBoard(Board board) {
		if (boards.add(board)) {
			return true;
		}
		return false;
	}

	// 목록
	List<Board> boardList() {
		return boards;
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

	// 있으면 객체 반환 없으면 null

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
}