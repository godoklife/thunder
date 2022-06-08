package dao;

import org.json.JSONArray;
import org.json.JSONObject;

import dto.Board;

public class BoardDao extends Dao{
	
	public static BoardDao instance = new BoardDao();
	public BoardDao() {super();}
	
	// 1. 글 쓰기 메서드
	public byte saveSummernote(Board board) {
		String sql = "insert into board(boardtitle, boardcontenttype, boardcontent, "
				+ "boardcategory, memberno, boardattachment) values(?, ?, ?, ?, ?, ?)"; 
		try {
			ps = con.prepareStatement(sql);
			ps.setString(1, board.getBoardtitle());
			ps.setString(2, board.getBoardcontenttype());
			ps.setString(3, board.getBoardcontent());
			ps.setInt(4, board.getBoardcategory());
			ps.setInt(5, board.getMemberno());
			ps.setBoolean(6, board.isBoardattachment());
			ps.executeUpdate();
			return 1;
		} catch (Exception e) {System.out.println("BoardDao_saveSummernote_Exception : "+e);}
		return 0;
	}
	// 2. 모든 글 불러오기
	public JSONArray getsearchlist (int boardcategory) {
		String sql="select * from board where boardcategory=?";
		try {
			ps = con.prepareStatement(sql);
			ps.setInt(1, boardcategory);
			rs = ps.executeQuery();
			JSONArray array = new JSONArray();
			while(rs.next()) {
				JSONObject object = new JSONObject();
				object.put("boardno", rs.getInt(1));
				object.put("boardtitle", rs.getString(2));
				object.put("boardcontenttype", rs.getString(3));
				object.put("boardcontent", rs.getString(4));
				object.put("boardviewcount", rs.getInt(5));
				object.put("boarddatetime", rs.getString(6));
				object.put("boardcategory", rs.getInt(7));
				object.put("memberno", rs.getInt(8));
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
				object.put("boardno", rs.getInt(1));
				object.put("boardtitle", rs.getString(2));
				object.put("boardcontenttype", rs.getString(3));
				object.put("boardcontent", rs.getString(4));
				object.put("boardviewcount", rs.getInt(5));
				object.put("boarddatetime", rs.getString(6));
				object.put("boardcategory", rs.getInt(7));
				object.put("memberno", rs.getInt(8));
				array.put(object);
			}
			return array;
		} catch (Exception e) {System.out.println("BoardDao_getsearch()_exception : "+e);}
		return null;	
	}
	
	// 4. 하나의 글 보기
	public JSONObject getBoard(int boardno) {
		String sql="select * from board where boardno=?";
		
		try {
			ps = con.prepareStatement(sql);
			ps.setInt(1, boardno);
			rs = ps.executeQuery();
			if(rs.next()) {
				JSONObject object = new JSONObject();
				object.put("boardno", rs.getInt(1));
				object.put("boardtitle", rs.getString(2));
				object.put("boardcontenttype", rs.getString(3));
				object.put("boardcontent", rs.getString(4));
				object.put("boardviewcount", rs.getInt(5));
				object.put("boarddatetime", rs.getString(6));
				object.put("boardcategory", rs.getInt(7));
				object.put("memberno", rs.getInt(8));
				return object;
			}
		} catch (Exception e) {System.out.println("BoardDao_getsearch()_exception : "+e);}
		return null;
	}
}
