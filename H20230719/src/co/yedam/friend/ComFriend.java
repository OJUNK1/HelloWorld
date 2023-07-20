package co.yedam.friend;

public class ComFriend extends Friend {
	// 필드
	private String company;
	private String dept;

	// 생성자
	public ComFriend(String name, String phone, String company, String dept) {
		super(name, phone);
		this.company = company;
		this.dept = dept;
	}
	public ComFriend() {
		
	}
	// 메소드 getter/setter
	public String getCompany() {
		return company;
	}

	public void setCompany(String company) {
		this.company = company;
	}

	public String getDept() {
		return dept;
	}

	public void setDept(String dept) {
		this.dept = dept;
	}

	
	@Override
	public String showInfo() {
		return super.showInfo() + ", 회사명: " + company + ", 부서명: " + dept;
	}
}
