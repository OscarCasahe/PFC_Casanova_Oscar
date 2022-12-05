package org.iesalixar.servidor.repository;

import java.util.Optional;

import org.iesalixar.servidor.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario,Long> {

	public Optional<Usuario> findByUserName(String userName);
}
