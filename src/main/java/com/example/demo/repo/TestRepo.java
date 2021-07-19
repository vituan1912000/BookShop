package com.example.demo.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.model.Material;


public interface TestRepo extends JpaRepository<Material, Integer>{
 public Material findById(int bookId);
 public List<Material> findByCategory(String category);
}
