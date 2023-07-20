package co.yedam.friend;

public class UnivFriend extends Friend {
	private String univ;
	private String major;

	// 생성자
	public UnivFriend(String name, String phone, String univ, String major) {
		super(name, phone);
		this.univ = univ;
		this.major = major;
	}
	public UnivFriend() {
		
	}

	// 메소드

	public String getUniv() {
		return univ;
	}

	public void setUniv(String univ) {
		this.univ = univ;
	}

	public String getMajor() {
		return major;
	}

	public void setMajor(String major) {
		this.major = major;
	}

	@Override
	public String showInfo() {
		return super.showInfo() + ", 대학명: " + univ + ", 전공명: " + major;
	}

}
                                                                                                                                                                                 