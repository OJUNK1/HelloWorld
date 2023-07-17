package co.yedam.board;

public class Board {
	private int boardNo;
	private String boardTitle;
	private String boardDetail;
	private String writer;

	// 생성자 함수
	public Board(int boardNo, String boardTitle, String boardDetail, String writer) {
		super();
		this.boardNo = boardNo;
		this.boardTitle = boardTitle;
		this.boardDetail = boardDetail;
		this.writer = writer;

	}

	public int getBoardNo() {
		return boardNo;
	}

	public void setBoardNo(int boardNo) {
		this.boardNo = boardNo;
	}

	public String getBoardTitle() {
		return boardTitle;
	}

	public void setBoardTitle(String boardTitle) {
		this.boardTitle = boardTitle;
	}

	public String getBoardDetail() {
		return boardDetail;
	}

	public void setBoardDetail(String boardDetail) {
		this.boardDetail = boardDetail;
	}

	public String getWriter() {
		return writer;
	}

	public void setWriter(String writer) {
		this.writer = writer;
	}

	public String showInfo() {
		return "글번호: " + boardNo + ", 글제목: " + boardTitle + ", 작성자: " + writer;
	}

	public String boardInfo() {
		return "-------------------------\n" + "글번호 : " + boardNo + "\n" + "글제목 : " + boardTitle + "\n" + "글내용 : "
				+ boardDetail + "\n" + "작성자 : " + writer + "\n" + "-------------------------\n";
	}
}
