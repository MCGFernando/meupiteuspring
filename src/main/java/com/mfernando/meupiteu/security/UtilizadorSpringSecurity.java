package com.mfernando.meupiteu.security;

import java.util.Arrays;
import java.util.Collection;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.mfernando.meupiteu.domain.enums.TipoUtilizador;

public class UtilizadorSpringSecurity implements UserDetails{
	private Integer id;
	private String email;
	private String senha;
	private GrantedAuthority authorities;
	
	
	
	public UtilizadorSpringSecurity() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	

	public UtilizadorSpringSecurity(Integer id, String email, String senha,
			TipoUtilizador tipoUtilizador) {
		super();
		this.id = id;
		this.email = email;
		this.senha = senha;
		this.authorities = new SimpleGrantedAuthority(tipoUtilizador.getDescricao());
	}



	public Integer getId() {
		return id;
	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		// TODO Auto-generated method stub
		return Arrays.asList( authorities);
	}

	@Override
	public String getPassword() {
		// TODO Auto-generated method stub
		return senha;
	}

	@Override
	public String getUsername() {
		// TODO Auto-generated method stub
		return email;
	}

	@Override
	public boolean isAccountNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isEnabled() {
		// TODO Auto-generated method stub
		return true;
	}

}
