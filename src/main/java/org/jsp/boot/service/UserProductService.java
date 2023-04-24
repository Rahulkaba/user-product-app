/**
 * 
 */
package org.jsp.boot.service;

import java.sql.PseudoColumnUsage;
import java.util.List;
import java.util.Optional;
import java.util.function.Predicate;
import java.util.stream.Collectors;

import org.jsp.boot.Exception.IdNotFoundException;
import org.jsp.boot.Repository.ProductRepository;
import org.jsp.boot.Repository.UserRepository;
import org.jsp.boot.dao.Productdao;
import org.jsp.boot.dao.Userdao;
import org.jsp.boot.dto.Product;
import org.jsp.boot.dto.ResponseStructure;
import org.jsp.boot.dto.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;

@Service
@SuppressWarnings("all")
public  class UserProductService {

	@Autowired
	private Productdao pdao;
	@Autowired
	private Userdao udao;




	public ResponseEntity<ResponseStructure<User,Product>> saveUserProduct(User user,Product product) {	
		ResponseStructure<User,Product> structure=new ResponseStructure<>();

		udao.saveUser(user);
		for (Product p:user.getProduct()){
			p.setUser(user);
		}
		structure.setBody(udao.saveUser(user));
		structure.setMessage("Saved Successfully");
		structure.setCode(HttpStatus.CREATED.value());

		return new ResponseEntity<ResponseStructure<User,Product>>(structure,HttpStatus.CREATED);
	}




	public ResponseEntity<ResponseStructure<User,Product>> saveProduct(Product product, int uid) {	
		ResponseStructure<User,Product> structure=new ResponseStructure<>();
		Optional<User> u=udao.findUserById(uid);

		if(u.isPresent()) {
			User user=u.get();
			product.setUser(user);
			structure.setBodyP(pdao.saveProduct(product));
			structure.setMessage("Saved Successfully");
			structure.setCode(HttpStatus.CREATED.value());
			return new ResponseEntity<ResponseStructure<User,Product>>(structure,HttpStatus.CREATED);
		}
		else 
			throw new IdNotFoundException();
	}



	public ResponseEntity<ResponseStructure<User,Product>> updateUserProduct(User user,Product product) {	
		ResponseStructure<User,Product> structure=new ResponseStructure<>();

		udao.saveUser(user);
		for (Product p:user.getProduct()){
			p.setUser(user);
		}
		structure.setBody(udao.saveUser(user));
		structure.setMessage("Saved Successfully");
		structure.setCode(HttpStatus.CREATED.value());
		

		return new ResponseEntity<ResponseStructure<User,Product>>(structure,HttpStatus.CREATED);
	}



	public ResponseEntity<ResponseStructure<User,Product>> fetchById(int id) {
		ResponseStructure<User,Product> structure=new ResponseStructure<>();
		Optional<User> us=udao.findUserById(id);

		if(us.isPresent())
		{
			structure.setBody(us.get());
			structure.setMessage("Details");
			structure.setCode(HttpStatus.FOUND.value());   
			return new ResponseEntity<ResponseStructure<User,Product>>(structure,HttpStatus.FOUND);      
		}
		else
			throw  new IdNotFoundException();	   
	}



	public ResponseEntity<ResponseStructure<List<User>, List<Product>>> fetchAllUserProducts() {
		ResponseStructure<List<User>, List<Product>> structure=new ResponseStructure<>();
		structure.setBody(udao.findAllUser());
		structure.setMessage("List of User and Products");
		structure.setCode(HttpStatus.FOUND.value());
		return new ResponseEntity<ResponseStructure<List<User>,List<Product>>>(structure,HttpStatus.FOUND);
	}




	public ResponseEntity<ResponseStructure<String,String>> deleteById(int id) {
		ResponseStructure<String,String> structure=new ResponseStructure<>();
		Optional<User> us=udao.findUserById(id);

		if(us.isPresent()){
			structure.setMessage("Deleted");
			structure.setCode(HttpStatus.OK.value());
			udao.deleteUser(us.get());
			return new ResponseEntity<ResponseStructure<String,String>>(structure,HttpStatus.OK);      
		}
		else
			throw  new IdNotFoundException();	   
	}
}
