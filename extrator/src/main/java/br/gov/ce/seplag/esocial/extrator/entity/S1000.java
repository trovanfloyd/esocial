package br.gov.ce.seplag.esocial.extrator.entity;

import java.io.Serializable;
import java.math.BigDecimal;
import java.math.BigInteger;

import javax.persistence.CascadeType;
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
import javax.xml.bind.annotation.XmlRootElement;

/**
 * The persistent class for the tb_s1000 database table.
 *
 */
@Entity
@Table(name = "tb_s1000_v2", schema = "db_esocial")
@NamedQuery(name = "S1000.findAll", query = "SELECT s FROM S1000 s")
@XmlRootElement
public class S1000 implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name = "db_esocial.sq_pk_s1000", sequenceName = "db_esocial.sq_pk_s1000")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "db_esocial.sq_pk_s1000")
	@Column(name = "isn_s1000")
	private Long id;
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "arquivo_esocial_id")
	private ArquivoEsocial arquivoEsocial;

	@Column(name = "inivalid_ideperiodo")
	private String iniValid;

	@Column(name = "fimvalid_ideperiodo ")
	private String fimValid;
	
	@Column(name = "tpamb_ideevento")
	private String tpAmb;
	
	@Column(name = "procemi_ideevento")
	private String procEmi;
	
	@Column(name = "verproc_ideevento")
	private String verProc;
	
	@Column(name = "tpinsc_ideempregador")
	private String tpInsc_ideEmpregador;
	
	@Column(name = "nrinsc_ideempregador")
	private String nrInsc_ideEmpregador;
	
	@Column(name = "nmrazao_infocadastro")
	private String nmRazao_infoCadastro;

	@Column(name = "classtrib_infocadastro")
	private String classTrib;

	@Column(name = "natjurid_infocadastro")
	private String natJurid;

	@Column(name = "indcoop_infocadastro")
	private Integer indCoop;

	@Column(name = "indconstr_infocadastro")
	private Integer indConstr;

	@Column(name = "inddesfolha_infocadastro")
	private Integer indDesFolha;

	@Column(name = "indoptregeletron_infocadastro")
	private Integer indOptRegEletron;

	@Column(name = "indented_infocadastro")
	private String indEntEd;

	@Column(name = "indett_infocadastro")
	private String indEtt;

	@Column(name = "nrregett_infocadastro")
	private BigInteger nrRegEtt;

	@Column(name = "ideminlei_dadosisencao")
	private String ideMinLei;

	@Column(name = "nrcertif_dadosisencao")
	private String nrCertif;

	@Column(name = "dtemiscertif_dadosisencao")
	private String dtEmisCertif;

	@Column(name = "dtvenccertif_dadosisencao")
	private String dtVencCertif;

	@Column(name = "nrprotrenov_dadosisencao")
	private String nrProtRenov;

	@Column(name = "dtprotrenov_dadosisencao")
	private String dtProtRenov;

	@Column(name = "dtdou_dadosisencao")
	private String dtDou;

	@Column(name = "pagdou_dadosisencao")
	private Integer pagDou;

	@Column(name = "nmctt_contato")
	private String nmCtt;

	@Column(name = "cpfctt_contato")
	private String cpfCtt;

	@Column(name = "fonefixo_contato")
	private String foneFixo;

	@Column(name = "fonecel_contato")
	private String foneCel;

	@Column(name = "email_contato")
	private String email_contato;

	@Column(name = "nrsiafi_infoop")
	private String nrSiafi;

	@Column(name = "ideefr_infoefr")
	private String ideEFR;

	@Column(name = "cnpjefr_infoefr")
	private String cnpjEFR;

	@Column(name = "nmente_infoente")
	private String nmEnte;

	@Column(name = "uf_infoente")
	private String uf;

	@Column(name = "codmunic_infoente")
	private Integer codMunic;

	@Column(name = "indrpps_infoente")
	private String indRPPS;

	@Column(name = "subteto_infoente")
	private Integer subTeto;

	@Column(name = "vrsubteto_infoente")
	private BigDecimal vrSubteto;

	@Column(name = "indacordoisenmulta_infoorginternacional")
	private Integer indAcordoIsenMulta;

	@Column(name = "cnpjsofthouse_softwarehouse")
	private String cnpjSoftHouse;

	@Column(name = "nmrazao_softwarehouse")
	private String nmRazao_softwareHouse;

	@Column(name = "nmcont_softwarehouse")
	private String nmCont_softwareHouse;

	@Column(name = "telefone_softwarehouse")
	private String telefone_softwareHouse;

	@Column(name = "email_softwarehouse")
	private String email_softwareHouse;

	@Column(name = "indsitpj_situacaopj")
	private Integer indSitPJ;

	@Column(name = "indsitpf_situacaopf")
	private Integer indSitPF;
	


	public String getIniValid() {
		return iniValid;
	}

	public void setIniValid(String iniValid) {
		this.iniValid = iniValid;
	}

	public String getFimValid() {
		return fimValid;
	}

	public void setFimValid(String fimValid) {
		this.fimValid = fimValid;
	}

	public String getNmRazao_infoCadastro() {
		return nmRazao_infoCadastro;
	}

	public void setNmRazao_infoCadastro(String nmRazao_infoCadastro) {
		this.nmRazao_infoCadastro = nmRazao_infoCadastro;
	}

	public String getClassTrib() {
		return classTrib;
	}

	public void setClassTrib(String classTrib) {
		this.classTrib = classTrib;
	}

	public String getNatJurid() {
		return natJurid;
	}

	public void setNatJurid(String natJurid) {
		this.natJurid = natJurid;
	}

	public Integer getIndCoop() {
		return indCoop;
	}

	public void setIndCoop(Integer indCoop) {
		this.indCoop = indCoop;
	}

	public Integer getIndConstr() {
		return indConstr;
	}

	public void setIndConstr(Integer indConstr) {
		this.indConstr = indConstr;
	}

	public Integer getIndDesFolha() {
		return indDesFolha;
	}

	public void setIndDesFolha(Integer indDesFolha) {
		this.indDesFolha = indDesFolha;
	}

	public Integer getIndOptRegEletron() {
		return indOptRegEletron;
	}

	public void setIndOptRegEletron(Integer indOptRegEletron) {
		this.indOptRegEletron = indOptRegEletron;
	}

	public String getIndEntEd() {
		return indEntEd;
	}

	public void setIndEntEd(String indEntEd) {
		this.indEntEd = indEntEd;
	}

	public String getIndEtt() {
		return indEtt;
	}

	public void setIndEtt(String indEtt) {
		this.indEtt = indEtt;
	}

	public BigInteger getNrRegEtt() {
		return nrRegEtt;
	}

	public void setNrRegEtt(BigInteger nrRegEtt) {
		this.nrRegEtt = nrRegEtt;
	}

	public String getIdeMinLei() {
		return ideMinLei;
	}

	public void setIdeMinLei(String ideMinLei) {
		this.ideMinLei = ideMinLei;
	}

	public String getNrCertif() {
		return nrCertif;
	}

	public void setNrCertif(String nrCertif) {
		this.nrCertif = nrCertif;
	}


	public String getDtEmisCertif() {
		return dtEmisCertif;
	}

	public void setDtEmisCertif(String dtEmisCertif) {
		this.dtEmisCertif = dtEmisCertif;
	}

	public String getDtVencCertif() {
		return dtVencCertif;
	}

	public void setDtVencCertif(String dtVencCertif) {
		this.dtVencCertif = dtVencCertif;
	}

	public String getNrProtRenov() {
		return nrProtRenov;
	}

	public void setNrProtRenov(String nrProtRenov) {
		this.nrProtRenov = nrProtRenov;
	}

	public String getDtProtRenov() {
		return dtProtRenov;
	}

	public void setDtProtRenov(String dtProtRenov) {
		this.dtProtRenov = dtProtRenov;
	}

	public String getDtDou() {
		return dtDou;
	}

	public void setDtDou(String dtDou) {
		this.dtDou = dtDou;
	}

	public Integer getPagDou() {
		return pagDou;
	}

	public void setPagDou(Integer pagDou) {
		this.pagDou = pagDou;
	}

	public String getNmCtt() {
		return nmCtt;
	}

	public void setNmCtt(String nmCtt) {
		this.nmCtt = nmCtt;
	}

	public String getCpfCtt() {
		return cpfCtt;
	}

	public void setCpfCtt(String cpfCtt) {
		this.cpfCtt = cpfCtt;
	}

	public String getFoneFixo() {
		return foneFixo;
	}

	public void setFoneFixo(String foneFixo) {
		this.foneFixo = foneFixo;
	}

	public String getFoneCel() {
		return foneCel;
	}

	public void setFoneCel(String foneCel) {
		this.foneCel = foneCel;
	}

	public String getEmail_contato() {
		return email_contato;
	}

	public void setEmail_contato(String email_contato) {
		this.email_contato = email_contato;
	}

	public String getNrSiafi() {
		return nrSiafi;
	}

	public void setNrSiafi(String nrSiafi) {
		this.nrSiafi = nrSiafi;
	}

	public String getIdeEFR() {
		return ideEFR;
	}

	public void setIdeEFR(String ideEFR) {
		this.ideEFR = ideEFR;
	}

	public String getCnpjEFR() {
		return cnpjEFR;
	}

	public void setCnpjEFR(String cnpjEFR) {
		this.cnpjEFR = cnpjEFR;
	}

	public String getNmEnte() {
		return nmEnte;
	}

	public void setNmEnte(String nmEnte) {
		this.nmEnte = nmEnte;
	}

	public String getUf() {
		return uf;
	}

	public void setUf(String uf) {
		this.uf = uf;
	}

	public Integer getCodMunic() {
		return codMunic;
	}

	public void setCodMunic(Integer codMunic) {
		this.codMunic = codMunic;
	}

	public String getIndRPPS() {
		return indRPPS;
	}

	public void setIndRPPS(String indRPPS) {
		this.indRPPS = indRPPS;
	}

	public Integer getSubTeto() {
		return subTeto;
	}

	public void setSubTeto(Integer subTeto) {
		this.subTeto = subTeto;
	}

	public BigDecimal getVrSubteto() {
		return vrSubteto;
	}

	public void setVrSubteto(BigDecimal vrSubteto) {
		this.vrSubteto = vrSubteto;
	}

	public Integer getIndAcordoIsenMulta() {
		return indAcordoIsenMulta;
	}

	public void setIndAcordoIsenMulta(Integer indAcordoIsenMulta) {
		this.indAcordoIsenMulta = indAcordoIsenMulta;
	}

	public String getCnpjSoftHouse() {
		return cnpjSoftHouse;
	}

	public void setCnpjSoftHouse(String cnpjSoftHouse) {
		this.cnpjSoftHouse = cnpjSoftHouse;
	}

	public String getNmRazao_softwareHouse() {
		return nmRazao_softwareHouse;
	}

	public void setNmRazao_softwareHouse(String nmRazao_softwareHouse) {
		this.nmRazao_softwareHouse = nmRazao_softwareHouse;
	}

	public String getNmCont_softwareHouse() {
		return nmCont_softwareHouse;
	}

	public void setNmCont_softwareHouse(String nmCont_softwareHouse) {
		this.nmCont_softwareHouse = nmCont_softwareHouse;
	}

	public String getTelefone_softwareHouse() {
		return telefone_softwareHouse;
	}

	public void setTelefone_softwareHouse(String telefone_softwareHouse) {
		this.telefone_softwareHouse = telefone_softwareHouse;
	}

	public String getEmail_softwareHouse() {
		return email_softwareHouse;
	}

	public void setEmail_softwareHouse(String email_softwareHouse) {
		this.email_softwareHouse = email_softwareHouse;
	}

	public Integer getIndSitPJ() {
		return indSitPJ;
	}

	public void setIndSitPJ(Integer indSitPJ) {
		this.indSitPJ = indSitPJ;
	}

	public Integer getIndSitPF() {
		return indSitPF;
	}

	public void setIndSitPF(Integer indSitPF) {
		this.indSitPF = indSitPF;
	}


	public String getTpAmb() {
		return tpAmb;
	}

	public void setTpAmb(String tpAmb) {
		this.tpAmb = tpAmb;
	}

	public String getProcEmi() {
		return procEmi;
	}

	public void setProcEmi(String procEmi) {
		this.procEmi = procEmi;
	}

	public String getVerProc() {
		return verProc;
	}

	public void setVerProc(String verProc) {
		this.verProc = verProc;
	}

	public String getTpInsc_ideEmpregador() {
		return tpInsc_ideEmpregador;
	}

	public void setTpInsc_ideEmpregador(String tpInsc_ideEmpregador) {
		this.tpInsc_ideEmpregador = tpInsc_ideEmpregador;
	}

	public String getNrInsc_ideEmpregador() {
		return nrInsc_ideEmpregador;
	}

	public void setNrInsc_ideEmpregador(String nrInsc_ideEmpregador) {
		this.nrInsc_ideEmpregador = nrInsc_ideEmpregador;
	}
	
	

	public Long getId() {
		return id;
	}

	public ArquivoEsocial getArquivoEsocial() {
		return arquivoEsocial;
	}

	public void setArquivoEsocial(ArquivoEsocial arquivoEsocial) {
		this.arquivoEsocial = arquivoEsocial;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		if (getClass() != obj.getClass()) {
			return false;
		}
		S1000 other = (S1000) obj;
		if (id == null) {
			if (other.id != null) {
				return false;
			}
		} else if (!id.equals(other.id)) {
			return false;
		}
		return true;
	}

}
