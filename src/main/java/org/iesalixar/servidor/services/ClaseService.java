package org.iesalixar.servidor.services;

import java.util.List;
import java.util.Optional;

import org.iesalixar.servidor.model.Clase;

public interface ClaseService {

	public Clase insertClase(Clase clase);
	public List<Clase> getAllClases();
	public void deleteClaseById(Long id);
	public Optional<Clase> findClaseById(Long id);
	
}
