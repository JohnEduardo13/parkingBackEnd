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

import com.parking.models.ParkingModel;
import com.parking.repository.ParkingRepository;

@RestController
@RequestMapping("/parking")
public class ParkingController {
	
	@Autowired
	private ParkingRepository parkingRepository;
	
	@GetMapping("/all")
	public ResponseEntity<List<ParkingModel>> FindAll(){
		List<ParkingModel> driver = parkingRepository.findAll();
		return ResponseEntity.ok(driver);
	}
	
	@RequestMapping(value="{id}")
	public ResponseEntity<ParkingModel> FindByParking(@PathVariable("id") int id){
		Optional<ParkingModel> optionalParking = parkingRepository.findById(id);
		if(optionalParking.isPresent()){
			return ResponseEntity.ok(optionalParking.get());
		}else {
			return ResponseEntity.noContent().build();
		}
	}
	
	@PostMapping("/save")
	public ResponseEntity<ParkingModel> CreateParking(@RequestBody ParkingModel parking){
		ParkingModel newParking = parkingRepository.save(parking);
		return ResponseEntity.ok(newParking);
	}
	
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<Void> DeleteParking(@PathVariable("id") int id){
		parkingRepository.deleteById(id);
		return ResponseEntity.ok(null);
	}
	
	@PutMapping("update/{user}")
	public ResponseEntity<ParkingModel> UpdateParking(@RequestBody ParkingModel parking){
		Optional<ParkingModel> optionalParking = parkingRepository.findById(parking.getIdParqueadero());
		if(optionalParking.isPresent()){
			ParkingModel updateParking = optionalParking.get();
			//updateDriver.setPassword(user.getPassword());
			parkingRepository.save(updateParking);
			return ResponseEntity.ok(updateParking);
		}else {
			return ResponseEntity.notFound().build();
		}
	}

}
