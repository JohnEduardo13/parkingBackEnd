package com.parking.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.parking.models.DriverModel;

public interface DriverRepository extends JpaRepository<DriverModel, Integer> {
	
	@Query("select d from DriverModel as d where d.correo = :email")
	Optional<DriverModel> findByEmail(@Param("email") String correo);
}
