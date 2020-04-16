package com.mitocode;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@SpringBootApplication
public class CineappBackendApplication implements CommandLineRunner {
	
	@Autowired
	private BCryptPasswordEncoder passEncoder;

	public static void main(String[] args) {
		SpringApplication.run(CineappBackendApplication.class, args);
	}
	
	@Override
	public void run(String... args) throws Exception {
		System.out.println("CONTRASEÑA: " +passEncoder.encode("12345"));
	}

}
