package br.gov.ce.seplag.esocial.mensageiro.endpoint;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.gov.ce.seplag.esocial.mensageiro.entity.ArquivoEsocial;
import br.gov.ce.seplag.esocial.mensageiro.service.MensageiroService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;


@RestController
@Api(tags = {"mensageiro"})
public class MensageiroEndpoint {

	@Autowired
	MensageiroService mensageiroService;

	@GetMapping("/send")
	@ApiOperation("Cria os Lotes de eventos que estão aguardando processamento e Envia manualmente para o eSocial-Gov")
	public ResponseEntity<?> send() {
		mensageiroService.send();
		return ResponseEntity.ok().build();
	}
	
	@GetMapping("/send/{tipo}")
	@ApiOperation("Cria os Lotes de um tipo de evento que esta aguardando processamento e Envia manualmente para o eSocial-Gov")
	public ResponseEntity<?> send(@ApiParam("Tipo do evento. Valores possíveis [1000, 1005, 1010, 1020, 1030...]") @PathVariable String tipo) {
		// TODO: Implementar envio por Tipo de Evento
		return ResponseEntity.ok().build();
	}
	
	@GetMapping("/consulta")
	@ApiOperation("Busca no eSocial-Gov o resultado do processamento de todos os lotes e registra os sucessos e erros no sistema local")
	public ResponseEntity<?> consulta() {
		mensageiroService.consultarLoteEventos();
		return ResponseEntity.ok().build();
	}
	
	@GetMapping("/consulta/{protocolo}")
	@ApiOperation("Busca no eSocial-Gov o resultado do processamento para um lote com protocolo específico e registra os sucessos e erros no sistema local.")
	public ResponseEntity<?> consultaByProtocolo(@ApiParam("Número do protocolo") @PathVariable String numProtocolo) {
		// TODO: Implementar consulta por protocolo
		return ResponseEntity.ok().build();
	}
	
	@GetMapping("/consulta/automacao/{habilitado}")
	@ApiOperation("Configura o processamento automático da consulta de lotes no eSocial-GOV ")
	public ResponseEntity<?> automacaoConsulta(@ApiParam("Habilita ou desabilita a execução automática. Valores válidos [true, false]") @PathVariable boolean habilitado, 
											   @ApiParam("Período em milisegundos entre cada ciclo de execução") @RequestParam(value = "periodo") Optional<Long> periodoMillis) {
		mensageiroService.automatizarConsulta(habilitado, periodoMillis.orElse(null));
		return ResponseEntity.ok().build();
	}
	
	@GetMapping("/consulta/map")
	public ArquivoEsocial map() {
		return mensageiroService.mapToJson();
	}
}
