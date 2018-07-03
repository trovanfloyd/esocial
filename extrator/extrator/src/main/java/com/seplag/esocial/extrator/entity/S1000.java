package com.seplag.esocial.extrator.entity;

import java.io.Serializable;
import java.math.BigDecimal;
import java.math.BigInteger;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * The persistent class for the tb_s1000 database table.
 *
 */
@Entity
@Table(name = "tb_s1000", schema = "db_esocial")
@NamedQuery(name = "S1000.findAll", query = "SELECT s FROM S1000 s")
@XmlRootElement
public class S1000 implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name = "db_esocial.sq_pk_s1000", sequenceName = "db_esocial.sq_pk_s1000")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "db_esocial.sq_pk_s1000")
	@Column(name = "isn_s1000")
	private Long isnS1000;

	@Column(name = "id")
	private String id;

	@Column(name = "inivalid")
	private String iniValid;

	@Column(name = "fimvalid")
	private String fimValid;

	@Column(name = "nmrazao")
	private String nmRazao_infoCadastro;

	@Column(name = "classtrib")
	private String classTrib;

	@Column(name = "natjurid")
	private String natJurid;

	@Column(name = "indcoop")
	private Integer indCoop;

	@Column(name = "indconstr")
	private Integer indConstr;

	@Column(name = "inddesfolha")
	private Integer indDesFolha;

	@Column(name = "indoptregeletron")
	private Integer indOptRegEletron;

	@Column(name = "indented")
	private String indEntEd;

	@Column(name = "indett")
	private String indEtt;

	@Column(name = "nrregett")
	private BigInteger nrRegEtt;

	@Column(name = "ideminlei")
	private String ideMinLei;

	@Column(name = "nrcertif")
	private String nrCertif;

	@Column(name = "dtemiscertif")
	private String dtEmiscertif;

	@Column(name = "dtvenccertif")
	private String dtVencCertif;

	@Column(name = "nrprotrenov")
	private String nrProtRenov;

	@Column(name = "dtprotrenov")
	private String dtProtRenov;

	@Column(name = "dtdou")
	private String dtDou;

	@Column(name = "pagdou")
	private Integer pagDou;

	@Column(name = "nmctt")
	private String nmCtt;

	@Column(name = "cpfctt")
	private String cpfCtt;

	@Column(name = "fonefixo")
	private String foneFixo;

	@Column(name = "fonecel")
	private String foneCel;

	@Column(name = "email")
	private String email_contato;

	@Column(name = "nrsiafi")
	private String nrSiafi;

	@Column(name = "ideefr")
	private String ideEfr;

	@Column(name = "cnpjefr")
	private String cnpjEfr;

	@Column(name = "nmente")
	private String nmEnte;

	@Column(name = "uf")
	private String uf;

	@Column(name = "codmunic")
	private Integer codMunic;

	@Column(name = "indrpps")
	private String indRpps;

	@Column(name = "subteto")
	private Integer subTeto;

	@Column(name = "vrsubteto")
	private BigDecimal vrSubTeto;

	@Column(name = "indacordoisenmulta")
	private Integer indAcordoIsenMulta;

	@Column(name = "cnpjsofthouse")
	private String cnpjSoftHouse;

	@Column(name = "nmrazaosofthouse")
	private String nmRazao_softwareHouse;

	@Column(name = "nmcont")
	private String nmCont_softwareHouse;

	@Column(name = "telefone")
	private String telefone_softwareHouse;

	@Column(name = "emailsofthouse")
	private String email_softwareHouse;

	@Column(name = "indsitpj")
	private Integer indSitPj;

	@Column(name = "indsitpf")
	private Integer indSitPf;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

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

	public String getDtEmiscertif() {
		return dtEmiscertif;
	}

	public void setDtEmiscertif(String dtEmiscertif) {
		this.dtEmiscertif = dtEmiscertif;
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

	public String getIdeEfr() {
		return ideEfr;
	}

	public void setIdeEfr(String ideEfr) {
		this.ideEfr = ideEfr;
	}

	public String getCnpjEfr() {
		return cnpjEfr;
	}

	public void setCnpjEfr(String cnpjEfr) {
		this.cnpjEfr = cnpjEfr;
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

	public String getIndRpps() {
		return indRpps;
	}

	public void setIndRpps(String indRpps) {
		this.indRpps = indRpps;
	}

	public Integer getSubTeto() {
		return subTeto;
	}

	public void setSubTeto(Integer subTeto) {
		this.subTeto = subTeto;
	}

	public BigDecimal getVrSubTeto() {
		return vrSubTeto;
	}

	public void setVrSubTeto(BigDecimal vrSubTeto) {
		this.vrSubTeto = vrSubTeto;
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

	public Integer getIndSitPj() {
		return indSitPj;
	}

	public void setIndSitPj(Integer indSitPj) {
		this.indSitPj = indSitPj;
	}

	public Integer getIndSitPf() {
		return indSitPf;
	}

	public void setIndSitPf(Integer indSitPf) {
		this.indSitPf = indSitPf;
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
		if (isnS1000 == null) {
			if (other.isnS1000 != null) {
				return false;
			}
		} else if (!isnS1000.equals(other.isnS1000)) {
			return false;
		}
		return true;
	}

}
