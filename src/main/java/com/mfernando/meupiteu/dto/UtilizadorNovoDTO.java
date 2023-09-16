package com.mfernando.meupiteu.dto;

import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotEmpty;

import com.mfernando.meupiteu.domain.Utilizador;

public class UtilizadorNovoDTO implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@NotEmpty(message = "Campo de preenchimento obrigatório")
	@Length(min = 5, max = 120, message = "Campo deve ter entre 5 e 120 caracteres")
	private String nome;
	@NotEmpty(message = "Campo de preenchimento obrigatório")
	@Email(message = "Este valor não é um endereço de e-mail válido")
	private String email;
	@NotEmpty(message = "Campo de preenchimento obrigatório")
	@Length(min = 8, message = "Campo deve ter no mínimo 8 caracteres")
	private String senha;
	private Integer tipoUtilizador;
	private Integer restauranteId;
	
	private Set<String> telefones = new HashSet<>();
	private Date dataCadastro;
	
	public UtilizadorNovoDTO() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
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
	
	public Integer getRestauranteId() {
		return restauranteId;
	}

	public void setRestauranteId(Integer restauranteId) {
		this.restauranteId = restauranteId;
	}

	public Integer getTipoUtilizador() {
		return tipoUtilizador;
	}

	public void setTipoUtilizador(Integer tipoUtilizador) {
		this.tipoUtilizador = tipoUtilizador;
	}

	public Set<String> getTelefones() {
		return telefones;
	}

	public void setTelefones(Set<String> telefones) {
		this.telefones = telefones;
	}

	public Date getDataCadastro() {
		return dataCadastro;
	}
	public void setDataCadastro(Date dataCadastro) {
		this.dataCadastro = dataCadastro;
	}
	
	
}
