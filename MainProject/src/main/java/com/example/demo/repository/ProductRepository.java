package com.example.demo.repository;

import java.time.LocalDate;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import com.example.demo.dto.ProductDTO;
import com.example.demo.entity.Product;

/**
 * ProductRepository interface for entity product
 * 
 * @author witty
 *
 */

public interface ProductRepository extends JpaRepository<Product, Long> {

	@Query("SELECT P FROM Product P WHERE P.productPrice BETWEEN :fromPrice AND :toPrice ")
	List<ProductDTO> findAllPrice(double fromPrice, double toPrice);

	List<ProductDTO> findByProductNameIgnoreCase(String productName);

	@Query("SELECT P FROM Product P WHERE P.date BETWEEN  :fromDate AND :toDate ")
	List<ProductDTO> findProductByDate(LocalDate fromDate, LocalDate toDate);

}
