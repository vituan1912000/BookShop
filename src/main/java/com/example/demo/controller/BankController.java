package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.example.demo.model.User;
import com.example.demo.repo.BankRepo;
import com.example.demo.repo.UserRepo;

@Controller
public class BankController {
	@Autowired
	private BankRepo repo;
	@Autowired
	private UserRepo urepo;
  @RequestMapping("/bank")
  public ModelAndView viewBank() {
	  ModelAndView model = new ModelAndView("index");
	  model.addObject("users", urepo.findAll());
	  return model;
  }
}
