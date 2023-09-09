package com.mfernando.meupiteu.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import java.util.Set;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.CollectionTable;
import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;

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
	@JsonBackReference
	@ManyToOne
	@JoinColumn(name = "tipo_restaurante_id")
	private TipoRestaurante tipoRestaurante;
	@ElementCollection
	@CollectionTable(name = "TAGS")
	private Set<String> tags = new HashSet<>();
	@ElementCollection
	@CollectionTable(name = "TELEFONES_RESTAURANTE")
	private Set<String> telefones = new HashSet<>();
	@JsonManagedReference //Gerencia referencias siclicas na classe principal
	@OneToMany(mappedBy = "restaurante")
	private List<Endereco> enderecos = new ArrayList<>();
	@JsonManagedReference
	@OneToMany(mappedBy = "restaurante")
	private List<Utilizador> utilizadores = new ArrayList<>();
	@JsonBackReference
	@OneToMany(mappedBy = "restaurante")
	private List<Pedido> pedidos = new ArrayList<>();
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
	
	public Set<String> getTags() {
		return tags;
	}
	public void setTags(Set<String> tags) {
		this.tags = tags;
	}
	public List<Endereco> getEnderecos() {
		return enderecos;
	}
	public void setEnderecos(List<Endereco> enderecos) {
		this.enderecos = enderecos;
	}
	
	public List<Utilizador> getUtilizadores() {
		return utilizadores;
	}
	public void setUtilizadores(List<Utilizador> utilizadores) {
		this.utilizadores = utilizadores;
	}
	
	public Set<String> getTelefones() {
		return telefones;
	}
	public void setTelefones(Set<String> telefones) {
		this.telefones = telefones;
	}
	
	public List<Pedido> getPedidos() {
		return pedidos;
	}
	public void setPedidos(List<Pedido> pedidos) {
		this.pedidos = pedidos;
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
