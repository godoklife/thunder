package dao;

import org.json.JSONArray;
import org.json.JSONObject;

import dto.Product;

public class ProductDao extends Dao{
	public static ProductDao instance = new ProductDao();
	public ProductDao() {super();}
	
	// 1. CREATE
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
	
	// 2. R
	public Product read(long productno) {
		String sql = "select * from product where productno = ?";
		
		try {
			ps = con.prepareStatement(sql);
			ps.setLong(1, productno);
			rs = ps.executeQuery();
			if(rs.next()) {
				Product product = new Product(rs.getLong(1), rs.getByte(2), 
						rs.getString(3), rs.getLong(4), rs.getString(5), rs.getLong(6));
				return product;
			}
		} catch (Exception e) {System.out.println("ProductDao_read_Exception : "+e);}
		return null;
	}
	
	// 3. 판매중인 제품만 좌표값(경도, 위도 형식으로 썰어서) 빼오기
	public JSONObject getLatLng() {
		String sql = "select productcoordinate, boardpkno"
				+ " from product where productactive = 1";
		try {
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();
			JSONArray array = new JSONArray();
			JSONObject tmp = new JSONObject();	
			while(rs.next()) {
				JSONObject object = new JSONObject();
				object.put("lat", rs.getString(1).split(", ")[0]);
				object.put("lng", rs.getString(1).split(", ")[1]);
				object.put("boardpkno", rs.getString(2));
				array.put(object);
			}
			tmp.put("positions", array);
			return tmp;
		} catch (Exception e) {System.out.println("ProductDao_getCoordinate_Exception : "+e);}
		return null;
	}
}
