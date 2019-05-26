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
import javax.persistence.UniqueConstraint;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
@Table(name = "login_gerente")
public class LoginGerente {
	
	 @Id
     @GeneratedValue(strategy = GenerationType.AUTO)
	 private int id;
	 @Column(unique=true)
	 private String email;
	 private String senha;
	 
	 @OneToOne()
	 @JsonBackReference
	 private Funcionario funcionario; //vou ter a foreign key do funcionario na tabela login_gerente


	public LoginGerente(String email, String senha) {
		super();
		this.email = email;
		this.senha = senha;
	}

	public LoginGerente() {
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
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
	 
	public Funcionario getFuncionario() {
		return funcionario;
	}

	public void setFuncionario(Funcionario funcionario) {
		this.funcionario = funcionario;
	}
	 
}
