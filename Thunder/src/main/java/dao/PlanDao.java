package dao;

import dto.Plan;

public class PlanDao extends Dao {
	
	public PlanDao() {
		super(); // 슈퍼클래스 
		
	
	}
	public static PlanDao planDao = new PlanDao(); 
	public static PlanDao getPlanDao() {return planDao;}
	
	public boolean write(Plan plan ){ 
		try {
		String sql = "insert into board(ptitle,pcontent,pcategoryno,memberno,pfile,pmapname,pamount,pdate)values(?,?,?,?,?,?,?,?)";
		ps=con.prepareStatement(sql);
		ps.setString(1,plan.getPtitle());
		ps.setString(2,plan.getPcontent());
		ps.setInt(3, plan.getPcategoryno());
		ps.setInt(4,plan.getMemberno());
		ps.setString(5, plan.getPfile());
		ps.setString(6, );
		}catch (Exception e) { System.out.println( e ); }	return false; 
	}


	// 1. 플랜 작성
	
	
	// 2. 플랜 수정
	
	// 3. 플랜 삭제
	
	// 4. 플랜 보기 
	
	// 5. 플랜 전체 /검색 

}
