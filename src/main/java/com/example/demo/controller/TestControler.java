package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.repo.CartItemRepo;
import com.example.demo.repo.TestRepo;

@RestController
public class TestControler {
@Autowired
private TestRepo rep;
@Autowired
private CartItemRepo cart;
@GetMapping("asd")
public List ad() {
	return rep.findAll();
}
}
