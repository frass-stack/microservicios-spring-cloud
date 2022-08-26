package com.formacionbdi.springboot.app.oauth.services;

import org.springframework.security.core.userdetails.UserDetailsService;
import com.formacionbdi.springboot.app.commons.usuarios.models.entity.Usuario;

//Cambio n°1 extends UserDetailsService
public interface IUsuarioService extends UserDetailsService{
	
	public Usuario findByUsername(String username);
	public Usuario update(Usuario usuario, Long id);
}
