package com.mfernando.meupiteu.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import java.util.Set;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToMany;

@Entity
public class Producto implements Serializable{
	
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String descricao;
	private Double preco;
	private Boolean activo;
	//@JsonIgnore
	//@JsonIgnoreProperties("categorias") //Gerencia referencias siclicas na classe secundaria
	@ManyToMany
	@JoinTable(
			name = "PRODUCTO_CATEGORIA",
			joinColumns = @JoinColumn(name = "producto_id"),
			inverseJoinColumns = @JoinColumn(name = "categoria_id")
	)
	private List<Categoria> categorias = new ArrayList<>();
	@JsonIgnore
	@OneToMany(mappedBy = "id.producto")
	private Set<ItemPedido> itens = new HashSet<>();
	
	public Producto() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Producto(Integer id, String descricao, Double preco, Boolean activo) {
		super();
		this.id = id;
		this.descricao = descricao;
		this.preco = preco;
		this.activo = activo;
	}

	@JsonIgnore
	public List<Pedido> getPedidos(){
		List<Pedido> pedidos = new ArrayList<>();
		for(ItemPedido item : itens) {
			pedidos.add(item.getPedido());
		}
		return pedidos;
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

	public List<Categoria> getCategorias() {
		return categorias;
	}

	public void setCategorias(List<Categoria> categorias) {
		this.categorias = categorias;
	}

	public Set<ItemPedido> getItens() {
		return itens;
	}

	public void setItens(Set<ItemPedido> itens) {
		this.itens = itens;
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
		Producto other = (Producto) obj;
		return Objects.equals(id, other.id);
	}
	
	
}
