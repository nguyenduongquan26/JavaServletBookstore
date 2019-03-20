package model;


import java.sql.DriverManager;

import java.sql.SQLException;

import java.util.LinkedList;
import java.util.List;


public class PublisherRepository extends Repository {
		
		public int add(Publisher obj) {
			try {
				Open();
				rp = connection.prepareStatement("INSERT INTO Publisher (PublisherName) VALUES(?)");
				rp.setString(1, obj.getName());
				int ret = rp.executeUpdate();
				close();
				return ret;
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				return 0;
			}
		}
		public int[] delete(List<Integer> list) {
			try {
				Open();
				rp = connection.prepareStatement("DELETE FROM Publisher WHERE PublisherId = ?");
				for(Integer item:list) {
					rp.setInt(1, item);
					rp.addBatch();
				}
				int[] ret = rp.executeBatch();
				close();
				return ret;
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				return null;
			}
		}
		public int delete(int id) {
			try {
				Open();
				rp = connection.prepareStatement("DELETE FROM Publisher WHERE PublisherId = ?");
				rp.setInt(1, id);
				int ret = rp.executeUpdate();
				close();
				return ret;
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				return 0;
			}
		}

			public Publisher getPublisher(int id) {
			try {
					Open();
					rp = connection.prepareStatement("SELECT * FROM Publisher WHERE PublisherId = ?");
					rp.setInt(1, id);
					rs = rp.executeQuery();
					if(rs.next()) {
						Publisher ojb = new Publisher(rs.getInt("PublisherId"), rs.getString("PublisherName"));
						return ojb;
					}		
					close();
			}catch(SQLException e) {
				e.printStackTrace();
				return null;
			}
			return null;
			}
			
		public int edit(Publisher obj) {
			try {
				Open();
				rp = connection.prepareStatement("Update Publisher SET PublisherName = ? WHERE PublisherId = ?");
				rp.setString(1, obj.getName());
				rp.setInt(2, obj.getId());
				int ret = rp.executeUpdate();
				close();
				return ret;
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				return 0;
			}
		}

		public List<Publisher> getPublisher(){
			try {
				connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/minishop?userUnicode=true&characterEncoding=UTF-8","root", "");
				st = connection.createStatement();
				rs = st.executeQuery("SELECT * FROM Publisher");
				List<Publisher> list = new LinkedList();
				while(rs.next()) {
					Publisher obj = new Publisher(rs.getInt("PublisherId"),rs.getString("PublisherName"));
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

}