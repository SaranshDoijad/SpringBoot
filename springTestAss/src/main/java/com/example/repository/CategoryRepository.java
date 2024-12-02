package com.example.repository;

import org.springframework.data.jpa.repository.JpaRepository;


import com.example.entity.Categories;

public interface CategoryRepository extends JpaRepository<Categories, Integer>   {
	

}
