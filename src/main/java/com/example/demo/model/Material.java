package com.example.demo.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="material")
public class Material {
@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
private int id;
private String title;
private String category;
private double price;
private String image;


@JoinColumn(name="author_id")
@ManyToOne
private Author author_id;

public Author getAuthor_id() {
	return author_id;
}
public void setAuthor_id(Author author_id) {
	this.author_id = author_id;
}
public Material(int id, String title, String category, double price, String image, Author author_id) {
	super();
	this.id = id;
	this.title = title;
	this.category = category;
	this.price = price;
	this.image = image;
	this.author_id = author_id;
}
public Material() {
	super();
	// TODO Auto-generated constructor stub
}
public int getId() {
	return id;
}
public void setId(int id) {
	this.id = id;
}
public String getTitle() {
	return title;
}
public void setTitle(String title) {
	this.title = title;
}
public String getCategory() {
	return category;
}
public void setCategory(String category) {
	this.category = category;
}
public double getPrice() {
	return price;
}
public void setPrice(double price) {
	this.price = price;
}
public String getImage() {
	return image;
}
public void setImage(String image) {
	this.image = image;
}


}
