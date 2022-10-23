package org.iesalixar.servidor.services;

import java.util.List;

import org.iesalixar.servidor.model.Usuario;

public interface UsuarioService {

	public Usuario insertUsuario(Usuario usuario);
	public List<Usuario> getAllUsuarios();
	public void deleteUsuarioById(Long id);

}
