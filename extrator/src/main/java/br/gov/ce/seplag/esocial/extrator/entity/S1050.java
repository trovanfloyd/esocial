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
@NamedQuery(name = "S1050.findAll", query = "SELECT s FROM S1050 s")
@Data
public class S1050 implements Serializable {
	
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name = "db_esocial.sq_pk_s1050", sequenceName = "db_esocial.sq_pk_s1050")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "db_esocial.sq_pk_s1050")
	@Column(name = "isn_s1050")
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
	
	@Column(name="inivalid_idehorcontratual")
	private String iniValid;
	
	@Column(name="fimvalid_idehorcontratual")
	private String fimValid;
	
	@Column(name="codhorcontrat_idehorcontratual")
	private String codHorContrat;

	@Column(name="durinterv_horariointervalo")
	private String durInterv;

	@Column(name="durjornada_dadoshorcontratual")
	private String durJornada;

	@Column(name="hrentr_dadoshorcontratual")
	private String hrEntr;

	@Column(name="hrsaida_dadoshorcontratual")
	private String hrSaida;

	@Column(name="iniinterv_horariointervalo")
	private String iniintervHorariointervalo;

	@Column(name="perhorflexivel_dadoshorcontratual")
	private String perHorFlexivel;

	@Column(name="terminterv_horariointervalo")
	private String termInterv;

	@Column(name="tpinterv_horariointervalo")
	private String tpInterv;



}
	

	
