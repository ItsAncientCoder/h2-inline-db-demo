package com.h2.demo.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.h2.demo.model.Alien;

public interface AlienRepository extends JpaRepository<Alien, Integer>{

}
