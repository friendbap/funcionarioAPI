package com.br.faj.funcionarioAPI.rest;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.br.faj.funcionarioAPI.dao.FuncionarioRepository;
import com.br.faj.funcionarioAPI.dao.LoginRepository;
import com.br.faj.funcionarioAPI.model.Funcionario;
import com.br.faj.funcionarioAPI.model.LoginGerente;

@RestController
@RequestMapping("/funcionarioAPI")
public class loginController {
	
	@Autowired
	LoginRepository loginRepository;
	
	@Autowired
	FuncionarioRepository funcionarioRepository;

	@PostMapping("/validar")
	Object validar(@RequestBody Map<String, LoginGerente> m) {
		LoginGerente l = m.get("loginGerente");
		System.out.println(l.getEmail());
		LoginGerente login = loginRepository.findByEmail(l.getEmail());
		return (login != null && login.getSenha().equals(l.getSenha())) ? login.getFuncionario() : "{\"status\":\"login ou senha incorreto\"}";
	}
}
