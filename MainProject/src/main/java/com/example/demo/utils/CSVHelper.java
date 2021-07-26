package com.example.demo.utils;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;
import org.springframework.web.multipart.MultipartFile;

import com.example.demo.dto.CustomerDTO;

public class CSVHelper {
	public static String TYPE = "text/csv";
	static String[] HEADERs = { "Id", "Email", "Password", "FirstName", "LastName", "PhoneNumber", "CreateDate",
			"UpdateDate" };

	public static boolean hasCSVFormat(MultipartFile file) {

		if (!TYPE.equals(file.getContentType())) {
			return false;
		}
		return true;
	}

	/**
	 * Method to read data from CSV file and set to the database.
	 * 
	 * @param is
	 * 
	 * @return list of CustomerDTO
	 */
	public static List<CustomerDTO> csvToTutorials(InputStream is) {
		try (BufferedReader fileReader = new BufferedReader(new InputStreamReader(is, "UTF-8"));
				CSVParser csvParser = new CSVParser(fileReader,
						CSVFormat.DEFAULT.withFirstRecordAsHeader().withIgnoreHeaderCase().withTrim());) {
			List<CustomerDTO> customerList = new ArrayList<>();
			Iterable<CSVRecord> csvRecords = csvParser.getRecords();
			for (CSVRecord csvRecord : csvRecords) {

				CustomerDTO customer = new CustomerDTO(Long.parseLong(csvRecord.get(6)), csvRecord.get(2),
						csvRecord.get(7), csvRecord.get(3), csvRecord.get(4), csvRecord.get(0), csvRecord.get(1),
						csvRecord.get(5));
				customerList.add(customer);
			}

			return customerList;

		} catch (IOException ex) {
			throw new RuntimeException(ex);
		}
	}

}