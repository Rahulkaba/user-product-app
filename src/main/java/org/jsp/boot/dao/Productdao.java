/**
 * 
 */
package org.jsp.boot.dao;

import java.util.List;
import java.util.Optional;

import org.jsp.boot.Repository.ProductRepository;
import org.jsp.boot.dto.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class Productdao {
    
	@Autowired
	private ProductRepository repository;
	
	public Product saveProduct(Product product) {	
		return repository.save(product);
	}
	
	public Product updateProduct(Product product) {	
		return repository.save(product);
	}
	
	public Optional<Product> fetchByProductId(int id) {
		return repository.findById(id);
	}
	
	public List<Product> fetchAllProduct() {
		 return repository.findAll();
	}
	
	public void deleteProduct(Product product) {
	      repository.delete(product);
	}
}
