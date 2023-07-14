package co.yedam.reference;

public class IntArrayExe {
	public static void main(String[] args) {
		int[] intAry = null; /// 정수형을 담을 수 있는 배열 선언
		intAry = new int[] { 10, 20, 30 }; // 새로운 값을 넣는 법 , 정수형 배열 3개 크기.
		intAry = new int[5]; // 정수형 배열 공간 5개 크기. -> 5개 모두 0으로

		intAry[0] = 15;
		intAry[intAry.length - 1] = 55;
		System.out.println(intAry[intAry.length - 1]);
		int sum = 0;
		for (int i = 0; i < intAry.length; i++) {
			System.out.println(intAry[i]);
			sum += intAry[i];
		}
		System.out.println("sum: " + sum);
		// 확장 for.
		for (int num : intAry) {
			System.out.println(num);
			sum += num;
		}
		System.out.println("sum: " + sum);

		// 정수를 저장할 수 있는 배열 scores.
		// 학생1 ~ 학생5: 80, 85, 77, 93, 100
		// 학생점수의 합과 평균.
		int[] scores = { 80, 85, 77, 93, 100 };
		int sumsum = 0;

		for (int i = 0; i < scores.length; i++) {
			sumsum += scores[i];
		}
		double avg = sumsum / scores.length;
		System.out.println("학생 점수의 합은 " + sumsum + "점이고\n평균은 " + avg + "점이다");
	}
}
