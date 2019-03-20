package model;

import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

public class InvoiceRepository extends Repository {
	public int add(Invoice obj) {
		String sql = "INSERT INTO Invoice (InvoiceId, MemberId, Email, Tel, Address, StatusId) VALUES(?,?,?,?,?,?)";
		try {
			Open();
			rp = connection.prepareStatement(sql);
			rp.setLong(1, obj.getId());
			rp.setObject(2, obj.getMemberId());
			rp.setString(3, obj.getEmail());
			rp.setString(4, obj.getTel());
			rp.setString(5, obj.getAddress());
			rp.setShort(6, obj.getStatusId());
			int ret = rp.executeUpdate();
			add(obj.getDetails());
			close();
			return ret;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return 0;
		}
	}
	
	private int[] add(List<InvoiceDetail> list) {
		String sql ="INSERT INTO InvoiceDetail (InvoiceId, ProductId, Price, Quantity) VALUES(?,?,?,?)";
		try {
			Open();
			rp = connection.prepareStatement(sql);
			for(InvoiceDetail obj : list) {
				rp.setLong(1, obj.getInvoiceId());
				rp.setInt(2, obj.getProductId());
				rp.setInt(3, obj.getPrice());
				rp.setShort(4, obj.getQuantity());
				rp.addBatch();
			}
			int[] ret = rp.executeBatch();
			return ret;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}
	
	
	public Invoice getInvoice(long id) {
		try {
			Open();
			rp = connection.prepareStatement("SELECT * FROM Invoice INNER JOIN Status ON Invoice.StatusId = Status.StatusId WHERE InvoiceId = ?");
			rp.setLong(1, id);
			rs = rp.executeQuery();
			Invoice obj = null;
			while(rs.next()) {
				obj = new Invoice(rs.getLong("InvoiceId"),
						rs.getLong("MemberId"),
						rs.getString("Email"),
						rs.getString("Tel"),
						rs.getString("Address"),
						rs.getShort("StatusId"),
						rs.getString("StatusName"),
						rs.getDate("AddedDate"));
			}
			obj.setDetails(getInvoiceDetails(id));
			close();
			return obj;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}
	
	private List<InvoiceDetail> getInvoiceDetails(long id){
		try {
			String sql= "SELECT * FROM InvoiceDetail INNER JOIN Product ON InvoiceDetail.ProductId = Product.ProductId WHERE InvoiceId = ?";
			rp = connection.prepareStatement(sql);
			rp.setLong(1, id);
			rs = rp.executeQuery();
			List<InvoiceDetail> list = new LinkedList<>();
			while(rs.next()) {
				InvoiceDetail obj = new InvoiceDetail(rs.getLong("InvoiceId"),
						rs.getInt("ProductId"),
				        rs.getString("Title"),
				        rs.getString("ImageUrl"),
				        rs.getInt("Price"),
				        rs.getShort("Quantity"));
				list.add(obj);
			}
			return list;
		} catch(SQLException e) {
			e.printStackTrace();
			return null;
		}
	}
	
	
}
