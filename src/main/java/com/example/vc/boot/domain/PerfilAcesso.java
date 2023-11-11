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
@Table(name = "perfil_acesso_sistema", schema = "public")
@Entity(name="PerfilAcesso")

public class PerfilAcesso implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Column(name = "pas_id", nullable = false)
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "perfil_acesso_sistema_pas_id_seq")
	@SequenceGenerator(name = "perfil_acesso_sistema_pas_id_seq", allocationSize = 1)
	private Integer id;
	
	@Column(name = "pas_dt_hr_cad", nullable = false)
	private LocalDate dataCadastro;
	
	@Column(name = "pas_fk_pfl_id", nullable = false)
	private Integer idPerfilAcesso;
	
	@Column(name = "pas_fk_asi_id", nullable = false)
	private Integer idAcessoSitema;
	
	@Column(name = "pas_acessar", length = 1, nullable = false)
    private String podeAcessar;
	
	@Column(name = "pas_editar", length = 1, nullable = false)
    private String podeEditar;
	
	@Column(name = "pas_excluir", length = 1, nullable = false)
    private String podeExcluir;
	
	@ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	@JoinColumn(name="pas_fk_usr_id_cad")
    @JsonIgnore
    private Usuario UsuarioCad;

}
