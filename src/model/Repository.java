package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public abstract class Repository {
	protected Connection connection;
	protected Statement st;
	protected ResultSet rs;
	protected java.sql.PreparedStatement rp;

	static {
		try {
			
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
		
	protected void Open() throws SQLException {
		connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/minishop?userUnicode=true&characterEncoding=UTF-8","root", "");
		
	}
	protected void close() throws SQLException {
		connection.close();
		if(st != null) {
			st.close();
		}
		if(rp != null) {
			rp.close();
		}
		if(rs != null) {
			rs.close();
		}
	}

}
