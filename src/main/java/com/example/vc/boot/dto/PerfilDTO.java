package com.example.vc.boot.dto;

import java.io.Serializable;

import com.example.vc.boot.domain.Perfil;

public class PerfilDTO implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private Integer id;
	private String nome;
	private String observacao;
	private String situacao;
	
	public PerfilDTO() {
		super();
		// TODO Auto-generated constructor stub
	}

	public PerfilDTO(Perfil iObj) {
		super();
		this.id = iObj.getId();
		this.nome = iObj.getNome();
		this.observacao = iObj.getObservacao();
		this.situacao = iObj.getSituacao();
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

	public String getObservacao() {
		return observacao;
	}

	public void setObservacao(String observacao) {
		this.observacao = observacao;
	}

	public String getSituacao() {
		return situacao;
	}

	public void setSituacao(String situacao) {
		this.situacao = situacao;
	}
	
}
