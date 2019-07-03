package edu.uni.everis.universidad.services.loaders;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import edu.uni.everis.universidad.services.loaders.LoaderService;

@Service
@Profile("test")
public class LoaderServiceTestImpl implements LoaderService {
	
	private Logger logger = LoggerFactory.getLogger(LoaderServiceTestImpl.class);

	public void load() {
		logger.warn("No hago na' que estoy en pruebas");
	}
	
}
