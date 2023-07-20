package co.yedam.inherit;

public /*final*/class CellPhone {
	// 필드(속성)
	private String model;
	private String color;

	// 기본생성자를 컴파일러가 생성. but 개발자가 직접 생성자를 정의하면 기본생성자를 컴파일러가 안 만들어줌.
	public CellPhone(String model, String color) {
		this.model = model;
		this.color = color;
	}

	public CellPhone() {

	}

	// 메소드(기능)
	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public void powerOn() {
		System.out.println("전원 ON");
	}

	public void powerOff() {
		System.out.println("전원 OFF");
	}

	public void sendMessage() {
		System.out.println("메세지 전송");
	}

	public void receiveMessage() {
		System.out.println("메세지 수신");
	}

	public String showInfo() {
		return "모델명: " + model + ", 색상: " + color;
	}
}
