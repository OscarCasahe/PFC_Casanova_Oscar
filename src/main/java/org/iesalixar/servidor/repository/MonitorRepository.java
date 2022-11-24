package org.iesalixar.servidor.repository;


import org.iesalixar.servidor.model.Monitor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MonitorRepository extends JpaRepository<Monitor,Long> {

	public Monitor findByNombre(String nombre);

}
