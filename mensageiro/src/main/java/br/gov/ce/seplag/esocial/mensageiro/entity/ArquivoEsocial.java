package br.gov.ce.seplag.esocial.mensageiro.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import br.gov.ce.seplag.esocial.mensageiro.enumeration.StatusArquivoEsocialEnum;
import br.gov.ce.seplag.esocial.mensageiro.enumeration.TipoEventoEnum;

@Entity
@Table(name = "tb_arquivo_esocial", schema = "db_esocial")
@JsonIdentityInfo(
		  generator = ObjectIdGenerators.PropertyGenerator.class, 
		  property = "isnArquivoEsocial")
public class ArquivoEsocial implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name = "db_esocial.sq_pk_arquivo_esocial", sequenceName = "db_esocial.sq_pk_arquivo_esocial", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "db_esocial.sq_pk_arquivo_esocial")
	@Column(name = "isn_arquivo_esocial")
	private Long isnArquivoEsocial;

	@Column(name = "txt_descricao")
	private String descricao;
	
	@Column(name = "data_criacao")
	private Date dataCriacao;

	@Column(name = "arquivo_original")
	private byte[] arquivoOriginal;
	
	@Column(name = "arquivo_assinado")
	private byte[] arquivoAssinado;
	
	@Enumerated(EnumType.STRING)
	private TipoEventoEnum tipoEvento;

	@Column(name = "id_evento")
	private String idEvento;

	@ManyToOne
	@JoinColumn(name = "isn_processamento_lote")
	private ProcessamentoLote processamentoLote;
	
	@Enumerated(EnumType.STRING)
	private StatusArquivoEsocialEnum status;
	
	@OneToMany(mappedBy = "arquivoEsocial")
	private List<Ocorrencia> listOcorrencias;
	
	@Column(name="nrinsc_ideempregador")
	private String nrInsc_ideEmpregador;

	public Long getIsnArquivoEsocial() {
		return isnArquivoEsocial;
	}

	public void setIsnArquivoEsocial(Long isnArquivoEsocial) {
		this.isnArquivoEsocial = isnArquivoEsocial;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public Date getDataCriacao() {
		return dataCriacao;
	}

	public void setDataCriacao(Date dataCriacao) {
		this.dataCriacao = dataCriacao;
	}

	public byte[] getArquivoOriginal() {
		return arquivoOriginal;
	}

	public void setArquivoOriginal(byte[] arquivoOriginal) {
		this.arquivoOriginal = arquivoOriginal;
	}

	public byte[] getArquivoAssinado() {
		return arquivoAssinado;
	}

	public void setArquivoAssinado(byte[] arquivoAssinado) {
		this.arquivoAssinado = arquivoAssinado;
	}

	public TipoEventoEnum getTipoEvento() {
		return tipoEvento;
	}

	public void setTipoEvento(TipoEventoEnum tipoEvento) {
		this.tipoEvento = tipoEvento;
	}

	public String getIdEvento() {
		return idEvento;
	}

	public void setIdEvento(String idEvento) {
		this.idEvento = idEvento;
	}

	public StatusArquivoEsocialEnum getStatus() {
		return status;
	}

	public void setStatus(StatusArquivoEsocialEnum status) {
		this.status = status;
	}

	public ProcessamentoLote getProcessamentoLote() {
		return processamentoLote;
	}

	public void setProcessamentoLote(ProcessamentoLote processamentoLote) {
		this.processamentoLote = processamentoLote;
	}

	public List<Ocorrencia> getListOcorrencias() {
		return listOcorrencias;
	}

	public void setListOcorrencias(List<Ocorrencia> listOcorrencias) {
		this.listOcorrencias = listOcorrencias;
	}

	public String getNrInsc_ideEmpregador() {
		return nrInsc_ideEmpregador;
	}

	public void setNrInsc_ideEmpregador(String nrInsc_ideEmpregador) {
		this.nrInsc_ideEmpregador = nrInsc_ideEmpregador;
	}


}
