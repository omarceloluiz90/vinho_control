package com.example.vc.boot.domain;

import java.io.Serializable;
import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "local_vinho_adega", schema = "public")
@Entity(name="LocalAdega")

public class LocalAdega implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Column(name = "lva_id", nullable = false)
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "local_vinho_adega_lva_id_seq")
	@SequenceGenerator(name = "local_vinho_adega_lva_id_seq", allocationSize = 1)
	private Integer id;
	
	@Column(name = "lva_dt_hr_cad", nullable = false)
	private LocalDate dataCadastro;
	
	@Column(name = "lva_fk_usr_id_cad", nullable = false)
	private Integer idUsuarioCad;
	
	@Column(name = "lva_fk_vin_id", nullable = false)
	private Integer idVinho;
	
	@Column(name = "lva_fk_adg_id", nullable = false)
	private Integer idAdega;
	
	@Column(name = "lva_adg_nro_fileira", nullable = false)
	private Integer adegaFileira;
	
	@Column(name = "lva_adg_nro_coluna", nullable = false)
	private Integer adegaColuna;
	
	@Column(name = "lva_adg_nro_posicao", nullable = false)
	private Integer adegaPosicao;

}
