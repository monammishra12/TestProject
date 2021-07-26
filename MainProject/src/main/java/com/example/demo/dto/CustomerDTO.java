package com.example.demo.dto;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import com.example.demo.entity.Customer;
import com.example.demo.utils.Common;

public class CustomerDTO {
	private long id;
	private String email;
	private String password;
	private String firstName;
	private String lastName;
	private String phoneNumber;
	private String createDate;
	private String updateDate;
	private List<AddressDTO> addressdto = new ArrayList<AddressDTO>();

	public CustomerDTO() {
	}

	public CustomerDTO(long id, String email, String password, String firstName, String lastName, String phoneNumber,
			String createDate, String updateDate) {
		this.id = id;
		this.email = email;
		this.password = password;
		this.firstName = firstName;
		this.lastName = lastName;
		this.phoneNumber = phoneNumber;
		this.createDate = createDate;
		this.updateDate = updateDate;
	}

	public CustomerDTO(Customer customer, boolean isUpdate) {
		this.id = customer.getId();
		this.email = customer.getEmail();
		this.password = customer.getPassword();
		this.firstName = customer.getFirstName();
		this.lastName = customer.getLastName();
		this.phoneNumber = customer.getPhoneNumber();
		this.createDate = Common.isConversionLocalDateTimeToString(customer.getCreateDate());
		if (isUpdate) {
			this.updateDate = Common.isConversionLocalDateTimeToString(customer.getUpdateDate());
		}
		this.addressdto = customer.getAddress().stream().map(data -> new AddressDTO(data)).collect(Collectors.toList());
	}

	/**
	 * Create CustomerDTO method to get all fields of Customer entity and set into
	 * CustomerDTO entity.
	 * 
	 * @param cust
	 * 
	 * @param isUpdate
	 * 
	 * @return CustomerDTO
	 */
	public static CustomerDTO getCustomer(Customer cust, boolean isUpdate) {
		CustomerDTO custDto = new CustomerDTO();
		custDto.setId(cust.getId());
		custDto.setEmail(cust.getEmail());
		custDto.setPassword(cust.getPassword());
		custDto.setFirstName(cust.getFirstName());
		custDto.setLastName(cust.getLastName());
		custDto.setPhoneNumber(cust.getPhoneNumber());
		custDto.setCreateDate(Common.isConversionLocalDateTimeToString(cust.getCreateDate()));
		if (isUpdate) {
			custDto.setUpdateDate(Common.isConversionLocalUpdateTimeToString(cust.getUpdateDate()));
		}
		return custDto;
	}

	/**
	 * (
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
	 * @return the email
	 */
	public String getEmail() {
		return email;
	}

	/**
	 * @param email the email to set
	 */
	public void setEmail(String email) {
		this.email = email;
	}

	/**
	 * @return the password
	 */
	public String getPassword() {
		return password;
	}

	/**
	 * @param password the password to set
	 */
	public void setPassword(String password) {
		this.password = password;
	}

	/**
	 * @return the firstName
	 */
	public String getFirstName() {
		return firstName;
	}

	/**
	 * @param firstName the firstName to set
	 */
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	/**
	 * @return the lastName
	 */
	public String getLastName() {
		return lastName;
	}

	/**
	 * @param lastName the lastName to set
	 */
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	/**
	 * @return the phoneNumber
	 */
	public String getPhoneNumber() {
		return phoneNumber;
	}

	/**
	 * @param phoneNumber the phoneNumber to set
	 */
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	/**
	 * @return the createDate
	 */
	public String getCreateDate() {
		return createDate;
	}

	/**
	 * @param create_date the create_date to set
	 */
	public void setCreateDate(String createDate) {
		this.createDate = createDate;
	}

	public String getUpdateDate() {
		return updateDate;
	}

	public void setUpdateDate(String updateDate) {
		this.updateDate = updateDate;
	}

	public List<AddressDTO> getAddressdto() {
		return addressdto;
	}

	public void setAddressdto(List<AddressDTO> addressdto) {
		this.addressdto = addressdto;
	}

	@Override
	public String toString() {
		return "CustomerDTO [id=" + id + ", email=" + email + ", password=" + password + ", firstName=" + firstName
				+ ", lastName=" + lastName + ", phoneNumber=" + phoneNumber + ", createDate=" + createDate
				+ ", updateDate=" + updateDate + ", addressdto=" + addressdto + "]";
	}

}