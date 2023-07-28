package co.micol.noticeprj.board.service;

import java.sql.Date;

import lombok.Data;

@Data
public class BoardVO {
	private int boardId;
	private String boardWriter;
	private String boardTitle;
	private String boardSubject;
	private Date boardDate; // java8 이후부터 권장
	private int boardHit;

	public BoardVO(int id, String writer, String title, String subject, Date today, int hit) {
		this.boardId = id;
		this.boardWriter = writer;
		this.boardTitle = title;
		this.boardSubject = subject;
		this.boardDate = today;
		this.boardHit = hit;
	}

	public BoardVO() {

	}

	@Override
	public String toString() {
		System.out.print(boardId + " ");
		System.out.print(boardWriter + " ");
		System.out.print(boardTitle + " ");
		System.out.print(boardSubject + " ");
		System.out.print(boardDate + " ");
		System.out.println(boardHit + " ");

		return null;
	}

}
