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
import com.parking.repository.DriverRepository;

@RestController
@RequestMapping("/driver")
public class DriverController {
	
	@Autowired
	private DriverRepository driverRepository;
	
	@GetMapping("/all")
	public ResponseEntity<List<DriverModel>> FindAll(){
		List<DriverModel> driver = driverRepository.findAll();
		return ResponseEntity.ok(driver);
	}
	
	@RequestMapping(value="/id/{cc}")
	public ResponseEntity<DriverModel> FindByDriver(@PathVariable("cc") int cedula){
		Optional<DriverModel> optionalDriver = driverRepository.findById(cedula);
		if(optionalDriver.isPresent()){
			return ResponseEntity.ok(optionalDriver.get());
		}else {
			return ResponseEntity.noContent().build();
		}
	}
	
	@RequestMapping(value="/email/{correo}")
	public ResponseEntity<DriverModel> FindByEmail(@PathVariable("correo") String email){
		Optional<DriverModel> optionalDriver = driverRepository.findByEmail(email);
		if(optionalDriver.isPresent()){
			return ResponseEntity.ok(optionalDriver.get());
		}else {
			return ResponseEntity.noContent().build();
		}
	}
	
	@PostMapping("/save/{cc}")
	public ResponseEntity<DriverModel> CreateDriver(@RequestBody DriverModel driver){
		Optional<DriverModel> optionalDriver = driverRepository.findById(driver.getCedula());
		if(optionalDriver.isPresent()) {
			return ResponseEntity.badRequest().build();
		}else {
			DriverModel newDriver = driverRepository.save(driver);
			return ResponseEntity.ok(newDriver);
		}
	}
	
	@DeleteMapping("/delete/{cc}")
	public ResponseEntity<Void> DeleteDriver(@PathVariable("cc") int cedula){
		driverRepository.deleteById(cedula);
		return ResponseEntity.ok(null);
	}
	
	@PutMapping("update/{user}")
	public ResponseEntity<DriverModel> UpdateDriver(@RequestBody DriverModel driver){
		Optional<DriverModel> optionalDriver = driverRepository.findById(driver.getCedula());
		if(optionalDriver.isPresent()){
			DriverModel updateDriver = optionalDriver.get();
			//updateDriver.setPassword(user.getPassword());
			updateDriver.setNombre(driver.getNombre());
			updateDriver.setApellido(driver.getApellido());
			updateDriver.setTelefono(driver.getTelefono());
			driverRepository.save(updateDriver);
			return ResponseEntity.ok(updateDriver);
		}else {
			return ResponseEntity.notFound().build();
		}
	}

}
