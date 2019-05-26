package com.br.faj.funcionarioAPI.rest;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.br.faj.funcionarioAPI.dao.FuncionarioRepository;
import com.br.faj.funcionarioAPI.dao.LoginRepository;
import com.br.faj.funcionarioAPI.model.Funcionario;
import com.br.faj.funcionarioAPI.model.LoginGerente;

@RestController
@RequestMapping("/funcionarioAPI")
public class FuncionarioController {
	@Autowired
	FuncionarioRepository funcionarioRepository;
	
	@Autowired
	LoginRepository loginRepository;
	
	@GetMapping("/funcionarios")
	List<Funcionario> todos() {
		return funcionarioRepository.findAll();
	}

	@PostMapping("/funcionarios")
	Funcionario novoFuncionario(@RequestBody Funcionario funcionario) {
		if (funcionario.getLoginGerente() != null) {
			funcionario.getLoginGerente().setFuncionario(funcionario);
			
		}
		return funcionarioRepository.save(funcionario);
	}

	@GetMapping("/funcionarios/{id}")
	Funcionario um(@PathVariable Integer id) {
		return funcionarioRepository.findById(id).orElse(null);
	}

	@PutMapping("/funcionarios")
	Funcionario updateFuncionario(@RequestBody Funcionario funcionario) {

		return funcionarioRepository.findById(funcionario.getId()).map(func -> {
			func.setEmail(funcionario.getEmail());
			func.setCargo(funcionario.getCargo());
			func.setNome(funcionario.getNome());
			func.setSalario(funcionario.getSalario());
			func.setSobrenome(funcionario.getSobrenome());
			func.setLoginGerente(funcionario.getLoginGerente());
			return funcionarioRepository.save(funcionario);
		}).orElse(null);
	}

	@DeleteMapping("/funcionarios/{id}")
	void deleteFuncionario(@PathVariable Integer id) {
		funcionarioRepository.deleteById(id);
	}
}
