package com.example.demo.service;

import java.io.IOException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.example.demo.dto.AddressDTO;
import com.example.demo.dto.CustomerDTO;
import com.example.demo.entity.Address;
import com.example.demo.entity.Customer;
import com.example.demo.repository.CustomerRepository;
import com.example.demo.utils.CSVHelper;
import com.example.demo.utils.Common;

/**
 * @author witty
 *
 */
@Service
public class CustomerService {
	private CustomerRepository customerRepository;

	@Autowired
	public CustomerService(CustomerRepository customerRepository) {
		this.customerRepository = customerRepository;
	}

	/**
	 * Method to create new records.
	 * 
	 * @param customerDTO
	 * 
	 * @return CustomerDTO
	 * 
	 * @throws Exception
	 */
	public CustomerDTO saveCustomer(CustomerDTO customerDTO) throws Exception {
		Customer customerData = new Customer(customerDTO);
		customerData.setId(customerDTO.getId());
		if (!Common.isEmailValid(customerDTO.getEmail())) {
			throw new Exception("Please enter a valid email");
		} else {
			customerData.setEmail(customerDTO.getEmail());
		}
		customerData.setPassword(customerDTO.getPassword());
		customerData.setFirstName(customerDTO.getFirstName());
		customerData.setLastName(customerDTO.getLastName());
		if (!Common.isPhoneNumber(customerDTO.getPhoneNumber())) {
			throw new Exception("Please enter a valid phoneNumber");
		} else {
			customerData.setPhoneNumber(customerDTO.getPhoneNumber());
		}
		if (customerDTO.getCreateDate() != null) {
			customerData.setCreateDate(Common.isConversionStringToLocalDateTime(customerDTO.getCreateDate()));
		} else {
			LocalDateTime dateTime1 = LocalDateTime.now();
			customerData.setCreateDate(dateTime1);
		}
		if (customerDTO.getAddressdto() != null && customerDTO.getAddressdto().size() > 0) {
			List<Address> address = new ArrayList<>();
			for (AddressDTO dto : customerDTO.getAddressdto()) {
				Address data = new Address();
				if (!Common.isPincode(dto.getPincode())) {
					throw new Exception("Please enter pincode in proper format: It can be only six digits:"
							+ "It should not start with zero:" + "First digit of the pincode must be from 1 to 9:"
							+ "Next five  digits of the pincode may range from 0 to 9:"
							+ "It should allow only one white space,but after three digits,although this is optional");
				} else {
					data.setPincode(dto.getPincode());
				}
				data.setHouseNo(dto.getHouseNo());
				data.setBuildingName(dto.getBuildingName());
				data.setArea(dto.getArea());
				data.setStreet(dto.getStreet());
				data.setLandmark(dto.getLandmark());
				data.setCity(dto.getCity());
				data.setState(dto.getState());
				address.add(data);
			}
			customerData.setAddress(address);
		}
		customerData = customerRepository.save(customerData);
		CustomerDTO custdto = new CustomerDTO(customerData, false);
		return custdto;
	}

	/**
	 * Delete a specified customer record given the customer id
	 * 
	 * @param id
	 * 
	 * @return
	 */
	public String deleteCustomer(long id) {
		if (customerRepository.findById(id).isPresent()) {
			customerRepository.deleteById(id);
			return "Record is deleted";
		}
		return "Record is not deleted";
	}

	/**
	 * Get all customer records
	 * 
	 * @return list of CustomerDTO
	 */
	public List<CustomerDTO> getAll() {
		List<Customer> list1 = customerRepository.findAll();
		List<CustomerDTO> allDTO = list1.stream().map(a -> new CustomerDTO(a, false)).collect(Collectors.toList());
		return allDTO;
	}

	/**
	 * Method to get customer records using id
	 * 
	 * @param id
	 * 
	 * @return Customer
	 */
	public Customer getAddress(long id) {
		Optional<Customer> customerData = customerRepository.findById(id);
		return customerData.get();
	}

