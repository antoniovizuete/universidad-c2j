package edu.uni.everis.universidad;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import edu.uni.everis.universidad.services.loaders.LoaderService;

@SpringBootApplication
@EnableJpaRepositories
public class UniversidadApplication implements CommandLineRunner {
	
	private LoaderService loaderService;
	
	public UniversidadApplication(LoaderService loaderService) {
		super();
		this.loaderService = loaderService;
	}

	public static void main(String[] args) {
		SpringApplication.run(UniversidadApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		loaderService.load();
	}

}