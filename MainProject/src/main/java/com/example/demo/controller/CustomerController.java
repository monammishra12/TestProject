package com.example.demo.controller;

import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import javax.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.supercsv.io.CsvBeanWriter;
import org.supercsv.io.ICsvBeanWriter;
import org.supercsv.prefs.CsvPreference;
import com.example.demo.dto.CustomerDTO;
import com.example.demo.entity.Customer;
import com.example.demo.service.CustomerService;

@RestController
@RequestMapping("/customer")
public class CustomerController {

	private CustomerService customerService;

	@Autowired
	private CustomerController(CustomerService customerService) {
		this.customerService = customerService;
	}

	/**
	 * Method to create newCustomer record.
	 * 
	 * @param newCustomer
	 * 
	 * @return newCustomer
	 * 
	 * @throws Exception
	 */
	@PostMapping("/create")
	public CustomerDTO createDTO(@RequestBody CustomerDTO newCustomer) throws Exception {
		return customerService.saveCustomer(newCustomer);
	}

	/**
	 * Method to delete records using id.
	 * 
	 * @param id
	 * 
	 * @return
	 */
	@DeleteMapping("delete/{id}")
	public String deleteCustomer(@PathVariable("id") long id) {
		return customerService.deleteCustomer(id);
	}

	/**
	 * Method to update a specified customer record given the customer id
	 * 
	 * @param newCustomer
	 * 
	 * @param id
	 * 
	 * @return CustomerDTO
	 * 
	 * @throws Exception
	 */
	@PutMapping("update/{id}")
	public CustomerDTO updateDTO(@RequestBody CustomerDTO newCustomer, @PathVariable("id") long id) throws Exception {
		return customerService.updateById(newCustomer, id);
	}

	/**
	 * Method to get all customer records.
	 * 
	 * @return list of CustomerDTO
	 */
	@GetMapping("get/all")
	public List<CustomerDTO> getAll() {
		return customerService.getAll();
	}

	/**
	 * Method to get all customer records using pagination.
	 * 
	 * @param pageNo   ooo
	 * @param pageSize
	 * 
	 * @return customerDTO
	 */
	@GetMapping("get/{pageNo}/{pageSize}/{sort}")
	public List<CustomerDTO> customerPageable(@PathVariable int pageNo, @PathVariable int pageSize) {
		return customerService.getAllRecord(pageNo, pageSize);

	}

	/**
	 * Method to get customer records using id.
	 * 
	 * @param id
	 * 
	 * @return Customer
	 */
	@GetMapping("/get/{id}")
	Customer getOne(@PathVariable("id") long id) {
		return customerService.getAddress(id);
	}

	/**
	 * Method to get CSV file.
	 * 
	 * @param response
	 * 
	 * @throws IOException
	 */
	@GetMapping("/customers/export")
	public void exportToCSV(HttpServletResponse response) throws IOException {
		response.setContentType("text/csv");
		DateFormat dateFormatter = new SimpleDateFormat("yyyy-MM-dd_HH-mm-ss");
		String currentDateTime = dateFormatter.format(new Date());
		String headerKey = "Content-Disposition";
		String headerValue = "attachment; filename=customers_" + currentDateTime + ".csv";
		response.setHeader(headerKey, headerValue);
		List<CustomerDTO> listCustomers = customerService.listAll();
		ICsvBeanWriter csvWriter = new CsvBeanWriter(response.getWriter(), CsvPreference.STANDARD_PREFERENCE);
		String[] csvHeader = { "customer_id", "create_date", "email", "first_name", "last_name", "password",
				"phone_number", "update_date" };
		String[] nameMapping = { "id", "createDate", "email", "firstName", "lastName", "password", "phoneNumber",
				"updateDate" };
		csvWriter.writeHeader(csvHeader);
		for (CustomerDTO customer : listCustomers) {
			csvWriter.write(customer, nameMapping);
		}
		csvWriter.close();

	}

	/**
	 * Method to read data from CSV file and set to the database
	 * 
	 * @param file
	 * 
	 * @return ResponseEntity
	 */
	@PostMapping("/upload")
	public String uploadFile(@RequestParam("file") MultipartFile file) {
		return customerService.save(file);
	}

}
