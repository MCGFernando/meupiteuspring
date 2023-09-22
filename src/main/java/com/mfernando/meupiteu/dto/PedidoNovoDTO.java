package com.mfernando.meupiteu.dto;

import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import com.mfernando.meupiteu.domain.ItemPedido;

public class PedidoNovoDTO implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private Double taxaFrete;
	
	private Date dataCriacao;
	
	private Date dataConfirmacao;
	
	private Date dataEntrega;
	
	private Date dataCancelamento;
	private Integer estadoPedido;
	
	private Integer idUtilizador;
	
	private Integer idEndereco;
	
	private Integer idRestaurante;
	
	private Set<ItemPedido> itens = new HashSet<>();

	public PedidoNovoDTO() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Double getTaxaFrete() {
		return taxaFrete;
	}

	public void setTaxaFrete(Double taxaFrete) {
		this.taxaFrete = taxaFrete;
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

	public Integer getEstadoPedido() {
		return estadoPedido;
	}

	public void setEstadoPedido(Integer estadoPedido) {
		this.estadoPedido = estadoPedido;
	}

	public Integer getIdUtilizador() {
		return idUtilizador;
	}

	public void setIdUtilizador(Integer idUtilizador) {
		this.idUtilizador = idUtilizador;
	}

	public Integer getIdEndereco() {
		return idEndereco;
	}

	public void setIdEndereco(Integer idEndereco) {
		this.idEndereco = idEndereco;
	}

	public Integer getIdRestaurante() {
		return idRestaurante;
	}

	public void setIdRestaurante(Integer idRestaurante) {
		this.idRestaurante = idRestaurante;
	}

	public Set<ItemPedido> getItens() {
		return itens;
	}

	public void setItens(Set<ItemPedido> itens) {
		this.itens = itens;
	}

	@Override
	public String toString() {
		return "PedidoNovoDTO [taxaFrete=" + taxaFrete + ", dataCriacao=" + dataCriacao + ", dataConfirmacao="
				+ dataConfirmacao + ", dataEntrega=" + dataEntrega + ", dataCancelamento=" + dataCancelamento
				+ ", estadoPedido=" + estadoPedido + ", idUtilizador=" + idUtilizador + ", idEndereco=" + idEndereco
				+ ", idRestaurante=" + idRestaurante + ", itens=" + itens + "]";
	}
	
}
