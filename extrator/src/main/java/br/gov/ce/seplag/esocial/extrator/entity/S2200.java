package br.gov.ce.seplag.esocial.extrator.entity;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "tb_s2200_v2", schema = "db_esocial")
public class S2200 implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	@Column(name = "isn_s2200")
	private Long id;

/*	@Column(name = "id")
	private String id;*/

	@Column(name = "bairro")
	private String bairro_brasil;

	@Column(name = "bairrodom")
	private String bairro_localTrabDom;

	@Column(name = "bairroexterior")
	private String bairro_exterior;

	@Column(name = "cadini")
	private String cadIni;

	@Column(name = "casadobr")
	private String casadoBr;

	@Column(name = "categoriacnh")
	private String categoriaCnh;

	@Column(name = "cep")
	private String cep_brasil;

	@Column(name = "cepexterior")
	private String cep_exterior;

	@Column(name = "classtrabestrang")
	private String classTrabEstrang;

	@Column(name = "clauassec")
	private String clauAssec;

	@Column(name = "cnpjempregant")
	private String cnpjEmpregAnt;

	@Column(name = "cnpjsindcategprof")
	private String cnpjSindCategProf;

	@Column(name = "cnpjsindtrab")
	private String cnpjSindTrab;

	@Column(name = "codcargo")
	private String codCargo;

	@Column(name = "codcateg")
	private String codCateg;

	@Column(name = "codcarreira")
	private String codCarreira;

	@Column(name = "codfuncao")
	private String codFuncao;

	@Column(name = "codhorcontrat")
	private String codHorContrat;

	@Column(name = "codmotafast")
	private String codMotAfast;

	@Column(name = "codmunic")
	private String codMunic_brasil;

	@Column(name = "paisnac")
	private String paisNac;

	@Column(name = "paisnascto")
	private String paisNascto;

	@Column(name = "codmunicdom")
	private String codMunic_localTrabDom;

	@Column(name = "codmunicnasc")
	private String codMunic_nascimento;

	@Column(name = "codpostal")
	private String codPostal;

	@Column(name = "complemento")
	private String complemento_brasil;

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

	@Column(name = "desccomp")
	private String descComp;

	private String dia;

	@Column(name = "dsclograd")
	private String dscLograd_brasil;

	@Column(name = "dsclograddom")
	private String dscLograd_localTrabDom;

	@Column(name = "dsclogradexterior")
	private String dscLograd_exterior;

	@Column(name = "dscsalvar")
	private String dscSalVar;

	@Column(name = "dsctpjorn")
	private String dscTpJorn;

	@Column(name = "dtadm")
	private String dtAdm;

	@Column(name = "dtbase")
	private String dtBase;

	@Column(name = "dtchegada")
	private String dtChegada;

	@Column(name = "dtdeslig")
	private String dtDeslig;

	@Column(name = "dtexercicio")
	private String dtExercicio;

	@Column(name = "dtexpedcnh")
	private String dtExped_CNH;

	@Column(name = "dtexpedoc")
	private String dtExped_OC;

	@Column(name = "dtexpedrg")
	private String dtExped_RG;

	@Column(name = "dtexpedric")
	private String dtExped_RIC;

	@Column(name = "dtexpedrne")
	private String dtExped_RNE;

	@Column(name = "dtingrcarr")
	private String dtIngrCarr;

	@Column(name = "dtiniafast")
	private String dtIniAfast;

	@Column(name = "dtnascto")
	private String dtNascto_nascimento;

	@Column(name = "dtnomeacao")
	private String dtNomeacao;

	@Column(name = "dtopcfgts")
	private String dtOpcFGTS;

	@Column(name = "dtposse")
	private String dtPosse;

	@Column(name = "dtprihab")
	private String dtPriHab;

	@Column(name = "dtterm")
	private String dtTerm;

	@Column(name = "dttransf")
	private String dtTransf_sucessaoVinc;

	@Column(name = "dttransfdom")
	private String dtTransf_transfDom;

	@Column(name = "dtvalidcnh")
	private String dtValid_CNH;

	@Column(name = "dtvalidoc")
	private String dtValid_OC;

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
	private String matricAnt_sucessaoVinc;

	@Column(name = "matricantdom")
	private String matricant_transfDom;

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
	private String nrInsc_localTrabGeral;

	@Column(name = "nrinscaprendiz")
	private String nrInsc_aprend;

	@Column(name = "nrinscempregador")
	private String nrInsc_ideEmpregador;

	@Column(name = "nrinscempresa")
	private String nrInsc_ideTomadorServ;

	@Column(name = "nrinscvinculado")
	private String nrInsc_ideEstabVinc;

	@Column(name = "nrlograd")
	private String nrLograd_brasil;

	@Column(name = "nrlograddom")
	private String nrLograd_localTrabDom;

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
	private String observacao_observacoes;

	@Column(name = "observacaodeficiente")
	private String observacao_infoDeficiencia;

	@Column(name = "observacaovinculo")
	private String observacao_sucessaoVinc;

	private String observacoes;

	@Column(name = "opcfgts")
	private String opcFgts;

	@Column(name = "orgaoemissoroc")
	private String orgaoEmissor_OC;

	@Column(name = "orgaoemissorrg")
	private String orgaoEmissor_RG;

	@Column(name = "orgaoemissorric")
	private String orgaoEmissor_RIC;

	@Column(name = "orgaoemissorrne")
	private String orgaoEmissor_RNE;

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
	private String tpInsc_aprend;

	@Column(name = "tpinscempregador")
	private String tpInsc_ideEmpregador;

	@Column(name = "tpinsclocaltrab")
	private String tpInsc_localTrabGeral;

	@Column(name = "tpinsctomador")
	private String tpInsc_ideTomadorServ;

	@Column(name = "tpinscvinculo")
	private String tpInsc_ideEstabVinc;

	@Column(name = "tpjornada")
	private String tpJornada;

	@Column(name = "tplograd")
	private String tpLograd_brasil;

	@Column(name = "tplograddom")
	private String tpLograd_localTrabDom;

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
	private String uf_localTrabDom;

	@Column(name = "ufnascimento")
	private String uf_nascimento;

	@Column(name = "uftrab")
	private String uf_brasil;

	@Column(name = "undsalfixo")
	private String undSalFixo;

	@Column(name = "verproc")
	private String verProc;

	@Column(name = "vrsalfx")
	private String vrSalFx;

	@OneToMany(mappedBy = "isnS2200")
	private List<Dependente> list_dependente;


	public Long getId() {
		return id;
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

	public String getCadIni() {
		return cadIni;
	}

	public void setCadIni(String cadIni) {
		this.cadIni = cadIni;
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

	public String getCep_brasil() {
		return cep_brasil;
	}

	public void setCep_brasil(String cep_brasil) {
		this.cep_brasil = cep_brasil;
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

	public String getClauAssec() {
		return clauAssec;
	}

	public void setClauAssec(String clauAssec) {
		this.clauAssec = clauAssec;
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

	public String getCodMunic_brasil() {
		return codMunic_brasil;
	}

	public void setCodMunic_brasil(String codMunic_brasil) {
		this.codMunic_brasil = codMunic_brasil;
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

	public String getComplemento_brasil() {
		return complemento_brasil;
	}

	public void setComplemento_brasil(String complemento_brasil) {
		this.complemento_brasil = complemento_brasil;
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

	public String getDescComp() {
		return descComp;
	}

	public void setDescComp(String descComp) {
		this.descComp = descComp;
	}

	public String getDia() {
		return dia;
	}

	public void setDia(String dia) {
		this.dia = dia;
	}

	public String getDscLograd_brasil() {
		return dscLograd_brasil;
	}

	public void setDscLograd_brasil(String dscLograd_brasil) {
		this.dscLograd_brasil = dscLograd_brasil;
	}

	public String getDscLograd_localTrabDom() {
		return dscLograd_localTrabDom;
	}

	public void setDscLograd_localTrabDom(String dscLograd_localTrabDom) {
		this.dscLograd_localTrabDom = dscLograd_localTrabDom;
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

	public String getDtAdm() {
		return dtAdm;
	}

	public void setDtAdm(String dtAdm) {
		this.dtAdm = dtAdm;
	}

	public String getDtBase() {
		return dtBase;
	}

	public void setDtBase(String dtBase) {
		this.dtBase = dtBase;
	}

	public String getDtChegada() {
		return dtChegada;
	}

	public void setDtChegada(String dtChegada) {
		this.dtChegada = dtChegada;
	}

	public String getDtDeslig() {
		return dtDeslig;
	}

	public void setDtDeslig(String dtDeslig) {
		this.dtDeslig = dtDeslig;
	}

	public String getDtExercicio() {
		return dtExercicio;
	}

	public void setDtExercicio(String dtExercicio) {
		this.dtExercicio = dtExercicio;
	}

	public String getDtExped_CNH() {
		return dtExped_CNH;
	}

	public void setDtExped_CNH(String dtExped_CNH) {
		this.dtExped_CNH = dtExped_CNH;
	}

	public String getDtExped_OC() {
		return dtExped_OC;
	}

	public void setDtExped_OC(String dtExped_OC) {
		this.dtExped_OC = dtExped_OC;
	}

	public String getDtExped_RG() {
		return dtExped_RG;
	}

	public void setDtExped_RG(String dtExped_RG) {
		this.dtExped_RG = dtExped_RG;
	}

	public String getDtExped_RIC() {
		return dtExped_RIC;
	}

	public void setDtExped_RIC(String dtExped_RIC) {
		this.dtExped_RIC = dtExped_RIC;
	}

	public String getDtExped_RNE() {
		return dtExped_RNE;
	}

	public void setDtExped_RNE(String dtExped_RNE) {
		this.dtExped_RNE = dtExped_RNE;
	}

	public String getDtIngrCarr() {
		return dtIngrCarr;
	}

	public void setDtIngrCarr(String dtIngrCarr) {
		this.dtIngrCarr = dtIngrCarr;
	}

	public String getDtIniAfast() {
		return dtIniAfast;
	}

	public void setDtIniAfast(String dtIniAfast) {
		this.dtIniAfast = dtIniAfast;
	}

	public String getDtNascto_nascimento() {
		return dtNascto_nascimento;
	}

	public void setDtNascto_nascimento(String dtNascto_nascimento) {
		this.dtNascto_nascimento = dtNascto_nascimento;
	}

	public String getDtNomeacao() {
		return dtNomeacao;
	}

	public void setDtNomeacao(String dtNomeacao) {
		this.dtNomeacao = dtNomeacao;
	}

	public String getDtOpcFGTS() {
		return dtOpcFGTS;
	}

	public void setDtOpcFGTS(String dtOpcFGTS) {
		this.dtOpcFGTS = dtOpcFGTS;
	}

	public String getDtPosse() {
		return dtPosse;
	}

	public void setDtPosse(String dtPosse) {
		this.dtPosse = dtPosse;
	}

	public String getDtPriHab() {
		return dtPriHab;
	}

	public void setDtPriHab(String dtPriHab) {
		this.dtPriHab = dtPriHab;
	}

	public String getDtTerm() {
		return dtTerm;
	}

	public void setDtTerm(String dtTerm) {
		this.dtTerm = dtTerm;
	}

	public String getDtTransf_sucessaoVinc() {
		return dtTransf_sucessaoVinc;
	}

	public void setDtTransf_sucessaoVinc(String dtTransf_sucessaoVinc) {
		this.dtTransf_sucessaoVinc = dtTransf_sucessaoVinc;
	}

	public String getDtTransf_transfDom() {
		return dtTransf_transfDom;
	}

	public void setDtTransf_transfDom(String dtTransf_transfDom) {
		this.dtTransf_transfDom = dtTransf_transfDom;
	}

	public String getDtValid_CNH() {
		return dtValid_CNH;
	}

	public void setDtValid_CNH(String dtValid_CNH) {
		this.dtValid_CNH = dtValid_CNH;
	}

	public String getDtValid_OC() {
		return dtValid_OC;
	}

	public void setDtValid_OC(String dtValid_OC) {
		this.dtValid_OC = dtValid_OC;
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

	public String getMatricAnt_sucessaoVinc() {
		return matricAnt_sucessaoVinc;
	}

	public void setMatricAnt_sucessaoVinc(String matricAnt_sucessaoVinc) {
		this.matricAnt_sucessaoVinc = matricAnt_sucessaoVinc;
	}

	public String getMatricant_transfDom() {
		return matricant_transfDom;
	}

	public void setMatricant_transfDom(String matricant_transfDom) {
		this.matricant_transfDom = matricant_transfDom;
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

	public String getNrInsc_localTrabGeral() {
		return nrInsc_localTrabGeral;
	}

	public void setNrInsc_localTrabGeral(String nrInsc_localTrabGeral) {
		this.nrInsc_localTrabGeral = nrInsc_localTrabGeral;
	}

	public String getNrInsc_aprend() {
		return nrInsc_aprend;
	}

	public void setNrInsc_aprend(String nrInsc_aprend) {
		this.nrInsc_aprend = nrInsc_aprend;
	}

	public String getNrInsc_ideEmpregador() {
		return nrInsc_ideEmpregador;
	}

	public void setNrInsc_ideEmpregador(String nrInsc_ideEmpregador) {
		this.nrInsc_ideEmpregador = nrInsc_ideEmpregador;
	}

	public String getNrInsc_ideTomadorServ() {
		return nrInsc_ideTomadorServ;
	}

	public void setNrInsc_ideTomadorServ(String nrInsc_ideTomadorServ) {
		this.nrInsc_ideTomadorServ = nrInsc_ideTomadorServ;
	}

	public String getNrInsc_ideEstabVinc() {
		return nrInsc_ideEstabVinc;
	}

	public void setNrInsc_ideEstabVinc(String nrInsc_ideEstabVinc) {
		this.nrInsc_ideEstabVinc = nrInsc_ideEstabVinc;
	}

	public String getNrLograd_brasil() {
		return nrLograd_brasil;
	}

	public void setNrLograd_brasil(String nrLograd_brasil) {
		this.nrLograd_brasil = nrLograd_brasil;
	}

	public String getNrLograd_localTrabDom() {
		return nrLograd_localTrabDom;
	}

	public void setNrLograd_localTrabDom(String nrLograd_localTrabDom) {
		this.nrLograd_localTrabDom = nrLograd_localTrabDom;
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

	public String getObservacao_observacoes() {
		return observacao_observacoes;
	}

	public void setObservacao_observacoes(String observacao_observacoes) {
		this.observacao_observacoes = observacao_observacoes;
	}

	public String getObservacao_infoDeficiencia() {
		return observacao_infoDeficiencia;
	}

	public void setObservacao_infoDeficiencia(String observacao_infoDeficiencia) {
		this.observacao_infoDeficiencia = observacao_infoDeficiencia;
	}

	public String getObservacao_sucessaoVinc() {
		return observacao_sucessaoVinc;
	}

	public void setObservacao_sucessaoVinc(String observacao_sucessaoVinc) {
		this.observacao_sucessaoVinc = observacao_sucessaoVinc;
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

	public String getOrgaoEmissor_OC() {
		return orgaoEmissor_OC;
	}

	public void setOrgaoEmissor_OC(String orgaoEmissor_OC) {
		this.orgaoEmissor_OC = orgaoEmissor_OC;
	}

	public String getOrgaoEmissor_RG() {
		return orgaoEmissor_RG;
	}

	public void setOrgaoEmissor_RG(String orgaoEmissor_RG) {
		this.orgaoEmissor_RG = orgaoEmissor_RG;
	}

	public String getOrgaoEmissor_RIC() {
		return orgaoEmissor_RIC;
	}

	public void setOrgaoEmissor_RIC(String orgaoEmissor_RIC) {
		this.orgaoEmissor_RIC = orgaoEmissor_RIC;
	}

	public String getOrgaoEmissor_RNE() {
		return orgaoEmissor_RNE;
	}

	public void setOrgaoEmissor_RNE(String orgaoEmissor_RNE) {
		this.orgaoEmissor_RNE = orgaoEmissor_RNE;
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

	public String getTpInsc_aprend() {
		return tpInsc_aprend;
	}

	public void setTpInsc_aprend(String tpInsc_aprend) {
		this.tpInsc_aprend = tpInsc_aprend;
	}

	public String getTpInsc_ideEmpregador() {
		return tpInsc_ideEmpregador;
	}

	public void setTpInsc_ideEmpregador(String tpInsc_ideEmpregador) {
		this.tpInsc_ideEmpregador = tpInsc_ideEmpregador;
	}

	public String getTpInsc_localTrabGeral() {
		return tpInsc_localTrabGeral;
	}

	public void setTpInsc_localTrabGeral(String tpInsc_localTrabGeral) {
		this.tpInsc_localTrabGeral = tpInsc_localTrabGeral;
	}

	public String getTpInsc_ideTomadorServ() {
		return tpInsc_ideTomadorServ;
	}

	public void setTpInsc_ideTomadorServ(String tpInsc_ideTomadorServ) {
		this.tpInsc_ideTomadorServ = tpInsc_ideTomadorServ;
	}

	public String getTpInsc_ideEstabVinc() {
		return tpInsc_ideEstabVinc;
	}

	public void setTpInsc_ideEstabVinc(String tpInsc_ideEstabVinc) {
		this.tpInsc_ideEstabVinc = tpInsc_ideEstabVinc;
	}

	public String getTpJornada() {
		return tpJornada;
	}

	public void setTpJornada(String tpJornada) {
		this.tpJornada = tpJornada;
	}

	public String getTpLograd_brasil() {
		return tpLograd_brasil;
	}

	public void setTpLograd_brasil(String tpLograd_brasil) {
		this.tpLograd_brasil = tpLograd_brasil;
	}

	public String getTpLograd_localTrabDom() {
		return tpLograd_localTrabDom;
	}

	public void setTpLograd_localTrabDom(String tpLograd_localTrabDom) {
		this.tpLograd_localTrabDom = tpLograd_localTrabDom;
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

	public String getUf_localTrabDom() {
		return uf_localTrabDom;
	}

	public void setUf_localTrabDom(String uf_localTrabDom) {
		this.uf_localTrabDom = uf_localTrabDom;
	}

	public String getUf_nascimento() {
		return uf_nascimento;
	}

	public void setUf_nascimento(String uf_nascimento) {
		this.uf_nascimento = uf_nascimento;
	}

	public String getUf_brasil() {
		return uf_brasil;
	}

	public void setUf_brasil(String uf_brasil) {
		this.uf_brasil = uf_brasil;
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

	public String getCodCateg() {
		return codCateg;
	}

	public void setCodCateg(String codCateg) {
		this.codCateg = codCateg;
	}

	public String getPaisNac() {
		return paisNac;
	}

	public void setPaisNac(String paisNac) {
		this.paisNac = paisNac;
	}

	public String getPaisNascto() {
		return paisNascto;
	}

	public void setPaisNascto(String paisNascto) {
		this.paisNascto = paisNascto;
	}

}
