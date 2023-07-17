package co.yedam.student;

public class StudentExe {
	public static void main(String[] args) {
		// 학생번호, 학생이름, 점수.
		Student std1 = new Student(); // 인스턴스.
		std1.setStudentNo(100);
		std1.setStudentName("홍길동"); // 값 지정
		std1.setScore(80);

//		System.out.println(std1.studentNo);

		Student std2 = new Student();
		std2.setStudentNo(110);
		std2.setStudentName("김길동");
		std2.setScore(85);

		Student[] students = { std1, std2 };
		students = new Student[5];
		students[0] = std1;
		students[1] = std2;

		// 120 박길동 90 => std3

		Student std3 = new Student();
		std3.setStudentNo(120);
		std3.setStudentName("박길동");
		std3.setScore(90);

		students[2] = std3;

		String searchName = "홍길동";

		for (int i = 0; i < students.length; i++) {
			if (students[i] != null) {
				// 4, 5번째는 null
				if (students[i].getStudentName().equals(searchName)) {
					System.out.printf("학생번호: %d, 이름: %s, 점수: %d", students[i].getStudentNo(),
							students[i].getStudentName(), students[i].getScore());
				}
			}
		} // 최고 점수를 받은 학생 출력 . maxScore
		int maxScore = 0;
		// max값을 학생의 정보 담기 위한 Student.
		Student maxStd = new Student();

		for (int i = 0; i < students.length; i++) {
			if (students[i] != null) {
				if (maxScore < students[i].getScore()) {
					maxScore = students[i].getScore();
					maxStd = students[i];
				}
			}
		}
		System.out.printf("학생번호: %d, 이름: %s, 점수: %d", maxStd.getStudentNo(), maxStd.getStudentName(),
				maxStd.getScore());

		// 평균점수
		int sum = 0;
		double avg = 0;
		int count = 0;
		for (int i = 0; i < students.length; i++) {
			if (students[i] != null) {
				sum += students[i].getScore();
				count++;
			}
			avg = (double) sum / count;
		}
		System.out.printf("\n합계점수: %d, 평균: %.1f", sum, avg);

	} // end of main
}
