package com.mfernando.meupiteu.dto;

import java.io.Serializable;
import java.util.Date;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotEmpty;

import com.mfernando.meupiteu.domain.Utilizador;

public class UtilizadorDTO implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Integer id;
	@NotEmpty(message = "Campo de preenchimento obrigatório")
	@Length(min = 5, max = 120, message = "Campo deve ter entre 5 e 120 caracteres")
	private String nome;
	private String bi;	
	@NotEmpty(message = "Campo de preenchimento obrigatório")
	@Email(message = "Este valor não é um endereço de e-mail válido")
	private String email;
	@NotEmpty(message = "Campo de preenchimento obrigatório")
	@Length(min = 8, message = "Campo deve ter no mínimo 8 caracteres")
	private String senha;
	
	private Date dataActualizado;
	public UtilizadorDTO() {
		super();
		// TODO Auto-generated constructor stub
	}
	public UtilizadorDTO(Utilizador obj) {
		id = obj.getId();
		nome = obj.getNome();
		bi = obj.getBi();
		email = obj.getEmail();
		senha = obj.getSenha();
		dataActualizado = obj.getDataActualizado();
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public String getBi() {
		return bi;
	}
	public void setBi(String bi) {
		this.bi = bi;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getSenha() {
		return senha;
	}
	public void setSenha(String senha) {
		this.senha = senha;
	}
	public Date getDataActualizado() {
		return dataActualizado;
	}
	public void setDataActualizado(Date dataActualizado) {
		this.dataActualizado = dataActualizado;
	}
	
	
}
