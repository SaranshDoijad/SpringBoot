package com.example.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.entity.Categories;
import com.example.entity.Product;
import com.example.repository.CategoryRepository;
import com.example.repository.ProductRepository;

@RestController
@RequestMapping("/api")
public class ProductController {
	
	@Autowired
	ProductRepository repo;
	
	@Autowired
	CategoryRepository cRepo;
	
	@GetMapping("/product") 
	public List<Product> getAllData()
	{
		return (List<Product>) repo.findAll();
	}
	
	@PostMapping("/product")
	public String addData(@RequestBody Product product)
	{
		repo.save(product);
		return "Data add successfull";
	}
	
	

	@GetMapping("/product/{id}")
	public Product getById(@PathVariable int id)
	{
		return  repo.findById(id).orElse(null);
		
	}
	
	@PutMapping("/product/{id}")
	public Product updateProduct(@PathVariable int id, @RequestBody Product product)
	{
		Product product1 = repo.findById(id).orElse(product);
		if(product1 != null)
		{
			product1.setPrd_name(product.getPrd_name());
			return repo.save(product1);
		}
		return null;
		
	}
	
	@DeleteMapping("/product/{id}")
	public String deleteData(@PathVariable int id)
	{
		repo.deleteById(id);
		return "deleted successful";
	}

}
