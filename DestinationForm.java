package jp.co.internous.mushrooms.model.form;

import java.io.Serializable;

public class DestinationForm implements Serializable{
	private static final long serialVersionUID = 1L;
	
	private long userId;
	private String familyName;
	private String firstName;
	private String address;
	private String telNumber;
	
	public long getUserId() {
		return userId;
	}
	public void setUserId(long userId) {
		this.userId = userId;
	}
	public String getFamilyName() {
		return familyName;
	}
	public void setFamilyName(String famillyName) {
		this.familyName = famillyName;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getTelNumber() {
		return telNumber;
	}
	public void setTelNumber(String telNumber) {
		this.telNumber = telNumber;
	}
}
