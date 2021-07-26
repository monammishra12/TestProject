package com.example.demo.dto;

import com.example.demo.entity.Product;
import com.example.demo.utils.Common;

public class ProductDTO {
	private long id;
	private String productName;
	private String productDescription;
	private double productPrice;
	private String date;
	private double discountPercent;
	private double discountPrice;
	private long productQuantity;

	public ProductDTO() {

	}

	/**
	 * Create ProductDTO method to get all fields of Product entity and set into
	 * ProductDTO entity.
	 * 
	 * @param product
	 * 
	 * @return ProductDTO
	 * 
	 * @throws Exception
	 */
	public static ProductDTO getProductDTO(Product product) throws Exception {
		ProductDTO productDTO = new ProductDTO();
		productDTO.setId(product.getId());
		productDTO.setProductName(product.getProductName());
		productDTO.setProductDescription(product.getProductDescription());
		productDTO.setProductPrice(product.getProductPrice());
		productDTO.setDate(Common.isConversionLocalDateToString(product.getDate()));
		productDTO.setDiscountPercent(product.getDiscountPercent());
		productDTO.setDiscountPrice(product.getDiscountPrice());
		return productDTO;

	}

	public ProductDTO(Product product) {
		this.id = product.getId();
		this.productName = product.getProductName();
		this.productDescription = product.getProductDescription();
		this.productPrice = product.getProductPrice();
		this.discountPercent = product.getDiscountPercent();
		this.discountPrice = product.getDiscountPrice();
		this.date = Common.isConversionLocalDateToString(product.getDate());
		this.productQuantity = product.getProductQuantity();

	}

	/**
	 * @return the productId
	 */
	public long getId() {
		return id;
	}

	/**
	 * @param id the productId to set
	 */
	public void setId(long id) {
		this.id = id;
	}

	/**
	 * @return the productName to set
	 */
	public String getProductName() {
		return productName;
	}

	/**
	 * @param productName the productName to set
	 */
	public void setProductName(String productName) {
		this.productName = productName;
	}

	/**
	 * @return the productDescription
	 */
	public String getProductDescription() {
		return productDescription;
	}

	/**
	 * @param productDescription the productDescription to set
	 */
	public void setProductDescription(String productDescription) {
		this.productDescription = productDescription;
	}

	/**
	 * @return the productPrice
	 */
	public double getProductPrice() {
		return productPrice;
	}

	/**
	 * @param productPrice the productPrice to set
	 */
	public void setProductPrice(double productPrice) {
		this.productPrice = productPrice;
	}

	/**
	 * @return the date to set
	 */
	public String getDate() {
		return date;
	}

	/**
	 * @param date the date to set
	 */
	public void setDate(String date) {
		this.date = date;
	}

	/**
	 * @return the discountPrice
	 */
	public double getDiscountPercent() {
		return discountPercent;
	}

	/**
	 * @param discountPercent the discountPercent to set
	 */
	public void setDiscountPercent(double discountPercent) {
		this.discountPercent = discountPercent;
	}

	/**
	 * @return the discountPrice
	 */
	public double getDiscountPrice() {
		return discountPrice;
	}

	/**
	 * @param discountPrice the discountPrice to set
	 */
	public void setDiscountPrice(double discountPrice) {
		this.discountPrice = discountPrice;
	}

	/**
	 * @return the productQuantity
	 */
	public long getProductQuantity() {
		return productQuantity;
	}

	/**
	 * @param productQuantity the productQuantity to set
	 */
	public void setProductQuantity(long productQuantity) {
		this.productQuantity = productQuantity;
	}

}
