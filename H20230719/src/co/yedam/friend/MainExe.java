package co.yedam.friend;

import java.util.Scanner;

public class MainExe {

	public static void main(String[] args) {

		// 1.등록 2.목록 3.수정 4.삭제 5.단건조회 6.종료
		boolean run = true;
		Scanner scn = new Scanner(System.in);
		Friend fri = new Friend();
		int menu = 0;
		String name = "", phone = "";
		AddressApp app = new AddressApp();
		while (run) {
			System.out.println("1.등록 2.목록 3.수정 4.삭제 5.단건조회 6.종료");
			try {
				System.out.println("메뉴입력> ");
				menu = Integer.parseInt(scn.nextLine());
			} catch (NumberFormatException e) {
				System.out.println("숫자만 입력가능합니다.");
				continue;
			}

			// 1 ~ 6 메뉴 이외의 메뉴를 선택하면 ..
			try {
				if (menu < 1 || menu > 6) {
					throw new MenuException(menu); // 예외발생.
				}
			} catch (MenuException e) {
				System.out.println("1~6번까지의 메뉴만 입력");
				continue;
			}

			if (menu == INIT_MENU.ADD) {
				System.out.println("등록할 친구의 소속을 선택> 1.친구 2.회사 3.학교");
				int belong = Integer.parseInt(scn.nextLine());
				if (belong == 1) {
					System.out.println("친구 이름을 입력> ");
					name = scn.nextLine();
					System.out.println("친구 번호를 입력> ");
					phone = scn.nextLine();
					boolean result = app.addFriend(new Friend(name, phone));
					if (result = true) {
						System.out.println("친구등록이 완료됐습니다");
					} else {
						System.out.println("친구목록이 가득찼습니다");
					}
				} else if (belong == 2) {
					System.out.println("친구 이름을 입력> ");
					name = scn.nextLine();
					System.out.println("친구 번호를 입력> ");
					phone = scn.nextLine();
					System.out.println("회사명을 입력> ");
					String company = scn.nextLine();
					System.out.println("부서명을 입력> ");
					String dept = scn.nextLine();
					boolean result2 = app.addFriendC(new ComFriend(name, phone, company, dept));
					if (result2 = true) {
						System.out.println("회사 친구등록이 완료됐습니다");
					} else {
						System.out.println("회사 친구목록이 가득찼습니다");
					}
				} else if (belong == 3) {
					System.out.println("친구 이름을 입력> ");
					name = scn.nextLine();
					System.out.println("친구 번호를 입력> ");
					phone = scn.nextLine();
					System.out.println("대학명을 입력> ");
					String univ = scn.nextLine();
					System.out.println("학과을 입력> ");
					String major = scn.nextLine();
					boolean result3 = app.addFriendU(new UnivFriend(name, phone, univ, major));
					if (result3 = true) {
						System.out.println("대학 친구등록이 완료됐습니다");
					} else {
						System.out.println("대학 친구목록이 가득찼습니다");
					}
				}

			} else if (menu == INIT_MENU.LIST) {
				System.out.println("조회할 친구의 소속을 입력>> 1.친구 2.회사 3.학교");
				int belong = Integer.parseInt(scn.nextLine());
				if (belong == 1) {
					System.out.println("조회할 친구의 이름을 입력>> ");
					name = scn.nextLine();
					int result = app.findFriend(name);
					if (result == 0) {
						System.out.println("찾으시는 친구 정보입니다");
					} else {
						System.out.println("정확한 친구명을 입력하시오");
					}
				} else if (belong == 2) {
					System.out.println("조회할 친구의 이름을 입력>> ");
					name = scn.nextLine();
					int result = app.findFriendC(name);
					if (result == 0) {
						System.out.println("찾으시는 친구 정보입니다");
					} else {
						System.out.println("정확한 친구명을 입력하시오");
					}
				} else if (belong == 3) {
					System.out.println("조회할 친구의 이름을 입력>> ");
					name = scn.nextLine();
					int result = app.findFriendU(name);
					if (result == 0) {
						System.out.println("찾으시는 친구 정보입니다");
					} else {
						System.out.println("정확한 친구명을 입력하시오");
					}
				}
			} else if (menu == INIT_MENU.EDIT) { // 수정
				System.out.println("수정할 친구의 소속을 입력>> 1.친구 2.회사 3.학교");
				int belong = Integer.parseInt(scn.nextLine());
				if (belong == 1) {
					System.out.println("수정할 친구의 이름을 입력> ");
					name = scn.nextLine();
					System.out.println("수정된 번호를 입력> ");
					phone = scn.nextLine();
					boolean result = app.editFriend(name, phone);
					if (result = true) {
						System.out.println("번호가 수정되었습니다");
					} else {
						System.out.println("정확한 친구명을 입력하시오");
					}
				} else if (belong == 2) {
					System.out.println("수정할 회사친구의 이름을 입력> ");
					name = scn.nextLine();
					System.out.println("수정된 번호를 입력> ");
					phone = scn.nextLine();
					boolean result = app.editFriendC(name, phone);
					if (result = true) {
						System.out.println("번호가 수정되었습니다");
					} else {
						System.out.println("정확한 회사친구명을 입력하시오");
					}
				} else if (belong == 3) {
					System.out.println("수정할 대학친구의 이름을 입력> ");
					name = scn.nextLine();
					System.out.println("수정된 번호를 입력> ");
					phone = scn.nextLine();
					boolean result = app.editFriendU(name, phone);
					if (result = true) {
						System.out.println("번호가 수정되었습니다");
					} else {
						System.out.println("정확한 대학친구명을 입력하시오");
					}
				}
			} else if (menu == INIT_MENU.DEL) {
				System.out.println("삭제할 친구의 소속을 입력>> 1.친구 2.회사 3.학교");
				int belong = Integer.parseInt(scn.nextLine());
				if (belong == 1) {
					System.out.println("삭제할 친구명을 입력> ");
					name = scn.nextLine();
					boolean result = app.delFriend(name);
					if (result = true) {
						System.out.println("친구가 삭제됐습니다");
					} else {
						System.out.println("정확한 친구명을 입력하시오");
					}

				} else if (belong == 2) {
					System.out.println("삭제할 회사친구명을 입력> ");
					name = scn.nextLine();
					boolean result = app.delFriendC(name);
					if (result = true) {
						System.out.println("친구가 삭제됐습니다");
					} else {
						System.out.println("정확한 친구명을 입력하시오");
					}
				} else if (belong == 3) {
					System.out.println("삭제할 대학친구명을 입력> ");
					name = scn.nextLine();
					boolean result = app.delFriendU(name);
					if (result = true) {
						System.out.println("친구가 삭제됐습니다");
					} else {
						System.out.println("정확한 친구명을 입력하시오");
					}
				}
			} else if (menu == INIT_MENU.SEARCH) {
				System.out.println("조회할 소속을 입력>> 1.친구 2.회사 3.학교 ");
				int belong = Integer.parseInt(scn.nextLine());
				if (belong == 1) {
					Friend[] ary = app.friendList();
					for (int i = 0; i < ary.length; i++) {
						if (ary[i] != null) {
							System.out.printf("친구이름 %s, 친구번호 %s\n", ary[i].getName(), ary[i].getPhone());
						}

					}
				} else if (belong == 2) {
					ComFriend[] ary = app.friendListC();
					for (int i = 0; i < ary.length; i++) {
						if (ary[i] != null) {
							System.out.printf("친구이름 %s, 친구번호 %s\n", ary[i].getName(), ary[i].getPhone());
						}
					}
				} else if (belong == 3) {
					UnivFriend[] ary = app.friendListU();
					for (int i = 0; i < ary.length; i++) {
						if (ary[i] != null) {
							System.out.printf("친구이름 %s, 친구번호 %s\n", ary[i].getName(), ary[i].getPhone());
						}

					}
				}

			} else if (menu == INIT_MENU.EXIT) {
				System.out.println("종료 버튼입니다");
				run = false;
			}
		}
		System.out.println("end of prog");
	}
}
//	
//	// 백업
//	// Friend < 상속 ComFriend, UnivFriend
//	Friend[] friends = new Friend[10];
//
//	// friends 배열에 Friend 클래스의 인스턴스 대입
//	friends[0] = new Friend("홍길동", "010-1111");
//	friends[1] = new ComFriend("김길동", "010-2222", "네이버", "개발부서");
//	friends[2] = new UnivFriend("박길동", "010-3333", "대구대학교", "정보통신");
//
//	for (int i = 0; i < 3; i++) {
//		System.out.println(friends[i].showInfo()); // 메소드 재정의에 의한 showInfo 실행.
