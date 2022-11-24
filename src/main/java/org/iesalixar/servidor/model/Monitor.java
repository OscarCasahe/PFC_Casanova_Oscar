package org.iesalixar.servidor.model;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="monitor")
public class Monitor implements Serializable{

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(nullable=false)
	private String nombre;

	
	@Column(nullable=false, name="last_name" )
	private String lastName;
	
	@OneToMany(mappedBy="monitor",cascade=CascadeType.ALL, orphanRemoval=true)
	private Set<Clase> clases = new HashSet<>();

	public Monitor() {
		super();
	}

	public Monitor(Long id, String nombre, String lastName, Set<Clase> clases) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.lastName = lastName;
		this.clases = clases;
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

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public Set<Clase> getClases() {
		return clases;
	}

	public void setClases(Set<Clase> clases) {
		this.clases = clases;
	}

	@Override
	public String toString() {
		return "Monitor [id=" + id + ", nombre=" + nombre + ", lastName=" + lastName + ", clases=" + clases + "]";
	}

	

}
