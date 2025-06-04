package com.example.Arrays;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class DemoApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

		final int[][] example = DimensionalArrays.createExample();
		System.out.println("First floor second item: " + example[0][1]);
		DimensionalArrays.print(example);
		DimensionalArrays.loop(example, (i,j, value)->
				System.out.println("Floor "+ i + ", Room " + j + ", Value: " + value));
	}
}
