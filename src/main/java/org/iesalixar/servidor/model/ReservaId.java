package org.iesalixar.servidor.model;

import java.io.Serializable;

public class ReservaId implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 3789369023120791748L;
	private Long clase;
	private Long usuario;
	
	public ReservaId() {
		super();
	}

	public Long getClase() {
		return clase;
	}

	public void setClase(Long clase) {
		this.clase = clase;
	}

	public Long getUsuario() {
		return usuario;
	}

	public void setUsuario(Long usuario) {
		this.usuario = usuario;
	}

	@Override
	public String toString() {
		return "ReservaId [clase=" + clase + ", usuario=" + usuario + "]";
	}
	
	
	
	
	

}
