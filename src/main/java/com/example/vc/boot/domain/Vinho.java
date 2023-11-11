package com.example.vc.boot.domain;

import java.io.Serializable;
import java.math.BigDecimal;
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
@Table(name = "vinho", schema = "public")
@Entity(name="Vinho")

public class Vinho implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Column(name = "vin_id", nullable = false)
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "vinho_vin_id_seq")
	@SequenceGenerator(name = "vinho_vin_id_seq", allocationSize = 1)
	private Integer id;
	
	@Column(name = "vin_dt_hr_cad", nullable = false)
    private LocalDate dataCadastro;
	
	@Column(name = "vin_nome", length = 100, nullable = false, unique = false)
    private String nome;
        
    @Column(name = "vin_cont_garrafa", precision = 6, scale = 3, nullable = false)
    private BigDecimal conteudoVolume;
    
    @Column(name = "vin_coment_som", length = 255, nullable = true, unique = false)
    private String comentario;
    
    @Column(name = "vin_tipo_uva", length = 60, nullable = true, unique = false)
    private String tipoUva;
    
    @Column(name = "vin_pais_regiao", length = 60, nullable = true, unique = false)
    private String paisRegiao;
    
    @Column(name = "vin_classificacao", length = 60, nullable = true, unique = false)
    private String classificacao;
    
    @Column(name = "vin_vinicola", length = 60, nullable = true, unique = false)
    private String vinicola;
    
    @Column(name = "vin_safra", nullable = true)
    private Integer safra;
    
    @Column(name = "vin_amadurecimento", length = 60, nullable = true, unique = false)
    private String amadurecimento;
    
    @Column(name = "vin_teor_acoolico", length = 60, nullable = true, unique = false)
    private String teorAlcoolico;
    
    @Column(name = "vin_temp_serv", nullable = true, unique = false)
    private Integer temperaturaServico;
    
    @Column(name= "vin_pot_guarda", length = 60, nullable = true, unique = false)
    private String potencialGuarda;
    
    @Column(name = "vin_olfativo", length = 60, nullable = true, unique = false)
    private String olfativo;
    
    @Column(name = "vin_visual", length = 60, nullable = true, unique = false)
    private String visual;
    
    @Column(name = "vin_gustativo", length = 60, nullable = true, unique = false)
    private String gustativo;
    
    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	@JoinColumn(name="vin_fk_usr_id_cad")
    @JsonIgnore
    private Usuario UsuarioCad;

}
