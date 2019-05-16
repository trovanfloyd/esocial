package br.gov.ce.seplag.esocial.mensageiro.dto;

import java.util.List;

import br.gov.ce.seplag.esocial.mensageiro.entity.ArquivoEsocial;
import br.gov.ce.seplag.esocial.mensageiro.schemas.EnviarLoteEventos;

public class LoteEventosDTO  {

	private EnviarLoteEventos loteEventos;
	private List<ArquivoEsocial> listArquivos;
	
	public LoteEventosDTO() {
		
	}
	
	public LoteEventosDTO(EnviarLoteEventos loteEventos, List<ArquivoEsocial> listArquivos) {
		this.loteEventos = loteEventos;
		this.listArquivos = listArquivos;
	}
	
	public EnviarLoteEventos getLoteEventos() {
		return loteEventos;
	}
	public void setLoteEventos(EnviarLoteEventos loteEventos) {
		this.loteEventos = loteEventos;
	}
	public List<ArquivoEsocial> getListArquivos() {
		return listArquivos;
	}
	public void setListArquivos(List<ArquivoEsocial> listArquivos) {
		this.listArquivos = listArquivos;
	}
	
	
}
