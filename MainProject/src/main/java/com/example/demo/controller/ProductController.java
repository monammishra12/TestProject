package com.example.demo.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.example.demo.dto.ProductAndCategoryDTO;
import com.example.demo.dto.ProductDTO;
import com.example.demo.service.ProductService;

@RestController
@RequestMapping("/product")
public class ProductController {
	private ProductService productService;

	@Autowired
	public ProductController(ProductService productService) {

		this.productService = productService;
	}

	/**
	 * Method to get all products by price range.
	 * 
	 * @param fromPrice
	 * 
	 * @param toPrice
	 * 
	 * @return the list of ProductDTO
	 * 
	 * @throws Exception
	 */
	@GetMapping("/get/price")
	public List<ProductDTO> getOne(@RequestParam(required = false) double fromPrice,
			@RequestParam(required = false) double toPrice) throws Exception {
		return productService.getProduct(fromPrice, toPrice);
	}

	/**
	 * Method to get the product by name.
	 * 
	 * @param productName
	 * 
	 * @return ProductAndCategoryDTO
	 * 
	 * @throws Exception
	 */
	@GetMapping("/get/name")
	public ProductAndCategoryDTO getProductName(@RequestParam(required = false) String productName) throws Exception {
		return productService.getProductName(productName);
	}

	/**
	 * Method to get all products which added in last 7 days.
	 * 
	 * @param date
	 * 
	 * @return list of ProductDTO
	 * 
	 * @throws Exception
	 */
	@GetMapping("/get/detail")
	public List<ProductDTO> getProductRecords(@RequestParam(required = false) String date) throws Exception {
		return productService.getProductRecords(date);
	}

	/**
	 * Method to update productQuantity by using productId.
	 * 
	 * @param updateQuantity
	 * 
	 * @return list of ProductDTO
	 * 
	 * @throws Exception
	 */
	@PutMapping("/update/quantity")
	public List<ProductDTO> get(@RequestBody List<ProductDTO> updateQuantity) throws Exception {
		return productService.findById(updateQuantity);
	}

}
