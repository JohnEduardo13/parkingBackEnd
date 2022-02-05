package com.parking.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.parking.models.UserModel;

public interface UserRepository extends JpaRepository<UserModel, String> {

}
