package co.yedam.boardapp;

import java.util.List;
import java.util.Scanner;

public class BoardExe {
	public static void main(String[] args) {
		String logId = "";
		String logPw = "";
		int boardNo = 0;
		String writer = "";
		String title = "";
		String content = "";
		BoardApp boardapps = new BoardApp();
		User users = new User();

		Scanner scn = new Scanner(System.in);
		boolean run = true;
		boolean isLoop = true;
		while (run) {
			System.out.println("메뉴를 입력> ");
			System.out.println("1.회원가입 2.로그인");
			int menu = Integer.parseInt(scn.nextLine());

			if (menu == 1) {
				System.out.println("회원가입을 진행하겠습니다");
				System.out.println("등록할 ID를 입력> ");
				String id = scn.nextLine();
				System.out.println("이름을 입력> ");
				String name = scn.nextLine();
				System.out.println("비밀번호를 입력> ");
				String pw = scn.nextLine();
				boolean result = users.signUp(id, name, pw);
				if (result) {
					System.out.println("회원가입에 성공했습니다");
					users.storeUserToFile();
				} else {
					System.out.println("중복된 ID입니다.");
				}
			}

			if (menu == 2) {
				System.out.println("로그인 할 아이디를 입력");
				logId = scn.nextLine();
				System.out.println("로그인 할 패스워드를 입력");
				logPw = scn.nextLine();
				boolean result = users.login(logId, logPw);
				if (result) {
					System.out.println("로그인에 성공했습니다");
					break;
				} else {
					System.out.println("아이디 혹은 비밀번호가 틀렸습니다");
					continue;
				}
			}
		}
		while (isLoop) {
			System.out.println("메뉴를 입력> ");
			System.out.println("1.글등록 2.글수정 3.글삭제 4.목록 5.종료 9.개인정보(비번수정)");
			int menu = Integer.parseInt(scn.nextLine());
			if (menu == 1) {
				writer = logId;
//				boardNo = boardapps.getNextNo();
				System.out.println("글제목을 입력> ");
				title = scn.nextLine();
				System.out.println("글내용을 입력> ");
				content = scn.nextLine();
				Board boards = new Board(boardNo, title, content, writer);
				boolean result = boardapps.addBoard(boards);
				if (result) {
					System.out.println("글을 등록하였습니다");
				} else {
					System.out.println("글등록에 실패했습니다");
				}

			} else if (menu == 2) {
				System.out.println("수정하고싶은 글의 글번호를 입력> ");
				boardNo = Integer.parseInt(scn.nextLine());
				System.out.println("수정할 글내용을 입력> ");
				content = scn.nextLine();
				Board board = boardapps.getBoard(boardNo);
				// 작성자 동일여부 확인
				if (!board.getWriter().equals(logId)) {
					System.out.println("수정할 권한이 없습니다");
					continue;
				}
				boolean result = boardapps.editBoard(boardNo, content);
				if (result) {
					System.out.println("글수정을 완료했습니다");
				} else {
					System.out.println("글수정에 실패했습니다");
				}
			} else if (menu == 3) {
				System.out.println("삭제하고싶은 글의 글번호를 입력> ");
				boardNo = Integer.parseInt(scn.nextLine());
				Board board = boardapps.getBoard(boardNo);
				// 작성자 동일여부 확인
				if (!board.getWriter().equals(logId)) {
					System.out.println("삭제할 권한이 없습니다");
					continue;
				}
				boolean result = boardapps.delBoard(boardNo);
				if (result) {
					System.out.println("글삭제를 완료했습니다");
				} else {
					System.out.println("글삭제에 실패했습니다");
				}
			} else if (menu == 4) {
				System.out.println("등록된 글을 조회합니다");
				List<Board> boards = boardapps.boardList();
				if (boards.isEmpty()) {
					System.out.println("등록된 글이 없습니다");
				} else {
					for (int i = 0; i < boards.size(); i++) {
						System.out.println(boards.get(i).toString());

					}
				}
			} else if (menu == 5) {
				System.out.println("종료합니다.");
				boardapps.storeBoardToFile();
				users.storeUserToFile();
				isLoop = false;
			} else if (menu == 9) {
				System.out.println("비밀번호를 수정합니다.");
				System.out.println("수정할 비밀번호를 입력> ");
				String pw = scn.nextLine();
				User user = new User(logId, users.getName(), pw);
				boolean result = users.editPw(user);
				if (result) {
					System.out.println("비밀번호를 변경했습니다");
				} else {
					System.out.println("변경에 실패했습니다");
				}
			}

		}
		System.out.println("end of prog.");
	}

}
