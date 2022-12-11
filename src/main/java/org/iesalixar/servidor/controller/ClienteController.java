package org.iesalixar.servidor.controller;

import java.util.List;
import java.util.Optional;

import org.apache.tomcat.util.net.openssl.ciphers.Authentication;
import org.iesalixar.servidor.dto.ClaseDTO;
import org.iesalixar.servidor.dto.ReservaDTO;
import org.iesalixar.servidor.dto.UsuarioDTO;
import org.iesalixar.servidor.model.Clase;
import org.iesalixar.servidor.model.JPAUserDetails;
import org.iesalixar.servidor.model.Monitor;
import org.iesalixar.servidor.model.Plan;
import org.iesalixar.servidor.model.Reserva;
import org.iesalixar.servidor.model.Usuario;
import org.iesalixar.servidor.services.ClaseServiceImpl;
import org.iesalixar.servidor.services.MonitorServiceImpl;
import org.iesalixar.servidor.services.PlanServiceImpl;
import org.iesalixar.servidor.services.ReservaServiceImpl;
import org.iesalixar.servidor.services.UsuarioServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/")

public class ClienteController {

	@Autowired
	MonitorServiceImpl monitorService;

	@Autowired
	UsuarioServiceImpl usuarioService;

	@Autowired
	PlanServiceImpl planService;

	@Autowired
	ReservaServiceImpl reservaService;

	@Autowired
	ClaseServiceImpl claseService;

	
	
// ZONA ADMIN
	
	//Clientes
	
	@GetMapping("/admin/clientes")
	public String usuarios(Model model) {

		List<Usuario> usuarios = usuarioService.getAllUsuarios();

		model.addAttribute("clientes", usuarios);
		return "listaClientes";
	}
	
	
	@GetMapping("/admin/clientes/update")
	public String editarCliente(@RequestParam(required = false, name = "cliente") String user, Model model) {


		if (user == null ) {
			return "redirect:/admin/clientes/";
		}
		
		
		Optional<Usuario> usuario = usuarioService.findUsuarioById(Long.parseLong(user));
		List<Plan> planes =  planService.getAllPlans();
		
		//COGE LOS DATOS DEL USUARIO CORRECTAMENTE
		model.addAttribute("usuario",usuario.get());		
		model.addAttribute("planes",planes);		
		
		
		
		return "updateCliente";
	}
	
	
	
	@PostMapping("/admin/clientes/update")
	public String editarClientePost( @ModelAttribute UsuarioDTO usuario, Model model){

		usuario.setPlan(usuario.getPlan());
		usuarioService.updateUsuario(usuario);

		return "redirect:/admin/clientes/";
	}
	
	
	
	@RequestMapping("/admin/clientes/delete")
	public String clientesDelete(@RequestParam(required = false, name = "cliente") String cliente, Model model) {

		usuarioService.deleteUsuarioById(Long.parseLong(cliente));

		return "redirect:/admin/clientes/	";
	}
	
	
	
	
	
	//Clases
	
	
	@GetMapping("/admin/clases")
	public String clases(Model model) {

		List<Clase> clases = claseService.getAllClases();

		model.addAttribute("clases", clases);
		return "listaClases";
		
	}
	
	
	
	@RequestMapping("/admin/clases/delete")
	public String clasesDelete(@RequestParam(required = false, name = "clase") String clase, Model model) {

		claseService.deleteClaseById(Long.parseLong(clase));

		return "redirect:/admin/clases/	";
	}
	
	
	
	@GetMapping("/admin/clases/update")
	public String editarClase(@RequestParam(required = false, name = "clas") String clas, Model model) {


		if (clas == null ) {
			return "redirect:/admin/clases/";
		}
		
		
		Optional<Clase> clase = claseService.findClaseById(Long.parseLong(clas));
		List<Monitor> monitores =  monitorService.getAllMonitores();
		
		model.addAttribute("clase",clase.get());		
		model.addAttribute("monitores",monitores);		
		
		
		
		return "updateClase";
	}
	
	
	
