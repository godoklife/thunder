package dao;

import java.sql.Statement;

import org.json.JSONArray;
import org.json.JSONObject;

import dto.Board;

public class BoardDao extends Dao{
	
	public static BoardDao instance = new BoardDao();
	public BoardDao() {super();}
	
	
	
	// 1. 글 쓰기 메서드
	public int saveSummernote(Board board) {
		String sql = "select max(boardcategoryno) from board where boardcategory = ?";
		long boardcategoryno;
		try {
			ps=con.prepareStatement(sql);
			ps.setByte(1, board.getBoardcategory());
			rs = ps.executeQuery();
			if(rs.next()) {
				boardcategoryno=rs.getLong(1)+1;
			}else boardcategoryno=-1;
		} catch (Exception e) {System.out.println("BoardDao_saveSummernote(1)_Exception : "+e);return -1;}
		
		
		sql = "insert into board(boardcategory, boardcategoryno, boardtitle, "
				+ "boardcontenttype, boardcontent, memberno ) values(?, ?, ?, ?, ?, ?)"; 
		try {
			ps = con.prepareStatement(sql,Statement.RETURN_GENERATED_KEYS);
			ps.setByte(1, board.getBoardcategory());
			
			if(boardcategoryno==-1) ps.setLong(2, 1);	// 해당 게시판에 아무도 글 쓴 사람이 없으면 게시물번호 1
			else ps.setLong(2, boardcategoryno);		// 해당 게시판 가장 마지막 게시글번호 +1
			
			ps.setString(3, board.getBoardtitle());
			ps.setString(4, board.getBoardcontenttype());
			ps.setString(5, board.getBoardcontent());
			ps.setLong(6, board.getMemberno());
			ps.executeUpdate();
			rs = ps.getGeneratedKeys();	// pk값 반환
			while(rs.next()) {
				return rs.getInt(1);
			}
		} catch (Exception e) {System.out.println("BoardDao_saveSummernote(2)_Exception : "+e);}
		return -1;
	}
	
	// 2. 모든 글 불러오기
	public JSONArray getsearchlist (byte boardcategory) {
		
		String sql="select * from board where boardcategory=?";
		try {
			ps = con.prepareStatement(sql);
			ps.setInt(1, boardcategory);
			rs = ps.executeQuery();
			JSONArray array = new JSONArray();
			while(rs.next()) {
				JSONObject object = new JSONObject();
				object.put("boardpkno", rs.getLong(1));
				object.put("boardcategory", rs.getByte(2));
				object.put("boardcategoryno", rs.getLong(3));
				object.put("boardtitle", rs.getString(4));
				object.put("boardcontenttype", rs.getString(5));
				object.put("boardcontent", rs.getString(6));
				object.put("boardviewcount", rs.getInt(7));
				object.put("boarddatetime", rs.getString(8));
				object.put("memberno", rs.getLong(9));
				array.put(object);
			}
			return array;
		} catch (Exception e) {System.out.println("BoardDao_getsearch()_exception : "+e);}
		return null;	
	}
	
	// 3. 글 검색해서 불러오기
	public JSONArray getsearchlist(int memberno, int boardcategory) {
		String sql="select * from board where memberno=? and boardcategory=?";
		try {
			ps = con.prepareStatement(sql);
			ps.setInt(1, memberno);
			ps.setInt(2, boardcategory);
			rs = ps.executeQuery();
			JSONArray array = new JSONArray();
			while(rs.next()) {
				JSONObject object = new JSONObject();
				/////////////////////
				// 미구현
				////////////////////
				array.put(object);
			}
			return array;
		} catch (Exception e) {System.out.println("BoardDao_getsearch()_exception : "+e);}
		return null;	
	}
	
	// 4. 하나의 글 보기
	public JSONObject getBoard(long boardpkno) {
		String sql="select * from board, product where product.boardpkno=? "
				+ "and board.boardpkno = product.boardpkno";
		
		try {
			ps = con.prepareStatement(sql);
			ps.setLong(1, boardpkno);
			rs = ps.executeQuery();
			if(rs.next()) {	// 만약 조회가 성공한다면 해당 글은 중고거래글
				JSONObject object = new JSONObject();
				object.put("boardpkno", rs.getLong(1));
				object.put("boardcategory", rs.getByte(2));
				object.put("boardcategoryno", rs.getLong(3));
				object.put("boardtitle", rs.getString(4));
				object.put("boardcontenttype", rs.getString(5));
				object.put("boardcontent", rs.getString(6));
				object.put("boardviewcount", rs.getInt(7));
				object.put("boarddatetime", rs.getString(8));
				object.put("memberno", rs.getLong(9));
				object.put("productno", rs.getLong(10));
				object.put("productactive", rs.getByte(11));
				object.put("productqulity", rs.getString(12));
				object.put("productprice", rs.getLong(13));
				object.put("productcoordinate", rs.getString(14));
				return object;
			}else {
				sql = "select * from board = ?";
				ps = con.prepareStatement(sql);
				ps.setLong(1, boardpkno);
				rs = ps.executeQuery();
				if(rs.next()) {	// 여기서 쿼리가 성공하면 
					JSONObject object = new JSONObject();
					object.put("boardpkno", rs.getLong(1));
					object.put("boardcategory", rs.getByte(2));
					object.put("boardcategoryno", rs.getLong(3));
					object.put("boardtitle", rs.getString(4));
					object.put("boardcontenttype", rs.getString(5));
					object.put("boardcontent", rs.getString(6));
					object.put("boardviewcount", rs.getInt(7));
					object.put("boarddatetime", rs.getString(8));
					object.put("memberno", rs.getLong(9));
					return object;
				}
				return null;
			}
		} catch (Exception e) {System.out.println("BoardDao_getsearch()_exception : "+e);}
		return null;
	}
	
	// 5. 조회수 증가 처리
	public void viewCnt(long boardpkno) {
		String sql = "update board set boardviewcount = boardviewcount + 1 where boardpkno = ?";
		try {
			ps = con.prepareStatement(sql);
			ps.setLong(1, boardpkno);
			ps.executeUpdate();
		} catch (Exception e) {System.out.println("BoardDao_viewCnt_Exception : "+e);}
	}
	
	// 6. 게시글 삭제
	public boolean delete(long boardpkno) {
		String sql = "delete from board where boardpkno=?";
		try {
			ps = con.prepareStatement(sql);
			ps.setLong(1, boardpkno);
			ps.executeUpdate();
			return true;
		} catch (Exception e) {System.out.println("BoardDao_delete_exception : "+e);} 
		return false;
	}
}
