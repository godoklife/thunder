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
	
	// 2. 판매중인 제품만 좌표값(경도, 위도 형식으로 썰어서) 빼오기
	public JSONObject getLatLng() {
		String sql = "select productcoordinate, productno"
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
				object.put("pno", rs.getString(2));
				array.put(object);
			}
			tmp.put("positions", array);
			return tmp;
		} catch (Exception e) {System.out.println("ProductDao_getCoordinate_Exception : "+e);}
		return null;
	}
}
