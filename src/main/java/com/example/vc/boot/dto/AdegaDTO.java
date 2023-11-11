package com.example.vc.boot.dto;

import java.io.Serializable;

import com.example.vc.boot.domain.Adega;

public class AdegaDTO implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private Integer id;
	private Integer codigo;
	private String descricao;
	private Integer totFileiras;
	private Integer totColunas;
	private Integer totPosicoes;
	private String observacao;
	private String situacao;
	
	public AdegaDTO() {
		super();
		// TODO Auto-generated constructor stub
	}

	public AdegaDTO(Adega iObj) {
		super();
		this.id = iObj.getId();
		this.codigo = iObj.getCodigo();
		this.descricao = iObj.getDescricao();
		this.totFileiras = iObj.getTotFileiras();
		this.totColunas = iObj.getTotColunas();
		this.totPosicoes = iObj.getTotPosicoes();
		this.observacao = iObj.getObservacao();
		this.situacao = iObj.getSituacao();
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getCodigo() {
		return codigo;
	}

	public void setCodigo(Integer codigo) {
		this.codigo = codigo;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public Integer getTotFileiras() {
		return totFileiras;
	}

	public void setTotFileiras(Integer totFileiras) {
		this.totFileiras = totFileiras;
	}

	public Integer getTotColunas() {
		return totColunas;
	}

	public void setTotColunas(Integer totColunas) {
		this.totColunas = totColunas;
	}

	public Integer getTotPosicoes() {
		return totPosicoes;
	}

	public void setTotPosicoes(Integer totPosicoes) {
		this.totPosicoes = totPosicoes;
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
