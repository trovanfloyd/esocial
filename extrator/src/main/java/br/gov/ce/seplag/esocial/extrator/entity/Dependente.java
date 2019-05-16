package br.gov.ce.seplag.esocial.extrator.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "tb_dependente_v2", schema = "db_esocial")
public class Dependente implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	@Column(name = "isn_dependente")
	private Long isnDependente;

	@Column(name = "tipo_dependente")
	private String tpDep;

	@Column(name = "txt_nome")
	private String nmDep;

	@Column(name = "dat_nascimento")
	private String dtNascto_dependente;

	@Column(name = "txt_cpf")
	private String cpfDep;

	@Column(name = "txt_dep_irrf")
	private String depIRRF;

	@Column(name = "txt_dep_sf")
	private String depSF;

	@Column(name = "txt_dep_plan")
	private String depPlan;

	@Column(name = "txt_inc_trab")
	private String incTrab;

	@ManyToOne
	@JoinColumn(name = "isn_s2200")
	private S2200 isnS2200;

	public String getNmDep() {
		return nmDep;
	}

	public void setNmDep(String nmDep) {
		this.nmDep = nmDep;
	}

	public String getTpDep() {
		return tpDep;
	}

	public void setTpDep(String tpDep) {
		this.tpDep = tpDep;
	}

	public String getDtNascto_dependente() {
		return dtNascto_dependente;
	}

	public void setDtNascto_dependente(String dtNascto_dependente) {
		this.dtNascto_dependente = dtNascto_dependente;
	}

	public String getCpfDep() {
		return cpfDep;
	}

	public void setCpfDep(String cpfDep) {
		this.cpfDep = cpfDep;
	}

	public String getDepIRRF() {
		return depIRRF;
	}

	public void setDepIRRF(String depIRRF) {
		this.depIRRF = depIRRF;
	}

	public String getDepSF() {
		return depSF;
	}

	public void setDepSF(String depSF) {
		this.depSF = depSF;
	}

	public String getDepPlan() {
		return depPlan;
	}

	public void setDepPlan(String depPlan) {
		this.depPlan = depPlan;
	}

	public String getIncTrab() {
		return incTrab;
	}

	public void setIncTrab(String incTrab) {
		this.incTrab = incTrab;
	}

}
