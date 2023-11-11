package com.example.vc.boot.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.vc.boot.domain.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Integer> {

}
