package org.iesalixar.servidor.repository;

import org.iesalixar.servidor.model.Clase;
import org.iesalixar.servidor.model.Reserva;
import org.iesalixar.servidor.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ReservaRepository extends JpaRepository<Reserva,Long> {

	public Reserva findByUsuarioAndClase(Usuario usuario, Clase clase);
}
