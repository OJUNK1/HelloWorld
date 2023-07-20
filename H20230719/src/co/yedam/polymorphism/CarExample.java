package co.yedam.polymorphism;

public class CarExample {
	public static void main(String[] args) {
		Car car = new Car();

		for (int i = 1; i < 10; i++) {
			int problemLocation = car.run(); // Car 객체의 run() 메소드 10번 반복 실행

			switch (problemLocation) {
			case 1:
				System.out.println("앞왼쪽 타이어 펑크. 타이어를 교체");
				car.frontLeftTire = new HankookTire("앞왼쪽", 10);
				break;
			case 2:
				System.out.println();
				car.frontRightTire = new Tire("앞오른쪽", 4);
				break;
			case 3:
				System.out.println();
				car.backLeftTire = new HankookTire("뒤왼쪽", 5);
				break;
			case 4:
				System.out.println();
				car.backRightTire = new Tire("뒤오른쪽", 15);
				break;
			}
			System.out.println("-----------------------");			
		}
		System.out.println("end of run.");
	}
}
