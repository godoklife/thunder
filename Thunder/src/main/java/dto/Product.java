package dto;

public class Product {
	private long productno;
	private byte productactive;
	private String productqulity;
	private long productprice;
	private String productcoordinate;
	private long boardpkno;
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return super.toString();
	}
	
	public Product() {
		// TODO Auto-generated constructor stub
	}

	public Product(long productno, byte productactive, String productqulity, long productprice,
			String productcoordinate, long boardpkno) {
		super();
		this.productno = productno;
		this.productactive = productactive;
		this.productqulity = productqulity;
		this.productprice = productprice;
		this.productcoordinate = productcoordinate;
		this.boardpkno = boardpkno;
	}

	public long getProductno() {
		return productno;
	}

	public void setProductno(long productno) {
		this.productno = productno;
	}

	public byte getProductactive() {
		return productactive;
	}

	public void setProductactive(byte productactive) {
		this.productactive = productactive;
	}

	public String getProductqulity() {
		return productqulity;
	}

	public void setProductqulity(String productqulity) {
		this.productqulity = productqulity;
	}

	public long getProductprice() {
		return productprice;
	}

	public void setProductprice(long productprice) {
		this.productprice = productprice;
	}

	public String getProductcoordinate() {
		return productcoordinate;
	}

	public void setProductcoordinate(String productcoordinate) {
		this.productcoordinate = productcoordinate;
	}

	public long getBoardpkno() {
		return boardpkno;
	}

	public void setBoardpkno(long boardpkno) {
		this.boardpkno = boardpkno;
	}
	
	
}
