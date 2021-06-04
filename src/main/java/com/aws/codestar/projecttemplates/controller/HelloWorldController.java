package com.aws.codestar.projecttemplates.controller;

import org.json.JSONObject;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/hello")
public class HelloWorldController {

	private static final String MESSAGE_FORMAT = "Hi %s!";

	@GetMapping(produces = "application/json")
	public ResponseEntity<String> helloWorldGet(@RequestParam(value = "name", defaultValue = "World") String name) {
		return ResponseEntity.ok(createResponse(name));
	}

	@PostMapping(produces = "application/json")
	public ResponseEntity<String> helloWorldPost(@RequestParam(value = "name", defaultValue = "World") String name) {
		return ResponseEntity.ok(createResponse(name));
	}

	private String createResponse(String name) {
		return new JSONObject().put("Output", String.format(MESSAGE_FORMAT, name)).toString();
	}
}