package co.yedam.collect.board;

public class Board {
	// 필드
	private int boardNo;
	private String title;
	private String content;
	private String writer;

	// 생성자
	public Board(int boardNo, String title, String content, String writer) {
		super();
		this.boardNo = boardNo;
		this.title = title;
		this.content = content;
		this.writer = writer;
	}

	public Board() {

	}

	//
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
		// TODO Auto-generated method stub
		return "[ boardNo= " + boardNo + ", title= " + title + ", content= " + content + ", writer= " + writer + " ] \n";
	}

}
