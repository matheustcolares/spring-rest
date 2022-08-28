package com.api.cursospring;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class CursoSpringApplication {

	public static void main(String[] args) {
		SpringApplication.run(CursoSpringApplication.class, args);
		
	}
	@GetMapping("/")
	public String index() {
		return "Ola mundo";
	}

}
