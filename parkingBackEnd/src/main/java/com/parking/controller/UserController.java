package com.parking.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.parking.models.UserModel;
import com.parking.repository.UserRepository;

@RestController
@RequestMapping("/user")
public class UserController {
	
	@Autowired
	private UserRepository userRepository;
	
	@GetMapping("/all")
	public ResponseEntity<List<UserModel>> FindAll(){
		List<UserModel> users = userRepository.findAll();
		return ResponseEntity.ok(users);
	}
	
	@RequestMapping(value="{user}")
	public ResponseEntity<UserModel> FindByUser(@PathVariable("user") String user){
		Optional<UserModel> optionalUser = userRepository.findById(user);
		if(optionalUser.isPresent()){
			return ResponseEntity.ok(optionalUser.get());
		}else {
			return ResponseEntity.noContent().build();
		}
	}
	
	@PostMapping("/save/{email}")
	public ResponseEntity<UserModel> CreateUser(@RequestBody UserModel user){
		Optional<UserModel> optionalUser = userRepository.findById(user.getUsuario());
		if(optionalUser.isPresent()) {
			return ResponseEntity.badRequest().build();
		}else {
			UserModel newUser = userRepository.save(user);
			return ResponseEntity.ok(newUser);
		}
	}
	
	@DeleteMapping("/delete/{user}")
	public ResponseEntity<Void> DeleteUser(@PathVariable("user") String user){
		userRepository.deleteById(user);
		return ResponseEntity.ok(null);
	}
	
	@PutMapping("update/{user}")
	public ResponseEntity<UserModel> UpdateUser(@RequestBody UserModel user){
		Optional<UserModel> optionalUser = userRepository.findById(user.getUsuario());
		if(optionalUser.isPresent()){
			UserModel updateUser = optionalUser.get();
			updateUser.setPassword(user.getPassword());
			userRepository.save(updateUser);
			return ResponseEntity.ok(updateUser);
		}else {
			return ResponseEntity.notFound().build();
		}
	}
}
