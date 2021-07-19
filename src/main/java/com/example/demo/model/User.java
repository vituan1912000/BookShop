package com.example.demo.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="customer")
public class User {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
private int uId;
private String uName;
private String email;
private String password;
@JoinColumn(name="bankId")
@OneToOne
private Bank bankId;
public User() {
	super();
	// TODO Auto-generated constructor stub
}
public User(int uId, String uName, String email, String password, Bank bankId) {
	super();
	this.uId = uId;
	this.uName = uName;
	this.email = email;
	this.password = password;
	this.bankId = bankId;
}
public int getuId() {
	return uId;
}
public void setuId(int uId) {
	this.uId = uId;
}
public String getuName() {
	return uName;
}
public void setuName(String uName) {
	this.uName = uName;
}
public String getEmail() {
	return email;
}
public void setEmail(String email) {
	this.email = email;
}
public String getPassword() {
	return password;
}
public void setPassword(String password) {
	this.password = password;
}
public Bank getBankId() {
	return bankId;
}
public void setBankId(Bank bankId) {
	this.bankId = bankId;
}

}
