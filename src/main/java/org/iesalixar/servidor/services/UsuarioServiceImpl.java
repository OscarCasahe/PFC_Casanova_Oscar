package org.iesalixar.servidor.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.iesalixar.servidor.dto.UsuarioDTO;
import org.iesalixar.servidor.model.Plan;
import org.iesalixar.servidor.model.Usuario;
import org.iesalixar.servidor.repository.PlanRepository;
import org.iesalixar.servidor.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UsuarioServiceImpl implements UsuarioService{

	@Autowired
	UsuarioRepository userRepo;

	@Autowired
	PlanRepository planRepo;

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


	public Usuario updateUsuario(UsuarioDTO usuario) {
		if (usuario==null || usuario.getId()==null ||usuario.getNombre()==null || usuario.getApellidos()==null || usuario.getPassword()==null || usuario.getPlan()>=3 || usuario.getPlan() < 0 || usuario.getUserName()==null) {
			return null;			
		}
		
		Usuario userBD = new Usuario();
		
		userBD.setId(usuario.getId());
		userBD.setUserName(usuario.getUserName());
		userBD.setNombre(usuario.getNombre());
		userBD.setApellidos(usuario.getApellidos());
		userBD.setEmail(usuario.getEmail());
		userBD.setPassword(usuario.getPassword());
		userBD.setCp(usuario.getCp());
		userBD.setRole(usuario.getRole());
		
		if (usuario.getPlan()!=null) {
			Plan plan = planRepo.findPlanById(usuario.getPlan());
			userBD.setPlan(plan);
		} else {
			userBD.setPlan(null);
		}

		
		
		return userRepo.save(userBD);		
	}


	@Override
	public Optional<Usuario> findUsuarioByUserName(String userName) {
		Optional<Usuario> user = userRepo.findByUserName(userName);

		return user;
	}

	
}
