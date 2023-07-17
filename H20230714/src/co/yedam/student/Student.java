package co.yedam.student;

// 복합적인 구조의 데이터를 처리하고 싶을 때 class 선언
public class Student {
	// 필드.
	private int studentNo;
	private String studentName;
	private int score;

	// 메소드(함수의 기능)
	// naming rule : 두 단어의 조합이면 두번째 단어의 첫번째 글자는 대문자 표기
	public void setStudentNo(int studentNo) {
		this.studentNo = studentNo;
	}

	public int getStudentNo() {
		return studentNo;
	}

	public void setStudentName(String sn) {
		studentName = sn; // this.studentName = studentName; 과 같은의미
	}

	public String getStudentName() {
		return studentName;
	}

	public void setScore(int score) {
		if (score < 0)
			this.score = 0;
		else
			this.score = score;
	}

	public int getScore() {
		return score;
	}
}
