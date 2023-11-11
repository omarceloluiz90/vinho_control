package com.example.vc.boot.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.vc.boot.domain.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Integer> {
	@Query(value="select * from public.usuario where usr_nome=:nome and usr_senha=:senha", nativeQuery = true)
	public Usuario encontrarUsuarioPorNomeSenha(String nome, String senha);

}
