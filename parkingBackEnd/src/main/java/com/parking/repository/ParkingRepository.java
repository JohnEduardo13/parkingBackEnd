package com.parking.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.parking.models.ParkingModel;

public interface ParkingRepository extends JpaRepository<ParkingModel, Integer>  {

}
