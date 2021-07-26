package com.example.demo.service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.demo.dto.ProductCategoryDTO;
import com.example.demo.dto.ProductDTO;
import com.example.demo.entity.Product;
import com.example.demo.entity.ProductCategory;
import com.example.demo.repository.ProductCategoryRepository;
import com.example.demo.utils.Common;

@Service
public class ProductCategoryService {
	private ProductCategoryRepository productCategoryRepository;

	@Autowired
	public ProductCategoryService(ProductCategoryRepository productCategoryRepository) {
		this.productCategoryRepository = productCategoryRepository;

	}

	/**
	 * Method to create ProductCategoryDTO.
	 * 
	 * @param productCategoryDTO
	 * 
	 * @return ProductCategoryDto
	 * 
	 * @throws Exception
	 */
	public ProductCategoryDTO saveProductCategory(ProductCategoryDTO newCategoryDTO) throws Exception {
		ProductCategory productCategory = new ProductCategory(newCategoryDTO);
		productCategory.setId(newCategoryDTO.getId());
		productCategory.setCategoryName(newCategoryDTO.getCategoryName());
		if (newCategoryDTO.getProductDto() != null && newCategoryDTO.getProductDto().size() > 0) {
			List<Product> products = new ArrayList<>();
			for (ProductDTO dto : newCategoryDTO.getProductDto()) {
				Product details = new Product();
				details.setProductName(dto.getProductName());
				details.setProductDescription(dto.getProductDescription());
				details.setProductPrice(Common.isConversionPrice(dto.getProductPrice()));
				if (dto.getDate() != null) {
					details.setDate(Common.isConversionStringToLocalDate(dto.getDate()));
				} else {
					LocalDate date = LocalDate.now();
					details.setDate(date);
				}
				if (dto.getDiscountPercent() < 100) {
					details.setDiscountPercent(Common.isConversionPrice(dto.getDiscountPercent()));
				} else {
					throw new Exception("Discount Percent is not possible to greater than or equal to 100");
				}
				if (dto.getProductPrice() != 0L) {
					if (dto.getDiscountPercent() != 0L) {
						details.setDiscountPrice(
								Common.isConversionPrice((100 - Common.isConversionPrice(dto.getDiscountPercent()))
										* Common.isConversionPrice(dto.getProductPrice()) / 100));
					} else {
						details.setDiscountPrice(dto.getProductPrice());
					}
				}
				details.setProductQuantity(dto.getProductQuantity());
				products.add(details);

			}
			productCategory.setProduct(products);
		}
		productCategory = productCategoryRepository.save(productCategory);
		System.out.println(productCategory);
		ProductCategoryDTO dto = new ProductCategoryDTO(productCategory);
		return dto;

	}

	/**
	 * Method to delete.
	 * 
	 * @param id
	 * 
	 */
	public String deleteProduct(long id) {
		if (productCategoryRepository.findById(id).isPresent()) {
			productCategoryRepository.deleteById(id);
			return "Record is deleted";
		}
		return "Record is not deleted";
	}

	/**
	 * Method to get all products by categoryName.
	 * 
	 * @param product_category
	 * 
	 * @return ProductCategoryDTO
	 * 
	 * @throws Exception
	 */
	public List<ProductCategoryDTO> getProduct(String productCategory) throws Exception {
		if (productCategory == null || productCategory.isEmpty()) {
			throw new Exception("Please provide name of product_category");
		}

		List<ProductCategoryDTO> productData = productCategoryRepository.findByCategoryNameIgnoreCase(productCategory);
		if (productData == null || productData.isEmpty()) {
			throw new Exception("Product not found");
		}
		return productData;

	}

	/**
	 * Method to update.
	 * 
	 * @param newCategory
	 * 
	 * @param id
	 * 
	 * @return ProductCategoryDto
	 * 
	 * @throws Exception
	 */

	public ProductCategoryDTO updateId(ProductCategoryDTO updateCategoryDTO) throws Exception {
		Optional<ProductCategory> productCategory = productCategoryRepository.findById(updateCategoryDTO.getId());
		if (productCategory.isPresent()) {
			ProductCategory category = productCategory.get();

			if (updateCategoryDTO.getCategoryName() != null) {
				category.setCategoryName(updateCategoryDTO.getCategoryName());
			}
			if (updateCategoryDTO.getProductDto() != null && updateCategoryDTO.getProductDto().size() > 0) {
				for (ProductDTO dto : updateCategoryDTO.getProductDto()) {
					for (Product data : category.getProduct()) {
						if (dto.getId() == data.getId()) {
							if (dto.getProductName() != null) {
								data.setProductName(dto.getProductName());
							}
							if (dto.getProductDescription() != null) {
								data.setProductDescription(dto.getProductDescription());
							}
							if (dto.getProductPrice() != 0L) {
								data.setProductPrice(dto.getProductPrice());

							}
							if (dto.getDate() != null) {
								data.setDate(Common.isConversionStringToLocalDate(dto.getDate()));
							}
							if (dto.getDiscountPercent() != 0L) {
								if(dto.getDiscountPercent() < 100)
								data.setDiscountPercent(Common.isConversionPrice(dto.getDiscountPercent()));
								else 
									throw new Exception("Discount Percent is not possible to greater than or equal to 100");
							}
							if (dto.getDiscountPrice() != 0L) {
								if (dto.getDiscountPercent() != 0L) {
									data.setDiscountPrice(Common.isConversionPrice(
											(100 - Common.isConversionPrice(dto.getDiscountPercent()))
													* Common.isConversionPrice(dto.getProductPrice()) / 100));
								} else {
									data.setDiscountPrice(dto.getProductPrice());
								}

							}
						}
					}
				}
			}
			category = productCategoryRepository.save(category);
			ProductCategoryDTO dto = new ProductCategoryDTO(category);
			return dto;
		} else {
			throw new Exception("not found ");
		}
	}

	/**
	 * Method to use get records using id.
	 * 
	 * @param id
	 * 
	 * @return ProductCategory
	 */
	public ProductCategory getProduct(long id) {
		Optional<ProductCategory> productData = productCategoryRepository.findById(id);
		return productData.get();
	}

	/**
	 * Method to get all productCategory records.
	 * 
	 * @return productCategoryDTO
	 */
	public List<ProductCategoryDTO> getAll() {
		List<ProductCategory> allCategory = productCategoryRepository.findAll();
		List<ProductCategoryDTO> allProducts = allCategory.stream().map(data -> new ProductCategoryDTO(data))
				.collect(Collectors.toList());
		return allProducts;

	}

}
