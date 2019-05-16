package br.gov.ce.seplag.esocial.mensageiro.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import br.gov.ce.seplag.esocial.mensageiro.entity.ProcessamentoLote;
import br.gov.ce.seplag.esocial.mensageiro.enumeration.StatusProcessamentoLoteEnum;


public interface ProcessamentoLoteRepository extends CrudRepository<ProcessamentoLote, Long> {

	List<ProcessamentoLote> findByStatus(StatusProcessamentoLoteEnum status);
}
