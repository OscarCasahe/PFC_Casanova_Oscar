package org.iesalixar.servidor.services;

import java.util.List;
import java.util.Optional;

import org.iesalixar.servidor.dto.UsuarioDTO;
import org.iesalixar.servidor.model.Usuario;

public interface UsuarioService {

	public Usuario insertUsuario(Usuario usuario);
	public List<Usuario> getAllUsuarios();
	public void deleteUsuarioById(Long id);
	public Optional<Usuario> findUsuarioById(Long id);
	public Usuario updateUsuario(UsuarioDTO usuario);


}
