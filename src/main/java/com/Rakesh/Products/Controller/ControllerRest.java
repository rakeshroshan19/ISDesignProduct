package com.Rakesh.Products.Controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.Rakesh.Products.Model.ProductsDetails;
import com.Rakesh.Products.services.Services;

@RestController
@RequestMapping("/products")
//@CrossOrigin(origins = "http://localhost:3000")
public class ControllerRest {
	@Autowired
	Services services;
	
	// Api to add new product in the product table
	@PostMapping("/add")
	public boolean addProducts(@RequestBody ProductsDetails pDetails) {
		return services.addProducts(pDetails);
	}
	
	// Api to search product with similar product name
	@GetMapping("/search/{word}")
	public List<ProductsDetails> searchAll(@PathVariable("word") String word){
		return services.searchAll(word);
	}

	// Api to get details of all products (only for admin)
	@GetMapping("/all")
	public List<ProductsDetails> showAll(){
		return services.showAll();
	}
	
	// Api to get products based on their category
	@GetMapping("/category/{pCategory}")
	public List<ProductsDetails> categoryAll(@PathVariable("pCategory") String pCategory){
		return services.categoryAll(pCategory);
	}
	
	// Api to get a product details searched by its id
	@GetMapping("/id/{id}")
	public Optional<ProductsDetails> showId(@PathVariable("id") String id) {
		return services.showId(id);
	}
	
	@GetMapping("/name/{name}")
	public List<ProductsDetails> showName(@PathVariable("name") String name){
		return services.showName(name);
	}
	
	@PutMapping("/edit/{id}")
	public boolean editProduct(@RequestBody ProductsDetails pDetail) {
		return services.editProduct(pDetail);
	}
	
	@DeleteMapping("/delete/{id}")
	public boolean deleteProduct(@PathVariable("id") String id) {
		return services.deleteProduct(id);
	}
	@GetMapping("/idall")
	public List<ProductsDetails> allProdutsDetails(@RequestBody String pIdList[]) {
		return services.allProductsDetails(pIdList);
	}
}
