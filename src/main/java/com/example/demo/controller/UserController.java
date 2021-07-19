package com.example.demo.controller;



import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.example.demo.model.Material;
import com.example.demo.model.User;
import com.example.demo.repo.TestRepo;
import com.example.demo.repo.UserRepo;

@Controller
public class UserController {
	@Autowired
	private UserRepo repo;
	@Autowired
	private TestRepo bookRep;
	public List<Material> top4 = new ArrayList<Material>();
    private String message="";
	
     @RequestMapping("/")
     public String loginPage(Model model) {
    	 model.addAttribute("user", new User());
    	
    	 model.addAttribute("mess",message);
    	 return "login";
     }
     @RequestMapping("/login")
     public String login(HttpServletRequest req,Model model,RedirectAttributes red) {
    	 String email = req.getParameter("email");
    	 String pass = req.getParameter("pass");
    	 User u = repo.findByEmail(email);
    	
    	 if(u!=null) {
    		 if(u.getPassword().equals(pass)) {

    			 return "redirect:/loadBookShop?email="+email;
    		 }if(!u.getPassword().equals(pass)) {
    			 message="wrong password";
    			 model.addAttribute("message", message);
    			 return "redirect:/";
    		 }
    	 }
    	 if(u==null) {
    		 System.out.println("Not exitsted");
    		 message="Not exitsted";
    		 model.addAttribute("message", message);
    		 return "redirect:/";
    	 }
    	 return null;
     }
     
     @RequestMapping("loadBookShop")
     public String loadBookShop(Model model) {
    	 message="";
		 model.addAttribute("message", message);
		 model.addAttribute("users", repo.findAll());

         List<Material> allBooks = bookRep.findAll();
		 List<Material> top4 = new ArrayList<Material>();
		  top4.add(allBooks.get(0));
		  top4.add(allBooks.get(1));
		  top4.add(allBooks.get(2));
		  top4.add(allBooks.get(3));
			 model.addAttribute("books", top4);
			 model.addAttribute("comic", bookRep.findByCategory("comic"));
			 model.addAttribute("fiction", bookRep.findByCategory("fiction"));
			 model.addAttribute("politic", bookRep.findByCategory("politic"));
			 model.addAttribute("novel", bookRep.findByCategory("novel"));
			 return "bookShop";
     }
     
     
     
     
     @PostMapping(value = "/register",consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
     public String pre_register(@ModelAttribute User user) {
    	 List<User> allUsers = repo.findAll();
    	 boolean bl = true;
    	 for(User u : allUsers) {
    		 if(u.getEmail().equals(user.getEmail())) {
    			 bl = false;
    		 }
    	 }
    	 if(bl) {
			 repo.save(user);
			 return "redirect:/";
		 }else {
			 message ="email already existed";
			 return "redirect:/";
		 }
         	 
     }
     @GetMapping("/pre-update/{uId}")
     public String pre_update(@PathVariable int uId,Model model){
    	 User u = repo.findOneById(uId);
    	 model.addAttribute("u", u);
    	 return "update"; 
    	 }
     
     @PostMapping(value = "/update",consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
     public String update(@RequestParam int id ,@ModelAttribute User user) {
        User updateUser = repo.findById(id).orElse(null);
        System.out.println(user.getEmail());
        updateUser.setuName(user.getuName());
        updateUser.setEmail(user.getEmail());
        updateUser.setBankId(user.getBankId());
        updateUser.setPassword(user.getPassword());
        repo.save(updateUser);
    	 return "redirect:/";
     }
     
     @RequestMapping("/forgot")
     public String forgot() {
    	 return"";
     }
     @GetMapping("/logout")
     public String logout() {
    	 return "redirect:/";
     }
}
