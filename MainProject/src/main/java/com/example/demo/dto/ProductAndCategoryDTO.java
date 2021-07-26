package com.example.demo.dto;

import java.util.List;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

@JsonInclude(Include.NON_NULL)
public class ProductAndCategoryDTO {
	List<ProductDTO> productData;
	List<ProductCategoryDTO> productcategory;

	/**
	 * @return the list of product
	 */
	public List<ProductDTO> getProduct() {
		return productData;
	}

	/**
	 * @param product the product to set
	 */
	public void setProduct(List<ProductDTO> product) {
		this.productData = product;
	}

	/**
	 * @return the list of productCategory
	 */
	public List<ProductCategoryDTO> getProductcategory() {
		return productcategory;
	}

	/**
	 * @param productcategory the productCategory to set
	 */
	public void setProductcategory(List<ProductCategoryDTO> productdata) {
		this.productcategory = productdata;
	}

}
