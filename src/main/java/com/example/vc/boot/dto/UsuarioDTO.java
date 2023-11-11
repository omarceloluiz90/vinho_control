package com.example.vc.boot.dto;

import java.io.Serializable;

import com.example.vc.boot.domain.Usuario;

public class UsuarioDTO implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private Integer id;
	private String nome;
	private String situacao;
	private Integer idPerfil;
	private String nomePerfil;
	
	public UsuarioDTO() {
		super();
		// TODO Auto-generated constructor stub
	}

	public UsuarioDTO(Usuario iObj) {
		super();
		this.id = iObj.getId();
		this.nome = iObj.getNome();
		this.situacao = iObj.getSituacao();
		this.setIdPerfil(iObj.getPerfilUsuario().getId());
		this.setNomePerfil(iObj.getPerfilUsuario().getNome());
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getSituacao() {
		return situacao;
	}

	public void setSituacao(String situacao) {
		this.situacao = situacao;
	}

	public Integer getIdPerfil() {
		return idPerfil;
	}

	public void setIdPerfil(Integer idPerfil) {
		this.idPerfil = idPerfil;
	}

	public String getNomePerfil() {
		return nomePerfil;
	}

	public void setNomePerfil(String nomePerfil) {
		this.nomePerfil = nomePerfil;
	}
	
}
