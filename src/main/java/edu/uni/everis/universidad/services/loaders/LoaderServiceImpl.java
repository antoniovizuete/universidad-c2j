package edu.uni.everis.universidad.services.loaders;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

@Service
@Profile("!test")
public class LoaderServiceImpl implements LoaderService {

	private AlumnosLoader alumnosLoader;
	private ProfesoresLoader profesoresLoader;
	
	public LoaderServiceImpl(AlumnosLoader alumnosLoader, ProfesoresLoader profesoresLoader) {
		super();
		this.alumnosLoader = alumnosLoader;
		this.profesoresLoader = profesoresLoader;
	}
	
	@Override
	public void load() {
		alumnosLoader.load();
		profesoresLoader.load();
	}
	
	
}
