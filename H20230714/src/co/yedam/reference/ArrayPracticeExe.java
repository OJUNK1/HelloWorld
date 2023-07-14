package co.yedam.reference;

import java.util.Scanner;

public class ArrayPracticeExe { /// p.202
	public static void main(String[] args) {
		boolean run = true;
		int studentNum = 0; // 학생수
		int[] scores = null; // 학생점수를 저장하기 위한 배열
		Scanner scn = new Scanner(System.in);
		while (run) {
			System.out.println("--------------------");
			System.out.println("1. 학생수 | 2. 점수입력 | 3. 점수리스트 | 4. 분석 | 5. 종료");
			System.out.println("--------------------");
			System.out.print("선택>> ");
			int selectNo = Integer.parseInt(scn.nextLine());

			if (selectNo == 1) {
				System.out.println("학생수> ");
				studentNum = Integer.parseInt(scn.nextLine());
				scores = new int[studentNum];
			} else if (selectNo == 2) {
				if (scores == null) {
					System.out.println("배열의 크기를 지정하시오.");
					continue;
				}
				
				for (int i = 0; i < scores.length; i++) {
					System.out.println("scores" + "[" + i + "]" + ">");
					scores[i] = Integer.parseInt(scn.nextLine());
				}
			} else if (selectNo == 3) {
				for (int i = 0; i < scores.length; i++) {
					System.out.println("scores" + "[" + i + "]" + ">" + scores[i]);
				}
			} else if (selectNo == 4) {
				int maxScore = 0;
				int sum = 0;
				for (int i = 0; i < studentNum; i++) {
					sum += scores[i];
				}
				double avg = sum / studentNum;

				for (int i = 0; i < studentNum; i++) {
					if (scores[i] > maxScore) {
						maxScore = scores[i];
					}
				}
				System.out.println("최고 점수는 " + maxScore + "점이고, 평균은 " + avg + "점이다");
			} else if (selectNo == 5) {
				System.out.println("프로그램 종료");
				scn.close();
				return;
			}
		}
		System.out.println("end of prog.");
	}

}
