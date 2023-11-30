package com.mfernando.meupiteu.dto;

import java.io.Serializable;

public class CredenciaisDTO implements Serializable{

	private static final long serialVersionUID = 1L;
	private String email;
	private String senhas;
	
	public CredenciaisDTO() {
		super();
		// TODO Auto-generated constructor stub
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getSenhas() {
		return senhas;
	}
	public void setSenhas(String senhas) {
		this.senhas = senhas;
	}
	
}
