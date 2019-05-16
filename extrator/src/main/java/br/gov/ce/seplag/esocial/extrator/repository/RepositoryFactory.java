package br.gov.ce.seplag.esocial.extrator.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.gov.ce.seplag.esocial.extrator.enumeration.TipoEventoEnum;
import br.gov.ce.seplag.esocial.extrator.repository.eventos.S1000Repository;
import br.gov.ce.seplag.esocial.extrator.repository.eventos.S1005Repository;
import br.gov.ce.seplag.esocial.extrator.repository.eventos.S1010Repository;
import br.gov.ce.seplag.esocial.extrator.repository.eventos.S1030Repository;
import br.gov.ce.seplag.esocial.extrator.repository.eventos.S1035Repository;
import br.gov.ce.seplag.esocial.extrator.repository.eventos.S1040Repository;
import br.gov.ce.seplag.esocial.extrator.repository.eventos.S1050Repository;
import br.gov.ce.seplag.esocial.extrator.repository.eventos.S1060Repository;
import br.gov.ce.seplag.esocial.extrator.repository.eventos.S1070Repository;
import br.gov.ce.seplag.esocial.extrator.repository.eventos.S2200Repository;

@Service
public class RepositoryFactory {
	
	@Autowired
	S1000Repository s1000Repository;
	
	@Autowired
	S1005Repository s1005Repository;
	
	@Autowired
	S1010Repository s1010Repository;
	
	@Autowired
	S1030Repository s1030Repository;
	
	@Autowired
	S1035Repository s1035Repository;
	
	@Autowired
	S1040Repository s1040Repository;
	
	@Autowired
	S1050Repository s1050Repository;
	
	@Autowired
	S1060Repository s1060Repository;
	
	@Autowired
	S1070Repository s1070Repository;
	
	@Autowired
	S2200Repository s2200Repository;

	public GenericRepository<?> getRepository(TipoEventoEnum tipoEvento) {
		
		switch (tipoEvento) {
		case S1000:
			return s1000Repository;
		case S1005:
			return s1005Repository;
		case S1010:
			return s1010Repository;
		case S1030:
			return s1030Repository;
		case S1035:
			return s1035Repository;
		case S1040:
			return s1040Repository;
		case S1050:
			return s1050Repository;
		case S1060:
			return s1060Repository;
		case S1070:
			return s1070Repository;
		case S2200:
			return s2200Repository;
		default:
			break;
		}
		
		return null;
	}
	
	public GenericCustomRepository<?> getRepositoryCustom(TipoEventoEnum tipoEvento) {
		
		switch (tipoEvento) {
		case S1000:
			return s1000Repository;
		default:
			break;
		}
		
		return null;
	}
}
