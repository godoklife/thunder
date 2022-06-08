package dao;

import dto.Product;

public class ProductDao extends Dao{
	public static ProductDao instance = new ProductDao();
	public ProductDao() {super();}
	
	// 1. C
	public boolean create(Product product) {
		String sql = "insert into product(productactive, productqulity, productprice, "
				+ "productcoordinate, boardpkno) values(?, ?, ?, ?, ?)";
		try {
			ps = con.prepareStatement(sql);
			ps.setByte(1, product.getProductactive());
			ps.setString(2, product.getProductqulity());
			ps.setLong(3, product.getProductprice());
			ps.setString(4, product.getProductcoordinate());
			ps.setLong(5, product.getBoardpkno());
			ps.executeUpdate();
			return true;
		} catch (Exception e) {System.out.println("ProductDao_create_exception : "+e);}
		return false;
	}
}
