package com.seplag.esocial.assinador.controller;

import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.w3c.dom.Document;

import com.seplag.esocial.assinador.service.AssinadorService;

@RestController
@RequestMapping("assinador")
public class AssinadorController {

	@Autowired
	AssinadorService assinadorService;

	@PostMapping("/sign")
	@Produces({ MediaType.APPLICATION_XML })
	public Document signDocument(@RequestBody Document document) {
		return assinadorService.signDoc(document);
	}

	@GetMapping("/teste")
	public String signDocument() {
		return "teste";
	}

}
