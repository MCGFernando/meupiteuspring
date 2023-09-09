package com.mfernando.meupiteu.domain.enums;

public enum EstadoPedido {
	CRIADO(1, "Criado"),
	CONFIRMADO(2, "Confirmado"),
	ENTREGUE(3, "Emtregue"),
	CANCELADO(4, "Cancelado");
	private int codigo;
	private String descricao;
	private EstadoPedido(Integer codigo, String descricao) {
		this.codigo = codigo;
		this.descricao = descricao;
	}
	public int getCodigo() {
		return codigo;
	}
	public String getDescricao() {
		return descricao;
	}
	public static EstadoPedido toEnum(Integer cod) {
		if(cod==null) return null;
		for(EstadoPedido tipo : EstadoPedido.values()) {
			if (cod.equals(tipo.getCodigo())) {
				return tipo;
			}
		}
		throw new  IllegalArgumentException("Id inválido; " + cod);
	}
}
