package com.seplag.esocial.mensageiro.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "tb_arquivo_esocial", schema = "db_esocial")
public class ArquivoEsocial implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name = "db_esocial.sq_pk_arquivo_esocial", sequenceName = "db_esocial.sq_pk_arquivo_esocial")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "db_esocial.sq_pk_arquivo_esocial")
	@Column(name = "isn_arquivo_esocial")
	private Long isnArquivoEsocial;

	@Column(name = "txt_descricao")
	private String descricao;

	@Column(name = "data_criacao")
	private Date dataCriacao;

	@Column(name = "arquivo")
	private byte[] arquivo;

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

	public byte[] getArquivo() {
		return arquivo;
	}

	public void setArquivo(byte[] arquivo) {
		this.arquivo = arquivo;
	}

}
