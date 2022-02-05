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

import com.parking.models.AdminModel;
import com.parking.models.UserModel;
import com.parking.repository.AdminRepository;
import com.parking.repository.UserRepository;

@RestController
@RequestMapping("/admin")
public class AdminController {
	
	@Autowired
	private AdminRepository adminRepository;
	
	@GetMapping("/all")
	public ResponseEntity<List<AdminModel>> FindAll(){
		List<AdminModel> admin = adminRepository.findAll();
		return ResponseEntity.ok(admin);
	}
	
	@RequestMapping(value="{cc}")
	public ResponseEntity<AdminModel> FindByAdmin(@PathVariable("cc") int cedula){
		Optional<AdminModel> optionalAdmin = adminRepository.findById(cedula);
		if(optionalAdmin.isPresent()){
			return ResponseEntity.ok(optionalAdmin.get());
		}else {
			return ResponseEntity.noContent().build();
		}
	}
	
	@PostMapping("/save")
	public ResponseEntity<AdminModel> CreateAdmin(@RequestBody AdminModel admin){
		AdminModel newAdmin = adminRepository.save(admin);
		return ResponseEntity.ok(newAdmin);
	}
	
	@DeleteMapping("/delete/{cc}")
	public ResponseEntity<Void> DeleteAdmin(@PathVariable("cc") int cedula){
		adminRepository.deleteById(cedula);
		return ResponseEntity.ok(null);
	}
	
	@PutMapping("update/{cc}")
	public ResponseEntity<AdminModel> UpdateUser(@RequestBody AdminModel admin){
		Optional<AdminModel> optionalAdmin = adminRepository.findById(admin.getCedula());
		if(optionalAdmin.isPresent()){
			AdminModel updateAdmin = optionalAdmin.get();
			//updateAdmin.setPassword(admin.getPassword());
			adminRepository.save(updateAdmin);
			return ResponseEntity.ok(updateAdmin);
		}else {
			return ResponseEntity.notFound().build();
		}
	}

}
