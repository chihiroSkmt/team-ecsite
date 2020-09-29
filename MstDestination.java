package jp.co.internous.mushrooms.model.domain;

import java.sql.Timestamp;

import jp.co.internous.mushrooms.model.form.DestinationForm;

public class MstDestination {
	
	private long id;
	private long userId;
	private String familyName;
	private String firstName;
	private String telNumber;
	private String address;
	private byte status = 1;
	private Timestamp createdAt;
	private Timestamp updatedAt;
	
	public MstDestination() {}
	
	public MstDestination(DestinationForm f) {
		userId= f.getUserId();
		familyName = f.getFamilyName();
		firstName = f.getFirstName();
		telNumber = f.getTelNumber();
		address = f.getAddress();
	}
	
//	setter
	public void setId(long id) {
		this.id = id;
	}
	public void setUserId(long userId) {
		this.userId = userId;
	}
	public void setFamilyName(String familyName) {
		this.familyName = familyName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public void setTelNumber(String telNumber) {
		this.telNumber = telNumber;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public void setStatus(byte status) {
		this.status = status;
	}
	public void setCreatedAt(Timestamp createdAt) {
		this.createdAt = createdAt;
	}
	public void setUpdatedAt(Timestamp updatedAt) {
		this.updatedAt = updatedAt;
	}

//	getter
	public long getId() {
		return id;
	}
	public long getUserId() {
		return userId;
	}
	public String getFamilyName() {
		return familyName;
	}
	public String getFirstName() {
		return firstName;
	}
	public String getTelNumber() {
		return telNumber;
	}
	public String getAddress() {
		return address;
	}
	public byte getStatus() {
		return status;
	}
	public Timestamp getCreatedAt() {
		return createdAt;
	}
	public Timestamp getUpdatedAt() {
		return updatedAt;
	}
	
}
