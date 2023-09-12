package com.mfernando.meupiteu.domain;

import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.mfernando.meupiteu.domain.enums.EstadoPedido;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
@Entity
public class Pedido implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String codigoPedido;
	private Double subTotal;
	private Double taxaFrete;
	private Double valorTotal;
	private Date dataCriacao;
	@Column(nullable = true)
	private Date dataConfirmacao;
	@Column(nullable = true)
	private Date dataEntrega;
	@Column(nullable = true)
	private Date dataCancelamento;
	private Integer estadoPedido;
	@JsonManagedReference
	@ManyToOne
	@JoinColumn(name = "utilizador_id")
	private Utilizador utilizador;
	@JsonManagedReference
	@ManyToOne
	@JoinColumn(name = "endereco_id")
	private Endereco endereco;
	@JsonManagedReference
	@ManyToOne
	@JoinColumn(name = "restaurante_id")
	private Restaurante restaurante;
	@OneToMany(mappedBy = "id.pedido")
	private Set<ItemPedido> itens = new HashSet<>();
	public Pedido() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Pedido(Integer id, String codigoPedido, Double subTotal, Double taxaFrete, Double valorTotal,
			Date dataCriacao, Date dataConfirmacao, Date dataEntrega, Date dataCancelamento, EstadoPedido estadoPedido,
			Utilizador utilizador, Endereco endereco, Restaurante restaurante) {
		super();
		this.id = id;
		this.codigoPedido = codigoPedido;
		this.subTotal = subTotal;
		this.taxaFrete = taxaFrete;
		this.valorTotal = valorTotal;
		this.dataCriacao = dataCriacao;
		this.dataConfirmacao = dataConfirmacao;
		this.dataEntrega = dataEntrega;
		this.dataCancelamento = dataCancelamento;
		this.estadoPedido = estadoPedido.getCodigo();
		this.utilizador = utilizador;
		this.endereco = endereco;
		this.restaurante = restaurante;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getCodigoPedido() {
		return codigoPedido;
	}
	public void setCodigoPedido(String codigoPedido) {
		this.codigoPedido = codigoPedido;
	}
	public Double getSubTotal() {
		return subTotal;
	}
	public void setSubTotal(Double subTotal) {
		this.subTotal = subTotal;
	}
	public Double getTaxaFrete() {
		return taxaFrete;
	}
	public void setTaxaFrete(Double taxaFrete) {
		this.taxaFrete = taxaFrete;
	}
	public Double getValorTotal() {
		return valorTotal;
	}
	public void setValorTotal(Double valorTotal) {
		this.valorTotal = valorTotal;
	}
	public Date getDataCriacao() {
		return dataCriacao;
	}
	public void setDataCriacao(Date dataCriacao) {
		this.dataCriacao = dataCriacao;
	}
	public Date getDataConfirmacao() {
		return dataConfirmacao;
	}
	public void setDataConfirmacao(Date dataConfirmacao) {
		this.dataConfirmacao = dataConfirmacao;
	}
	public Date getDataEntrega() {
		return dataEntrega;
	}
	public void setDataEntrega(Date dataEntrega) {
		this.dataEntrega = dataEntrega;
	}
	public Date getDataCancelamento() {
		return dataCancelamento;
	}
	public void setDataCancelamento(Date dataCancelamento) {
		this.dataCancelamento = dataCancelamento;
	}
	public EstadoPedido getEstadoPedido() {
		return EstadoPedido.toEnum(estadoPedido);
	}
	public void setEstadoPedido(EstadoPedido estadoPedido) {
		this.estadoPedido = estadoPedido.getCodigo();
	}
	public Utilizador getUtilizador() {
		return utilizador;
	}
	public void setUtilizador(Utilizador utilizador) {
		this.utilizador = utilizador;
	}
	public Endereco getEndereco() {
		return endereco;
	}
	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
	}
	public Restaurante getRestaurante() {
		return restaurante;
	}
	public void setRestaurante(Restaurante restaurante) {
		this.restaurante = restaurante;
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
		Pedido other = (Pedido) obj;
		return Objects.equals(id, other.id);
	}
	
	
	
}
