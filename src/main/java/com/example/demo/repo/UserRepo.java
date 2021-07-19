package com.example.demo.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.demo.model.User;

public interface UserRepo extends JpaRepository<User, Integer>{
	  @Query("select u from User u where email = :email")
	   public User findByEmail(@Param("email")String email);
	 @Query("select u from User u where uId =:uId")
	 public User findOneById(@Param("uId")int id);
	 
}
