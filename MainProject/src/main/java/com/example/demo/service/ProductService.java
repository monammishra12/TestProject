package com.example.demo.service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dto.ProductAndCategoryDTO;
import com.example.demo.dto.ProductCategoryDTO;
import com.example.demo.dto.ProductDTO;
import com.example.demo.entity.Product;
import com.example.demo.repository.ProductCategoryRepository;
import com.example.demo.repository.ProductRepository;
import com.example.demo.utils.Common;

@Service
public class ProductService {
	private ProductRepository productRepository;

	@Autowired
	public ProductService(ProductRepository productRepository) {

		this.productRepository = productRepository;
	}

	@Autowired
	private ProductCategoryRepository productCategoryRepository;

	/**
	 * Method to get all products by price range.
	 * 
	 * @param fromPrice
	 * 
	 * @param toPrice
	 * 
	 * @return ProductPrice
	 * 
	 * @throws Exception
	 */
	public List<ProductDTO> getProduct(double fromPrice, double toPrice) throws Exception {
		if (fromPrice == 0L && toPrice == 0L) {
			throw new Exception("Please enter price value");
		}
		List<ProductDTO> productPrice = productRepository.findAllPrice(fromPrice, toPrice);
		if (fromPrice == toPrice || fromPrice >= toPrice) {
			throw new Exception(
					"Please enter diiferent price in 'fromPrice' and 'toPrice' OR Please enter min price in 'fromPrice' and max price in 'toPrice");
		} else {
			return productPrice;
		}

	}

	/**
	 * Method to get all product by name(if the name is not the same then return
	 * those products which have the same product company name)
	 * 
	 * @param productName
	 * 
	 * @throws Exception
	 * 
	 * @return ProductAndCategoryDTO
	 */
	public ProductAndCategoryDTO getProductName(String productName) throws Exception {
		ProductAndCategoryDTO productAndCategoryDTO = new ProductAndCategoryDTO();
		List<ProductCategoryDTO> productdata = null;	
		List<ProductDTO> product = productRepository.findByProductNameIgnoreCase(productName);
		if (product == null || product.isEmpty()) {
			productdata = productCategoryRepository.findByCategoryNameIgnoreCase(productName);
			if (productdata == null || productdata.isEmpty()) {
				throw new Exception("Product not found");
			} else {
				productAndCategoryDTO.setProductcategory(productdata);
				return productAndCategoryDTO;
			}
		}

		productAndCategoryDTO.setProduct(product);
		return productAndCategoryDTO;
	}

	/**
	 * Method to get all products which added in last 7 days.
	 * 
	 * @param date
	 * 
	 * @return list ofProductDTO
	 * 
	 * @throws Exception
	 */
	public List<ProductDTO> getProductRecords(String date) throws Exception {
		if (date == null || date.isEmpty()) {
			throw new Exception("please provide date");
		}
		LocalDate dateTime = Common.isConversionStringToLocalDate(date);
		LocalDate dateData = dateTime.minusDays(7);
		List<ProductDTO> productDetails = productRepository.findProductByDate(dateData, dateTime);
		return productDetails;
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
	public List<ProductDTO> findById(List<ProductDTO> updateQuantity) throws Exception {
		List<Product> productData = new ArrayList<>();
		for (ProductDTO product : updateQuantity) {
			Optional<Product> quantityData = productRepository.findById(product.getId());
			if (quantityData.isPresent()) {
				Product product2 = quantityData.get();
				product2.setProductQuantity(product.getProductQuantity());
				productData.add(product2);
			} else {
				throw new Exception("Record not found");
			}
		}
		productData = productRepository.saveAll(productData);

		return productData.stream().map(st -> new ProductDTO(st)).collect(Collectors.toList());
	}

}
