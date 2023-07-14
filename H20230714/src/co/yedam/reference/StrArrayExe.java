package co.yedam.reference;

import java.util.Scanner;

public class StrArrayExe {
	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		String[] strAry = new String[3]; // 크기가 3인 배열. null 값을 가짐.
		int[] scores = new int[3];

		for (String str : strAry) {
			System.out.println(str);
		}
		for (int i = 0; i < strAry.length; i++) {
			System.out.print("이름>> ");
			strAry[i] = scn.nextLine();
			System.out.println("점수>> ");
			scores[i] = Integer.parseInt(scn.nextLine());
		}

//		System.out.println("검색하고 싶은 학생의 이름을 입력>>>");
//		String searchName = scn.nextLine();
		// 최고 점수를 구하고, 학생의 이름 출력하기
		int maxScore = 0;
		String maxName ="";
		for(int i = 0; i < strAry.length; i++) {
			if(scores[i] > maxScore) {
				maxScore = scores[i];
				maxName = strAry[i];
			}
		} System.out.printf("이름은 %s, 점수는 %d \n", maxName, maxScore);
			
		// 전체목록을 출력. strAry에 값중에서 searchName 같은 값을 출력.
//		for (int i = 0; i < strAry.length; i++) {
//			if (strAry[i].equals(searchName)) {
//				System.out.printf("이름은 %s, 점수는 %d \n", strAry[i], scores[i]);
//			}
//		}
	} 
}
