package co.yedam.io;

import java.io.FileNotFoundException;
import java.util.List;
import java.util.Scanner;

public class MemberManageExe {
	// 이름, 주소, 연락처 => 시작(초기값), 추가, 수정, 삭제, 목록, 종료(저장)
	public static void main(String[] args) throws FileNotFoundException {
		MemberManage manager = new MemberManage();
		Scanner scn = new Scanner(System.in);
		boolean run = true;

		while (run) {
			System.out.println("1.추가 2.수정 3.삭제 4.목록 5.종료");
			System.out.println("선택>> ");
			int menu = Integer.parseInt(scn.nextLine());
			if (menu == 1) {
				System.out.println("이름 주소 연락처 입력>> ");
				String str = scn.nextLine();
				String[] data = str.split(" ");

				if (data.length == 3) {
					Member member = new Member(data[0], data[1], data[2]);
					if (manager.addMember(member)) {
						System.out.println("등록성공");						
					} else {
						System.out.println("등록실패");
					}
				} else {
					System.out.println("잘못된 형식입니다. 이름 주소 연락처를 형식에 맞게 정확히 입력해주세요.");
					continue;
				}
			}

			else if (menu == 2) {
				System.out.println("이름 연락처 입력>> ");
				String str = scn.nextLine();
				String[] data = str.split(" ");
				Member member = new Member(data[0], "", data[1]);
				if (manager.editMember(member)) {
					System.out.println("변경성공");
				} else {
					System.out.println("변경실패");
				}

			} else if (menu == 3) {
				System.out.println("이름");
				String str = scn.nextLine();
				if (manager.delMember(str)) {
					System.out.println("삭제성공");
				} else {
					System.out.println("삭제실패");
				}

			} else if (menu == 4) { /// 이해하기
				List<Member> list = manager.list();
				for (Member member : list) {
					System.out.println(member.toString());
				}

			} else if (menu == 5) {
				System.out.println("종료합니다");
				manager.save1();
				run = false;
			}
		}

		System.out.println("end of prog.");
		scn.close();
	}

}
