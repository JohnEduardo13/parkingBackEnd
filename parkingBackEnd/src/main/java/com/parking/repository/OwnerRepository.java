package com.parking.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.parking.models.OwnerModel;

public interface OwnerRepository extends JpaRepository<OwnerModel, Integer> {

}
