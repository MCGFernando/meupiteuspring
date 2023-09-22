package com.mfernando.meupiteu.domain;

import java.io.Serializable;
import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;

@Entity
public class ItemPedido implements  Serializable{
	
	private static final long serialVersionUID = 1L;
	@JsonIgnore
	@EmbeddedId
	private ItemPedidoPK id =  new ItemPedidoPK();
	private Integer quantidade;
	private Double preco;
	private Double desconto;
	private Double iva;
	private Double total;
	private String observacoes;
	public ItemPedido() {
		super();
		// TODO Auto-generated constructor stub
	}
	public ItemPedido(Pedido pedido, Producto producto, Integer quantidade, Double preco, Double desconto, Double iva, Double total,
			String observacoes) {
		super();
		this.id.setPedido(pedido);
		this.id.setProducto(producto);
		this.quantidade = quantidade;
		this.preco = preco;
		this.desconto = desconto;
		this.iva = iva;
		this.total = total;
		this.observacoes = observacoes;
	}
	@JsonIgnore
	public Pedido getPedido() {
		return id.getPedido();
	}
	
	public void setPedido(Pedido pedido) {
		id.setPedido(pedido);
	}
	
	public Producto getProducto() {
		return id.getProducto();
	}
	public void setProducto(Producto producto) {
		id.setProducto(producto);
	}
	
	
	public Double getSubTotal() {
		return quantidade * preco * (1 - (desconto/ 100)) * (1 + (iva/ 100));
	}
	
	public ItemPedidoPK getId() {
		return id;
	}
	public void setId(ItemPedidoPK id) {
		this.id = id;
	}
	public Integer getQuantidade() {
		return quantidade;
	}
	public void setQuantidade(Integer quantidade) {
		this.quantidade = quantidade;
	}
	public Double getPreco() {
		return preco;
	}
	public void setPreco(Double preco) {
		this.preco = preco;
	}
	public Double getDesconto() {
		return desconto;
	}
	public void setDesconto(Double desconto) {
		this.desconto = desconto;
	}
	public Double getIva() {
		return iva;
	}
	public void setIva(Double iva) {
		this.iva = iva;
	}
	public Double getTotal() {
		return total;
	}
	public void setTotal(Double total) {
		this.total = total;
	}
	public String getObservacoes() {
		return observacoes;
	}
	public void setObservacoes(String observacoes) {
		this.observacoes = observacoes;
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
		ItemPedido other = (ItemPedido) obj;
		return Objects.equals(id, other.id);
	}
	 
	
}
