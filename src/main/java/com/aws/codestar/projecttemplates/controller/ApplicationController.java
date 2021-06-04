package com.aws.codestar.projecttemplates.controller;

import org.apache.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ApplicationController {

	@GetMapping(value = "/health")
	public int healthCheck() {
		return HttpStatus.SC_OK;
	}
}