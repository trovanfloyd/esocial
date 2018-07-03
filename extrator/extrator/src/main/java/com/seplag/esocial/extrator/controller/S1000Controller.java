package com.seplag.esocial.extrator.controller;

import java.util.List;

import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.seplag.esocial.extrator.entity.S1000;
import com.seplag.esocial.extrator.service.S1000Service;
import com.seplag.esocial.extrator.service.S2200Service;

@RestController
@RequestMapping("event/s1000")
public class S1000Controller {

	@Autowired
	S1000Service s1000Service;

	@Autowired
	S2200Service s2200Service;

	@GetMapping("/all")
	public List<S1000> getAll() {
		return (List<S1000>) s1000Service.findAll();
	}

	@GetMapping("/xml")
	@Produces({ MediaType.APPLICATION_XML })
	public String getXml() {
		return s1000Service.executeXml();
	}

	@GetMapping("/xml2")
	@Produces({ MediaType.APPLICATION_XML })
	public String getXmlS2200() {
		return s2200Service.executeXml();
	}

}
