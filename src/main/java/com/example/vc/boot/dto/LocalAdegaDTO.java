package com.example.vc.boot.dto;

import java.io.Serializable;

import com.example.vc.boot.domain.LocalAdega;

public class LocalAdegaDTO implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private Integer id;
	private Integer adegaFileira;
	private Integer adegaColuna;
	private Integer adegaPosicao;
	private Integer codigoAdega;
	private String descricaoAdega;
	private String nomeVinho;
		
	public LocalAdegaDTO() {
		super();
		// TODO Auto-generated constructor stub
	}

	public LocalAdegaDTO(LocalAdega iObj) {
		super();
		this.id = iObj.getId();
		this.adegaFileira = iObj.getAdegaFileira();
		this.adegaColuna = iObj.getAdegaColuna();
		this.adegaPosicao = iObj.getAdegaPosicao();
		this.codigoAdega = iObj.getAdega().getCodigo();
		this.descricaoAdega = iObj.getAdega().getDescricao();
		this.nomeVinho = iObj.getVinho().getNome();
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getAdegaFileira() {
		return adegaFileira;
	}

	public void setAdegaFileira(Integer adegaFileira) {
		this.adegaFileira = adegaFileira;
	}

	public Integer getAdegaColuna() {
		return adegaColuna;
	}

	public void setAdegaColuna(Integer adegaColuna) {
		this.adegaColuna = adegaColuna;
	}

	public Integer getAdegaPosicao() {
		return adegaPosicao;
	}

	public void setAdegaPosicao(Integer adegaPosicao) {
		this.adegaPosicao = adegaPosicao;
	}

	public Integer getCodigoAdega() {
		return codigoAdega;
	}

	public void setCodigoAdega(Integer codigoAdega) {
		this.codigoAdega = codigoAdega;
	}

	public String getDescricaoAdega() {
		return descricaoAdega;
	}

	public void setDescricaoAdega(String descricaoAdega) {
		this.descricaoAdega = descricaoAdega;
	}

	public String getNomeVinho() {
		return nomeVinho;
	}

	public void setNomeVinho(String nomeVinho) {
		this.nomeVinho = nomeVinho;
	}
		
}
