package org.iesalixar.servidor.dto;

import org.iesalixar.servidor.model.Plan;

public class UsuarioDTO {
	
	private Long id;
	private String userName;
	private String nombre;
	private String apellidos;
	private String email;
	private String password;
	private int cp;
	private Long plan;
	private String role;
	
	public UsuarioDTO() {
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

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public int getCp() {
		return cp;
	}

	public void setCp(int cp) {
		this.cp = cp;
	}




	public Long getPlan() {
		return plan;
	}




	public void setPlan(Long plan) {
		this.plan = plan;
	}
	
	




	public String getRole() {
		return role;
	}




	public void setRole(String role) {
		this.role = role;
	}




	@Override
	public String toString() {
		return "UsuarioDTO [id=" + id + ", userName=" + userName + ", nombre=" + nombre + ", apellidos=" + apellidos
				+ ", email=" + email + ", password=" + password + ", cp=" + cp + ", plan=" + plan + "]";
	}





	
	



	
	
	
}
