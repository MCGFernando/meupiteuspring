package com.mfernando.meupiteu.config;

import java.security.AuthProvider;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.ProviderManager;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;

import com.mfernando.meupiteu.security.JWTAuthenticationFilter;
import com.mfernando.meupiteu.security.JWTUtil;

//import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
@Configuration
@EnableWebSecurity
public class SecurityConfig {
	
	private static final String [] PUBLIC_MATCHER = {
			"/h2-console/**",
	};
	private static final String [] PUBLIC_MATCHER_GET = {
			"/productos/**",
			"/categorias/**"
	};
	@Autowired
	private UserDetailsService detailsService;
	@Autowired
	private JWTUtil jwtUtil;
	
	//private AuthenticationManager authenticationManager;
	
	@Bean
	public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
		
		
		http.cors().and().csrf().disable();
		http.authorizeRequests().requestMatchers(AntPathRequestMatcher.antMatcher(PUBLIC_MATCHER[0])).permitAll();
		http.authorizeRequests().requestMatchers(AntPathRequestMatcher.antMatcher(HttpMethod.GET, PUBLIC_MATCHER_GET[0])).permitAll();
		http.authorizeRequests().requestMatchers(AntPathRequestMatcher.antMatcher(HttpMethod.GET, PUBLIC_MATCHER_GET[1])).permitAll();
		http.authorizeRequests().anyRequest().authenticated();
		http.addFilter(new JWTAuthenticationFilter(authenticationManager( ), jwtUtil));
		http.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);
		http.headers().frameOptions().disable();
		http.httpBasic();
		return http.build();
	}
	
	@Bean
    public AuthenticationProvider userDetailsAuthProvider(){
        DaoAuthenticationProvider a = new DaoAuthenticationProvider();
        a.setUserDetailsService(detailsService);
        a.setPasswordEncoder(bCryptPasswordEncoder());
        return a;
    }
	
	@Bean
    public AuthenticationManager authenticationManager( ) throws Exception {
		return new ProviderManager(Arrays.asList((userDetailsAuthProvider())));
        //return amb.authenticationProvider(userDetailsAuthProvider()).build();
    }
	
	@Bean
	CorsConfigurationSource corsConfigurationSource() {
		final UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
		source.registerCorsConfiguration("/**", new CorsConfiguration().applyPermitDefaultValues());
		return  source;
	}
	
	@Bean
	public BCryptPasswordEncoder bCryptPasswordEncoder() {
		return new BCryptPasswordEncoder();
	}

}
