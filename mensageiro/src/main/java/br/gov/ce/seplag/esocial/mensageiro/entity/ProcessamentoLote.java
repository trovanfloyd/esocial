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
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import br.gov.ce.seplag.esocial.mensageiro.enumeration.StatusProcessamentoLoteEnum;

@Entity
@Table(name = "tb_processamento_lote", schema = "db_esocial")
@JsonIdentityInfo(
		  generator = ObjectIdGenerators.PropertyGenerator.class, 
		  property = "isnProcessamentoLote")
public class ProcessamentoLote implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name = "db_esocial.sq_pk_processamento_lote", sequenceName = "db_esocial.sq_pk_processamento_lote", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "db_esocial.sq_pk_processamento_lote")
	@Column(name = "isn_retorno_envio_lote")
	private Long isnProcessamentoLote;

	@Column(name = "protocoloenvio")
	private String protocoloEnvio;
	
	@Enumerated(EnumType.STRING)
	private StatusProcessamentoLoteEnum status;
	
	@Column(name = "data_envio")
	private Date dataEnvio;
	
	@OneToMany(mappedBy = "processamentoLote")
	private List<ArquivoEsocial> listArquivos;
	
	@OneToMany(mappedBy = "processamentoLote")
	private List<Ocorrencia> listOcorrencias;

	public Long getIsnProcessamentoLote() {
		return isnProcessamentoLote;
	}

	public void setIsnProcessamentoLote(Long isnProcessamentoLote) {
		this.isnProcessamentoLote = isnProcessamentoLote;
	}

	public String getProtocoloEnvio() {
		return protocoloEnvio;
	}

	public void setProtocoloEnvio(String protocoloEnvio) {
		this.protocoloEnvio = protocoloEnvio;
	}


	public StatusProcessamentoLoteEnum getStatus() {
		return status;
	}

	public void setStatus(StatusProcessamentoLoteEnum status) {
		this.status = status;
	}

	public List<ArquivoEsocial> getListArquivos() {
		return listArquivos;
	}

	public void setListArquivos(List<ArquivoEsocial> listArquivos) {
		this.listArquivos = listArquivos;
	}

	public Date getDataEnvio() {
		return dataEnvio;
	}

	public void setDataEnvio(Date dataEnvio) {
		this.dataEnvio = dataEnvio;
	}

	public List<Ocorrencia> getListOcorrencias() {
		return listOcorrencias;
	}

	public void setListOcorrencias(List<Ocorrencia> listOcorrencias) {
		this.listOcorrencias = listOcorrencias;
	}

	
}
