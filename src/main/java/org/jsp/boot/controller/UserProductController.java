/**
 * 
 */
package org.jsp.boot.controller;

import java.util.List;

import org.jsp.boot.dto.Product;
import org.jsp.boot.dto.ResponseStructure;
import org.jsp.boot.dto.User;
import org.jsp.boot.service.UserProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin("http://localhost:3000")
public class UserProductController {

	@Autowired
	private UserProductService service;



	@PostMapping("/product")
	public ResponseEntity<ResponseStructure<User,Product>> saveUserProduct(@RequestBody User user,Product product){

		return service.saveUserProduct(user, product); 
	}


	@PostMapping("/product/{id}")
	public ResponseEntity<ResponseStructure<User,Product>> saveProduct(@RequestBody Product product , @PathVariable("id") int id){

		return service.saveProduct(product,id); 
	}


	@PutMapping("/product")
	public ResponseEntity<ResponseStructure<User,Product>> updateUserProduct(@RequestBody User user,Product product){

		return service.updateUserProduct(user, product); 
	}

	@GetMapping("/product/{id}")
	public ResponseEntity<ResponseStructure<User,Product>> fetchById(@PathVariable("id") int id){

		return service.fetchById(id);
	}

	@GetMapping("/product")
	public ResponseEntity<ResponseStructure<List<User>, List<Product>>> fetchAllUserProducts(){
		return service.fetchAllUserProducts(); 
	}


	@DeleteMapping("/product/{id}")
	public ResponseEntity<ResponseStructure<String,String>> deleteUserProducts(@PathVariable("id")int id) {
		return service.deleteById(id);
	}

}
