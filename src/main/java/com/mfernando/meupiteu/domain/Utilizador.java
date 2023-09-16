package com.mfernando.meupiteu.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import java.util.Set;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.mfernando.meupiteu.domain.enums.TipoUtilizador;

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
public class Utilizador implements Serializable{
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String nome;
	private String email;
	private String senha;
	private Date dataCadastro;
	private Date dataActualizado;
	@ElementCollection
	@CollectionTable(name = "TELEFONES")
	private Set<String> telefones = new HashSet<>();
	private Integer tipoUtilizador;
	@JsonIgnore
	@ManyToOne
	@JoinColumn(name = "restaurante_id", nullable = true)
	private Restaurante restaurante;
	@JsonIgnore
	@OneToMany(mappedBy = "utilizador")
	private List<Pedido> pedidos = new ArrayList<>();
	public Utilizador() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Utilizador(Integer id, String nome, String email, String senha, Date dataCadastro, Date dataActualizado,
			TipoUtilizador tipoUtilizador, Restaurante restaurante) {
		super();
		this.id = id;
		this.nome = nome;
		this.email = email;
		this.senha = senha;
		this.dataCadastro = dataCadastro;
		this.dataActualizado = dataActualizado;
		this.tipoUtilizador = (tipoUtilizador==null) ? null : tipoUtilizador.getCodigo();
		this.restaurante = restaurante;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getSenha() {
		return senha;
	}
	public void setSenha(String senha) {
		this.senha = senha;
	}
	public Date getDataCadastro() {
		return dataCadastro;
	}
	public void setDataCadastro(Date dataCadastro) {
		this.dataCadastro = dataCadastro;
	}
	public Date getDataActualizado() {
		return dataActualizado;
	}
	public void setDataActualizado(Date dataActualizado) {
		this.dataActualizado = dataActualizado;
	}
	public Set<String> getTelefones() {
		return telefones;
	}
	public void setTelefones(Set<String> telefones) {
		this.telefones = telefones;
	}
	public TipoUtilizador getTipoUtilizador() {
		return  TipoUtilizador.toEnum(tipoUtilizador);
	}
	public void setTipoUtilizador(TipoUtilizador tipoUtilizador) {
		this.tipoUtilizador = tipoUtilizador.getCodigo();
	}
	public Restaurante getRestaurante() {
		return restaurante;
	}
	public void setRestaurante(Restaurante restaurante) {
		this.restaurante = restaurante;
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
		Utilizador other = (Utilizador) obj;
		return Objects.equals(id, other.id);
	}
	
	
}
