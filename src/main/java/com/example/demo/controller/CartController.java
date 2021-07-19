package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.example.demo.model.Cart_Item;
import com.example.demo.model.Material;
import com.example.demo.model.User;
import com.example.demo.repo.BankRepo;
import com.example.demo.repo.CartItemRepo;
import com.example.demo.repo.TestRepo;
import com.example.demo.repo.UserRepo;

@Controller
public class CartController {
	@Autowired
	private CartItemRepo cartRepo;
	@Autowired
	private TestRepo bookRepo;
    @Autowired
    private BankRepo bankRepo;
    @Autowired
    private UserRepo userRepo;

	
  @GetMapping("/addToCart/{bookId}/{uId}")
 public String showCart(@PathVariable int bookId, @PathVariable int uId,Model model) {

	 Cart_Item existed = cartRepo.findByBookId(bookRepo.findById(bookId));
 
	  if(existed==null) {
		  Material book = new Material();
		  User user = new User();
	  book.setId(bookId);
	  user.setuId(uId);
	  existed = new Cart_Item();  
	  existed.setBookId(book);
	  existed.setuId(user);
	  existed.setQuantity(1);
	  existed.setTotal(bookRepo.findById(bookId).getPrice());
	  cartRepo.save(existed);
	
	  }else if(existed!=null) {
		  System.out.println("+1");
		  int i = existed.getQuantity();
		  existed.setQuantity(i+1);
		 existed.setTotal(existed.getQuantity()* bookRepo.findById(bookId).getPrice() );
		  cartRepo.save(existed);
	  }

		return "redirect:/loadBookShop";
 }
  @GetMapping("/viewCart")
   public String viewCart(Model model){

      model.addAttribute("cart",cartRepo.findAll() );
      model.addAttribute("book", bookRepo.findAll());
      
	  if(cartRepo.findAll().size() ==0) {
		  return "redirect:/loadBookShop";
	  }else {
	      model.addAttribute("sum", cartRepo.sumTotal());
	  }
	  return "home";
  }
  
  @GetMapping("/remove/{cartId}")
  public String removeFromCart(@PathVariable int cartId) {
	  Cart_Item cart = cartRepo.findByCartId(cartId);
	  cartRepo.delete(cart);
	  return "redirect:/viewCart";
  }
}
