package com.example.controller;

import java.util.ArrayList;
import java.util.List;

import org.apache.el.stream.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.entity.Categories;
import com.example.repository.CategoryRepository;

@RestController
@RequestMapping("/api")
public class CategoryController {
	
	@Autowired
	CategoryRepository repo;
	
//	@GetMapping("/categories")
//	public ResponseEntity<List<Categories>> getAllCategory()
//	{
//		List<Categories> category = new ArrayList<>();
//		repo.findAll().forEach(category::add);
//		return new ResponseEntity<List<Categories>>(category,HttpStatus.OK);
//		
//	}
	
	@GetMapping("/categories")
	public List<Categories> getAllData()
	{
		return (List<Categories>) repo.findAll();
	}
	
	@PostMapping("/categories")
	public String createCategory(@RequestBody Categories categories)
	{
		repo.save(categories);
		return "Data add in database";
		
	}

	@GetMapping("/categories/{id}")
	public Categories getCategoryById(@PathVariable int id)
	{
		return  repo.findById(id).orElse(null);
	} 
	
	// UPDATE
    @PutMapping("/categories/{id}")
    public Categories updateEmployee(@PathVariable int id, @RequestBody Categories categories) 
    {
    	Categories categories1 = repo.findById(id).orElse(null);
        if(categories1 != null)
        {
        	categories1.setCategories(categories.getCategories());
        	return repo.save(categories1);
        }
    	
    	return null;
    }
    
    //Delete	
    @DeleteMapping("/categories/{id}")
    public String deleteCategories(@PathVariable int id)
    {
    	repo.deleteById(id);
    	return "categories is deleted";
    }
	
}
