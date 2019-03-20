package model;

import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

public class AuthorRepository extends Repository {
	public List<Author> getAuthors(){
		try {
			Open();
			st = connection.createStatement();
			rs = st.executeQuery("SELECT * FROM Author");
			List<Author> list = new LinkedList<>();
			while(rs.next()) {
				list.add(new Author(rs.getInt("AuthorId"),rs.getString("AuthorName")));
			}
			close();
			return list;
			
		} catch (SQLException e) {

			e.printStackTrace();
			return null;
		}
	}
}
