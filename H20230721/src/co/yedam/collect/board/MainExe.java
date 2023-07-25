package co.yedam.collect.board;

import java.util.List;
import java.util.Scanner;

public class MainExe {
	public static void main(String[] args) {
		String logId = "";
		String logPw = "";
		int boardNo;
		String title;
		String content;
		String writer;
		UserApp userapps = new UserApp();
		BoardApp boardapps = new BoardApp();
		// 로그인 처리 -> 기능 사용.

		// 구현한 것 1.등록 2.목록 3. 단건조회 4. 삭제 9.종료
		Scanner scn = new Scanner(System.in);
		boolean run = true;

		while (run) {
			System.out.println("로그인 할 ID 입력> ");
			logId = scn.nextLine();
			System.out.println("로그인 할 PW 입력> ");
			logPw = scn.nextLine();
			boolean result = userapps.login(logId, logPw);
			if (result) { /// result = true 하면 안되는 이유?....
				System.out.println("로그인에 성공했습니다");
			} else {
				System.out.println("아이디가 존재하지 않거나, 비밀번호가 틀렸습니다");
				continue;
			}
			while (run) {
				System.out.println("메뉴를 입력> ");
				System.out.println("1.등록 2.목록 3.단건조회 4.삭제 9.종료");
				int menu = Integer.parseInt(scn.nextLine());
				if (menu == 1) {
					System.out.println("게시판에 글등록을 진행하겠습니다");
					System.out.println("글 번호를 입력> ");
					boardNo = Integer.parseInt(scn.nextLine());
					System.out.println("글 제목을 입력> ");
					title = scn.nextLine();
					System.out.println("글 내용을 입력> ");
					content = scn.nextLine();
					Board boards = new Board(boardNo, title, content, logId);
					result = boardapps.addBoard(boards);
					if (result) {
						System.out.println("글등록에 성공");
					} else {
						System.out.println("글등록에 실패");
					}

				} else if (menu == 2) {
					System.out.println("등록된 글을 조회합니다.");
					List<Board> boards = boardapps.boardList();
					if (boards.isEmpty()) {
						System.out.println("등록된 글이 없습니다");
					} else {
						for (int i = 0; i < boards.size(); i++) {
							System.out.println(boards.get(i).toString());
						}
					}
				} else if (menu == 3) {
					System.out.println("조회하고 싶은 글의 글번호를 입력하시오> ");
					boardNo = Integer.parseInt(scn.nextLine());
					boardapps.getBoard(boardNo);

				} else if (menu == 4) {
					System.out.println("삭제하고 싶은 글의 글번호를 입력하시오> ");
					boardNo = Integer.parseInt(scn.nextLine());
					Board board = boardapps.getBoard(boardNo);
					// 삭제전 작성자 확인
					if (!board.getWriter().equals(logId)) {
						System.out.println("삭제권한이 없습니다.");
						continue;
					}
					result = boardapps.delBoard(boardNo);

					if (result = true) {
						System.out.println("삭제가 완료");
					} else {
						System.out.println("삭제에 실패");
					}

				} else if (menu == 9) {
					System.out.println("종료버튼입니다");
					run = false;
				} else {
					System.out.println("없는 메뉴입니다.");
				}
			}
		}
		System.out.println("end of prog.");
		scn.close();
	} // end of main.
}
