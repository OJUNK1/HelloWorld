package co.yedam.boardapp;

import java.io.Serializable;

public class Board implements Serializable {
	int boardNo;
	String title;
	String content;
	String writer;

	// 생성자 함수
	public Board(int boardNo, String title, String content, String writer) {
		super();
		this.boardNo = boardNo;
		this.title = title;
		this.content = content;
		this.writer = writer;
	}

	public Board() {

	}

	// getter setter
	public int getBoardNo() {
		return boardNo;
	}

	public void setBoardNo(int boardNo) {
		this.boardNo = boardNo;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getWriter() {
		return writer;
	}

	public void setWriter(String writer) {
		this.writer = writer;
	}

	@Override
	public String toString() {
		return "[ boardNo= " + boardNo + ", title= " + title + ", content= " + content + ", writer= " + writer
				+ " ] \n";
	}

}
