package co.yedam.student;

/*
 * 학생의 정보 등록, 등록된 학생의 목록 출력, 성적의 합계, 최고점수를 계산.
 */
public class StudentApp {
	// 필드.
	Student[] students;
	int studentNum = 0;

	// 생성자.
	StudentApp() {
		students = new Student[2];
	}

	// 메소드.
	boolean addStudent(Student std) {
		if (studentNum >= 2) { // 등록할 공간 부족 => 실패.
			return false;
		}
		students[studentNum] = std;
		studentNum++;
		return true;
	}

	Student[] studentList() {
		return students;
	}

	int sumScores() {
		int sum = 0;
		for (int i = 0; i < studentNum; i++) {
			sum += students[i].score;
		}
		return sum;
//		System.out.println("점수의 합계: " + sum);
	}

	int maxPrint() {
		int maxScore = 0;
		for (int i = 0; i < studentNum; i++) {
			if (maxScore < students[i].score) {
				maxScore = students[i].score;
			}
		}
		return maxScore;
//		System.out.println("최고점수: " + maxScore);
	}
}
