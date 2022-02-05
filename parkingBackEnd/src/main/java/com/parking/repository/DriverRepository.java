package com.parking.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.parking.models.DriverModel;

public interface DriverRepository extends JpaRepository<DriverModel, Integer> {

}
