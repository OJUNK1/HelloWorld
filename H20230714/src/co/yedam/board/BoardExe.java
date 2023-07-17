package co.yedam.board;

import java.util.Scanner;

public class BoardExe {
	static Board[] boards = new Board[20];

	static Scanner scn = new Scanner(System.in);

	private static void init() {
		Board b1 = new Board(1000, "날개", "박제가 되어버린 천재를 아시오", "이상");
		Board b2 = new Board(1001, "데미안", "알은 세계다", "헤세");
		Board b3 = new Board(1002, "정의란 무엇인가", "Justice", "샌델");
		Board b4 = new Board(1003, "사피엔스", "유인원에서 사이보그까지", "유발");
		Board b5 = new Board(1004, "군주론", "군주가 갖추어야 할 자질", "마키아벨리");
		Board b6 = new Board(1005, "인연", "세번의 만남", "피천득");
		Board b7 = new Board(1006, "칠번글", "칠번째 글내용", "권오준");
		Board b8 = new Board(1007, "팔번글", "팔번째 글내용", "박근수");
		Board b9 = new Board(1008, "구번글", "구번째 글내용", "구번장");
		Board b10 = new Board(1009, "십번글", "십번째 글내용", "십번장");
		Board b11 = new Board(1010, "십일번글", "십일번째 글내용", "십일번장");
		Board b12 = new Board(1011, "십이번글", "십이번째 글내용", "십이번장");
		Board b13 = new Board(1012, "토지", "대하소설 토지", "박경리");
		Board b14 = new Board(1013, "고구려", "삼국", "김진명");

		boards[0] = b1;
		boards[1] = b2;
		boards[2] = b3;
		boards[3] = b4;
		boards[4] = b5;
		boards[5] = b6;
		boards[6] = b7;
		boards[7] = b8;
		boards[8] = b9;
		boards[9] = b10;
		boards[10] = b11;
		boards[11] = b12;
		boards[12] = b13;
		boards[13] = b14;
	}

	// 등록 기능.
	private static void addBoard() {
		System.out.println("글을 등록합니다");
		System.out.println("글번호를 입력> ");
		int boardNo = Integer.parseInt(scn.nextLine());
		System.out.println("글제목을 입력> ");
		String boardTitle = scn.nextLine();
		System.out.println("글내용을 입력> ");
		String boardDetail = scn.nextLine();
		System.out.println("글작성자를 입력> ");
		String writer = scn.nextLine();

		Board board = new Board(boardNo, boardTitle, boardDetail, writer);
		board.setBoardNo(boardNo);
		board.setBoardTitle(boardTitle);
		board.setBoardDetail(boardDetail);
		board.setWriter(writer);

		for (int i = 0; i < boards.length; i++) {
			if (boards[i] == null) {
				boards[i] = board;
				break;
			}
		}
	}

	// 수정 기능.
	private static void editBoard() {
		System.out.println("글 수정");
		System.out.println("수정할 글의 글번호를 입력> ");
		int bno = Integer.parseInt(scn.nextLine());
		System.out.println("수정할 글내용을 입력> ");
		String bdetails = scn.nextLine();
		for (int i = 0; i < boards.length; i++) {
			if (boards[i] != null && boards[i].getBoardNo() == bno) {
				boards[i].setBoardDetail(bdetails);
			}
		}
	}

	// 삭제 기능.
	private static void delBoard() {
		System.out.println("글 삭제");
		System.out.println("삭제할 글의 글번호 입력> ");
		int bno = Integer.parseInt(scn.nextLine());
		for (int i = 0; i < boards.length; i++) {
			if (boards[i] != null && boards[i].getBoardNo() == bno) {
				boards[i] = null;
			}
		}
	}

	// 목록 기능.
	private static void list() {
		int Cnt = 0;
		int lastPage = (int) Math.floor(boards.length / 5);

		System.out.println("글 목록보기");
		System.out.println("페이지를 입력> ");
		int pageNo = Integer.parseInt(scn.nextLine());
		if (pageNo >= 1 && pageNo <= lastPage) {
			int startIndex = (pageNo - 1) * 5;

			for (int i = startIndex; i<boards.length && i<startIndex + 5; i++) {
				System.out.println(boards[i].showInfo());
				Cnt++;
				if (Cnt % 5 == 0) {
					System.out.println("\n\nPage: " + pageNo + " / " + lastPage);
					break;
				}

			}
		}
	}

	// 상세 보기 기능.
	private static void getBoard() {
		System.out.println("상세조회기능");
		System.out.println("조회할 글의 글번호 입력> ");
		int bno = Integer.parseInt(scn.nextLine());
		for (int i = 0; i < boards.length; i++) {
			if (boards[i] != null && boards[i].getBoardNo() == bno) {
				System.out.println(boards[i].boardInfo());
			}

		}
	}

	public static void main(String[] args) {
		init(); // 실행
		boolean run = true;

		while (run) {
			System.out.println("1.글등록 2.글목록 3.글수정 4.글삭제 5.글상세보기 6.종료");
			System.out.println("목록 선택>> ");
			int menu = Integer.parseInt(scn.nextLine());
			if (menu == 1) {
				addBoard();
			} else if (menu == 2) {
				// 한 페이지당 5개씩
				list();
			} else if (menu == 3) {
				editBoard();
			} else if (menu == 4) {
				delBoard();
			} else if (menu == 5) {
				getBoard();
			} else if (menu == 6) {
				System.out.println("종료 기능입니다");
				run = false;
			}
		}
		System.out.println("End of prog.");
	} // end of the main
}
