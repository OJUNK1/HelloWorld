package co.yedam.boardpkg;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

interface Menu {
	int ADD = 1, EDIT = 2, DEL = 3, LIST = 4, INFO = 5, EXIT = 6;
}

public class MainExe {
	public static void menuPrint() {
		System.out.println("1.등록 2.수정 3.삭제 4.목록 5.개인정보 6.종료");
		System.out.print("선택>> ");
	}

	public static void main(String[] args) {

		BoardService svc = new BoardApp(); // BoardDAO
		User users = new User();

		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		Scanner scn = new Scanner(System.in);
		boolean run = true;
		boolean run1 = true;
		String logId = "";
		String logPw = "";

		while (run1) {
			svc.login(logId, logPw);
			System.out.println("아이디를 입력> ");
			logId = scn.nextLine();
			System.out.println("비밀번호를 입력> ");
			logPw = scn.nextLine();
			boolean result = svc.login(logId, logPw);
			if (result) {
				System.out.println("로그인 성공");
				break;
			} else {
				System.out.println("로그인 실패");
				continue;
			}
		}
		while (run) {

			menuPrint();
			int menu = Integer.parseInt(scn.nextLine());

			switch (menu) {
			case Menu.ADD:
				System.err.println("글등록을 진행> ");
				System.out.println("글번호 입력> ");
				int brdNo = Integer.parseInt(scn.nextLine());
				String writer = logId;
				System.out.println("글제목 입력> ");
				String title = scn.nextLine();
				System.out.println("글내용 입력> ");
				String content = scn.nextLine();
				String date = sdf.format(new Date());
				Board boards = new Board(brdNo, title, content, writer, date);
				boolean result = svc.addBoard(boards);
				if (result) {
					System.out.println("글등록 완료");
				} else {
					System.out.println("글등록 실패");
				}
				break;
			case Menu.EDIT:
				System.out.println("글수정을 진행> ");
				System.out.println("수정할 글의 번호 입력> ");
				brdNo = Integer.parseInt(scn.nextLine());
				System.out.println("수정할 글의 내용을 입력> ");
				content = scn.nextLine();
				Board board = new Board(brdNo, "", content, "", "");
				if (!board.getWriter().equals(logId)) {
					System.out.println("수정할 권한 X");
					continue;
				}
				result = svc.editBoard(board);
				if (result) {
					System.out.println("글수정 성공");
				} else {
					System.out.println("글수정 실패");
				}
				break;
			case Menu.DEL:
				System.out.println("글삭제 진행> ");
				System.out.println("삭제할 글의 번호 입력> ");
				brdNo = Integer.parseInt(scn.nextLine());

				board = new Board(brdNo, "", "", "", "");
				if (!board.getWriter().equals(logId)) {
					System.out.println("삭제할 권한 X");
					continue;
				}
				result = svc.delBoard(brdNo);
				if (result) {
					System.out.println("글삭제 성공");
				} else {
					System.out.println("글삭제 실패");
				}
				break;
			case Menu.LIST:
				for (Board brd : svc.boardList()) {
					System.out.println(brd.toString());
				}
				break;
			case Menu.INFO:
				System.err.println("수정할 비밀번호 입력> ");
				String editPw = scn.nextLine();
				User user = new User(logId, users.getUserName(), editPw);
				result = svc.modInfo(user);
				if (result) {
					System.out.println("비밀번호를 변경했습니다");
				} else {
					System.out.println("변경에 실패했습니다");
				}
				break;
			case Menu.EXIT:
				System.out.println("종료합니다");
				svc.exit();
				run = false;
			}
		}
		System.out.println("end of prog.");
		scn.close();
	}
}
