package co.yedam.calculator;

public class MainExe {
	public static void main(String[] args) {
		Person person = new Person(); // 인스턴스 생성
		int result = person.sum(1232, 2340);
		System.out.println("결과: " + result);	
		
		Calculator cal = new Calculator();
		cal.model = "SSC101";
		cal.price = 20000;
		cal.showInfo();
		Calculator.model = "SSC102";
		Calculator.price = 20000;
		Calculator.showInfo();
	}
	
}
