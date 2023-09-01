package com.mfernando.meupiteu.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
@Entity
public class TipoRestaurante implements Serializable{
	
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String tipoRestaurante;
	@JsonManagedReference
	@OneToMany(mappedBy = "tipoRestaurante")
	private List<Restaurante> restaurantes =  new ArrayList<>();
	public TipoRestaurante() {
		super();
		// TODO Auto-generated constructor stub
	}
	public TipoRestaurante(Integer id, String tipoRestaurante) {
		super();
		this.id = id;
		this.tipoRestaurante = tipoRestaurante;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getTipoRestaurante() {
		return tipoRestaurante;
	}
	public void setTipoRestaurante(String tipoRestaurante) {
		this.tipoRestaurante = tipoRestaurante;
	}
	public List<Restaurante> getRestaurantes() {
		return restaurantes;
	}
	public void setRestaurantes(List<Restaurante> restaurantes) {
		this.restaurantes = restaurantes;
	}
	@Override
	public int hashCode() {
		return Objects.hash(id);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		TipoRestaurante other = (TipoRestaurante) obj;
		return Objects.equals(id, other.id);
	}
	
}