	@PostMapping("/admin/clases/update")
	public String editarClasePost( @ModelAttribute ClaseDTO clase, Model model){

		claseService.updateClase(clase);

		return "redirect:/admin/clases/";
	}

	//RESERVAS
	@GetMapping("/admin/reservas")
	public String reservas(Model model) {

		List<Reserva> reservas = reservaService.getAllReservas();

		model.addAttribute("reservas", reservas);
		return "listaReservas";
	}
	
	
	
	//ZONA USUARIO
	
	
	
	@GetMapping("/contrataPlan")
	public String contrataPlan(@RequestParam(required = false, name = "cliente") String cliente, Model model) {


		return "contrataPlan";
	}

	
	@PostMapping("/contrataPlan")
	public String contrataPlanPost( @ModelAttribute UsuarioDTO user, Model model){
		
		org.springframework.security.core.Authentication auth = SecurityContextHolder.getContext().getAuthentication();		
		JPAUserDetails userDetail = (JPAUserDetails) auth.getPrincipal();
		Optional<Usuario> usuario = usuarioService.findUsuarioByUserName(userDetail.getUsername());

		Optional<Plan> plan = planService.findPlanById(user.getPlan());
		
		
		UsuarioDTO userBD = new UsuarioDTO();
		
		userBD.setId(usuario.get().getId());
		userBD.setUserName(usuario.get().getUserName());
		userBD.setNombre(usuario.get().getNombre());
		userBD.setApellidos(usuario.get().getApellidos());
		userBD.setEmail(usuario.get().getEmail());
		userBD.setPassword(usuario.get().getPassword());
		userBD.setCp(usuario.get().getCp());
		userBD.setPlan(plan.get().getId());		
		
		usuarioService.updateUsuario(userBD);

		return "redirect:/";
	} 

	
	@GetMapping("/vistaPerfil")
	public String vistaPerfil(Model model) {
		org.springframework.security.core.Authentication auth = SecurityContextHolder.getContext().getAuthentication();		
		JPAUserDetails userDetail = (JPAUserDetails) auth.getPrincipal();
		Optional<Usuario> usuario = usuarioService.findUsuarioByUserName(userDetail.getUsername());
		

		List<Reserva> reservas =  reservaService.getAllReservas();


		model.addAttribute("c", usuario.get());
		model.addAttribute("reservas", reservas);


		return "vistaPerfil";
	}
	
	
	@GetMapping("/infoPage")
	public String infoPage(Model model) {


		return "infoPage";
	}
	
	
	
	@GetMapping("/reservarClase")
	public String reserva(Model model) {
		
		Reserva res = new Reserva();
		List<Clase> clases = claseService.getAllClases();

		model.addAttribute("clases", clases);
		model.addAttribute("reserva", res);
		
		return "reservarClase";
	}
	
	@PostMapping("/reservarClase")
	public String reservaPost(@ModelAttribute ReservaDTO reserva) {
		
		if (reserva==null) {
			return "redirect:/index";
		}
		
		org.springframework.security.core.Authentication auth = SecurityContextHolder.getContext().getAuthentication();		
		JPAUserDetails userDetail = (JPAUserDetails) auth.getPrincipal();
		Optional<Usuario> usuario = usuarioService.findUsuarioByUserName(userDetail.getUsername());

		
		Reserva reservaBD = new Reserva();
		Optional<Clase> clase = claseService.findClaseById(reserva.getClase());
		
		reservaBD.setClase(clase.get());
		reservaBD.setUsuario(usuario.get());
		reservaBD.setFecha(reserva.getFecha());
		reservaBD.setHora(reserva.getHora());
		
		reservaBD = reservaService.insertReserva(reservaBD);
		

		
		return "redirect:/";
		
	}
}
