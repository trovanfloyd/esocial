package br.gov.ce.seplag.esocial.extrator.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import lombok.AccessLevel;
import lombok.Data;
import lombok.Setter;

@Entity
@Table(name = "tb_s1040", schema = "db_esocial")
@NamedQuery(name = "S1040.findAll", query = "SELECT s FROM S1040 s")
@Data
public class S1040 implements Serializable {
	
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name = "db_esocial.sq_pk_s1040", sequenceName = "db_esocial.sq_pk_s1040")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "db_esocial.sq_pk_s1040")
	@Column(name = "isn_s1040")
	private Long id;
	
	@OneToOne
	@JoinColumn(name = "arquivo_esocial_id")
	@Setter(value = AccessLevel.PUBLIC)
	private ArquivoEsocial arquivoEsocial;

	@Column(name="tpamb_ideevento")
	private String tpAmb;
	
	@Column(name="procemi_ideevento")
	private String procEmi;
	
	@Column(name="verproc_ideevento")
	private String verProc;
	
	@Column(name="tpinsc_ideempregador")
	private String tpInsc;
	
	@Column(name="nrinsc_ideempregador")
	private String nrInsc_ideEmpregador;
	
	@Column(name="codfuncao_idefuncao")
	private String codFuncao;
	
	@Column(name="inivalid_idefuncao")
	private String iniValid;
	
	@Column(name="fimvalid_idefuncao")
	private String fimValid;

	@Column(name="dscfuncao_dadosfuncao")
	private String dscFuncao;
	
	@Column(name="codcbo_dadosfuncao")
	private String codCBO;




}
	

	
