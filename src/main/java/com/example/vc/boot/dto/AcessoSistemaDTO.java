package com.example.vc.boot.dto;

import java.io.Serializable;

import com.example.vc.boot.domain.AcessoSistema;

public class AcessoSistemaDTO implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private Integer id;
	private String descricao;
	
	public AcessoSistemaDTO() {
		super();
		// TODO Auto-generated constructor stub
	}

	public AcessoSistemaDTO(AcessoSistema iObj) {
		super();
		this.id = iObj.getId();
		this.descricao = iObj.getDescricao();
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	
}
