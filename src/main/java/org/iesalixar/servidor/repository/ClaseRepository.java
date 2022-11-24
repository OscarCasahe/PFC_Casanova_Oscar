package org.iesalixar.servidor.repository;

import org.iesalixar.servidor.model.Clase;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClaseRepository extends JpaRepository<Clase,Long> {

	public Clase findByNombre(String nombre);
	public Clase findById(int id);
}
