package co.yedam.polymorphism;

//상속 관계 : Tire < - HankookTire, KumhoTire
public class Tire {
	// 필드.
	int maxRotation; // 최대 회전수(타이어 수명)
	int accumulatedRotation; // 누적 회전수
	String location; // 타이어의 위치

	// 생성자.
	public Tire(String location, int maxRotation) {
		this.location = location;
		this.maxRotation = maxRotation;
	}

	public Tire() {

	}

	// 메소드.
	public boolean roll() {
		++accumulatedRotation; // 누적 회전수 1 증가
		if (accumulatedRotation < maxRotation) {
			System.out.println(location + "HankookTire 수명: " + (maxRotation - accumulatedRotation) + "회");
			return true;
		} else {
			System.out.println("*** " + location + "HankookTire 펑크 ***");
			return false;
		}
	}

}
