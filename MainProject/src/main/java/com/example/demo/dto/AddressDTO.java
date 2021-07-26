package com.example.demo.dto;

import com.example.demo.entity.Address;

public class AddressDTO {
	private long id;
	private String pincode;
	private String houseNo;
	private String buildingName;
	private String area;
	private String street;
	private String landmark;
	private String city;
	private String state;

	public AddressDTO() {

	}

	/**
	 * Create AddressDTO method to get all fields of Customer entity and set into
	 * AddressDTO entity.
	 * 
	 * @param address
	 * 
	 * @return AddressDTO
	 */
	public static AddressDTO getAddressDTO(Address address) {
		AddressDTO addressDTO = new AddressDTO();
		addressDTO.setId(address.getId());
		addressDTO.setPincode(address.getPincode());
		addressDTO.setHouseNo(address.getHouseNo());
		addressDTO.setBuildingName(address.getBuildingName());
		addressDTO.setArea(address.getArea());
		addressDTO.setStreet(address.getStreet());
		addressDTO.setLandmark(address.getLandmark());
		addressDTO.setCity(address.getCity());
		addressDTO.setState(address.getState());
		return addressDTO;
	}

	public AddressDTO(Address address) {
		this.id = address.getId();
		this.pincode = address.getPincode();
		this.houseNo = address.getHouseNo();
		this.buildingName = address.getBuildingName();
		this.area = address.getArea();
		this.street = address.getStreet();
		this.landmark = address.getLandmark();
		this.city = address.getCity();
		this.state = address.getState();
	}

	/**
	 * @return the id
	 */
	public long getId() {
		return id;
	}

	/**
	 * @param id thhe id to set
	 */
	public void setId(long id) {
		this.id = id;
	}

	/**
	 * @return the pinCode
	 */
	public String getPincode() {
		return pincode;
	}

	/**
	 * @param pincode the pinCode to set
	 */
	public void setPincode(String pincode) {
		this.pincode = pincode;
	}

	/**
	 * @return the houseNo
	 */
	public String getHouseNo() {
		return houseNo;
	}

	/**
	 * @param houseNo the houseNo to set
	 */
	public void setHouseNo(String houseNo) {
		this.houseNo = houseNo;
	}

	/**
	 * @return the buildingName
	 */
	public String getBuildingName() {
		return buildingName;
	}

	/**
	 * @param buildingName the buildingName to set
	 */
	public void setBuildingName(String buildingName) {
		this.buildingName = buildingName;
	}

	/**
	 * @return the area
	 */
	public String getArea() {
		return area;
	}

	/**
	 * @param area the area to set
	 */
	public void setArea(String area) {
		this.area = area;
	}

	/**
	 * @return the street
	 */
	public String getStreet() {
		return street;
	}

	/**
	 * @param street the street to set
	 */
	public void setStreet(String street) {
		this.street = street;
	}

	/**
	 * @return the landmark
	 */
	public String getLandmark() {
		return landmark;
	}

	/**
	 * @param landmark the landmark to set
	 */
	public void setLandmark(String landmark) {
		this.landmark = landmark;
	}

	/**
	 * @return the city
	 */
	public String getCity() {
		return city;
	}

	/**
	 * @param city the city to set
	 */
	public void setCity(String city) {
		this.city = city;
	}

	/**
	 * @return the state
	 */
	public String getState() {
		return state;
	}

	/**
	 * @param state the state to set
	 */
	public void setState(String state) {
		this.state = state;
	}

}
