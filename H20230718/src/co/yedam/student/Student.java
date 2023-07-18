package co.yedam.student;

public class Student {
	// 필드
	String stdNo; //
	String stdName;
	int score;
	double height;

	// 생성자. 아무것도 선언 안할 시 자바 컴파일러가 기본 생성자를 생성해 줌. but 개발자가 직접 다른 생성자 함수를 만들면, 기본 생성자가
	// 없어지므로 직접 기본 생성자를 만들어줘야 한다.
	//
	Student() {

	}

	public Student(String stdNo, String stdName, int score, double height) {
		super();
		this.stdNo = stdNo;
		this.stdName = stdName;
		this.score = score;
		this.height = height;
	}

	Student(String stdNo) {
		this.stdNo = stdNo; // 필드의 초기값 지정하는 역할
	}
	
	Student(String stdNo, int score) {
//		this.stdNo = stdNo;
		this(stdNo); // this 클래스에서 자기 자신의 필드, 생성자, 메소드.
		this.score = score;
	}
	// 메소드.
	public String showInfo() {
		return "학생번호: " + stdNo + ", 학생이름: " + stdName;
	}
}