	/**
	 * Update a specified customer record given the customer id
	 * 
	 * @param customerDTO
	 * 
	 * @param id
	 * 
	 * @return CustomerDTO
	 * 
	 * @throws Exception
	 */
	public CustomerDTO updateById(CustomerDTO customerDTO, long id) throws Exception {
		boolean isUpdate = true;
		Optional<Customer> customer = customerRepository.findById(id);
		if (customer.isPresent()) {
			Customer record = customer.get();
			if (customerDTO.getEmail() != null) {
				if (Common.isEmailValid(customerDTO.getEmail()))
					record.setEmail(customerDTO.getEmail());
				else {
					throw new Exception("Please enter a valid email");
				}
			}
			if (customerDTO.getPassword() != null) {
				record.setPassword(customerDTO.getPassword());
			}
			if (customerDTO.getFirstName() != null) {
				record.setFirstName(customerDTO.getFirstName());
			}
			if (customerDTO.getLastName() != null) {
				record.setLastName(customerDTO.getLastName());
			}
			if (customerDTO.getPhoneNumber() != null) {
				if (Common.isPhoneNumber(customerDTO.getPhoneNumber()))
					record.setPhoneNumber(customerDTO.getPhoneNumber());
				else {
					throw new Exception("Please enter a valid phoneNumber");
				}
			}
			if (customerDTO.getCreateDate() != null) {
				if (Common.isEmailValid(customerDTO.getEmail())) {
					record.setCreateDate(Common.isConversionStringToLocalDateTime(customerDTO.getCreateDate()));
				} else {
					throw new Exception();
				}
			} else {
				LocalDateTime dateTime = LocalDateTime.now();
				record.setCreateDate(dateTime);
			}
			if (isUpdate)
				if (customerDTO.getUpdateDate() != null) {
					record.setUpdateDate(Common.isConversionStringToLocalUpdateTime(customerDTO.getUpdateDate()));
				} else {
					LocalDateTime dateUpdate = LocalDateTime.now();
					record.setUpdateDate(dateUpdate);
				}
			if (customerDTO.getAddressdto() != null && customerDTO.getAddressdto().size() > 0) {
				for (AddressDTO dto : customerDTO.getAddressdto()) {
					for (Address data : record.getAddress()) {
						if (dto.getPincode() != null) {
							if (Common.isPincode(dto.getPincode()))
								data.setPincode(dto.getPincode());
							else {
								throw new Exception("Please enter pincode in proper format: It can be only six digits:"
										+ "It should not start with zero:"
										+ "First digit of the pincode must be from 1 to 9:"
										+ "Next five  digits of the pincode may range from 0 to 9:"
										+ "It should allow only one white space,but after three digits,although this is optional");
							}
						}
						if (dto.getHouseNo() != null) {
							data.setHouseNo(dto.getHouseNo());
						}
						if (dto.getBuildingName() != null) {
							data.setBuildingName(dto.getBuildingName());
						}
						if (dto.getArea() != null) {
							data.setArea(dto.getArea());
						}
						if (dto.getStreet() != null) {
							data.setStreet(dto.getStreet());
						}
						if (dto.getLandmark() != null) {
							data.setLandmark(dto.getLandmark());
						}
						if (dto.getCity() != null) {
							data.setCity(dto.getCity());
						}
						if (dto.getState() != null) {
							data.setState(dto.getState());
						}
					}
				}
			}
			record = customerRepository.save(record);
			CustomerDTO dto = new CustomerDTO(record, true);
			return dto;
		} else {

		}
		throw new Exception("not found");
	}

	/**
	 * Method to get CSV file.
	 * 
	 * @return list of CustomerDTO
	 */
	public List<CustomerDTO> listAll() {
		List<Customer> allCustomers = customerRepository.findAll();
		List<CustomerDTO> allDto = allCustomers.stream().map(data -> new CustomerDTO(data, false))
				.collect(Collectors.toList());
		return allDto;
	}

	/**
	 * Method to read data from CSV file and set to the database.
	 * 
	 * @param file
	 * 
	 * @return list of CustomerDTO
	 */
	public String save(MultipartFile file) {
		try {
			List<CustomerDTO> tutorials = CSVHelper.csvToTutorials(file.getInputStream());
			List<Customer> customers = tutorials.stream().map(st -> new Customer(st)).collect(Collectors.toList());
			customerRepository.saveAll(customers);

		} catch (IOException e) {
			throw new RuntimeException("fail to store csv data:" + e.getMessage());
		}
		String message = "";
		if (CSVHelper.hasCSVFormat(file)) {
			message = "Uploaded the file  successfully:" + file.getOriginalFilename();
			return message;
		} else {
			message = "Could not upload the file:" + file.getOriginalFilename() + "!";
			return message;
		}

	}

	public List<CustomerDTO> getAllRecord(int pageNo, int pageSize) {
		Pageable paging = PageRequest.of(pageNo, pageSize, Sort.by("id").descending());
		Page<Customer> pagedResult = customerRepository.findAll(paging);
		List<CustomerDTO> allRecords = pagedResult.stream().map(record -> new CustomerDTO(record, false))
				.collect(Collectors.toList());
		return allRecords;

	}

}
