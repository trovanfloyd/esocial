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
@Table(name = "tb_s1010", schema = "db_esocial")
@NamedQuery(name = "S1010.findAll", query = "SELECT s FROM S1010 s")
@Data
public class S1010 implements Serializable {
	
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name = "db_esocial.sq_pk_s1010", sequenceName = "db_esocial.sq_pk_s1010")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "db_esocial.sq_pk_s1010")
	@Column(name = "isn_s1010")
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
	
	@Column(name="inivalid_iderubrica")
	private String iniValid;
	
	@Column(name="fimvalid_iderubrica")
	private String fimValid;
	
	@Column(name="codinccp_dadosrubrica")
	private String codIncCP;

	@Column(name="codincfgts_dadosrubrica")
	private String codIncFGTS;

	@Column(name="codincirrf_dadosrubrica")
	private String codIncIRRF;

	@Column(name="codincsind_dadosrubrica")
	private String codIncSIND;

	@Column(name="codrubr_iderubrica")
	private String codRubr;

	@Column(name="codsusp_ideprocessocp")
	private String codSusp_ideProcessoCP;

	@Column(name="codsusp_ideprocessoirrf")
	private String codSusp_ideProcessoIRRF;

	@Column(name="dscrubr_dadosrubrica")
	private String dscRubr;

	@Column(name="extdecisao_ideprocessocp")
	private String extDecisao;

	@Column(name="idetabrubr_iderubrica")
	private String ideTabRubr;

	@Column(name="natrubr_dadosrubrica")
	private String natRubr;

	@Column(name="nrproc_ideprocessocp")
	private String nrProc_ideProcessoCP;

	@Column(name="nrproc_ideprocessofgts")
	private String nrProc_ideProcessoFGTS;

	@Column(name="nrproc_ideprocessoirrf")
	private String nrProc_ideProcessoIRRF;

	@Column(name="nrproc_ideprocessosind")
	private String nrProc_ideprocessoSIND;

	@Column(name="observacao_dadosrubrica")
	private String observacao;

	@Column(name="tpproc_ideprocessocp")
	private String tpProc_ideProcessoCP;

	@Column(name="tprubr_dadosrubrica")
	private String tpRubr;

	
	

}
	

	
