package dao;

public class MemberDao extends Dao{
	
	public static MemberDao instance = new MemberDao();
	public MemberDao() {super();}
	
	// 1. 회원가입 메서드
	public boolean signup() {
		return false;
	}
	
	// 2. 아이디 또는 닉네임 중복확인
	public byte idCheck(String memberid, String type) {
		String sql="";
		if(type.equals("memberid")) sql="select memberid from member where memberid = ?";
		else if(type.equals("membernickname"))sql="select membernickname from member where membernickname=?";
		else{System.out.println("MemberDao_idcheck->> type값이 잘못되었읍니다 :"+type);return -1;}
		// 리턴값->> 0 : 예외 발생, 1: 중복값 없음, 2: 중복값 있음.
		try {
			ps=con.prepareStatement(sql);
			ps.setString(1, memberid);
			rs = ps.executeQuery();
			if(rs.next()) {
				return 2;
			}else{
				return 1;
			}
		} catch (Exception e) {System.out.println("MemberDao_idcheck_exception : "+e);}	
		return 0;
	}
	
	// 3. 이메일 중복확인
	
	// 4. 연락처 중복확인
	
	// 5. reserved
	
}
