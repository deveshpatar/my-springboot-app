package com.devesh.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.devesh.entity.UserLogin;

public interface LoginRepository extends JpaRepository<UserLogin, String>{

}
