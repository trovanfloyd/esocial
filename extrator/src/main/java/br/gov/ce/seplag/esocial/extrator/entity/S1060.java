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
@Table(name = "tb_s1060", schema = "db_esocial")
@NamedQuery(name = "S1060.findAll", query = "SELECT s FROM S1060 s")
@Data
public class S1060 implements Serializable {
	
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name = "db_esocial.sq_pk_s1060", sequenceName = "db_esocial.sq_pk_s1060")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "db_esocial.sq_pk_s1060")
	@Column(name = "isn_s1060")
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
	
	@Column(name="inivalid_ideambiente")
	private String iniValid;
	
	@Column(name="fimvalid_ideambiente")
	private String fimValid;
	
	@Column(name="codamb_ideambiente")
	private String codAmb;

	@Column(name="codfatris_fatorrisco")
	private String codFatRis;

	@Column(name="dscamb_dadosambiente")
	private String dscAmb;

	@Column(name="localamb_dadosambiente")
	private String localAmb;

	@Column(name="nrinsc_dadosambiente")
	private String nrInsc_dadosAmbiente;

	@Column(name="tpinsc_dadosambiente")
	private String tpInsc_dadosAmbiente;	


}
	

	
