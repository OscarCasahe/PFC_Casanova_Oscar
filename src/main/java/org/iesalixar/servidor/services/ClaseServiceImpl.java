package org.iesalixar.servidor.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.iesalixar.servidor.model.Clase;
import org.iesalixar.servidor.model.Usuario;
import org.iesalixar.servidor.repository.ClaseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ClaseServiceImpl implements ClaseService{

	@Autowired
	ClaseRepository claseRepo;
	
	@Override
	public Clase insertClase(Clase clase) {
		
		if (clase!=null) {
			
			return claseRepo.save(clase);
		}
		
		return null;
		
	}
	

	@Override
	public List<Clase> getAllClases() {
		List<Clase> clases = claseRepo.findAll();

		// Verificando que he obtenido algo
		if (clases != null && clases.size() > 0) {

			return clases;
		}
		return new ArrayList<Clase>();

}
	
	
	@Override
	public void deleteClaseById(Long id) {
		claseRepo.deleteById(id);
		

	}

	@Override
	public Optional<Clase> findClaseById(Long id) {
		
		Optional<Clase> clase = null;
		
		if (id!=null) {
			clase = claseRepo.findById(id);
		}
		
		return clase;
	}
	
}
