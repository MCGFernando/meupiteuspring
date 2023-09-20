package com.mfernando.meupiteu.dto;

import java.io.Serializable;

import com.mfernando.meupiteu.domain.Producto;

public class ProductoDTO implements Serializable{
	
	private static final long serialVersionUID = 1L;
	private Integer id;
	private String descricao;
	private Double preco;
	private Boolean activo;
	public ProductoDTO() {
		super();
		// TODO Auto-generated constructor stub
	}
	public ProductoDTO(Producto p) {
		id = p.getId();
		descricao = p.getDescricao();
		preco = p.getPreco();
		activo = p.getActivo();
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	public Double getPreco() {
		return preco;
	}
	public void setPreco(Double preco) {
		this.preco = preco;
	}
	public Boolean getActivo() {
		return activo;
	}
	public void setActivo(Boolean activo) {
		this.activo = activo;
	}
	
}
