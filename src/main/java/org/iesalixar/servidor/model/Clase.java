package org.iesalixar.servidor.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="clase")
public class Clase implements Serializable{

	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name="nombre",unique=true, nullable=false)
	private String nombre;

	@Column(nullable=false)
	private int asistentes;

	@ManyToOne
	@JoinColumn(name="monitor_id")
	Monitor monitor;

	public Clase() {
		super();
	}

	public Clase(Long id, String nombre, int asistentes, Monitor monitor) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.asistentes = asistentes;
		this.monitor = monitor;
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

	public int getAsistentes() {
		return asistentes;
	}

	public void setAsistentes(int asistentes) {
		this.asistentes = asistentes;
	}

	public Monitor getMonitor() {
		return monitor;
	}

	public void setMonitor(Monitor monitor) {
		this.monitor = monitor;
	}

	@Override
	public String toString() {
		return "Clase [id=" + id + ", nombre=" + nombre + ", asistentes=" + asistentes + "]";
	}
	
	

}
