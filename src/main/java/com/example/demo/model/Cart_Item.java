
package com.example.demo.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="cart_item")
public class Cart_Item {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int cartId;
	private int quantity;
    private double total;
	@ManyToOne
	@JoinColumn(name="uId")
	private User uId;
	@ManyToOne
	@JoinColumn(name="bookId")
	private Material bookId;
	public Cart_Item(int cartId, User uId, Material bookId) {
		super();
		this.cartId = cartId;
		this.uId = uId;
		this.bookId = bookId;
	}
	public Cart_Item() {
		super();
		// TODO Auto-generated constructor stub
	}
	public int getCartId() {
		return cartId;
	}
	public void setCartId(int cartId) {
		this.cartId = cartId;
	}
	public User getuId() {
		return uId;
	}
	public void setuId(User uId) {
		this.uId = uId;
	}
	public Material getBookId() {
		return bookId;
	}
	public void setBookId(Material bookId) {
		this.bookId = bookId;
	}
	
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public double getTotal() {
		return total;
	}
	public void setTotal(double total) {
		this.total = total;
	}

}
