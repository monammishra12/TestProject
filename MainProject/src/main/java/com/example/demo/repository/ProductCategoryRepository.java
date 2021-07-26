package com.example.demo.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import com.example.demo.dto.ProductCategoryDTO;
import com.example.demo.entity.ProductCategory;

/**
 * ProductCategoryRepository interface for entity productCategory
 * 
 * @author witty
 *
 */
public interface ProductCategoryRepository extends JpaRepository<ProductCategory, Long> {

	List<ProductCategoryDTO> findByCategoryNameIgnoreCase(String productCategory);

}
