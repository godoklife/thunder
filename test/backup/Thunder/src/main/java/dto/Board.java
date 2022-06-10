package dto;

public class Board {
	private long boardpkno;	// pk
	private byte boardcategory;	// 게시판 카테고리
	private long boardcategoryno;	// 실제로 사용자에게 출력하는 게시글 번호
	private String boardtitle;
	private String boardcontenttype;
	private String boardcontent;
	private int boardviewcount;
	private String boarddatetime;
	private long memberno;
	
	@Override
	public String toString() {
		return super.toString();
	}

	public Board() {}

	public Board(long boardpkno, byte boardcategory, long boardcategoryno, String boardtitle, String boardcontenttype,
			String boardcontent, int boardviewcount, String boarddatetime, long memberno) {
		super();
		this.boardpkno = boardpkno;
		this.boardcategory = boardcategory;
		this.boardcategoryno = boardcategoryno;
		this.boardtitle = boardtitle;
		this.boardcontenttype = boardcontenttype;
		this.boardcontent = boardcontent;
		this.boardviewcount = boardviewcount;
		this.boarddatetime = boarddatetime;
		this.memberno = memberno;
	}

	public long getBoardpkno() {
		return boardpkno;
	}

	public void setBoardpkno(long boardpkno) {
		this.boardpkno = boardpkno;
	}

	public byte getBoardcategory() {
		return boardcategory;
	}

	public void setBoardcategory(byte boardcategory) {
		this.boardcategory = boardcategory;
	}

	public long getBoardcategoryno() {
		return boardcategoryno;
	}

	public void setBoardcategoryno(long boardcategoryno) {
		this.boardcategoryno = boardcategoryno;
	}

	public String getBoardtitle() {
		return boardtitle;
	}

	public void setBoardtitle(String boardtitle) {
		this.boardtitle = boardtitle;
	}

	public String getBoardcontenttype() {
		return boardcontenttype;
	}

	public void setBoardcontenttype(String boardcontenttype) {
		this.boardcontenttype = boardcontenttype;
	}

	public String getBoardcontent() {
		return boardcontent;
	}

	public void setBoardcontent(String boardcontent) {
		this.boardcontent = boardcontent;
	}

	public int getBoardviewcount() {
		return boardviewcount;
	}

	public void setBoardviewcount(int boardviewcount) {
		this.boardviewcount = boardviewcount;
	}

	public String getBoarddatetime() {
		return boarddatetime;
	}

	public void setBoarddatetime(String boarddatetime) {
		this.boarddatetime = boarddatetime;
	}

	public long getMemberno() {
		return memberno;
	}

	public void setMemberno(long memberno) {
		this.memberno = memberno;
	}
	
	
	
	
}
