package com.mfernando.meupiteu.domain.enums;

public enum TipoUtilizador {
	ADMIN(1, "ROLE_ADMIN"),
	OWNER(2, "ROLE_OWNER"),
	EMPLOYEE(3, "ROLE_EMPLOYEE"),
	CUSTOMER(4, "ROLE_CUSTOMER");
	private int codigo;
	private String descricao;
	private TipoUtilizador(Integer codigo, String descricao) {
		this.codigo = codigo;
		this.descricao = descricao;
	}
	public int getCodigo() {
		return codigo;
	}
	public String getDescricao() {
		return descricao;
	}
	public static TipoUtilizador toEnum(Integer cod) {
		if(cod==null) return null;
		for(TipoUtilizador tipo : TipoUtilizador.values()) {
			if (cod.equals(tipo.getCodigo())) {
				return tipo;
			}
		}
		throw new  IllegalArgumentException("Id inválido; " + cod);
	}
}
