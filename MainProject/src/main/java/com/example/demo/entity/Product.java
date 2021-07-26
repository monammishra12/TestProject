package com.example.demo.entity;

import java.time.LocalDate;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import com.example.demo.dto.ProductDTO;
import com.example.demo.utils.Common;
import com.sun.istack.NotNull;

@Entity
@Table(name = "products")
public class Product {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	@Column(name = "product_id")
	private long id;

	@NotNull
	@Column(name = "product_name")
	private String productName;

	@NotNull
	@Column(name = "product_description")
	private String productDescription;
	@NotNull
	@Column(name = "product_price")
	private double productPrice;

	@NotNull
	@Column(name = "date")
	private LocalDate date;

	@Column(name = "discount_percent")
	private double discountPercent;

	@Column(name = "discount_price")
	private double discountPrice;

	@Column(name = "available_quantity")
	private long productQuantity;

	public Product() {
	}

	

	public Product(ProductDTO productDTO) throws Exception {
		String date = productDTO.getDate();
		this.id = productDTO.getId();
		this.productName = productDTO.getProductName();
		this.productDescription = productDTO.getProductDescription();
		this.productPrice = productDTO.getProductPrice();
		this.date = Common.isConversionStringToLocalDate(date);
		this.discountPercent = productDTO.getDiscountPercent();
		this.discountPrice = productDTO.getDiscountPrice();
		this.productQuantity = productDTO.getProductQuantity();

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
	 * @return the productName
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
	 * @return the productPrice to set
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
	 * @return the date
	 */
	public LocalDate getDate() {
		return date;
	}

	/**
	 * @param date the date to set
	 */
	public void setDate(LocalDate date) {
		this.date = date;
	}

	/**
	 * @return the discountPercent
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



	@Override
	public String toString() {
		return "Product [id=" + id + ", productName=" + productName + ", productDescription=" + productDescription
				+ ", productPrice=" + productPrice + ", date=" + date + ", discountPercent=" + discountPercent
				+ ", discountPrice=" + discountPrice + ", productQuantity=" + productQuantity + "]";
	}
	

}
