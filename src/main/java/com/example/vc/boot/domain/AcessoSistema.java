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
@Table(name = "acesso_sistema", schema = "public")
@Entity(name="AcessoSistema")

public class AcessoSistema implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Column(name = "asi_id", nullable = false)
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "acesso_sistema_asi_id_seq")
	@SequenceGenerator(name = "acesso_sistema_asi_id_seq", allocationSize = 1)
	private Integer id;
	
	@Column(name = "asi_dt_hr_cad", nullable = false)
	private LocalDate dataCadastro;
	
	@Column(name = "asi_descricao", length = 60, nullable = false, unique = true)
    private String descricao;
	
	@ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	@JoinColumn(name="asi_fk_usr_id_cad")
    @JsonIgnore
    private Usuario UsuarioCad;

}
