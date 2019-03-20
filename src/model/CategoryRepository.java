package model;


import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;


public class CategoryRepository extends Repository {
	public Category fetch(ResultSet rs) throws SQLException {
		return new Category(rs.getInt("CategoryId"), rs.getString("CategoryName"), rs.getInt("ParentId"));
	}
	public Category getCategories(int id) {
		try {
			Open();
			rp = connection.prepareStatement("SELECT * FROM Category WHERE CategoryId = ?");
			rp.setInt(1, id);
			rs = rp.executeQuery();
			Category obj = null;
			if(rs.next()) {
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
	public List<Category> getCategories2(){
		try {
			Open();
			st = connection.createStatement();
			rs = st.executeQuery("SELECT * FROM Category");
			List<Category> list = new LinkedList<>();
			while(rs.next()) {
				list.add(fetch(rs));
			}
			close();
			return list;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}
	public List<Category> getCategories(){
		try {
			Open();
			st = connection.createStatement();
			rs = st.executeQuery("SELECT Child.CategoryId, Child.CategoryName,Child.ParentId,\r\n" + 
					"Parent.CategoryName AS ParentName FROM Category AS Parent RIGHT JOIN Category AS Child\r\n" + 
					"ON Child.ParentId = Parent.CategoryId;");
			List<Category> list = new LinkedList<>();
			while(rs.next()) {
				Category obj = new Category(rs.getInt("CategoryId"), rs.getString("CategoryName"), rs.getInt("ParentId"), rs.getString("ParentName"));
				list.add(obj);
			}
			close();
			return list;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}
	public List<Category> getParents(){
		try {
			Open();
				st = connection.createStatement();
				rs = st.executeQuery("SELECT * FROM Category WHERE ParentId IS NULL");
				List<Category> list = new LinkedList<>();
				while(rs.next()) {
					Category obj = new Category(rs.getInt("CategoryId"), rs.getString("CategoryName"), rs.getInt("ParentId"));
					list.add(obj);
				}
				close();
				return list;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}
	public int add(Category obj) {
		try {
			Open();
			rp = connection.prepareStatement("INSERT INTO Category(CategoryName, ParentId) VALUES(?,?)");
			rp.setString(1, obj.getName());
			rp.setInt(2,obj.getParent());
			int ret = rp.executeUpdate();
			close();
			return ret;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return 0;
		}
	}
	

}
