package ru.liga.prerevolutionarytindertgbotclient.control;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication
public class PrerevolutionaryTinderTgbotClientApplication {

	public static void main(String[] args) {
		try {
			SpringApplication.run(PrerevolutionaryTinderTgbotClientApplication.class, args);
		} catch (Exception e) {
			e.printStackTrace();
		}

	}
}
