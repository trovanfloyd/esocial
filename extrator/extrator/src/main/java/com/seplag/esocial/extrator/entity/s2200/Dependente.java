package com.seplag.esocial.extrator.entity.s2200;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "tb_dependente", schema = "db_esocial")
public class Dependente implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	@Column(name = "isn_dependente")
	private Long isnDependente;

	@Column(name = "txt_nome")
	private String nmdep;

	@Column(name = "dat_nascimento")
	private Date dtnasctodep;

	@Column(name = "txt_cpf")
	private String cpfdep;

	@Column(name = "txt_dep_irrf")
	private String depirrf;

	@Column(name = "txt_dep_sf")
	private String depsf;

	@Column(name = "txt_inc_trab")
	private String inctrab;

	@ManyToOne
	@JoinColumn(name = "isn_s2200")
	private S2200 isnS2200;

	@ManyToOne
	@JoinColumn(name = "isn_tipo_dependente")
	private TipoDependente tipoDep;

	public Long getIsnDependente() {
		return isnDependente;
	}

	public void setIsnDependente(Long isnDependente) {
		this.isnDependente = isnDependente;
	}

	public void setDtnasctodep(Date dtnasctodep) {
		this.dtnasctodep = dtnasctodep;
	}

	public String getNmdep() {
		return nmdep;
	}

	public void setNmdep(String nmdep) {
		this.nmdep = nmdep;
	}

	public String getCpfdep() {
		return cpfdep;
	}

	public void setCpfdep(String cpfdep) {
		this.cpfdep = cpfdep;
	}

	public String getDepirrf() {
		return depirrf;
	}

	public void setDepirrf(String depirrf) {
		this.depirrf = depirrf;
	}

	public String getDepsf() {
		return depsf;
	}

	public void setDepsf(String depsf) {
		this.depsf = depsf;
	}

	public String getInctrab() {
		return inctrab;
	}

	public void setInctrab(String inctrab) {
		this.inctrab = inctrab;
	}

	public S2200 getIsnS2200() {
		return isnS2200;
	}

	public void setIsnS2200(S2200 isnS2200) {
		this.isnS2200 = isnS2200;
	}

	public TipoDependente getTipoDep() {
		return tipoDep;
	}

	public void setTipoDep(TipoDependente tipoDep) {
		this.tipoDep = tipoDep;
	}

}
