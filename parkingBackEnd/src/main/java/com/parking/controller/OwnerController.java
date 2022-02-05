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
import com.parking.models.OwnerModel;
import com.parking.repository.DriverRepository;
import com.parking.repository.OwnerRepository;

@RestController
@RequestMapping("/owner")
public class OwnerController {
	
	@Autowired
	private OwnerRepository ownerRepository;
	
	@GetMapping("/all")
	public ResponseEntity<List<OwnerModel>> FindAll(){
		List<OwnerModel> driver = ownerRepository.findAll();
		return ResponseEntity.ok(driver);
	}
	
	@RequestMapping(value="{cc}")
	public ResponseEntity<OwnerModel> FindByOwner(@PathVariable("cc") int cedula){
		Optional<OwnerModel> optionalOwner = ownerRepository.findById(cedula);
		if(optionalOwner.isPresent()){
			return ResponseEntity.ok(optionalOwner.get());
		}else {
			return ResponseEntity.noContent().build();
		}
	}
	
	@PostMapping("/save")
	public ResponseEntity<OwnerModel> CreateOwner(@RequestBody OwnerModel owner){
		OwnerModel newOwner = ownerRepository.save(owner);
		return ResponseEntity.ok(newOwner);
	}
	
	@DeleteMapping("/delete/{cc}")
	public ResponseEntity<Void> DeleteOwner(@PathVariable("cc") int cedula){
		ownerRepository.deleteById(cedula);
		return ResponseEntity.ok(null);
	}
	
	@PutMapping("update/{user}")
	public ResponseEntity<OwnerModel> UpdateUser(@RequestBody OwnerModel owner){
		Optional<OwnerModel> optionalOwner = ownerRepository.findById(owner.getCedula());
		if(optionalOwner.isPresent()){
			OwnerModel updateOwner = optionalOwner.get();
			//updateDriver.setPassword(user.getPassword());
			ownerRepository.save(updateOwner);
			return ResponseEntity.ok(updateOwner);
		}else {
			return ResponseEntity.notFound().build();
		}
	}

}
