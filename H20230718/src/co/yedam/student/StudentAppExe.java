package co.yedam.student;

import java.util.Scanner;

public class StudentAppExe {
	public static void main(String[] args) {

		// 메뉴 : 1. 등록, 2. 목록, 3. 합계, 4. 최고점, 5. 종료.

		// 기능 구현
		boolean run = true;
		Scanner scn = new Scanner(System.in);

		StudentApp app = new StudentApp();
		app.addStudent(new Student("001", "홍길동", 80, 177.7));
		app.addStudent(new Student("002", "김길동", 85, 178.9));

		while (run) {
			System.out.println("1.등록, 2.목록, 3.합계, 4.최고점, 5.종료");
			System.out.println("메뉴를 선택>> ");
			int menu = Integer.parseInt(scn.nextLine());
			if (menu == 1) {
				System.out.println("학생을 등록합니다 >");
				System.out.println("학생번호를 입력> ");
				String stdNum = scn.nextLine();
				System.out.println("학생이름을 입력> ");
				String stdName = scn.nextLine();
				System.out.println("학생점수를 입력> ");
				int score = Integer.parseInt(scn.nextLine());
				System.out.println("학생 키를 입력> ");
				double height = Double.parseDouble(scn.nextLine());

				Student student = new Student(stdNum, stdName, score, height);
				if (app.addStudent(student)) {
					System.out.println("정상적으로 등록이 되었습니다.");
				} else {
					System.out.println("등록 실패!!!");
				}
			} else if (menu == 2) {
				Student[] ary = app.studentList();
				for (int i = 0; i < ary.length; i++) {
					if (ary[i] != null) {
						System.out.printf("학생번호 %s, 이름 %s, 점수 %d \n", ary[i].stdNo, ary[i].stdName, ary[i].score);
					}
				}

			} else if (menu == 3) {
				int result = app.sumScores();
				System.out.println("합계 점수는: " + result);
			} else if (menu == 4) {
				int result = app.maxPrint();
				System.out.println("최고 점수는: " + result);
			} else if (menu == 5) {
				System.out.println("종료합니다");
				run = false;
			}
		}
		System.out.println("End of prog.");

	}
}
