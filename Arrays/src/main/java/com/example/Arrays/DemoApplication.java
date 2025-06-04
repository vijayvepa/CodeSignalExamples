package com.example.Arrays;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Arrays;

@SpringBootApplication
public class DemoApplication implements CommandLineRunner {

	static Logger log = LoggerFactory.getLogger(DemoApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

		final Integer[][] example = new Integer[][]{
				{1, 2, 3},
				{4, 5, 6},
				{7, 8, 9}
		}
		;
		log.info("First floor second item: {}", example[0][1]);
		log.info(Arrays.deepToString(example));

		DimensionalArrays.loop(example, (i, j, value)->
				log.info("Floor: {}, Room: {}, Value: {} ", i, j, value));

		final String[][] floors = {
				{"Apt 101", "Apt 102", "Apt 103"},
				{"Apt 201", "Apt 202", "Apt 203"},
				{"Apt 301", "Apt 302", "Apt 303"}
		};

		StringBuilder stringBuilder = new StringBuilder();
		DimensionalArrays.loop(floors, (i,j,value)-> stringBuilder.append(value).append(", "));
		log.info("Floors: {}", stringBuilder);

		//replace item
		example[0][1] = 10;
		log.info(Arrays.deepToString(example));

		//number of floors:
		System.out.println();
	}

}
