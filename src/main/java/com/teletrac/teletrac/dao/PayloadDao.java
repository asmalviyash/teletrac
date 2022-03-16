package com.teletrac.teletrac.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.teletrac.teletrac.entities.Payload;

@Repository
public interface PayloadDao extends JpaRepository<Payload, Long>{

}
