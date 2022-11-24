package org.iesalixar.servidor.dto;

import java.util.Objects;

public class ReservaDTO {

	private Long id_usuario;
	private Long id_clase;
	
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
	
	@Override
	public int hashCode() {
		return Objects.hash(id_clase, id_usuario);
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
		return Objects.equals(id_clase, other.id_clase) && Objects.equals(id_usuario, other.id_usuario);
	}
	
	
	
	
}
