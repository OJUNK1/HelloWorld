package co.micol.noticeprj.board.service;

import java.util.List;

public interface BoardService { // CRUD
	List<BoardVO> boardSelectList(); // 전체조회 R

	BoardVO boardSelect(BoardVO vo); // 한건조회 R

	int boardInsert(BoardVO vo); // 게시판 등록 C

	int boardDelete(BoardVO vo); // 게시판 삭제 D

	int boardUpdate(BoardVO vo); // 게시판 변경 U
	
	
}
