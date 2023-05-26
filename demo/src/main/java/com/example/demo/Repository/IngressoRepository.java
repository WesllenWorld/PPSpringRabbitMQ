package com.example.demo.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.Entity.Ingresso;

public interface IngressoRepository extends JpaRepository<Ingresso, Long> {
    
}