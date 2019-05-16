package br.gov.ce.seplag.esocial.mensageiro.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import br.gov.ce.seplag.esocial.mensageiro.entity.ArquivoEsocial;
import br.gov.ce.seplag.esocial.mensageiro.enumeration.StatusArquivoEsocialEnum;


public interface MensageiroRepository extends CrudRepository<ArquivoEsocial, Long> {

	ArquivoEsocial findByIdEvento(String idEvento);

	List<ArquivoEsocial> findByStatus(StatusArquivoEsocialEnum statusArquivoEsocialEnum);
}
