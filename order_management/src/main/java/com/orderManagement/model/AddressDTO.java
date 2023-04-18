package com.orderManagement.model;

public class AddressDTO {

	private String addressLine1;
	private String addressLine2;
	private String city;
	private String state;
	private Long pincode;
	private String country;
	private String AddressType;

	public String getAddressLine1() {
		return addressLine1;
	}

	public void setAddressLine1(String addressLine1) {
		this.addressLine1 = addressLine1;
	}

	public String getAddressLine2() {
		return addressLine2;
	}

	public void setAddressLine2(String addressLine2) {
		this.addressLine2 = addressLine2;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public Long getPincode() {
		return pincode;
	}

	public void setPincode(Long pincode) {
		this.pincode = pincode;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getAddressType() {
		return AddressType;
	}

	public void setAddressType(String addressType) {
		AddressType = addressType;
	}

	@Override
	public String toString() {
		return "AddressDTO [addressLine1=" + addressLine1 + ", addressLine2=" + addressLine2 + ", city=" + city
				+ ", state=" + state + ", pincode=" + pincode + ", country=" + country + ", AddressType=" + AddressType
				+ "]";
	}

	public AddressDTO(String addressLine1, String addressLine2, String city, String state, Long pincode, String country,
			String addressType) {
		super();
		this.addressLine1 = addressLine1;
		this.addressLine2 = addressLine2;
		this.city = city;
		this.state = state;
		this.pincode = pincode;
		this.country = country;
		AddressType = addressType;
	}

}
