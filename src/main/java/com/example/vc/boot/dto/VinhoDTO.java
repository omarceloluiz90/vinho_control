package com.example.vc.boot.dto;

import java.io.Serializable;
import java.math.BigDecimal;

import com.example.vc.boot.domain.Vinho;

public class VinhoDTO implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private Integer id;
	private String nome;
	private BigDecimal conteudoVolume;
	private String tipoUva;
	private Integer safra;
	private String teorAlcoolico;
	private Integer temperaturaServico;
	
	public VinhoDTO() {
		super();
		// TODO Auto-generated constructor stub
	}

	public VinhoDTO(Vinho iObj) {
		super();
		this.id = iObj.getId();
		this.nome = iObj.getNome();
		this.conteudoVolume = iObj.getConteudoVolume();
		this.tipoUva = iObj.getTipoUva();
		this.safra = iObj.getSafra();
		this.teorAlcoolico = iObj.getTeorAlcoolico();
		this.temperaturaServico = iObj.getTemperaturaServico();
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

	public BigDecimal getConteudoVolume() {
		return conteudoVolume;
	}

	public void setConteudoVolume(BigDecimal conteudoVolume) {
		this.conteudoVolume = conteudoVolume;
	}

	public String getTipoUva() {
		return tipoUva;
	}

	public void setTipoUva(String tipoUva) {
		this.tipoUva = tipoUva;
	}

	public Integer getSafra() {
		return safra;
	}

	public void setSafra(Integer safra) {
		this.safra = safra;
	}

	public String getTeorAlcoolico() {
		return teorAlcoolico;
	}

	public void setTeorAlcoolico(String teorAlcoolico) {
		this.teorAlcoolico = teorAlcoolico;
	}

	public Integer getTemperaturaServico() {
		return temperaturaServico;
	}

	public void setTemperaturaServico(Integer temperaturaServico) {
		this.temperaturaServico = temperaturaServico;
	}
	
}
