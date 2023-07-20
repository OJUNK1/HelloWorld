package co.yedam.inherit;

//상속 
public class DmbCellPhone extends CellPhone {
	// 추가속성, 메소드.
	private int channel;

	// 기본생성자 자동생성.
	public DmbCellPhone() {
		super();
	}

	public void setChannel(int channel) {
		this.channel = channel;
	}

	public DmbCellPhone(String model, String color, int channel) {
		super(model, color);
		this.channel = channel;
	}

	//
	public int getChannel() {
		return channel;
	}

	public void turnOn() {
		System.out.println("화면 ON");
	}

	public void turnOff() {
		System.out.println("화면 OFF");
	}

	public void changeChannel(int channel) {
		this.channel = channel;
	}

	// overriding 부모클래스의 메소드를 자식클래스가 재정의 하는것.
	@Override
	public void powerOn() {
		System.out.println("DMB 폰의 전원을 켭니다.");
		// TODO Auto-generated method stub
	}

	@Override
	public void powerOff() {
		System.out.println("DMB 폰의 전원을 끕니다.");
		// TODO Auto-generated method stub
	}

	@Override
	public String showInfo() {
		return "모델: " + this.getModel() + ", 색상: " + getColor() + ", 채널: " + channel;
		// TODO Auto-generated method stub
	}
}
