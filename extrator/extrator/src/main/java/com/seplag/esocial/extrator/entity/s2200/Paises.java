package com.seplag.esocial.extrator.entity.s2200;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "tb_06_paises", schema = "db_esocial")
public class Paises implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	@Column(name = "isn_pais")
	private Long isnPais;

	@Column(name = "txt_pais")
	private String pais;

	@Column(name = "dat_criacao")
	private Date datCriacao;

	@Column(name = "dat_extincao")
	private Date datExtincao;

	public Long getIsnPais() {
		return isnPais;
	}

	public void setIsnPais(Long isnPais) {
		this.isnPais = isnPais;
	}

	public String getPais() {
		return pais;
	}

	public void setPais(String pais) {
		this.pais = pais;
	}

	public Date getDatCriacao() {
		return datCriacao;
	}

	public void setDatCriacao(Date datCriacao) {
		this.datCriacao = datCriacao;
	}

	public Date getDatExtincao() {
		return datExtincao;
	}

	public void setDatExtincao(Date datExtincao) {
		this.datExtincao = datExtincao;
	}

}
