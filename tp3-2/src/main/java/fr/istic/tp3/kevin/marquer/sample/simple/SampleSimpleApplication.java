package fr.istic.tp3.kevin.marquer.sample.simple;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import fr.istic.tp3.kevin.marquer.sample.simple.client.IRun;

@SpringBootApplication
public class SampleSimpleApplication implements CommandLineRunner {

	@Autowired
	private IRun iRun;
	
	public void run(String... args) throws Exception {
		this.iRun.run();
		
	}
	
	public static void main(String[] args) throws Exception {
		SpringApplication.run(SampleSimpleApplication.class, args);
	}

	
	
}
