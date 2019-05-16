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
@Table(name = "tb_s1030", schema = "db_esocial")
@NamedQuery(name = "S1030.findAll", query = "SELECT s FROM S1030 s")
@Data
public class S1030 implements Serializable {
	
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name = "db_esocial.sq_pk_s1030", sequenceName = "db_esocial.sq_pk_s1030")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "db_esocial.sq_pk_s1030")
	@Column(name = "isn_s1030")
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

	@Column(name="codcargo_idecargo")
	private String codCargo;
	
	@Column(name="inivalid_idecargo")
	private String iniValid;
	
	@Column(name="fimvalid_idecargo")
	private String fimValid;
	
	@Column(name="nmcargo_dadoscargo")
	private String nmCargo;
	
	@Column(name="codcbo_dadoscargo")
	private String codCBO;

	@Column(name="acumcargo_cargopublico")
	private String acumCargo;

	@Column(name="contagemesp_cargopublico")
	private String contagemEsp;

	@Column(name="dedicexcl_cargopublico")
	private String dedicExcl;
	
	@Column(name="nrlei_leicargo")
	private String nrLei;

	@Column(name="dtlei_leicargo")
	private String dtLei;

	@Column(name="sitcargo_leicargo")
	private String sitCargo;



	
}
