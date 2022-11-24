package org.iesalixar.servidor.model;

import java.io.Serializable;
import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="reserva")
@IdClass(ReservaId.class)
public class Reserva implements Serializable{

	@Id
	@ManyToOne
	@JoinColumn(name="clase_id",insertable=false,updatable=false)
	private Clase clase;

	
	@Id
	@ManyToOne
	@JoinColumn(name="usuario_id",insertable=false,updatable=false)
	private Usuario usuario;
	
	@Column(nullable=false)
	private Date fecha;

	@Column(nullable=false)
	private String hora;

	public Reserva() {
		super();
	}

	public Reserva(Clase clase, Usuario usuario, Date fecha, String hora) {
		super();
		this.clase = clase;
		this.usuario = usuario;
		this.fecha = fecha;
		this.hora = hora;
	}

	public Clase getClase() {
		return clase;
	}

	public void setClase(Clase clase) {
		this.clase = clase;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
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
	public String toString() {
		return "Reserva [usuario=" + usuario + ", fecha=" + fecha + ", hora=" + hora + "]";
	}

	

	
}
