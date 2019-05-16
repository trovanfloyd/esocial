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
@Table(name = "tb_s1005", schema = "db_esocial")
@NamedQuery(name = "S1005.findAll", query = "SELECT s FROM S1005 s")
@Data
public class S1005 implements Serializable {
	
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name = "db_esocial.sq_pk_s1005", sequenceName = "db_esocial.sq_pk_s1005")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "db_esocial.sq_pk_s1005")
	@Column(name = "isn_s1005")
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
	private String tpInsc_ideEmpregador;
	
	@Column(name="nrinsc_ideempregador")
	private String nrInsc_ideEmpregador;
	
	@Column(name="inivalid_ideEstab")
	private String iniValid;
	
	@Column(name="fimvalid_ideEstab")
	private String fimValid;
	
	@Column(name="aliqrat_aliqgilrat")
	private String aliqRat;

	@Column(name="aliqratajust_aliqgilrat")
	private String aliqRatAjust;

	@Column(name="cnaeprep_dadosestab")
	private String cnaePrep;

	@Column(name="codsusp_procadmjudfap")
	private String codSusp_procAdmJudFat;

	@Column(name="codsusp_procadmjudrat")
	private String codSusp_procAdmJudRat;

	@Column(name="contapr_infoapr")
	private String contApr;

	@Column(name="contented_infoapr")
	private String contEntEd;

	@Column(name="contpcd_infopcd")
	private String contPCD;

	@Column(name="fap_aliqgilrat")
	private String fap;

	@Column(name="indsubstpatrobra_infoobra")
	private String indSubstPatrObra;

	@Column(name="nrinsc_ideestab")
	private String nrInsc_ideEstab;

	@Column(name="nrinsc_infoenteduc")
	private String nrInsc_infoEntEduc;
	
	@Column(name="nrproc_procadmjudfap")
	private String nrProc_procAdmJudFap;

	@Column(name="nrproc_procadmjudrat")
	private String nrProc_procAdmJudRat;

	@Column(name="nrprocjud_infoapr")
	private String nrProcJud_infoApr;

	@Column(name="nrprocjud_infopcd")
	private String nrProcJud_infoPCD;

	@Column(name="regpt_infotrab")
	private String regPt;

	@Column(name="tpcaepf_infocaepf")
	private String tpCaepf;

	@Column(name="tpinsc_ideestab")
	private String tpInsc_ideEstab;

	@Column(name="tpproc_procadmjudfap")
	private String tpProc__procAdmJudFap;

	@Column(name="tpproc_procadmjudrat")
	private String tpProc__procAdmJudRat;


}
	

	
