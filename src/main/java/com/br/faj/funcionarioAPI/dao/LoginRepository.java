package com.br.faj.funcionarioAPI.dao;

import org.hibernate.query.criteria.internal.CriteriaUpdateImpl;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.br.faj.funcionarioAPI.model.Funcionario;
import com.br.faj.funcionarioAPI.model.LoginGerente;

@Repository
public interface LoginRepository extends JpaRepository<LoginGerente, Integer> {

	LoginGerente findByEmail(String email);
}
