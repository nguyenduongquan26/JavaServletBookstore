package model;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

public class ProductRepository extends Repository{
	public int add(Product obj) {
		String sql = "INSERT INTO Product (CategoryId, AuthorId, PublisherId, ISBN, Title, Pages, Year, Weight, Size, Description, Content, ImageUrl, Price) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?)";
		try {
			Open();
			rp = connection.prepareStatement(sql);
			rp.setInt(1, obj.getCategoryId());
			rp.setInt(2, obj.getAuthorId());
			rp.setInt(3, obj.getPublisherId());
			rp.setString(4, obj.getIsbn());
			rp.setString(5, obj.getTitle());
			rp.setShort(6, obj.getPages());
			rp.setShort(7, obj.getYear());
			rp.setString(8, obj.getWeight());
			rp.setString(9, obj.getSize());
			rp.setString(10, obj.getDescription());
			rp.setString(11, obj.getContent());
			rp.setString(12, obj.getImageURL());
			rp.setInt(13, obj.getPrice());
			int ret = rp.executeUpdate();
			close();
			return ret;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return 0;
		}
	}
	
	private	static Product fetch(ResultSet rs) throws SQLException {
			return new Product(rs.getInt("ProductId"),
					rs.getInt("CategoryId"),
					rs.getInt("AuthorId"),
					rs.getInt("PublisherId"),
					rs.getString("ISBN"),
					rs.getString("Title"),
					rs.getShort("Pages"),
					rs.getShort("Year"),
					rs.getString("Weight"),
					rs.getString("Size"),
					rs.getString("Content"),
					rs.getString("ImageUrl"),
					rs.getString("Description"),
					rs.getInt("Price"));
	}
	private static List<Product> fetchAll(ResultSet rs) throws SQLException{
		List<Product> list = new LinkedList<>();
		while(rs.next()) {
			list.add(fetch(rs));
		}
		return list;
	}
	
	public List<Product> getProducts(){
		try {
			Open();
			st = connection.createStatement();
			rs = st.executeQuery("SELECT * FROM Product");
			List<Product> list = fetchAll(rs);
			close();
			return list;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}
	public List<Product> getProducts(int id){
		try {
			Open();
			rp = connection.prepareStatement("SELECT * FROM Product WHERE CategoryId = ?");
			rp.setInt(1,id);
			rs= rp.executeQuery();
			List<Product> list = fetchAll(rs);
			close();
			return list;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}
	public List<Product> getProducts(int pageIndex,int pageSize){
		try {
			Open();
			rp = connection.prepareStatement("SELECT * FROM Product LIMIT ?,?");
			rp.setInt(1,pageIndex);
			rp.setInt(2, pageSize);
			rs= rp.executeQuery();
			List<Product> list = fetchAll(rs);
			close();
			return list;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}
	public int count() {
		try {
			Open();
			st=connection.createStatement();
			rs =st.executeQuery("SELECT COUNT(*) AS Total FROM Product");
			int ret = 0;
			if(rs.next()) {
				ret = rs.getInt("Total");
			}
			close();
			return ret;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return 0;
		}
	}
	public Product getProduct(int id) {
		try {
			Open();
			rp = connection.prepareStatement("SELECT * FROM Product WHERE ProductId = ?");
			rp.setInt(1, id);
			rs = rp.executeQuery();
			Product obj =null;
			while(rs.next()) {
				obj = fetch(rs);
			}
			close();
			return obj;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}
	public List<Product> searchProduct(String q){
		try {
			Open();
			rp = connection.prepareStatement("SELECT * FROM Product WHERE Title Like ?");
			rp.setString(1,"%"+q+"%");
			rs= rp.executeQuery();
			List<Product> list = fetchAll(rs);
			close();
			return list;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}
}
