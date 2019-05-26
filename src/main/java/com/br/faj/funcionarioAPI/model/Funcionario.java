package com.br.faj.funcionarioAPI.model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.Null;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

@Entity
@Table(name = "funcionario")
public class Funcionario {
	
	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	private String cargo;
	private String salario;
	private String email;
	private String nome;
	private String sobrenome;
	private String perfil;
	
	
	@OneToOne(mappedBy = "funcionario",cascade = CascadeType.ALL)
	@JsonManagedReference
	private LoginGerente loginGerente; // vou mapear o id do funcionario na foreign key da tabela loginGerente
	

	public Funcionario() {
		super();
	}


	public Funcionario(String cargo, String salario, String email, String nome, String sobrenome,
			String perfil, LoginGerente loginGerente) {
		super();
		this.cargo = cargo;
		this.salario = salario;
		this.email = email;
		this.nome = nome;
		this.sobrenome = sobrenome;
		this.perfil = perfil;
		this.loginGerente = loginGerente;
	}


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public String getCargo() {
		return cargo;
	}


	public void setCargo(String cargo) {
		this.cargo = cargo;
	}


	public String getSalario() {
		return salario;
	}


	public void setSalario(String salario) {
		this.salario = salario;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public String getNome() {
		return nome;
	}


	public void setNome(String nome) {
		this.nome = nome;
	}


	public String getSobrenome() {
		return sobrenome;
	}


	public void setSobrenome(String sobrenome) {
		this.sobrenome = sobrenome;
	}
	
	public LoginGerente getLoginGerente() {
		return loginGerente;
	}


	public void setLoginGerente(LoginGerente loginGerente) {
		this.loginGerente = loginGerente;
	}


	public String getPerfil() {
		return perfil;
	}


	public void setPerfil(String perfil) {
		this.perfil = perfil;
	}


}
