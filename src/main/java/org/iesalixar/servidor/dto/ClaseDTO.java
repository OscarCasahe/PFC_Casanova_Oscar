package org.iesalixar.servidor.dto;

import java.util.Objects;

public class ClaseDTO {

	private Long id;
	private String nombre;
	private Integer asistentes;
	private Long monitor;
	
	public ClaseDTO() {
		super();
	}
	
	
	
	public Long getId() {
		return id;
	}



	public void setId(Long id) {
		this.id = id;
	}



	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Integer getAsistentes() {
		return asistentes;
	}

	public void setAsistentes(Integer asistentes) {
		this.asistentes = asistentes;
	}


	public Long getMonitor() {
		return monitor;
	}

	public void setMonitor(Long monitor) {
		this.monitor = monitor;
	}



	@Override
	public String toString() {
		return "ClaseDTO [nombre=" + nombre + ", asistentes=" + asistentes + ", monitor=" + monitor + "]";
	}


	
	
	
	

}
