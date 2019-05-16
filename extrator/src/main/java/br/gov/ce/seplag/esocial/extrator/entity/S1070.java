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
@Table(name = "tb_s1050", schema = "db_esocial")
@NamedQuery(name = "S1070.findAll", query = "SELECT s FROM S1070 s")
@Data
public class S1070 implements Serializable {
	
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name = "db_esocial.sq_pk_s1070", sequenceName = "db_esocial.sq_pk_s1070")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "db_esocial.sq_pk_s1070")
	@Column(name = "isn_s1070")
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
	
	@Column(name="inivalid_ideprocesso")
	private String iniValid;
	
	@Column(name="fimvalid_ideprocesso")
	private String fimValid;
	
	@Column(name="idvara_dadosprocjud")
	private String idVara;

	@Column(name="indautoria_dadosproc")
	private String indAutoria;

	@Column(name="inddeposito_infosusp")
	private String indDeposito;

	@Column(name="indmatproc_dadosproc")
	private String indMatProc;

	@Column(name="indsusp_infosusp")
	private String indSusp;

	@Column(name="nrproc_ideprocesso")
	private String nrProc;

	@Column(name="observacao_dadosproc")
	private String observacao;

	@Column(name="tpproc_ideprocesso")
	private String tpProc;

	@Column(name="ufvara_dadosprocjud")
	private String ufVara;
	


}
	

	
