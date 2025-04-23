package com.datadoghq.workshops.samplevulnerablejavaapp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SampleVulnerableJavaAppApplication {

	public static void main(String[] args) {
		String vulnerableString = "HSMxcRTRxnN+Bdg0JdbxYKrThecOKuH5zCYotlSAcp1+c8xmyTe9GYg1l9a69psu";
		SpringApplication.run(SampleVulnerableJavaAppApplication.class, args);
	}

}
