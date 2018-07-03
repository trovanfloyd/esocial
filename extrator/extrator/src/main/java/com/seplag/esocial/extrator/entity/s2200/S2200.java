package com.seplag.esocial.extrator.entity.s2200;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "tb_s2200", schema = "db_esocial")
public class S2200 implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	@Column(name = "isn_s2200")
	private Long isnS2200;

	@Column(name = "id")
	private String id;

	@Column(name = "bairro")
	private String bairro_brasil;

	@Column(name = "bairrodom")
	private String bairro_localTrabDom;

	@Column(name = "bairroexterior")
	private String bairro_exterior;

	private String cadini;

	@Column(name = "casadobr")
	private String casadoBr;

	@Column(name = "categoriacnh")
	private String categoriaCnh;

	private String cep;

	@Column(name = "cepexterior")
	private String cep_exterior;

	@Column(name = "classtrabestrang")
	private String classTrabEstrang;

	private String clauassec;

	@Column(name = "cnpjempregant")
	private String cnpjEmpregAnt;

	@Column(name = "cnpjsindcategprof")
	private String cnpjSindCategProf;

	@Column(name = "cnpjsindtrab")
	private String cnpjSindTrab;

	@Column(name = "codcargo")
	private String codCargo;

	@Column(name = "codcarreira")
	private String codCarreira;

	@Column(name = "codfuncao")
	private String codFuncao;

	@Column(name = "codhorcontrat")
	private String codHorContrat;

	@Column(name = "codmotafast")
	private String codMotAfast;

	@Column(name = "codmunic")
	private String codMunic;

	@Column(name = "codmunicdom")
	private String codMunic_localTrabDom;

	@Column(name = "codmunicnasc")
	private String codMunic_nascimento;

	@Column(name = "codpostal")
	private String codPostal;

	private String complemento;

	@Column(name = "complementodom")
	private String complemento_localTrabDom;

	@Column(name = "complementoexterior")
	private String complemento_exterior;

	private String cpfsubstituido;

	@Column(name = "cpftrab")
	private String cpfTrab;

	@Column(name = "cpftrabsubst")
	private String cpfTrabSubst;

	@Column(name = "defauditiva")
	private String defAuditiva;

	@Column(name = "deffisica")
	private String defFisica;

	@Column(name = "defintelectual")
	private String defIntelectual;

	@Column(name = "defmental")
	private String defMental;

	@Column(name = "defvisual")
	private String defVisual;

	private String desccomp;

	private String dia;

	@Column(name = "dsclograd")
	private String dscLograd;

	@Column(name = "dsclograddom")
	private String dscLograddom;

	@Column(name = "dsclogradexterior")
	private String dscLograd_exterior;

	@Column(name = "dscsalvar")
	private String dscSalVar;

	@Column(name = "dsctpjorn")
	private String dscTpJorn;

	@Column(name = "dtadm")
	private Date dtSdm;

	@Column(name = "dtbase")
	private String dtBase;

	@Column(name = "dtchegada")
	private Date dtChegada;

	@Column(name = "dtdeslig")
	private Date dtDeslig;

	@Column(name = "dtexercicio")
	private Date dtExercicio;

	@Column(name = "dtexpedcnh")
	private Date dtExpedCnh;

	@Column(name = "dtexpedoc")
	private Date dtExpeDoc;

	@Column(name = "dtexpedrg")
	private Date dtExpedRg;

	@Column(name = "dtexpedric")
	private Date dtExpedRic;

	@Column(name = "dtexpedrne")
	private Date dtExpedRne;

	@Column(name = "dtingrcarr")
	private Date dtIngrCarr;

	@Column(name = "dtiniafast")
	private Date dtIniAfast;

	@Column(name = "dtnascto")
	private Date dtNascto_nascimento;

	@Column(name = "dtnomeacao")
	private Date dtNomeacao;

	@Column(name = "dtopcfgts")
	private Date dtOpcFgts;

	@Column(name = "dtposse")
	private Date dtPosse;

	@Column(name = "dtprihab")
	private Date dtPriHab;

	@Column(name = "dtterm")
	private Date dtTerm;

	@Column(name = "dttransf")
	private Date dtTransf;

	@Column(name = "dttransfdom")
	private Date dtTransfDom;

	@Column(name = "dtvalidcnh")
	private Date dtValidCnh;

	@Column(name = "dtvalidoc")
	private Date dtValiDoc;

	@Column(name = "emailalternat")
	private String emailAlternat;

	@Column(name = "emailprinc")
	private String emailPrinc;

	@Column(name = "estciv")
	private String estCiv;

	@Column(name = "filhosbr")
	private String filhosBr;

	@Column(name = "fonealternat")
	private String foneAlternat;

	@Column(name = "foneprinc")
	private String fonePrinc;

	@Column(name = "grauinstr")
	private String grauInstr;

	@Column(name = "hipleg")
	private String hipLeg;

	@Column(name = "indadmissao")
	private String indAdmissao;

	@Column(name = "indpriempr")
	private String indPriEmpr;

	@Column(name = "indprovim")
	private String indProvim;

	@Column(name = "indretif")
	private String indRetif;

	@Column(name = "infocota")
	private String infoCota;

	@Column(name = "justcontr")
	private String justContr;

	@Column(name = "matricant")
	private String matricAnt;

	@Column(name = "matricantdom")
	private String matricantdom;

	private String matricula;

	@Column(name = "natatividade")
	private String natAtividade;

	@Column(name = "nistrab")
	private String nisTrab;

	@Column(name = "nmcid")
	private String nmCid;

	@Column(name = "nmmae")
	private String nmMae;

	@Column(name = "nmpai")
	private String nmPai;

	@Column(name = "nmsoc")
	private String nmSoc;

	@Column(name = "nmtrab")
	private String nmTrab;

	@Column(name = "nrctps")
	private String nrCtps;

	@Column(name = "nrinsc")
	private String nrInsc;

	@Column(name = "nrinscaprendiz")
	private String nrInscAprendiz;

	@Column(name = "nrinscempregador")
	private String nrInscEmpregador;

	@Column(name = "nrinscempresa")
	private String nrInscEmpresa;

	@Column(name = "nrinscvinculado")
	private String nrInscVinculado;

	@Column(name = "nrlograd")
	private String nrLograd;

	@Column(name = "nrlograddom")
	private String nrLogradDom;

	@Column(name = "nrlogradexterior")
	private String nrLograd_exterior;

	@Column(name = "nroc")
	private String nrOc;

	@Column(name = "nrprocjud")
	private String nrProcJud;

	@Column(name = "nrprocjudaprendiz")
	private String nrProcJudAprendiz;

	@Column(name = "nrrecibo")
	private String nrRecibo;

	@Column(name = "nrrecinfprelim")
	private String nrRecInfPrelim;

	@Column(name = "nrregcnh")
	private String nrRegCnh;

	@Column(name = "nrrg")
	private String nrRg;

	@Column(name = "nrric")
	private String nrRic;

	@Column(name = "nrrne")
	private String nrRne;

	@Column(name = "observacaocontrato")
	private String observacaoContrato;

	@Column(name = "observacaodeficiente")
	private String observacaoDeficiente;

	@Column(name = "observacaovinculo")
	private String observacaoVinculo;

	private String observacoes;

	@Column(name = "opcfgts")
	private String opcFgts;

	@Column(name = "orgaoemissoroc")
	private String orgaoEmissorOc;

	@Column(name = "orgaoemissorrg")
	private String orgaoEmissorRg;

	@Column(name = "orgaoemissorric")
	private String orgaoEmissorRic;

	@Column(name = "orgaoemissorrne")
	private String orgaoEmissorRne;

	@Column(name = "paisresid")
	private String paisResid;

	@Column(name = "procemi")
	private String procEmi;

	@Column(name = "qtdhrssem")
	private String qtdHrsSem;

	@Column(name = "racacor")
	private String racaCor;

	@Column(name = "reabreadap")
	private String reabReadap;

	@Column(name = "seriectps")
	private String serieCtps;

	private String sexo;

	@Column(name = "tmpparc")
	private String tmpParc;

	@Column(name = "tpadmissao")
	private String tpAdmissao;

	@Column(name = "tpamb")
	private String tpAmb;

	@Column(name = "tpcontr")
	private String tpContr;

	@Column(name = "tpinclcontr")
	private String tpInclContr;

	@Column(name = "tpinscaprendiz")
	private String tpInscAprendiz;

	@Column(name = "tpinscempregador")
	private String tpInscEmpregador;

	@Column(name = "tpinsclocaltrab")
	private String tpInscLocalTrab;

	@Column(name = "tpinsctomador")
	private String tpInscTomador;

	@Column(name = "tpinscvinculo")
	private String tpInscVinculo;

	@Column(name = "tpjornada")
	private String tpJornada;

	@Column(name = "tplograd")
	private String tpLograd;

	@Column(name = "tplograddom")
	private String tpLogradDom;

	@Column(name = "tpplanrp")
	private String tpPlanRp;

	@Column(name = "tpprov")
	private String tpProv;

	@Column(name = "tpregjor")
	private String tpRegJor;

	@Column(name = "tpregprev")
	private String tpRegPrev;

	@Column(name = "tpregtrab")
	private String tpRegTrab;

	@Column(name = "trabaposent")
	private String trabAposent;

	@Column(name = "ufcnh")
	private String ufCnh;

	@Column(name = "ufctps")
	private String ufCtps;

	@Column(name = "ufdom")
	private String ufDom;

	@Column(name = "ufnascimento")
	private String ufNascimento;

	@Column(name = "uftrab")
	private String ufTrab;

	@Column(name = "undsalfixo")
	private String undSalFixo;

	@Column(name = "verproc")
	private String verProc;

	@Column(name = "vrsalfx")
	private String vrSalFx;

	@OneToMany(mappedBy = "isnS2200")
	private List<Dependente> list_dependente;

	@ManyToOne
	@JoinColumn(name = "isn_categoria_trabalhador")
	private CategoriaTrabalhador codcateg;

	@ManyToOne
	@JoinColumn(name = "isn_pais_nac")
	private Paises paisnac;

	@ManyToOne
	@JoinColumn(name = "isn_pais_nascto")
	private Paises paisnascto;

	public Long getIsnS2200() {
		return isnS2200;
	}

	public void setIsnS2200(Long isnS2200) {
		this.isnS2200 = isnS2200;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getBairro_brasil() {
		return bairro_brasil;
	}

	public void setBairro_brasil(String bairro_brasil) {
		this.bairro_brasil = bairro_brasil;
	}

	public String getBairro_localTrabDom() {
		return bairro_localTrabDom;
	}

	public void setBairro_localTrabDom(String bairro_localTrabDom) {
		this.bairro_localTrabDom = bairro_localTrabDom;
	}

	public String getBairro_exterior() {
		return bairro_exterior;
	}

	public void setBairro_exterior(String bairro_exterior) {
		this.bairro_exterior = bairro_exterior;
	}

	public String getCadini() {
		return cadini;
	}

	public void setCadini(String cadini) {
		this.cadini = cadini;
	}

	public String getCasadoBr() {
		return casadoBr;
	}

	public void setCasadoBr(String casadoBr) {
		this.casadoBr = casadoBr;
	}

	public String getCategoriaCnh() {
		return categoriaCnh;
	}

	public void setCategoriaCnh(String categoriaCnh) {
		this.categoriaCnh = categoriaCnh;
	}

	public String getCep() {
		return cep;
	}

	public void setCep(String cep) {
		this.cep = cep;
	}

	public String getCep_exterior() {
		return cep_exterior;
	}

	public void setCep_exterior(String cep_exterior) {
		this.cep_exterior = cep_exterior;
	}

	public String getClassTrabEstrang() {
		return classTrabEstrang;
	}

	public void setClassTrabEstrang(String classTrabEstrang) {
		this.classTrabEstrang = classTrabEstrang;
	}

	public String getClauassec() {
		return clauassec;
	}

	public void setClauassec(String clauassec) {
		this.clauassec = clauassec;
	}

	public String getCnpjEmpregAnt() {
		return cnpjEmpregAnt;
	}

	public void setCnpjEmpregAnt(String cnpjEmpregAnt) {
		this.cnpjEmpregAnt = cnpjEmpregAnt;
	}

	public String getCnpjSindCategProf() {
		return cnpjSindCategProf;
	}

	public void setCnpjSindCategProf(String cnpjSindCategProf) {
		this.cnpjSindCategProf = cnpjSindCategProf;
	}

	public String getCnpjSindTrab() {
		return cnpjSindTrab;
	}

	public void setCnpjSindTrab(String cnpjSindTrab) {
		this.cnpjSindTrab = cnpjSindTrab;
	}

	public String getCodCargo() {
		return codCargo;
	}

	public void setCodCargo(String codCargo) {
		this.codCargo = codCargo;
	}

	public String getCodCarreira() {
		return codCarreira;
	}

	public void setCodCarreira(String codCarreira) {
		this.codCarreira = codCarreira;
	}

	public String getCodFuncao() {
		return codFuncao;
	}

	public void setCodFuncao(String codFuncao) {
		this.codFuncao = codFuncao;
	}

	public String getCodHorContrat() {
		return codHorContrat;
	}

	public void setCodHorContrat(String codHorContrat) {
		this.codHorContrat = codHorContrat;
	}

	public String getCodMotAfast() {
		return codMotAfast;
	}

	public void setCodMotAfast(String codMotAfast) {
		this.codMotAfast = codMotAfast;
	}

	public String getCodMunic() {
		return codMunic;
	}

	public void setCodMunic(String codMunic) {
		this.codMunic = codMunic;
	}

	public String getCodMunic_localTrabDom() {
		return codMunic_localTrabDom;
	}

	public void setCodMunic_localTrabDom(String codMunic_localTrabDom) {
		this.codMunic_localTrabDom = codMunic_localTrabDom;
	}

	public String getCodMunic_nascimento() {
		return codMunic_nascimento;
	}

	public void setCodMunic_nascimento(String codMunic_nascimento) {
		this.codMunic_nascimento = codMunic_nascimento;
	}

	public String getCodPostal() {
		return codPostal;
	}

	public void setCodPostal(String codPostal) {
		this.codPostal = codPostal;
	}

	public String getComplemento() {
		return complemento;
	}

	public void setComplemento(String complemento) {
		this.complemento = complemento;
	}

	public String getComplemento_localTrabDom() {
		return complemento_localTrabDom;
	}

	public void setComplemento_localTrabDom(String complemento_localTrabDom) {
		this.complemento_localTrabDom = complemento_localTrabDom;
	}

	public String getComplemento_exterior() {
		return complemento_exterior;
	}

	public void setComplemento_exterior(String complemento_exterior) {
		this.complemento_exterior = complemento_exterior;
	}

	public String getCpfsubstituido() {
		return cpfsubstituido;
	}

	public void setCpfsubstituido(String cpfsubstituido) {
		this.cpfsubstituido = cpfsubstituido;
	}

	public String getCpfTrab() {
		return cpfTrab;
	}

	public void setCpfTrab(String cpfTrab) {
		this.cpfTrab = cpfTrab;
	}

	public String getCpfTrabSubst() {
		return cpfTrabSubst;
	}

	public void setCpfTrabSubst(String cpfTrabSubst) {
		this.cpfTrabSubst = cpfTrabSubst;
	}

	public String getDefAuditiva() {
		return defAuditiva;
	}

	public void setDefAuditiva(String defAuditiva) {
		this.defAuditiva = defAuditiva;
	}

	public String getDefFisica() {
		return defFisica;
	}

	public void setDefFisica(String defFisica) {
		this.defFisica = defFisica;
	}

	public String getDefIntelectual() {
		return defIntelectual;
	}

	public void setDefIntelectual(String defIntelectual) {
		this.defIntelectual = defIntelectual;
	}

	public String getDefMental() {
		return defMental;
	}

	public void setDefMental(String defMental) {
		this.defMental = defMental;
	}

	public String getDefVisual() {
		return defVisual;
	}

	public void setDefVisual(String defVisual) {
		this.defVisual = defVisual;
	}

	public String getDesccomp() {
		return desccomp;
	}

	public void setDesccomp(String desccomp) {
		this.desccomp = desccomp;
	}

	public String getDia() {
		return dia;
	}

	public void setDia(String dia) {
		this.dia = dia;
	}

	public String getDscLograd() {
		return dscLograd;
	}

	public void setDscLograd(String dscLograd) {
		this.dscLograd = dscLograd;
	}

	public String getDscLograddom() {
		return dscLograddom;
	}

	public void setDscLograddom(String dscLograddom) {
		this.dscLograddom = dscLograddom;
	}

	public String getDscLograd_exterior() {
		return dscLograd_exterior;
	}

	public void setDscLograd_exterior(String dscLograd_exterior) {
		this.dscLograd_exterior = dscLograd_exterior;
	}

	public String getDscSalVar() {
		return dscSalVar;
	}

	public void setDscSalVar(String dscSalVar) {
		this.dscSalVar = dscSalVar;
	}

	public String getDscTpJorn() {
		return dscTpJorn;
	}

	public void setDscTpJorn(String dscTpJorn) {
		this.dscTpJorn = dscTpJorn;
	}

	public Date getDtSdm() {
		return dtSdm;
	}

	public void setDtSdm(Date dtSdm) {
		this.dtSdm = dtSdm;
	}

	public String getDtBase() {
		return dtBase;
	}

	public void setDtBase(String dtBase) {
		this.dtBase = dtBase;
	}

	public Date getDtChegada() {
		return dtChegada;
	}

	public void setDtChegada(Date dtChegada) {
		this.dtChegada = dtChegada;
	}

	public Date getDtDeslig() {
		return dtDeslig;
	}

	public void setDtDeslig(Date dtDeslig) {
		this.dtDeslig = dtDeslig;
	}

	public Date getDtExercicio() {
		return dtExercicio;
	}

	public void setDtExercicio(Date dtExercicio) {
		this.dtExercicio = dtExercicio;
	}

	public Date getDtExpedCnh() {
		return dtExpedCnh;
	}

	public void setDtExpedCnh(Date dtExpedCnh) {
		this.dtExpedCnh = dtExpedCnh;
	}

	public Date getDtExpeDoc() {
		return dtExpeDoc;
	}

	public void setDtExpeDoc(Date dtExpeDoc) {
		this.dtExpeDoc = dtExpeDoc;
	}

	public Date getDtExpedRg() {
		return dtExpedRg;
	}

	public void setDtExpedRg(Date dtExpedRg) {
		this.dtExpedRg = dtExpedRg;
	}

	public Date getDtExpedRic() {
		return dtExpedRic;
	}

	public void setDtExpedRic(Date dtExpedRic) {
		this.dtExpedRic = dtExpedRic;
	}

	public Date getDtExpedRne() {
		return dtExpedRne;
	}

	public void setDtExpedRne(Date dtExpedRne) {
		this.dtExpedRne = dtExpedRne;
	}

	public Date getDtIngrCarr() {
		return dtIngrCarr;
	}

	public void setDtIngrCarr(Date dtIngrCarr) {
		this.dtIngrCarr = dtIngrCarr;
	}

	public Date getDtIniAfast() {
		return dtIniAfast;
	}

	public void setDtIniAfast(Date dtIniAfast) {
		this.dtIniAfast = dtIniAfast;
	}

	public Date getDtNascto_nascimento() {
		return dtNascto_nascimento;
	}

	public void setDtNascto_nascimento(Date dtNascto_nascimento) {
		this.dtNascto_nascimento = dtNascto_nascimento;
	}

	public Date getDtNomeacao() {
		return dtNomeacao;
	}

	public void setDtNomeacao(Date dtNomeacao) {
		this.dtNomeacao = dtNomeacao;
	}

	public Date getDtOpcFgts() {
		return dtOpcFgts;
	}

	public void setDtOpcFgts(Date dtOpcFgts) {
		this.dtOpcFgts = dtOpcFgts;
	}

	public Date getDtPosse() {
		return dtPosse;
	}

	public void setDtPosse(Date dtPosse) {
		this.dtPosse = dtPosse;
	}

	public Date getDtPriHab() {
		return dtPriHab;
	}

	public void setDtPriHab(Date dtPriHab) {
		this.dtPriHab = dtPriHab;
	}

	public Date getDtTerm() {
		return dtTerm;
	}

	public void setDtTerm(Date dtTerm) {
		this.dtTerm = dtTerm;
	}

	public Date getDtTransf() {
		return dtTransf;
	}

	public void setDtTransf(Date dtTransf) {
		this.dtTransf = dtTransf;
	}

	public Date getDtTransfDom() {
		return dtTransfDom;
	}

	public void setDtTransfDom(Date dtTransfDom) {
		this.dtTransfDom = dtTransfDom;
	}

	public Date getDtValidCnh() {
		return dtValidCnh;
	}

	public void setDtValidCnh(Date dtValidCnh) {
		this.dtValidCnh = dtValidCnh;
	}

	public Date getDtValiDoc() {
		return dtValiDoc;
	}

	public void setDtValiDoc(Date dtValiDoc) {
		this.dtValiDoc = dtValiDoc;
	}

	public String getEmailAlternat() {
		return emailAlternat;
	}

	public void setEmailAlternat(String emailAlternat) {
		this.emailAlternat = emailAlternat;
	}

	public String getEmailPrinc() {
		return emailPrinc;
	}

	public void setEmailPrinc(String emailPrinc) {
		this.emailPrinc = emailPrinc;
	}

	public String getEstCiv() {
		return estCiv;
	}

	public void setEstCiv(String estCiv) {
		this.estCiv = estCiv;
	}

	public String getFilhosBr() {
		return filhosBr;
	}

	public void setFilhosBr(String filhosBr) {
		this.filhosBr = filhosBr;
	}

	public String getFoneAlternat() {
		return foneAlternat;
	}

	public void setFoneAlternat(String foneAlternat) {
		this.foneAlternat = foneAlternat;
	}

	public String getFonePrinc() {
		return fonePrinc;
	}

	public void setFonePrinc(String fonePrinc) {
		this.fonePrinc = fonePrinc;
	}

	public String getGrauInstr() {
		return grauInstr;
	}

	public void setGrauInstr(String grauInstr) {
		this.grauInstr = grauInstr;
	}

	public String getHipLeg() {
		return hipLeg;
	}

	public void setHipLeg(String hipLeg) {
		this.hipLeg = hipLeg;
	}

	public String getIndAdmissao() {
		return indAdmissao;
	}

	public void setIndAdmissao(String indAdmissao) {
		this.indAdmissao = indAdmissao;
	}

	public String getIndPriEmpr() {
		return indPriEmpr;
	}

	public void setIndPriEmpr(String indPriEmpr) {
		this.indPriEmpr = indPriEmpr;
	}

	public String getIndProvim() {
		return indProvim;
	}

	public void setIndProvim(String indProvim) {
		this.indProvim = indProvim;
	}

	public String getIndRetif() {
		return indRetif;
	}

	public void setIndRetif(String indRetif) {
		this.indRetif = indRetif;
	}

	public String getInfoCota() {
		return infoCota;
	}

	public void setInfoCota(String infoCota) {
		this.infoCota = infoCota;
	}

	public String getJustContr() {
		return justContr;
	}

	public void setJustContr(String justContr) {
		this.justContr = justContr;
	}

	public String getMatricAnt() {
		return matricAnt;
	}

	public void setMatricAnt(String matricAnt) {
		this.matricAnt = matricAnt;
	}

	public String getMatricantdom() {
		return matricantdom;
	}

	public void setMatricantdom(String matricantdom) {
		this.matricantdom = matricantdom;
	}

	public String getMatricula() {
		return matricula;
	}

	public void setMatricula(String matricula) {
		this.matricula = matricula;
	}

	public String getNatAtividade() {
		return natAtividade;
	}

	public void setNatAtividade(String natAtividade) {
		this.natAtividade = natAtividade;
	}

	public String getNisTrab() {
		return nisTrab;
	}

	public void setNisTrab(String nisTrab) {
		this.nisTrab = nisTrab;
	}

	public String getNmCid() {
		return nmCid;
	}

	public void setNmCid(String nmCid) {
		this.nmCid = nmCid;
	}

	public String getNmMae() {
		return nmMae;
	}

	public void setNmMae(String nmMae) {
		this.nmMae = nmMae;
	}

	public String getNmPai() {
		return nmPai;
	}

	public void setNmPai(String nmPai) {
		this.nmPai = nmPai;
	}

	public String getNmSoc() {
		return nmSoc;
	}

	public void setNmSoc(String nmSoc) {
		this.nmSoc = nmSoc;
	}

	public String getNmTrab() {
		return nmTrab;
	}

	public void setNmTrab(String nmTrab) {
		this.nmTrab = nmTrab;
	}

	public String getNrCtps() {
		return nrCtps;
	}

	public void setNrCtps(String nrCtps) {
		this.nrCtps = nrCtps;
	}

	public String getNrInsc() {
		return nrInsc;
	}

	public void setNrInsc(String nrInsc) {
		this.nrInsc = nrInsc;
	}

	public String getNrInscAprendiz() {
		return nrInscAprendiz;
	}

	public void setNrInscAprendiz(String nrInscAprendiz) {
		this.nrInscAprendiz = nrInscAprendiz;
	}

	public String getNrInscEmpregador() {
		return nrInscEmpregador;
	}

	public void setNrInscEmpregador(String nrInscEmpregador) {
		this.nrInscEmpregador = nrInscEmpregador;
	}

	public String getNrInscEmpresa() {
		return nrInscEmpresa;
	}

	public void setNrInscEmpresa(String nrInscEmpresa) {
		this.nrInscEmpresa = nrInscEmpresa;
	}

	public String getNrInscVinculado() {
		return nrInscVinculado;
	}

	public void setNrInscVinculado(String nrInscVinculado) {
		this.nrInscVinculado = nrInscVinculado;
	}

	public String getNrLograd() {
		return nrLograd;
	}

	public void setNrLograd(String nrLograd) {
		this.nrLograd = nrLograd;
	}

	public String getNrLogradDom() {
		return nrLogradDom;
	}

	public void setNrLogradDom(String nrLogradDom) {
		this.nrLogradDom = nrLogradDom;
	}

	public String getNrLograd_exterior() {
		return nrLograd_exterior;
	}

	public void setNrLograd_exterior(String nrLograd_exterior) {
		this.nrLograd_exterior = nrLograd_exterior;
	}

	public String getNrOc() {
		return nrOc;
	}

	public void setNrOc(String nrOc) {
		this.nrOc = nrOc;
	}

	public String getNrProcJud() {
		return nrProcJud;
	}

	public void setNrProcJud(String nrProcJud) {
		this.nrProcJud = nrProcJud;
	}

	public String getNrProcJudAprendiz() {
		return nrProcJudAprendiz;
	}

	public void setNrProcJudAprendiz(String nrProcJudAprendiz) {
		this.nrProcJudAprendiz = nrProcJudAprendiz;
	}

	public String getNrRecibo() {
		return nrRecibo;
	}

	public void setNrRecibo(String nrRecibo) {
		this.nrRecibo = nrRecibo;
	}

	public String getNrRecInfPrelim() {
		return nrRecInfPrelim;
	}

	public void setNrRecInfPrelim(String nrRecInfPrelim) {
		this.nrRecInfPrelim = nrRecInfPrelim;
	}

	public String getNrRegCnh() {
		return nrRegCnh;
	}

	public void setNrRegCnh(String nrRegCnh) {
		this.nrRegCnh = nrRegCnh;
	}

	public String getNrRg() {
		return nrRg;
	}

	public void setNrRg(String nrRg) {
		this.nrRg = nrRg;
	}

	public String getNrRic() {
		return nrRic;
	}

	public void setNrRic(String nrRic) {
		this.nrRic = nrRic;
	}

	public String getNrRne() {
		return nrRne;
	}

	public void setNrRne(String nrRne) {
		this.nrRne = nrRne;
	}

	public String getObservacaoContrato() {
		return observacaoContrato;
	}

	public void setObservacaoContrato(String observacaoContrato) {
		this.observacaoContrato = observacaoContrato;
	}

	public String getObservacaoDeficiente() {
		return observacaoDeficiente;
	}

	public void setObservacaoDeficiente(String observacaoDeficiente) {
		this.observacaoDeficiente = observacaoDeficiente;
	}

	public String getObservacaoVinculo() {
		return observacaoVinculo;
	}

	public void setObservacaoVinculo(String observacaoVinculo) {
		this.observacaoVinculo = observacaoVinculo;
	}

	public String getObservacoes() {
		return observacoes;
	}

	public void setObservacoes(String observacoes) {
		this.observacoes = observacoes;
	}

	public String getOpcFgts() {
		return opcFgts;
	}

	public void setOpcFgts(String opcFgts) {
		this.opcFgts = opcFgts;
	}

	public String getOrgaoEmissorOc() {
		return orgaoEmissorOc;
	}

	public void setOrgaoEmissorOc(String orgaoEmissorOc) {
		this.orgaoEmissorOc = orgaoEmissorOc;
	}

	public String getOrgaoEmissorRg() {
		return orgaoEmissorRg;
	}

	public void setOrgaoEmissorRg(String orgaoEmissorRg) {
		this.orgaoEmissorRg = orgaoEmissorRg;
	}

	public String getOrgaoEmissorRic() {
		return orgaoEmissorRic;
	}

	public void setOrgaoEmissorRic(String orgaoEmissorRic) {
		this.orgaoEmissorRic = orgaoEmissorRic;
	}

	public String getOrgaoEmissorRne() {
		return orgaoEmissorRne;
	}

	public void setOrgaoEmissorRne(String orgaoEmissorRne) {
		this.orgaoEmissorRne = orgaoEmissorRne;
	}

	public String getPaisResid() {
		return paisResid;
	}

	public void setPaisResid(String paisResid) {
		this.paisResid = paisResid;
	}

	public String getProcEmi() {
		return procEmi;
	}

	public void setProcEmi(String procEmi) {
		this.procEmi = procEmi;
	}

	public String getQtdHrsSem() {
		return qtdHrsSem;
	}

	public void setQtdHrsSem(String qtdHrsSem) {
		this.qtdHrsSem = qtdHrsSem;
	}

	public String getRacaCor() {
		return racaCor;
	}

	public void setRacaCor(String racaCor) {
		this.racaCor = racaCor;
	}

	public String getReabReadap() {
		return reabReadap;
	}

	public void setReabReadap(String reabReadap) {
		this.reabReadap = reabReadap;
	}

	public String getSerieCtps() {
		return serieCtps;
	}

	public void setSerieCtps(String serieCtps) {
		this.serieCtps = serieCtps;
	}

	public String getSexo() {
		return sexo;
	}

	public void setSexo(String sexo) {
		this.sexo = sexo;
	}

	public String getTmpParc() {
		return tmpParc;
	}

	public void setTmpParc(String tmpParc) {
		this.tmpParc = tmpParc;
	}

	public String getTpAdmissao() {
		return tpAdmissao;
	}

	public void setTpAdmissao(String tpAdmissao) {
		this.tpAdmissao = tpAdmissao;
	}

	public String getTpAmb() {
		return tpAmb;
	}

	public void setTpAmb(String tpAmb) {
		this.tpAmb = tpAmb;
	}

	public String getTpContr() {
		return tpContr;
	}

	public void setTpContr(String tpContr) {
		this.tpContr = tpContr;
	}

	public String getTpInclContr() {
		return tpInclContr;
	}

	public void setTpInclContr(String tpInclContr) {
		this.tpInclContr = tpInclContr;
	}

	public String getTpInscAprendiz() {
		return tpInscAprendiz;
	}

	public void setTpInscAprendiz(String tpInscAprendiz) {
		this.tpInscAprendiz = tpInscAprendiz;
	}

	public String getTpInscEmpregador() {
		return tpInscEmpregador;
	}

	public void setTpInscEmpregador(String tpInscEmpregador) {
		this.tpInscEmpregador = tpInscEmpregador;
	}

	public String getTpInscLocalTrab() {
		return tpInscLocalTrab;
	}

	public void setTpInscLocalTrab(String tpInscLocalTrab) {
		this.tpInscLocalTrab = tpInscLocalTrab;
	}

	public String getTpInscTomador() {
		return tpInscTomador;
	}

	public void setTpInscTomador(String tpInscTomador) {
		this.tpInscTomador = tpInscTomador;
	}

	public String getTpInscVinculo() {
		return tpInscVinculo;
	}

	public void setTpInscVinculo(String tpInscVinculo) {
		this.tpInscVinculo = tpInscVinculo;
	}

	public String getTpJornada() {
		return tpJornada;
	}

	public void setTpJornada(String tpJornada) {
		this.tpJornada = tpJornada;
	}

	public String getTpLograd() {
		return tpLograd;
	}

	public void setTpLograd(String tpLograd) {
		this.tpLograd = tpLograd;
	}

	public String getTpLogradDom() {
		return tpLogradDom;
	}

	public void setTpLogradDom(String tpLogradDom) {
		this.tpLogradDom = tpLogradDom;
	}

	public String getTpPlanRp() {
		return tpPlanRp;
	}

	public void setTpPlanRp(String tpPlanRp) {
		this.tpPlanRp = tpPlanRp;
	}

	public String getTpProv() {
		return tpProv;
	}

	public void setTpProv(String tpProv) {
		this.tpProv = tpProv;
	}

	public String getTpRegJor() {
		return tpRegJor;
	}

	public void setTpRegJor(String tpRegJor) {
		this.tpRegJor = tpRegJor;
	}

	public String getTpRegPrev() {
		return tpRegPrev;
	}

	public void setTpRegPrev(String tpRegPrev) {
		this.tpRegPrev = tpRegPrev;
	}

	public String getTpRegTrab() {
		return tpRegTrab;
	}

	public void setTpRegTrab(String tpRegTrab) {
		this.tpRegTrab = tpRegTrab;
	}

	public String getTrabAposent() {
		return trabAposent;
	}

	public void setTrabAposent(String trabAposent) {
		this.trabAposent = trabAposent;
	}

	public String getUfCnh() {
		return ufCnh;
	}

	public void setUfCnh(String ufCnh) {
		this.ufCnh = ufCnh;
	}

	public String getUfCtps() {
		return ufCtps;
	}

	public void setUfCtps(String ufCtps) {
		this.ufCtps = ufCtps;
	}

	public String getUfDom() {
		return ufDom;
	}

	public void setUfDom(String ufDom) {
		this.ufDom = ufDom;
	}

	public String getUfNascimento() {
		return ufNascimento;
	}

	public void setUfNascimento(String ufNascimento) {
		this.ufNascimento = ufNascimento;
	}

	public String getUfTrab() {
		return ufTrab;
	}

	public void setUfTrab(String ufTrab) {
		this.ufTrab = ufTrab;
	}

	public String getUndSalFixo() {
		return undSalFixo;
	}

	public void setUndSalFixo(String undSalFixo) {
		this.undSalFixo = undSalFixo;
	}

	public String getVerProc() {
		return verProc;
	}

	public void setVerProc(String verProc) {
		this.verProc = verProc;
	}

	public String getVrSalFx() {
		return vrSalFx;
	}

	public void setVrSalFx(String vrSalFx) {
		this.vrSalFx = vrSalFx;
	}

	public List<Dependente> getList_dependente() {
		return list_dependente;
	}

	public void setList_dependente(List<Dependente> list_dependente) {
		this.list_dependente = list_dependente;
	}

	public CategoriaTrabalhador getCodcateg() {
		return codcateg;
	}

	public void setCodcateg(CategoriaTrabalhador codcateg) {
		this.codcateg = codcateg;
	}

	public Paises getPaisnac() {
		return paisnac;
	}

	public void setPaisnac(Paises paisnac) {
		this.paisnac = paisnac;
	}

	public Paises getPaisnascto() {
		return paisnascto;
	}

	public void setPaisnascto(Paises paisnascto) {
		this.paisnascto = paisnascto;
	}

}
