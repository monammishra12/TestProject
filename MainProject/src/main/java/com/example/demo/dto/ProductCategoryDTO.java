package com.example.demo.dto;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import com.example.demo.entity.ProductCategory;

public class ProductCategoryDTO {
	private long id;
	private String categoryName;
	private List<ProductDTO> productDto = new ArrayList<ProductDTO>();

	public ProductCategoryDTO() {
	}

	public ProductCategoryDTO(ProductCategory productCategory) {
		this.id = productCategory.getId();
		this.categoryName = productCategory.getCategoryName();
		this.productDto = productCategory.getProduct().stream().map(product -> new ProductDTO(product))
				.collect(Collectors.toList());
	}

	/**
	 * Create method to get all fields from Customer entity and set into
	 * ProductCategoryDTO entity.
	 * 
	 * @param newCategory
	 * 
	 * @return ProductCategoryDTO
	 */
	public static ProductCategoryDTO getProductCategoryDTO(ProductCategoryDTO newCategory) {
		ProductCategoryDTO categoryDTO = new ProductCategoryDTO();
		categoryDTO.setId(newCategory.getId());
		categoryDTO.setCategoryName(newCategory.getCategoryName());
		categoryDTO.setProductDto(newCategory.getProductDto());
		return categoryDTO;
	}

	/**
	 * @return the productCategoryId
	 */
	public long getId() {
		return id;
	}

	/**
	 * @param id the productCategoryId to set
	 */
	public void setId(long id) {
		this.id = id;
	}

	/**
	 * @return the categoryName
	 */
	public String getCategoryName() {
		return categoryName;
	}

	/**
	 * @param categoryName the categoryName to set
	 */
	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}

	/**
	 * @return the productDto
	 */
	public List<ProductDTO> getProductDto() {
		return productDto;
	}

	/**
	 * @param productDto the productDto to set
	 */
	public void setProductDto(List<ProductDTO> productDto) {
		this.productDto = productDto;
	}

	@Override
	public String toString() {
		return "ProductCategoryDTO [id=" + id + ", categoryName=" + categoryName + ", productDto=" + productDto + "]";
	}

}
