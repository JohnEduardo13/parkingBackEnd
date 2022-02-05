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

import com.parking.models.VehicleModel;
import com.parking.repository.VehicleRepository;

@RestController
@RequestMapping("/vehicle")
public class VehicleController {

	@Autowired
	private VehicleRepository vehicleRepository;
	
	@GetMapping("/all")
	public ResponseEntity<List<VehicleModel>> FindAll(){
		List<VehicleModel> driver = vehicleRepository.findAll();
		return ResponseEntity.ok(driver);
	}
	
	/*@RequestMapping(value="{Id}")
	public ResponseEntity<VehicleModel> FindByVehicle(@PathVariable("Id") String id){
		Optional<VehicleModel> optionalVehicle = vehicleRepository.findById(id);
		if(optionalVehicle.isPresent()){
			return ResponseEntity.ok(optionalVehicle.get());
		}else {
			return ResponseEntity.noContent().build();
		}
	}*/
	
	@RequestMapping(value="{Id}")
	public ResponseEntity<List<VehicleModel>> FindByVehicle(@PathVariable("Id") int id){
		List<VehicleModel> driver = vehicleRepository.findByidConductor(id);
		return ResponseEntity.ok(driver);
	}
	
	@PostMapping("/save")
	public ResponseEntity<VehicleModel> CreateVehicle(@RequestBody VehicleModel vehicle){
		VehicleModel newDriver = vehicleRepository.save(vehicle);
		return ResponseEntity.ok(newDriver);
	}
	
	@DeleteMapping("/delete/{placa}")
	public ResponseEntity<Void> DeleteVehicle(@PathVariable("placa") String placa){
		vehicleRepository.deleteById(placa);
		return ResponseEntity.ok(null);
	}
	
	@PutMapping("update/{placa}")
	public ResponseEntity<VehicleModel> UpdateVehicle(@RequestBody VehicleModel vehicle){
		Optional<VehicleModel> optionalVehicle = vehicleRepository.findById(vehicle.getPlaca());
		if(optionalVehicle.isPresent()){
			VehicleModel updateVehicle = optionalVehicle.get();
			//updateDriver.setPassword(user.getPassword());
			vehicleRepository.save(updateVehicle);
			return ResponseEntity.ok(updateVehicle);
		}else {
			return ResponseEntity.notFound().build();
		}
	}
}
