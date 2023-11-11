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
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
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
	
	@Column(name = "usr_usr_id_cad", nullable = false)
	private Integer idUsuarioCad;
	
	@Column(name = "usr_nome", length = 60, nullable = false, unique = true)
    private String nome;
	
	@Column(name = "usr_senha", length = 100, nullable = false, unique = false)
    private String senha; 
	
	@Column(name = "usr_situacao", length = 1, nullable = false, unique = false)
    private String situacao;
    
    @Column(name = "usr_observacao", length = 1000, nullable = true, unique = false)
    private String observacao;
    
    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name="usr_fk_pfl_id", nullable = false)
    @JsonIgnore
    private Perfil perfilUsuario;
    
    @OneToMany(mappedBy = "UsuarioCad", fetch = FetchType.EAGER)
    @JsonIgnore
    private List<Perfil> perfis;
    
    @OneToMany(mappedBy = "UsuarioCad", fetch = FetchType.EAGER)
    @JsonIgnore
    private List<Vinho> vinhos;
    
    @OneToMany(mappedBy = "UsuarioCad", fetch = FetchType.EAGER)
    @JsonIgnore
    private List<Adega> adegas;
    
    @OneToMany(mappedBy = "UsuarioCad", fetch = FetchType.EAGER)
    @JsonIgnore
    private List<AcessoSistema> acessosistema;
    
    @OneToMany(mappedBy = "UsuarioCad", fetch = FetchType.EAGER)
    @JsonIgnore
    private List<PerfilAcesso> perfisacesso;
    
    @OneToMany(mappedBy = "UsuarioCad", fetch = FetchType.EAGER)
    @JsonIgnore
    private List<LocalAdega> localadega;


}
