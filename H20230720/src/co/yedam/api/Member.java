package co.yedam.api;

//p.466~ java package, api
public class Member {
	int memberNo;
	String memberName;

	public Member(int memberNo, String memberName) {
		this.memberNo = memberNo;
		this.memberName = memberName;
	}

	@Override
	public int hashCode() {
		// TODO Auto-generated method stub
		return this.memberName.hashCode();
	}
	@Override
	public boolean equals(Object obj) {
		// TODO Auto-generated method stub
		if (obj instanceof Member) {
			Member m2 = (Member) obj;
			return this.memberNo == m2.memberNo && this.memberName.equals(m2.memberName);
		} else {
			return false;
		}

	}

	@Override
	public String toString() {
		return "Member [memberNo=" + memberNo + ", memberName=" + memberName + "]";
	}
}
