package com.mfernando.meupiteu.dto;

import java.io.Serializable;



import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotBlank;
import org.hibernate.validator.constraints.NotEmpty;

import com.mfernando.meupiteu.domain.Categoria;

public class CategoriaDTO implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Integer id;
	@NotBlank(message = "Campo de preenchimento obrigatório")
	@Length(min = 5, max = 80, message = "Campo deve ter entre 5 e 80 caracteres")
	private String nome;
	public CategoriaDTO() {
		super();
		// TODO Auto-generated constructor stub
	}
	public CategoriaDTO(Categoria categoria) {
		// TODO Auto-generated constructor stub
		this.id = categoria.getId();
		this.nome = categoria.getNome();
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
	
}
