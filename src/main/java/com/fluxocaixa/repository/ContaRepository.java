package com.fluxocaixa.repository;

import org.springframework.data.repository.CrudRepository;

import com.fluxocaixa.models.Conta;

public interface ContaRepository extends CrudRepository<Conta, String> {
	Conta findByCodigo(long codigo);
}
