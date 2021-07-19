package com.example.demo.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="author")
public class Author {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
private int author_id;
private String author_name;
public Author() {
	super();
	// TODO Auto-generated constructor stub
}
public Author(int author_id, String author_name) {
	super();
	this.author_id = author_id;
	this.author_name = author_name;
}
public int getAuthor_id() {
	return author_id;
}
public void setAuthor_id(int author_id) {
	this.author_id = author_id;
}
public String getAuthor_name() {
	return author_name;
}
public void setAuthor_name(String author_name) {
	this.author_name = author_name;
}

}
