package co.micol.miniproject.menu;

import java.util.Date;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import co.micol.miniproject.member.service.MemberService;
import co.micol.miniproject.member.service.MemberVO;
import co.micol.miniproject.member.serviceImpl.MemberServiceImpl;
import co.micol.noticeprj.board.service.BoardService;
import co.micol.noticeprj.board.service.BoardVO;
import co.micol.noticeprj.board.serviceImpl.BoardServiceImpl;

public class MainMenu {
	private Scanner sc = new Scanner(System.in);
	private MemberService ms = new MemberServiceImpl(); // DB
	private BoardService bs = new BoardServiceImpl();

	private void memberTitle() {
		System.out.println("==== 회원관리 ====");
		System.out.println("= 1. 전체회원 조회 =");
		System.out.println("= 2. 한명회원 조회 =");
		System.out.println("= 3. 회원정보 등록 =");
		System.out.println("= 4. 회원정보 수정 =");
		System.out.println("= 5. 회원정보 삭제 =");
		System.out.println("= 6. 회원관리 종료 =");
		System.out.println("================");
		System.out.println("원하는 작업번호를 입력");
	}

	private void memberManage() {
		boolean b = false;
		do {
			memberTitle();
			sc.nextLine();
			int menu = sc.nextInt();
			switch (menu) {
			case 1:
				memberSelectList();
				break;
			case 2:
				memberSelect();
				break;
			case 3:
				memberInsert();
				break;
			case 4:
//				memberUpdate();
				break;
			case 5:

				break;
			case 6:
				b = true;
				System.out.println("회원관리 종료");
				break;
			}
		} while (!b);

	}

	private void boardTitle() {
		System.out.println("==== 공지관리 ====");
		System.out.println("= 1. 공지사항 조회 =");
		System.out.println("= 2. 공지사항 세부 =");
		System.out.println("= 3. 공지사항 등록 =");
		System.out.println("= 4. 공지사항 수정 =");
		System.out.println("= 5. 공지사항 삭제 =");
		System.out.println("= 6. 공지사항 종료 =");
		System.out.println("================");
		System.out.println("원하는 작업번호를 입력하세요");
	}

	private void boardManage() {
		boolean b = true;
		do {
			boardTitle();
			sc.nextLine();
			int menu = sc.nextInt();
			switch (menu) {
			case 1:
				boardSelectList();
				break;
			case 2:
				boardSelect();
				break;
			case 3:
				boardInsert();
				break;
			case 4:
//				boardUpdate();
				break;
			case 5:
				boardDelete();
				break;
			case 6:
				b = true;
				break;
			}
		} while (!b);
	}

	private void mainTitle() {
		System.out.println("==== 학사관리 ====");
		System.out.println("= 1. 회원 관리    =");
		System.out.println("= 2. 공지사항 관리 =");
		System.out.println("= 3. 학사관리 종료 =");
		System.out.println("================");
		System.out.println("원하는 작업번호를 입력하세요");
	}

	// 여기서 CRUD 메소드를 private으로 하나씩 만들어 간다.
	private void memberSelect() {
		MemberVO member = new MemberVO();
		System.out.println("===조회할 회원의 아이디를 입력하세요?.===");
		sc.nextLine();
		String id = sc.nextLine();
		member.setMemberId(id);
		member = ms.memberSelect(member);
		if (member.getMemberName() != null) {
			member.toString();
		} else {
			System.out.println("존재하지 않는 회원입니다. ㅠㅠ");
		}
	}

	private void memberSelectList() {
		List<MemberVO> members = ms.memberSelectList();
		if (!members.isEmpty()) {
			for (MemberVO member : members) {
				member.toString();
			}
		} else {
			System.out.println("회원이 한명도 존재하지 않습니다.");
		}
	}

	// 멤버 등록
	private void memberInsert() {

	}

	public void run() {
		boolean b = false; // 관례적으로 boolean 변수를 선언할 때 false로 선언.
		do {
			mainTitle();
			int key = sc.nextInt();
			switch (key) {
			case 1:
				memberManage();
				break;
			case 2:
				boardManage();
				break;

			case 3:
				System.out.println("학사관리를 종료합니다!!!");
				b = true;
				break;
			}
		} while (!b);

		sc.close();
	}

	private void boardSelectList() {
		List<BoardVO> boards = new ArrayList<BoardVO>();
		boards = bs.boardSelectList();

		for (BoardVO board : boards) {
			board.toString();
		}

	}

	private void boardSelect() {
		BoardVO board = new BoardVO();
		System.out.println("===검색할 게시판의 번호를 입력하세요?.===");
//		sc.nextLine();
		int num = sc.nextInt();
		board.setBoardId(num);
		board = bs.boardSelect(board);
		board.toString();
	}

	private void boardInsert() {

		System.out.println("== 등록할 글의 번호를 입력 ==");
		int id = sc.nextInt();
		System.out.println("== 등록할 글의 작성자를 입력 ==");
		sc.nextLine();
		String writer = sc.nextLine();
		System.out.println("== 등록할 글의 제목을 입력 ==");
		String title = sc.nextLine();
		System.out.println("== 등록할 글의 내용을 입력 ==");

		String subject = sc.nextLine();
		Date today = new Date();
		java.sql.Date sqlToday = new java.sql.Date(today.getTime());
		int hit = 0;
		BoardVO board = new BoardVO(id, writer, title, subject, sqlToday, hit);
		int boards = bs.boardInsert(board);

		if (boards != 0) {
			System.out.println("등록 완료");
		} else {
			System.out.println("등록 실패");
		}
	}

	private void boardDelete() {
		// TODO Auto-generated method stub

	}
}
