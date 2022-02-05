package com.parking.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.parking.models.ParkingLotModel;

public interface ParkingLotRepository extends JpaRepository<ParkingLotModel, Integer> {

}