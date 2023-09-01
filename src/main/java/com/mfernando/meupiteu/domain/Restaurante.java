package com.mfernando.meupiteu.domain;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class Restaurante implements Serializable{
	
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String restaurante;
	private String descricao;
	private Double taxaEnvio;
	private Date horaAbertura;
	private Date horaEncerramento;
	private Boolean activo;
	private Date dataCadastro;
	private Date dataActualizacao;
	@ManyToOne
	@JoinColumn(name = "tipo_restaurante_id")
	private TipoRestaurante tipoRestaurante;
	public Restaurante() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Restaurante(Integer id, String restaurante, String descricao, Double taxaEnvio, Date horaAbertura,
			Date horaEncerramento, Boolean activo, Date dataCadastro, Date dataActualizacao,
			TipoRestaurante tipoRestaurante) {
		super();
		this.id = id;
		this.restaurante = restaurante;
		this.descricao = descricao;
		this.taxaEnvio = taxaEnvio;
		this.horaAbertura = horaAbertura;
		this.horaEncerramento = horaEncerramento;
		this.activo = activo;
		this.dataCadastro = dataCadastro;
		this.dataActualizacao = dataActualizacao;
		this.tipoRestaurante = tipoRestaurante;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getRestaurante() {
		return restaurante;
	}
	public void setRestaurante(String restaurante) {
		this.restaurante = restaurante;
	}
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	public Double getTaxaEnvio() {
		return taxaEnvio;
	}
	public void setTaxaEnvio(Double taxaEnvio) {
		this.taxaEnvio = taxaEnvio;
	}
	public Date getHoraAbertura() {
		return horaAbertura;
	}
	public void setHoraAbertura(Date horaAbertura) {
		this.horaAbertura = horaAbertura;
	}
	public Date getHoraEncerramento() {
		return horaEncerramento;
	}
	public void setHoraEncerramento(Date horaEncerramento) {
		this.horaEncerramento = horaEncerramento;
	}
	public Boolean getActivo() {
		return activo;
	}
	public void setActivo(Boolean activo) {
		this.activo = activo;
	}
	public Date getDataCadastro() {
		return dataCadastro;
	}
	public void setDataCadastro(Date dataCadastro) {
		this.dataCadastro = dataCadastro;
	}
	public Date getDataActualizacao() {
		return dataActualizacao;
	}
	public void setDataActualizacao(Date dataActualizacao) {
		this.dataActualizacao = dataActualizacao;
	}
	public TipoRestaurante getTipoRestaurante() {
		return tipoRestaurante;
	}
	public void setTipoRestaurante(TipoRestaurante tipoRestaurante) {
		this.tipoRestaurante = tipoRestaurante;
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
		Restaurante other = (Restaurante) obj;
		return Objects.equals(id, other.id);
	}
	
}
