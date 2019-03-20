package model;


import java.sql.SQLException;

import util.Helper;

public class MemberRepository extends Repository{
	public int LogOn(Member obj) {
		try {
			Open();
			rp = connection.prepareStatement("SELECT MemberId, Email FROM Member WHERE Username = ? AND Password = ?");
			rp.setString(1, obj.getUsername());
			rp.setBytes(2, Helper.hash(obj.getPassword()));
			rs = rp.executeQuery();
			if(rs.next()) {
				obj.setId(rs.getLong("MemberId"));
				obj.setEmail(rs.getString("Email"));
				return 1;
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return 0;
	}

public int add(Member obj) {
	String sql = "INSERT INTO Member (MemberId, Username, Password, FullName, Email, Gender) VALUES(?,?,?,?,?,?)";
	try {
		Open();
		rp = connection.prepareStatement(sql);
		rp.setLong(1,obj.getId());
		rp.setString(2, obj.getUsername());
		rp.setBytes(3, Helper.hash(obj.getPassword()));
		rp.setString(4, obj.getFullname());
		rp.setString(5, obj.getEmail());
		rp.setByte(6, obj.getGender());
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
