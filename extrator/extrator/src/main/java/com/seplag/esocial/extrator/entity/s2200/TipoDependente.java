package com.seplag.esocial.extrator.entity.s2200;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "tb_07_tipo_dependente", schema = "db_esocial")
public class TipoDependente implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	@Column(name = "isn_tipo_dependente")
	private Long isnTipoDependente;

	@Column(name = "txt_tipo_dependente")
	private String tipoDep;

	public Long getIsnTipoDependente() {
		return isnTipoDependente;
	}

	public void setIsnTipoDependente(Long isnTipoDependente) {
		this.isnTipoDependente = isnTipoDependente;
	}

	public String getTipoDep() {
		return tipoDep;
	}

	public void setTipoDep(String tipoDep) {
		this.tipoDep = tipoDep;
	}

}
