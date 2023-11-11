package com.example.vc.boot.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.vc.boot.domain.Vinho;

public interface VinhoRepository extends JpaRepository<Vinho, Integer> {

}
