package com.example.demo.utils;

import java.text.DecimalFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Common {

	/**
	 * Method to validate email using RegEx.
	 * 
	 * @param email
	 * 
	 * @return boolean
	 */
	public static boolean isEmailValid(String email) {
		Pattern emailPattern = Pattern.compile(
				"^[_a-zA-Z0-9!#$%&'*+-/=?^_`{|}~;]+(\\.[_a-zA-Z0-9!#$%&'*+-/=?^_`{|}~;]+)*@[a-zA-Z0-9-]+(\\.[a-zA-Z0-9-]+)*(\\.[a-zA-Z]{2,})$");
		Matcher m = emailPattern.matcher(email);
		return m.matches();

	}

	/**
	 * Method to validate phoneNumber using RegEx.
	 * 
	 * @param phoneNumber
	 * 
	 * @return boolean
	 */
	public static boolean isPhoneNumber(String phoneNumber) {
		Pattern phoneNumberPattern = Pattern.compile("^[6789]\\d{9}$");
		Matcher matcher = phoneNumberPattern.matcher(phoneNumber);
		return matcher.matches();

	}

	/**
	 * Method to validate pinCode using RegEx.
	 * 
	 * @param pincode
	 * 
	 * @return
	 */
	public static boolean isPincode(String pincode) {
		Pattern pincodePattern = Pattern.compile("^[1-9][0-9]{5}$");
		Matcher matcher = pincodePattern.matcher(pincode);
		return matcher.matches();
	}

	/**
	 * Method to get only 2 digit after decimal.
	 * 
	 * @param productPrice
	 * 
	 * @return productPrice
	 */
	public static double isConversionPrice(double productPrice) {
		productPrice = Double.parseDouble(new DecimalFormat("##.##").format(productPrice));
		return productPrice;
	}

	public static LocalDateTime isConversionStringToLocalDateTime(String createDate) {
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
		LocalDateTime dateTime = LocalDateTime.parse(createDate, formatter);
		return dateTime;

	}

	/**
	 * Method to convert LocalDateTime to String.
	 * 
	 * @param createDate
	 * 
	 * @return createDate
	 */
	public static String isConversionLocalDateTimeToString(LocalDateTime createDate) {
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
		String str = createDate.format(formatter);
		return str;
	}

	/**
	 * Method to convert String to LocalUpdateTime.
	 * 
	 * @param updateDate
	 * 
	 * @return updateDate
	 */
	public static LocalDateTime isConversionStringToLocalUpdateTime(String updateDate) {
		DateTimeFormatter formatter1 = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
		LocalDateTime updateDateTime1 = LocalDateTime.parse(updateDate, formatter1);
		return updateDateTime1;
	}

	/**
	 * Method to convert LocalUpdateTime to String.
	 * 
	 * @param updateDate
	 * 
	 * @return updateDate
	 */
	public static String isConversionLocalUpdateTimeToString(LocalDateTime updateDate) {
		DateTimeFormatter formatter1 = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
		String str = updateDate.format(formatter1);
		return str;
	}

	/**
	 * Method to convert String to LocalDate.
	 * 
	 * @param date
	 * 
	 * @return date
	 * 
	 * @throws Exception
	 */
	public static LocalDate isConversionStringToLocalDate(String date) throws Exception {
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
		if (isValidate(date, formatter)) {
			LocalDate dateTime = LocalDate.parse(date, formatter);
			return dateTime;
		}
		throw new Exception("Please enter proper date foramt(yyyy-MM-dd) 'or' enter correct date");

	}

	private static boolean isValidate(String date, DateTimeFormatter formatter) {
		try {
			LocalDate.parse(date, formatter);
		} catch (DateTimeParseException e) {
			return false;
		}
		return true;
	}

	/**
	 * Method to convert LocalDate to String.
	 * 
	 * @param date
	 * 
	 * @return date
	 */
	public static String isConversionLocalDateToString(LocalDate date) {
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
		String str = date.format(formatter);
		return str;
	}

}
