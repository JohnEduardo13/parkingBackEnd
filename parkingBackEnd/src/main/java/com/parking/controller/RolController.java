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

import com.parking.models.DriverModel;
import com.parking.models.RolModel;
import com.parking.repository.DriverRepository;
import com.parking.repository.RolRepository;

@RestController
@RequestMapping("/rol")
public class RolController {
	@Autowired
	private RolRepository rolRepository;
	
	@GetMapping("/all")
	public ResponseEntity<List<RolModel>> FindAll(){
		List<RolModel> driver = rolRepository.findAll();
		return ResponseEntity.ok(driver);
	}
	
	@RequestMapping(value="{id}")
	public ResponseEntity<RolModel> FindByRol(@PathVariable("id") int id){
		Optional<RolModel> optionalRol = rolRepository.findById(id);
		if(optionalRol.isPresent()){
			return ResponseEntity.ok(optionalRol.get());
		}else {
			return ResponseEntity.noContent().build();
		}
	}
	
	@PostMapping("/save")
	public ResponseEntity<RolModel> CreateRol(@RequestBody RolModel rol){
		RolModel newRol = rolRepository.save(rol);
		return ResponseEntity.ok(newRol);
	}
	
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<Void> DeleteRol(@PathVariable("id") int id){
		rolRepository.deleteById(id);
		return ResponseEntity.ok(null);
	}
	
	@PutMapping("update/{user}")
	public ResponseEntity<RolModel> UpdateRol(@RequestBody RolModel rol){
		Optional<RolModel> optionalRol = rolRepository.findById(rol.getIdRol());
		if(optionalRol.isPresent()){
			RolModel updateRol = optionalRol.get();
			//updateDriver.setPassword(user.getPassword());
			rolRepository.save(updateRol);
			return ResponseEntity.ok(updateRol);
		}else {
			return ResponseEntity.notFound().build();
		}
	}

}
