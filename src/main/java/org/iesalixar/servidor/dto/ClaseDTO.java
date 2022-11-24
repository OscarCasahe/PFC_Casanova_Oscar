package org.iesalixar.servidor.dto;

import java.util.Objects;

public class ClaseDTO {

	private String nombre;
	private int asistentes;
	private Long id_monitor;
	
	public ClaseDTO() {
		super();
	}
	
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public int getAsistentes() {
		return asistentes;
	}
	public void setAsistentes(int asistentes) {
		this.asistentes = asistentes;
	}
	public Long getId_monitor() {
		return id_monitor;
	}
	public void setId_monitor(Long id_monitor) {
		this.id_monitor = id_monitor;
	}

	@Override
	public int hashCode() {
		return Objects.hash(asistentes, id_monitor, nombre);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ClaseDTO other = (ClaseDTO) obj;
		return asistentes == other.asistentes && Objects.equals(id_monitor, other.id_monitor)
				&& Objects.equals(nombre, other.nombre);
	}
	
	

}
