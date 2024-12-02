package com.example.entity;



import java.util.List;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;

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
@Table(name="product")
public class Product {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "prd_id")
	private int prd_id;
	@Column(name="prd_name")
	private String prd_name;
	
	
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name="category_id")
	
	private Categories categoriesObj;
	
	
	
	
	public int getPrd_id() {
		return prd_id;
	}
	public void setPrd_id(int prd_id) {
		this.prd_id = prd_id;
	}
	public String getPrd_name() {
		return prd_name;
	}
	public void setPrd_name(String prd_name) {
		this.prd_name = prd_name;
	}
	
	public Product() {
		
	}


	@Override
	public String toString() {
		return "Product [prd_id=" + prd_id + ", prd_name=" + prd_name + ", categoriesObj=" + categoriesObj + "]";
	}
	
	public Product(int prd_id, String prd_name, Categories categoriesObj) {
	super();
	this.prd_id = prd_id;
	this.prd_name = prd_name;
	this.categoriesObj = categoriesObj;
}
	
	public Categories getCategories() {
        return categoriesObj;
    }

    public void setCategories(Categories categoriesObj) {
        this.categoriesObj =  categoriesObj;
    }
	
}
