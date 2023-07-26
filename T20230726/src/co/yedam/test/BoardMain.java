package co.yedam.test;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

public class BoardMain {
	public static void main(String[] args) {
		Board boards = new Board();
		BoardApp boardapps = new BoardApp();

		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		Scanner scn = new Scanner(System.in);

		int boardNo = 0;
		String title = "";
		boolean run = true;

		while (run) {
			System.out.println("게시판메뉴 선택");
			System.out.println("1.추가 2.수정 3.조회 4.삭제 5.목록 6.종료");
			int menu = Integer.parseInt(scn.nextLine());

			if (menu == 1) {
				boardNo = boardapps.getNextNo();
				System.out.println("글제목 입력> ");
				title = scn.nextLine();
				System.out.println("글내용 작성> ");
				String content = scn.nextLine();
				System.out.println("작성자 이름 입력> ");
				String writer = scn.nextLine();
				String writeDate = sdf.format(new Date());

				boards = new Board(boardNo, title, content, writer, writeDate);
				boolean result = boardapps.register(boards);
				if (result) {
					System.out.println("등록성공");
				} else {
					System.out.println("등록실패");
				}

			} else if (menu == 2) {
				System.out.println("수정할 글의 글번호 입력> ");
				boardNo = Integer.parseInt(scn.nextLine());
				System.out.println("수정할 글내용 작성> ");
				String content = scn.nextLine();
				boards = new Board(boardNo, "", content, "", "");
				boolean result = boardapps.modify(boards);
				if (result) {
					System.out.println("수정완료");
				} else {
					System.out.println("수정실패. 없는 글입니다.");
				}

			} else if (menu == 3) {
				System.out.println("조회하고 싶은 글의 글번호 입력> ");
				boardNo = Integer.parseInt(scn.nextLine());
				boardapps.search(boardNo);

			} else if (menu == 4) {
				System.out.println("삭제할 글의 글번호 입력> ");
				boardNo = Integer.parseInt(scn.nextLine());
				boolean result = boardapps.remove(boardNo);
				if (result) {
					System.out.println("삭제완료");
				} else {
					System.out.println("삭제실패. 없는 글입니다.");
				}

			} else if (menu == 5) {
				System.out.println("등록된 모든 글을 조회합니다....");
				List<Board> board = boardapps.list();
				if (board.isEmpty()) {
					System.out.println("등록된 글이 없습니다");
				} else {
					for (int i = 0; i < board.size(); i++) {
						System.out.println(board.get(i).toString());
					}
				}
			} else if (menu == 6) {
				System.out.println("종료합니다");
				boardapps.storeToFile();
				run = false;
			}
		}

	}
}
