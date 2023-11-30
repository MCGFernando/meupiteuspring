package com.mfernando.meupiteu.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.mfernando.meupiteu.domain.Utilizador;
import com.mfernando.meupiteu.domain.enums.TipoUtilizador;
import com.mfernando.meupiteu.repositories.UtilizadorRepository;
import com.mfernando.meupiteu.security.UtilizadorSpringSecurity;
@Service
public class UtilizadorDetailServiceImpl implements UserDetailsService {
	@Autowired
	private UtilizadorRepository repo;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		 Utilizador utilizador = repo.findByEmail(username);
		 if(utilizador == null) {
			 throw new UsernameNotFoundException(username);
		 }
		return new UtilizadorSpringSecurity(utilizador.getId(), utilizador.getEmail(), utilizador.getSenha(), utilizador.getTipoUtilizador());
	}

}
