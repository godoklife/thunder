package dto;

public class Board {
	private long boardno;	// PK, int unsigned
	private String boardtitle;
	private String boardcontenttype;
	private String boardcontent;
	private int boardviewcount;
	private String boarddatetime;
	private int boardcategory;
	private int memberno;
	private boolean boardattachment;	// FK
		// true이면 첨부파일이 있는 게시글이므로 보드어테치먼트 테이블에서 boardno로 검색할것
	
	@Override
	public String toString() {return super.toString();}
	
	public Board() {}
	
	public Board(long boardno, String boardtitle, String boardcontenttype, String boardcontent, int boardviewcount,
			String boarddatetime, int boardcategory, int memberno, boolean boardattachment) {
		super();
		this.boardno = boardno;
		this.boardtitle = boardtitle;
		this.boardcontenttype = boardcontenttype;
		this.boardcontent = boardcontent;
		this.boardviewcount = boardviewcount;
		this.boarddatetime = boarddatetime;
		this.boardcategory = boardcategory;
		this.memberno = memberno;
		this.boardattachment = boardattachment;
	}

	public long getBoardno() {
		return boardno;
	}

	public void setBoardno(long boardno) {
		this.boardno = boardno;
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

	public int getBoardcategory() {
		return boardcategory;
	}

	public void setBoardcategory(int boardcategory) {
		this.boardcategory = boardcategory;
	}

	public int getMemberno() {
		return memberno;
	}

	public void setMemberno(int memberno) {
		this.memberno = memberno;
	}

	public boolean isBoardattachment() {
		return boardattachment;
	}

	public void setBoardattachment(boolean boardattachment) {
		this.boardattachment = boardattachment;
	}
	
	
	
	
}
