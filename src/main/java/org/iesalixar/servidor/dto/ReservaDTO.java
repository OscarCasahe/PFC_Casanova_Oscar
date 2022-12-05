package org.iesalixar.servidor.dto;

import java.sql.Date;
import java.util.Objects;

public class ReservaDTO {

	private Long id_usuario;
	private Long id_clase;
	private Date fecha;
	private String hora;
	
	public ReservaDTO() {
		super();
	}
	
	public Long getId_usuario() {
		return id_usuario;
	}
	public void setId_usuario(Long id_usuario) {
		this.id_usuario = id_usuario;
	}
	public Long getId_clase() {
		return id_clase;
	}
	public void setId_clase(Long id_clase) {
		this.id_clase = id_clase;
	}

	public Date getFecha() {
		return fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	public String getHora() {
		return hora;
	}

	public void setHora(String hora) {
		this.hora = hora;
	}

	@Override
	public int hashCode() {
		return Objects.hash(fecha, hora, id_clase, id_usuario);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ReservaDTO other = (ReservaDTO) obj;
		return Objects.equals(fecha, other.fecha) && Objects.equals(hora, other.hora)
				&& Objects.equals(id_clase, other.id_clase) && Objects.equals(id_usuario, other.id_usuario);
	}
	
	

	
	
	
	
}
