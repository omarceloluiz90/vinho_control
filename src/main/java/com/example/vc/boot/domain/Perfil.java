package com.example.vc.boot.domain;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "perfil", schema = "public")
@Entity(name="Perfil")

public class Perfil implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Column(name = "pfl_id", nullable = false)
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "perfil_pfl_id_seq")
	@SequenceGenerator(name = "perfil_pfl_id_seq", allocationSize = 1)
	private Integer id;
	
	@Column(name = "pfl_dt_hr_cad", nullable = false)
	private LocalDate dataCadastro;
	
	@Column(name = "pfl_nome", length = 100, nullable = false, unique = true)
    private String nome;
	
	@Column(name = "pfl_observacao", length = 1000, nullable = true, unique = false)
	private String observacao;	
	
	@Column(name = "pfl_situacao", length = 1, nullable = false, unique = false)
    private String situacao;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name="pfl_fk_usr_id_cad", nullable = false)
    @JsonIgnore
    private Usuario UsuarioCad;
	
	@OneToMany(mappedBy = "perfilUsuario", fetch = FetchType.EAGER)
	@JsonIgnore
    private List<Usuario> usuarios;
	
	@OneToMany(mappedBy = "perfil", fetch = FetchType.EAGER)
	@JsonIgnore
    private List<PerfilAcesso> perfisacesso;
	
}
