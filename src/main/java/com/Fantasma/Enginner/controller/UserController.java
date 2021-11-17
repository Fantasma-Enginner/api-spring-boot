package com.Fantasma.Enginner.controller;

import java.util.List;
import java.util.Optional;
import java.util.Spliterator;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.Fantasma.Enginner.entity.User;
import com.Fantasma.Enginner.service.UserService;

@RestController
@RequestMapping("/api/users")
public class UserController {
	
	@Autowired
	public UserService userService;
	
	//crate new user
	
	@PostMapping
    // importamos user de entity status prueva 201
	private ResponseEntity<?> crear (@RequestBody  User user){
		return ResponseEntity.status(HttpStatus.CREATED).body(userService.save(user));
	}
	
	//read edit user
	
	@GetMapping("/{id}")
	public ResponseEntity<?> read(@PathVariable(value = "id") Long userId){
		Optional<User> oUser = userService.findById(userId);
		
		if(!oUser.isPresent()) {
			return ResponseEntity.notFound().build();
		}
		
		return ResponseEntity.ok(oUser);
	}
	
	//update an user

	@PutMapping("/{id}")
	public ResponseEntity<?> update(@RequestBody User userDetails, @PathVariable(value = "id")  Long userId ){
		Optional<User> user = userService.findById(userId);
		
		if(!user.isPresent()) {
			return ResponseEntity.notFound().build();
		}
		
		user.get().setName(userDetails.getName());
		user.get().setSurname(userDetails.getSurname());
		user.get().setEmail(userDetails.getEmail());
		user.get().setEnabled(userDetails.getEnabled());
		
		return ResponseEntity.status(HttpStatus.CREATED).body(userService.save(user.get()));
	}
	
	//delete an user
	
	@DeleteMapping("/{id}")
	public ResponseEntity<?> delete(@PathVariable(value = "id") Long userId){
		
		//sino esta presente
		if(!userService.findById(userId).isPresent()) {
			return ResponseEntity.notFound().build();
		}
		
		userService.deleteById(userId);
		
		return ResponseEntity.ok().build();
	}
	
	//read all user
	
	@GetMapping
	
    public List<User> readAll(){
    	List<User> user = StreamSupport
    			   .stream(userService.findAll().spliterator(), false)
    			   .collect(Collectors.toList());
    	 return user;

    }
    
   
}
