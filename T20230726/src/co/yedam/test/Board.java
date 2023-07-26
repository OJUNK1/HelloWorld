package co.yedam.test;

import java.io.Serializable;

public class Board implements Serializable {
	int boardNo;
	String title;
	String content;
	String writer;
	String writeDate;

	public Board(int boarddNo, String title, String content, String writer, String writeDate) {
		super();
		this.boardNo = boarddNo;
		this.title = title;
		this.content = content;
		this.writer = writer;
		this.writeDate = writeDate;
	}

	public Board() {

	}

	public int getBoardNo() {
		return boardNo;
	}

	public void setBoardNo(int boardNo) {
		this.boardNo = boardNo;
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

	public String getWriteDate() {
		return writeDate;
	}

	public void setWriteDate(String writeDate) {
		this.writeDate = writeDate;
	}

	@Override
	public String toString() {
		return "[ boardNo: " + boardNo + ", title: " + title + ", content: " + content + ", writer: " + writer
				+ ", writeDate: " + writeDate + " ]";
	}
}
