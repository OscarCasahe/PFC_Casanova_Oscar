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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;


@Entity
@Table(name="usuarios")
public class Usuario implements Serializable {
	
	@Id
	@SequenceGenerator(name="seq", initialValue=10, allocationSize=100)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq")
	private Long id;
	
	@Column(name="usuario",unique=true, nullable=false)
	private String userName;
	
	@Column(nullable=false)
	private String password;
	
	@Column(unique=true,nullable=false)
	private String email;
	
	@Column(nullable=false)
	private String nombre;
	
	@Column(nullable=false)
	private String apellidos;
	
	@Column(nullable=false)
	private String role;

	@Column(nullable=false)
	private int cp;

	@Column(nullable=false,columnDefinition="BOOLEAN")	
	private boolean activo;
	
	@ManyToOne
	@JoinColumn(name="plan")
	Plan plan;
	
	@OneToMany(mappedBy="usuario",cascade=CascadeType.ALL, orphanRemoval=true)
	private Set<Reserva> reservas = new HashSet<>();

	
	
	public Usuario() {
		// TODO Auto-generated constructor stub
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellidos() {
		return apellidos;
	}

	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public int getCp() {
		return cp;
	}

	public void setCp(int cp) {
		this.cp = cp;
	}

	public boolean isActivo() {
		return activo;
	}

	public void setActivo(boolean activo) {
		this.activo = activo;
	}

	public Plan getPlan() {
		return plan;
	}

	public void setPlan(Plan plan) {
		this.plan = plan;
	}

	public Set<Reserva> getReservas() {
		return reservas;
	}

	public void setReservas(Set<Reserva> reservas) {
		this.reservas = reservas;
	}

	@Override
	public String toString() {
		return "Usuario [id=" + id + ", userName=" + userName + ", password=" + password + ", email=" + email
				+ ", nombre=" + nombre + ", apellidos=" + apellidos + ", role=" + role + ", cp=" + cp + ", activo="
				+ activo + ", plan=" + plan + ", reservas=" + reservas + "]";
	}


	

	
	
	

	

}
