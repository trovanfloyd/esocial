package com.seplag.esocial.mensageiro.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.seplag.esocial.mensageiro.service.MensageiroService;

@RestController
@RequestMapping("mensageiro")
public class MensageiroController {

	@Autowired
	MensageiroService mensageiroService;

	@GetMapping("/send")
	public ResponseEntity<?> send() {
		mensageiroService.send();

		return ResponseEntity.ok().build();
	}
}
