package com.example.demo.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="bank")
public class Bank {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
private int bankId;
public String bName;
private int number;
private double value;
public Bank() {
	super();
	// TODO Auto-generated constructor stub
}
public Bank(int bankId, String bName, int number, double value) {
	super();
	this.bankId = bankId;
	this.bName = bName;
	this.number = number;
	this.value = value;
}
public int getBankId() {
	return bankId;
}
public void setBankId(int bankId) {
	this.bankId = bankId;
}
public String getbName() {
	return bName;
}
public void setbName(String bName) {
	this.bName = bName;
}
public int getNumber() {
	return number;
}
public void setNumber(int number) {
	this.number = number;
}
public double getValue() {
	return value;
}
public void setValue(double value) {
	this.value = value;
}

}
