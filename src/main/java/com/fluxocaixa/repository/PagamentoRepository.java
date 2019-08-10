package com.fluxocaixa.repository;

import org.springframework.data.repository.CrudRepository;

import com.fluxocaixa.models.Transacao;
import com.fluxocaixa.models.Conta;

public interface PagamentoRepository extends CrudRepository<Transacao, String> {
	Iterable<Transacao> findByConta(Conta conta);

	Transacao findByCdTransacao(String cdTransacao);
}
