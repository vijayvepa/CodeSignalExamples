import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

package com.example.Arrays;


@Component
public class Runner implements CommandLineRunner {

	@Override
	public void run(String... args) throws Exception {
		System.out.println("CommandLineRunner executed!");
		// Add your logic here
	}
}