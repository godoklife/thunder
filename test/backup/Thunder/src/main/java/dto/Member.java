package dto;

public class Member {
	private int memberno;	// [FK] DB는 unsignedINT이나, 현실적으로 42억명이나 될 일이 없으므로 그냥 int형 선언
	private String memberphone;	// varchar(15)
	
	public String toString() {
		return "Member [memberno=" + memberno + ", memberphone=" + memberphone + "]";
	}

	public Member() {}
	
	public Member(int memberno, String memberphone) {
		super();
		this.memberno = memberno;
		this.memberphone = memberphone;
	}

	public int getMemberno() {
		return memberno;
	}

	public void setMemberno(int memberno) {
		this.memberno = memberno;
	}

	public String getMemberphone() {
		return memberphone;
	}

	public void setMemberphone(String memberphone) {
		this.memberphone = memberphone;
	}
	
}
