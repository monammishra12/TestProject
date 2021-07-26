package com.example.demo.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.example.demo.dto.ProductCategoryDTO;
import com.sun.istack.NotNull;

@Entity
@Table(name = "product_category")
public class ProductCategory {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)

	@Column(name = "category_id")
	private long id;

	@NotNull
	@Column(name = "category_name")
	private String categoryName;

	@OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL, targetEntity = Product.class)
	@JoinColumn(name = "category_id")
	private List<Product> product;

	public ProductCategory() {
	}

	public ProductCategory(ProductCategoryDTO productCategoryDTO) {
		this.id = productCategoryDTO.getId();
		this.categoryName = productCategoryDTO.getCategoryName();
	}

	/**
	 * @return the the productCategoryId
	 */
	public long getId() {
		return id;
	}

	/**
	 * @param id the productCategoryId
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
	 * @return the product
	 */
	public List<Product> getProduct() {
		return product;
	}

	/**
	 * @param product the product to set
	 */
	public void setProduct(List<Product> product) {
		this.product = product;
	}

	@Override
	public String toString() {
		return "ProductCategory [id=" + id + ", categoryName=" + categoryName + ", product=" + product + "]";
	}

}
