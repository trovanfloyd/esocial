package br.gov.ce.seplag.esocial.mensageiro.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

@Entity
@Table(name = "tb_ocorrencia", schema = "db_esocial")
@JsonIdentityInfo(
		  generator = ObjectIdGenerators.PropertyGenerator.class, 
		  property = "isn_ocorrencia")
public class Ocorrencia implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name = "db_esocial.sq_pk_ocorrencia", sequenceName = "db_esocial.sq_pk_ocorrencia", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "db_esocial.sq_pk_ocorrencia")
	@Column(name = "isn_ocorrencia")
	private Long isn_ocorrencia;

	@Column(name = "codigo")
	private String codigo;
	
	@Column(name = "descricao")
	private String descricao;
	
	@Column(name = "tipo")
	private String tipo;
	
	@Column(name = "localizacao")
	private String localizacao;
	
	@ManyToOne
	@JoinColumn(name = "isn_arquivo_esocial")
	private ArquivoEsocial arquivoEsocial;
	
	@ManyToOne
	@JoinColumn(name = "isn_processamento_lote")
	private ProcessamentoLote processamentoLote;
	
	public Ocorrencia() {
		
	}

	public Ocorrencia(Integer codigo, String descricao, Short tipo, String localizacao) {
		this.codigo = codigo.toString();
		this.descricao = descricao;
		this.tipo = tipo.toString();
		this.localizacao = localizacao;
	}
	
	public Ocorrencia(Integer codigo, String descricao, Short tipo, String localizacao, ProcessamentoLote processamentoLote) {
		this.codigo = codigo.toString();
		this.descricao = descricao;
		this.tipo = tipo.toString();
		this.localizacao = localizacao;
		this.processamentoLote = processamentoLote;
	}
	
	public Ocorrencia(Integer codigo, String descricao) {
		this.codigo = codigo.toString();
		this.descricao = descricao;
	}
	
	public Long getIsn_ocorrencia() {
		return isn_ocorrencia;
	}

	public void setIsn_ocorrencia(Long isn_ocorrencia) {
		this.isn_ocorrencia = isn_ocorrencia;
	}

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public String getLocalizacao() {
		return localizacao;
	}

	public void setLocalizacao(String localizacao) {
		this.localizacao = localizacao;
	}

	public ArquivoEsocial getArquivoEsocial() {
		return arquivoEsocial;
	}

	public void setArquivoEsocial(ArquivoEsocial arquivoEsocial) {
		this.arquivoEsocial = arquivoEsocial;
	}

	public ProcessamentoLote getProcessamentoLote() {
		return processamentoLote;
	}

	public void setProcessamentoLote(ProcessamentoLote processamentoLote) {
		this.processamentoLote = processamentoLote;
	}


	
	
}
