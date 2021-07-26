package com.example.demo.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.example.demo.dto.AddressDTO;
import com.sun.istack.NotNull;

@Entity
@Table(name = "address")
public class Address {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	@Column(name = "address_id")
	private long id;

	@NotNull
	@Column(name = "pincode")
	private String pincode;

	@NotNull
	@Column(name = "house_no")
	private String houseNo;

	@NotNull
	@Column(name = "building_name")
	private String buildingName;

	@NotNull
	@Column(name = "area")
	private String area;

	@NotNull
	@Column(name = "street")
	private String street;

	@NotNull
	@Column(name = "landmark")
	private String landmark;

	@NotNull
	@Column(name = "city")
	private String city;

	@NotNull
	@Column(name = "state")
	private String state;

	public Address() {

	}

	public Address(AddressDTO addressDTO) {
		this.id = addressDTO.getId();
		this.pincode = addressDTO.getPincode();
		this.houseNo = addressDTO.getHouseNo();
		this.buildingName = addressDTO.getBuildingName();
		this.area = addressDTO.getArea();
		this.street = addressDTO.getStreet();
		this.landmark = addressDTO.getLandmark();
		this.city = addressDTO.getCity();
		this.state = addressDTO.getState();
	}

	/**
	 * @return the id
	 */

	public long getId() {
		return id;
	}

	/**
	 * @param id the id to set
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
