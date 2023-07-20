package co.yedam.inherit;

public class PhoneExe {
	public static void main(String[] args) {
		CellPhone cellPhone = new CellPhone();
		cellPhone.setModel("Galaxy S10");
		cellPhone.setColor("White");
		cellPhone.powerOn();
		cellPhone.powerOff();
		cellPhone.sendMessage();
		System.out.println(cellPhone.showInfo());
		System.out.println("--------------------");
		// 자식 클래스는 상속을 통해 부모의 메소드, 필드, 생성자를 사용 가능
		DmbCellPhone dmbPhone = new DmbCellPhone();
		dmbPhone.setModel("Galaxy Dmb 1");
		dmbPhone.setColor("Yello");
		dmbPhone.powerOn();
		dmbPhone.sendMessage();
		dmbPhone.turnOn();
		dmbPhone.changeChannel(10);
		dmbPhone.turnOff();
		dmbPhone.powerOff();
		System.out.println(dmbPhone.showInfo());

		// 부모클래스의 변수에 자식 클래스의 변수 대입.
		CellPhone parent = new DmbCellPhone("DMB S22", "White", 10); // promotion
		// parent.turnOn(); // Error. 자식 클래스의 필드, 메소드는 사용이 불가
		System.out.println(parent.showInfo());
		DmbCellPhone child = null;
		; 				// casting
//		child.turnOn();
		if (parent instanceof DmbCellPhone) {
			child = (DmbCellPhone) parent;
			child.turnOn();
		}

		// 부모 클래스의 변수를 자식 변수로 casting 할 경우, 체크를 해야 함.
		if (cellPhone instanceof DmbCellPhone) {
			child = (DmbCellPhone) cellPhone;
			child.turnOn();
		}
	}
}
