package org.iesalixar.servidor.dto;

import java.sql.Date;
import java.util.Objects;

public class ReservaDTO {

	private Long usuario;
	private Long clase;
	private Date fecha;
	private String hora;
	
	public ReservaDTO() {
		super();
	}
	

	public Long getUsuario() {
		return usuario;
	}


	public void setUsuario(Long usuario) {
		this.usuario = usuario;
	}


	public Long getClase() {
		return clase;
	}


	public void setClase(Long clase) {
		this.clase = clase;
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
		return Objects.hash(clase, fecha, hora, usuario);
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
		return Objects.equals(clase, other.clase) && Objects.equals(fecha, other.fecha)
				&& Objects.equals(hora, other.hora) && Objects.equals(usuario, other.usuario);
	}


	@Override
	public String toString() {
		return "ReservaDTO [usuario=" + usuario + ", clase=" + clase + ", fecha=" + fecha + ", hora=" + hora + "]";
	}



	
	
	
	
}
