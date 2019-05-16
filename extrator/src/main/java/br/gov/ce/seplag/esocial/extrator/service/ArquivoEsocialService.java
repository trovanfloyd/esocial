package br.gov.ce.seplag.esocial.extrator.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.gov.ce.seplag.esocial.extrator.entity.ArquivoEsocial;
import br.gov.ce.seplag.esocial.extrator.repository.ArquivoEsocialRepository;


@Service
public class ArquivoEsocialService {

	@Autowired
	ArquivoEsocialRepository arquivoEsocialRepository;

	public void save(ArquivoEsocial arquivoEsocial) {
		arquivoEsocialRepository.save(arquivoEsocial);
	}

}
