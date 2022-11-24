package org.iesalixar.servidor.controller;

import java.util.List;

import org.iesalixar.servidor.model.Clase;
import org.iesalixar.servidor.model.Usuario;
import org.iesalixar.servidor.services.ClaseServiceImpl;
import org.iesalixar.servidor.services.MonitorServiceImpl;
import org.iesalixar.servidor.services.PlanServiceImpl;
import org.iesalixar.servidor.services.ReservaServiceImpl;
import org.iesalixar.servidor.services.UsuarioServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
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

	

	
	
	
	
	
	
	
	
	
	
	
// ADMIN
	
	@GetMapping("/admin/clientes")
	public String usuarios(Model model) {

		List<Usuario> usuarios = usuarioService.getAllUsuarios();

		model.addAttribute("clientes", usuarios);
		return "listaClientes";
	}
	
	
	@RequestMapping("/admin/clientes/delete")
	public String clientesDelete(@RequestParam(required = false, name = "cliente") String cliente, Model model) {

		usuarioService.deleteUsuarioById(Long.parseLong(cliente));

		return "redirect:/admin/clientes/	";
	}
	
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
	
	

	
//	@GetMapping("/contrataPlan")
//	public String contrataPlan(Model model) {
//
//	Usuario usuarios = usuarioService.findByUserName();
//
//		model.addAttribute("clientes", usuarios);
//		return "listaClientes";
//	}

//	
//	
//	@RequestMapping("/matriculas/add")
//	public String addMatriculaGet(@RequestParam(required = false, name = "error") String error,@RequestParam(required = false, name = "codigo") String codigo, Model model) {
//		
//	
//		AlumnoAsignaturaNotaDTO matricula = new AlumnoAsignaturaNotaDTO();
//		Optional<Asignatura> asignatura = asignaturaService.findAsignaturaById(Long.parseLong(codigo));
//		List<Alumno> alumnos = alumnoService.getAllAlumnos();
//
//		
//		model.addAttribute("matricula", matricula);
//		model.addAttribute("alumnos", alumnos);
//		model.addAttribute("asignatura", asignatura);
//		model.addAttribute("error", error);
//		return "addMatricula";
//	}
//	
//	@PostMapping("/matriculas/add")
//	public String addMatriculaPost( @ModelAttribute AlumnoAsignaturaNotaDTO alumAsig, Model model) throws ParseException {
//
//		AlumnoAsignatura alumnoAsignaturaBD = new AlumnoAsignatura();
//		Optional<Alumno> alumno = alumnoService.findAlumnoById(alumAsig.getId_alumno());
//		Optional<Asignatura> asignatura = asignaturaService.findAsignaturaById(alumAsig.getId_asignatura());
//
//		
//		alumnoAsignaturaBD.setAlumno(alumno.get());
//		alumnoAsignaturaBD.setAsignatura(asignatura.get());
//		alumnoAsignaturaBD.setNota(alumAsig.getNota());
//		
//		alumnoAsignaturaService.actualizarAlumnoAsignaturas(alumnoAsignaturaBD);
//
//		return "redirect:/";
//	}
//	
//
//
//	
//	@GetMapping("/matriculas/list")
//	public String asignaturasGrado(@RequestParam(required = false, name = "codigo") String codigo, Model model) {
//
//
//		if (codigo == null) {
//			return "redirect:/";
//		}
//		
//		
//		Optional<Asignatura> asignatura = asignaturaService.findAsignaturaById(Long.parseLong(codigo));
//		model.addAttribute("asignatura",asignatura.get());		
//		model.addAttribute("matriculados",asignatura.get().getAlumnosAsignatura());		
//		return "listMatricula";
//	}
//	
//	
//	@RequestMapping("/matriculas/delete")
//	public String gradosDelete(@RequestParam(required = false, name = "error") String error, @RequestParam(required = false, name = "alum") String alum,@RequestParam(required = false, name = "asig") String asig, Model model) {
//		
//		Optional<Alumno> alumno = alumnoService.findAlumnoById(Long.parseLong(alum));
//		Optional<Asignatura> asignatura = asignaturaService.findAsignaturaById(Long.parseLong(asig));
//
//		asignatura.get().removeNota(alumno.get());
//		
//		model.addAttribute("error", error);
//
//
//		return "redirect:/";
//	}
//	
//	
//	
//	
//	
//	
//	
//
//	@GetMapping("/grados/estudiantes/editarnota")
//	public String editarNota(@RequestParam(required = false, name = "alum") String alum, @RequestParam(required = false, name = "asig") String asig, Model model) {
//
//
//		if (alum == null || asig == null) {
//			return "redirect:/grados/estudiantes/";
//		}
//		
//		
//		Optional<Alumno> alumno = alumnoService.findAlumnoById(Long.parseLong(alum));
//		Optional<Asignatura> asignatura = asignaturaService.findAsignaturaById(Long.parseLong(asig));
//		model.addAttribute("alumno",alumno.get());		
//		model.addAttribute("asignatura",asignatura.get());
//		
//		
//		
//		
//		
//		//Recorrer el bucle para encontrar la nota de la asignatura en concreto
//		
//		
//			for (AlumnoAsignatura nota : alumno.get().getAlumnoAsignaturas()) { 
//				if(nota.getAsignatura().getId() == asignatura.get().getId()) {
//					
//					model.addAttribute("alumnoAsignatura", nota);		
//
//					
//				}
//			}
//		
//		
//		return "editarnota";
//	}
//	
//	
//	
//	@PostMapping("/grados/estudiantes/editarnota")
//	public String editarnotaPost( @ModelAttribute AlumnoAsignaturaNotaDTO alumAsig, Model model) throws ParseException {
//
//		AlumnoAsignatura alumnoAsignaturaBD = new AlumnoAsignatura();
//		Optional<Alumno> alumno = alumnoService.findAlumnoById(alumAsig.getAlumno());
//		Optional<Asignatura> asignatura = asignaturaService.findAsignaturaById(alumAsig.getAsignatura());
//
//		
//		alumnoAsignaturaBD.setAlumno(alumno.get());
//		alumnoAsignaturaBD.setAsignatura(asignatura.get());
//		alumnoAsignaturaBD.setNota(alumAsig.getNota());
//		
//		alumnoAsignaturaService.actualizarAlumnoAsignaturas(alumnoAsignaturaBD);
//
//		return "redirect:/grados/estudiantes?codigo="+asignatura.get().getGrado().getId();
//	}
//
//	
	
}
