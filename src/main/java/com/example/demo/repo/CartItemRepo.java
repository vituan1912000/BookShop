package com.example.demo.repo;



import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.demo.model.Cart_Item;
import com.example.demo.model.Material;

public interface CartItemRepo extends JpaRepository<Cart_Item, Integer>{
	@Query("select c from Cart_Item c where uId = :uId")
   public Cart_Item findByUId(@Param("uId") int uId);
	   public Cart_Item findByBookId( Material id);
	   
	   public Cart_Item findByCartId(int cartId);
	   @Query("select sum(total) from Cart_Item")
	   public double sumTotal();
     @Query("select c from Cart_Item c where uId = :uId")
	   public List<Cart_Item> findAllByUId(@Param("uId") int uId);
	  
}
