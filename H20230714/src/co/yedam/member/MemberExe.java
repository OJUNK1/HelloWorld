package co.yedam.member;

public class MemberExe {
	public static void main(String[] args) {

		java.util.Scanner scn = new java.util.Scanner(System.in);
		boolean run = true;
		Member[] members = new Member[10];

		Member m1 = new Member();
		Member m2 = new Member();
		m1.setMemberNo(1001);
		m1.setMemberName("홍길동");
		m1.setPhone("010-1111");
		m1.setGender(Gender.MEN);
		m1.setAddress("대구 100");
		m2.setMemberNo(1002);
		m2.setMemberName("김길동");
		m2.setPhone("010-2222");
		m2.setGender(Gender.WOMEN);
		m2.setAddress("대구 200");
		members[0] = m1;
		members[1] = m2;

		// 기본생성자로 생성하는 법. Member에 컨트롤 클릭 해보면 됨 . 위의 방식처럼 값을 지정해 만드는 것보다 생성자 메소드로 만드는 것이 더 편함
		Member m3 = new Member();
		members[2] = m3;

		Member m4 = new Member(3001, "홍미숙", "010-1234", Gender.WOMEN, "대구 123");
		members[3] = m4;

		while (run) {
			System.out.println("1.등록 2.목록 3.수정 4.삭제 5.상세조회 6.남자회원목록 7.종료");
			System.out.print("선택>> ");
			int menu = Integer.parseInt(scn.nextLine());

			if (menu == 1) {
				System.out.println("등록 기능입니다");
				System.out.println("회원번호입력> ");
				int mNo = Integer.parseInt(scn.nextLine());
				System.out.println("회원이름입력> ");
				String mName = scn.nextLine();
				System.out.print("회원연락처입력> ");
				String phone = scn.nextLine();
				System.out.print("회원성별입력> ");

				// 남, 남자 startsWith("남")
				Gender gender = null;
				String temp = scn.nextLine();
				if (temp.startsWith("남")) {
					gender = Gender.MEN;
				} else if (temp.startsWith("여")) {
					gender = Gender.WOMEN;
				}
				System.out.print("회원주소입력> ");
				String addr = scn.nextLine();

				Member member = new Member(); // 인스턴스
				member.setMemberNo(mNo);
				member.setMemberName(mName);
				member.setPhone(phone);
				member.setGender(gender);
				member.setAddress(addr);

				// members = member 인스턴스 10개까지 저장 가능.
				for (int i = 0; i < members.length; i++) {
					if (members[i] == null) {
						members[i] = member; // 배열의 빈값에 저장
						break; // 한건 저장 후 반복문 종료.
					}
				}

			} else if (menu == 2) {
				System.out.println("목록 기능입니다");
				for (int i = 0; i < members.length; i++) {
					if (members[i] != null) {
						System.out.println(members[i].showInfo());
					}
				}

			} else if (menu == 3) {
				System.out.println("수정 기능입니다");
				System.out.println("회원번호 입력>> ");
				int no = Integer.parseInt(scn.nextLine());
				System.out.println("연락처 입력>> ");
				String phone = scn.nextLine();

				// 배열의 요소에서 조회.
				for (int i = 0; i < members.length; i++) {
					if (members[i] != null && members[i].getMemberNo() == no) {
						members[i].setPhone(phone);
					}
				}

			} else if (menu == 4) {
				System.out.println("삭제 기능입니다");
				System.out.println("삭제할 회원의 회원번호 입력>> ");
				int no = Integer.parseInt(scn.nextLine());
				// 배열의 요소에서 조회
				for (int i = 0; i < members.length; i++) {
					if (members[i] != null && members[i].getMemberNo() == no) {
						members[i] = null;
						// 변경 후 반복문 종료
						break;
					}
				}

				// 배열의 위치에 null 값을 대입.
			} else if (menu == 5) {
				System.out.println("조회 기능입니다");
				System.out.print("회원번호입력>> ");
				int no = Integer.parseInt(scn.nextLine());
				boolean isExist = false; // 조회 결과 존재 여부 체크

				for (int i = 0; i < members.length; i++) {
					// 배열의 값 null 여부 체크 반드시 하기.
					if (members[i] != null && members[i].getMemberNo() == no) {
						System.out.println(members[i].detailInfo());
						isExist = true;
					}
				}
				if (isExist == false) {
					System.out.println("찾는 회원이 없습니다.");
				}
			} else if (menu == 6) {
				for (int i = 0; i < members.length; i++) {
					if (members[i] != null && members[i].getGender() == Gender.MEN) {
						System.out.println(members[i].showInfo());
					}
				}

			} else if (menu == 7) {
				System.out.println("종료 기능입니다");
				run = false;
			}

		}
		System.out.println("end of prog");
	}
}
