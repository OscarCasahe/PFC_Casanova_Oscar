package org.iesalixar.servidor.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.iesalixar.servidor.model.Usuario;
import org.iesalixar.servidor.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UsuarioServiceImpl implements UsuarioService{

	@Autowired
	UsuarioRepository userRepo;
	
	@Override
	public Usuario insertUsuario(Usuario usuario) {
		
		if (usuario!=null) {
			
			return userRepo.save(usuario);
		}
		
		return null;
		
	}
	

	@Override
	public List<Usuario> getAllUsuarios() {
		List<Usuario> users = userRepo.findAll();

		// Verificando que he obtenido algo
		if (users != null && users.size() > 0) {

			return users;
		}
		return new ArrayList<Usuario>();

}
	
	
	@Override
	public void deleteUsuarioById(Long id) {
		userRepo.deleteById(id);
		

	}


	@Override
	public Optional<Usuario> findUsuarioById(Long id) {
		
		Optional<Usuario> user = userRepo.findById(id);

		
		return user;
	}

	
}
