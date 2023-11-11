package com.example.vc.boot.domain;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

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
import jakarta.persistence.OneToMany;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "usuario", schema = "public")
@Entity(name="Usuario")

public class Usuario implements Serializable {
	private static final long serialVersionUID = 1L;

	@Column(name = "usr_id", nullable = false)
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "usuario_usr_id_seq")
	@SequenceGenerator(name = "usuario_usr_id_seq", allocationSize = 1)
	private Integer id;
	
	@Column(name = "usr_dt_hr_cad", nullable = false)
	private LocalDate dataCadastro;
	
	@Column(name = "usr_usr_id_cad", nullable = true)
	private Integer idUsuarioCad;
	
	@Column(name = "usr_nome", length = 60, nullable = false, unique = false)
    private String nome;
	
	@Column(name = "usr_senha", length = 100, nullable = false, unique = false)
    private String senha; 
	
	@Column(name = "usr_situacao", length = 1, nullable = false, unique = false)
    private String situacao;
    
    @Column(name = "usr_observacao", length = 1000, nullable = true, unique = false)
    private String observacao;
    
    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	@JoinColumn(name="usr_fk_pfl_id")
    @JsonIgnore
    private Perfil perfilUsuario;
    
    @OneToMany(mappedBy = "UsuarioCad", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JsonIgnore
	private List<Perfil> Perfil = new ArrayList<Perfil>();
    
    @OneToMany(mappedBy = "UsuarioCad", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JsonIgnore
	private List<PerfilAcesso> PerfilAcesso = new ArrayList<PerfilAcesso>();
    
    @OneToMany(mappedBy = "UsuarioCad", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JsonIgnore
	private List<AcessoSistema> AcessoSistema = new ArrayList<AcessoSistema>();
	    
    @OneToMany(mappedBy = "UsuarioCad", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JsonIgnore
	private List<Adega> Adega = new ArrayList<Adega>();
    
    @OneToMany(mappedBy = "UsuarioCad", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JsonIgnore
	private List<Vinho> Vinho = new ArrayList<Vinho>();

}
