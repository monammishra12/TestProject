package com.example.demo.controller;

import java.util.List;
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
import com.example.demo.dto.ProductCategoryDTO;
import com.example.demo.entity.ProductCategory;
import com.example.demo.service.ProductCategoryService;
import springfox.documentation.annotations.ApiIgnore;

@ApiIgnore
@RestController
@RequestMapping("/productcategory")
public class ProductCategoryController {
	private ProductCategoryService productCategoryService;

	@Autowired
	public ProductCategoryController(ProductCategoryService productCategoryService) {
		this.productCategoryService = productCategoryService;
	}

	/**
	 * Method to create productCategory .
	 * 
	 * @param newCategory
	 * 
	 * @return list of ProductCategory
	 * 
	 * @throws Exception
	 */

	@PostMapping("/create")
	public ProductCategoryDTO createProduct(@RequestBody(required = false) ProductCategoryDTO newCategoryDTO)
			throws Exception {
		return productCategoryService.saveProductCategory(newCategoryDTO);
	}

	
	/**
	 * 
	 * 
	 * @param id
	 * 
	 * @return
	 */
	@DeleteMapping("/delete/{id}")
	public String deleteProduct(@PathVariable("id") long id) {
		return productCategoryService.deleteProduct(id);
	}

	/**
	 * Method to update productCategory records.
	 * 
	 * @param newCategory
	 * 
	 * @param id
	 * 
	 * @return updateCategoryDTO
	 * 
	 * @throws Exception
	 */
	@PutMapping("/update/{id}")
	public ProductCategoryDTO productUpdate(@RequestBody ProductCategoryDTO updateCategoryDTO) throws Exception {
		return productCategoryService.updateId(updateCategoryDTO);
	}

	/**
	 * Method to get all products by productCategory.
	 * 
	 * @param productCategory
	 * 
	 * @return list of ProductCategoryDTO
	 * 
	 * @throws Exception
	 */
	@GetMapping("/get/category")
	public List<ProductCategoryDTO> getOne(@RequestParam(required = false) String productCategory) throws Exception {
		return productCategoryService.getProduct(productCategory);
	}

	/**
	 * Method to get all products by productCategoryId.
	 * 
	 * @param id
	 * 
	 * @return productCategory
	 */
	@GetMapping("/get/{id}")
	ProductCategory getOne(@PathVariable("id") long id) {
		return productCategoryService.getProduct(id);
	}

	/**
	 * Method to get all products.
	 * 
	 * @return list of ProductCategoryDTO
	 */
	@GetMapping("/get/all")
	public List<ProductCategoryDTO> findAll() {
		return productCategoryService.getAll();
	}

}
