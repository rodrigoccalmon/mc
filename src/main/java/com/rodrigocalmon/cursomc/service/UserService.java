package com.rodrigocalmon.cursomc.service;

import org.springframework.security.core.context.SecurityContextHolder;

import com.rodrigocalmon.cursomc.security.UserSS;

public class UserService {

//metodo estatico pode ser chamado independente de ser instanciado
	public static UserSS authenticated() {
		try {
			return (UserSS) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
			//retorna usuario logado aqui
		} catch (Exception e) {
			return null;
		}
	}

}
