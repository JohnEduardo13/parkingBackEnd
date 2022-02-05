package com.parking.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.parking.models.AdminModel;


public interface AdminRepository extends JpaRepository<AdminModel, Integer> {

}
