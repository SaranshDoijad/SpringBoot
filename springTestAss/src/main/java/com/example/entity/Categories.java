package com.example.entity;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name ="category")
public class Categories {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;
	
	@Column(name="categories")
	private String categories ;
	
	
	

	
		@OneToMany
		private List<Product> productList = new ArrayList<>();
	
	
	
	
	
	
	public Categories() {
		
	}
	
	public Categories(int id, String categories) {
		super();
		this.id = id;
		this.categories = categories;
	}
	
	
	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}
	public String getCategories() {
		return categories;
	}
	public void setCategories(String categories) {
		this.categories = categories;
	}
	


	@Override
	public String toString() {
		return "Categories [id=" + id + ", categories=" + categories + "]";
	}

	public void setProductList(List<Product> productList) {
		this.productList = productList;
	}
	
	
	

}
