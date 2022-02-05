package com.parking.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.parking.models.VehicleModel;

public interface VehicleRepository extends JpaRepository<VehicleModel, String>  {
	List<VehicleModel> findByidConductor(int idConductor);

}
