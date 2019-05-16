package br.gov.ce.seplag.esocial.mensageiro.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.gov.ce.seplag.esocial.mensageiro.entity.ArquivoEsocial;
import br.gov.ce.seplag.esocial.mensageiro.schedule.Agendador;

@Service
public class MensageiroService {


	@Autowired
	EnvioLoteBusiness envioLoteBusiness;
	
	@Autowired
	ConsultaLoteBusiness consultaLoteBusiness;
	
	@Autowired
	Agendador agendador;


	public void send() {
		envioLoteBusiness.send();
	}
	
	public void consultarLoteEventos() {
		consultaLoteBusiness.consultarLoteEventos();
	}
	
	public void automatizarConsulta(boolean habilitado, Long periodoMillis) {
		if (habilitado) {
			Runnable task  = () -> consultarLoteEventos();
			agendador.scheduling(task, periodoMillis.longValue());
		} else {
			agendador.cancelSchedule();
		}
	}
	
	public ArquivoEsocial mapToJson() {
		return consultaLoteBusiness.mapToJson(null);
	}

}
