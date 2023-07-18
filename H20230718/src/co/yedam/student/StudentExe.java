package co.yedam.student;

public class StudentExe {
	public static void main(String[] args) {
		Student s1 = new Student(); // heap 영역에 인스턴스 생성하는 것을 의미.인스턴스의 주소값을 new가 s1 변수에 반환해줌
		s1.stdName = "홍길동";

		Student s2 = new Student();  // 기본 생성자 'Student()'를 이용해서 인스턴스. 
		s2.stdName = "홍길동";
		s2.stdNo = "23-0002";
		
		
		// 전체 필드를 초기화하는 생서자를 통해 인스턴스 만듦.
		Student s3 = new Student("23-0001", "박길동", 80, 176.7); 
		System.out.println();

		System.out.println(s1);
		System.out.println(s2);
		System.out.println(s1.stdName.equals(s2.stdName)); // s1 == s2 하면 false 즉, 주소값은 항상 다름.
													 //그러나 필드값을 지정한 후 메소드를 통해 비교가능.
	}
}
