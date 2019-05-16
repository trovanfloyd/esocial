package br.gov.ce.seplag.esocial.extrator.endpoint;

import java.util.List;

import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import br.gov.ce.seplag.esocial.extrator.enumeration.TipoEventoEnum;
import br.gov.ce.seplag.esocial.extrator.service.ExtratorService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;


@RestController
@Api(tags = {"extrator"})
@Secured({"ROLE_ADMIN","ROLE_USER"})
public class ExtratorEndpoint {

	@Autowired
	ExtratorService extratorService;
	
	@GetMapping("/{evento}/")
	@ApiOperation("Retorna as informações do evento informado")
	public List<?> getAll(@ApiParam("Valores possíveis [S1000, S1010, S1030...]") @PathVariable String evento) {
		return extratorService.findAll(TipoEventoEnum.valueOf(evento));
	}

	@GetMapping("/{evento}/xml")
	@Produces({ MediaType.APPLICATION_XML })
	@ApiOperation("Gera e retorna o XML assinado do evento informado.")
	public String getXml(@ApiParam("Valores possíveis [S1000, S1010, S1030...]") @PathVariable String evento) {
		return extratorService.executeXml(TipoEventoEnum.valueOf(evento));
	}


	@GetMapping("/clean/{nrInsc}")
	@ApiOperation("Limpa a base de produção restrita no eSocial-Gov e reinicia a base de dados local")
	public String cleanDataBase(@ApiParam("Número de inscrição do empregador") @PathVariable String nrInsc) {
		return extratorService.cleanBase(nrInsc);
	}
}
