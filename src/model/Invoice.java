package model;

import java.util.Date;
import java.util.List;

public class Invoice {
	private long id;
	private Long memberId;
	private String email;
	private String tel;
	private String address;
	private short statusId;
	private String statusName;
	private Date dated;
	private List<InvoiceDetail> details;

	public Invoice(long id, Long memberId, String email, String tel, String address, short statusId) {
		this.id = id;
		this.memberId = memberId;
		this.email = email;
		this.tel = tel;
		this.address = address;
		this.statusId = statusId;
	}
	
	public Invoice(long id, Long memberId, String email, String tel, String address, short statusId, String statusName,
			Date dated) {
		this.id = id;
		this.memberId = memberId;
		this.email = email;
		this.tel = tel;
		this.address = address;
		this.statusId = statusId;
		this.statusName = statusName;
		this.dated = dated;
	}

	public String getStatusName() {
		return statusName;
	}

	public void setStatusName(String statusName) {
		this.statusName = statusName;
	}

	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public Long getMemberId() {
		return memberId;
	}
	public void setMemberId(Long memberId) {
		this.memberId = memberId;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getTel() {
		return tel;
	}
	public void setTel(String tel) {
		this.tel = tel;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public short getStatusId() {
		return statusId;
	}
	public void setStatusId(short statusId) {
		this.statusId = statusId;
	}
	public Date getDated() {
		return dated;
	}
	public void setDated(Date dated) {
		this.dated = dated;
	}
	public List<InvoiceDetail> getDetails() {
		return details;
	}
	public void setDetails(List<InvoiceDetail> details) {
		this.details = details;
	}
	
}
