package com.example.vc.boot.domain;

import java.io.Serializable;
import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "adega", schema = "public")
@Entity(name="Adega")

public class Adega implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Column(name = "adg_id", nullable = false)
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "adega_adg_id_seq")
	@SequenceGenerator(name = "adega_adg_id_seq", allocationSize = 1)
	private Integer id;
	
	@Column(name = "adg_dt_hr_cad", nullable = false)
	private LocalDate dataCadastro;
	
	@Column(name = "adg_codigo", nullable = true)
	private Integer codigo;
	
	@Column(name = "adg_descricao", length = 100, nullable = false, unique = true)
    private String descricao;
	
	@Column(name = "adg_nro_tot_fileira", nullable = false)
	private Integer totFileiras;
	
	@Column(name = "adg_nro_tot_coluna", nullable = false)
	private Integer totColunas;
	
	@Column(name = "adg_nro_tot_posicao", nullable = false)
	private Integer totPosicoes;
	
	@Column(name = "adg_observacao", length = 1000, nullable = true, unique = false)
	private String observacao;
	
	@Column(name = "adg_situacao", length = 1, nullable = false, unique = false)
    private String situacao;
	
	@ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	@JoinColumn(name="adg_fk_usr_id_cad")
    @JsonIgnore
    private Usuario UsuarioCad;

}
