package com.fluxocaixa.models;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import org.hibernate.validator.constraints.NotEmpty;

@Entity
public class Transacao implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	// @GeneratedValue(strategy= GenerationType.AUTO)
	private String cdTransacao;

	@NotEmpty
	private String nome;

	@NotEmpty
	private String item;

	@NotEmpty
	private String formaPagamento;

	@NotEmpty
	private String tipoConta;

	@NotEmpty
	private String valor;

	@NotEmpty
	private String qtdParcela;

	@NotEmpty
	private String dtVencimento;

	@NotEmpty
	private String descricao;

	@NotEmpty
	private String status;

	@ManyToOne
	private Conta conta;

	public String getCdTransacao() {
		return cdTransacao;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public void setCdTransacao(String cdTransacao) {
		this.cdTransacao = cdTransacao;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getItem() {
		return item;
	}

	public void setItem(String item) {
		this.item = item;
	}

	public String getFormaPagamento() {
		return formaPagamento;
	}

	public void setFormaPagamento(String formaPagamento) {
		this.formaPagamento = formaPagamento;
	}

	public String getTipoConta() {
		return tipoConta;
	}

	public void setTipoConta(String tipoConta) {
		this.tipoConta = tipoConta;
	}

	public String getValor() {
		return valor;
	}

	public void setValor(String valor) {
		this.valor = valor;
	}

	public String getQtdParcela() {
		return qtdParcela;
	}

	public void setQtdParcela(String qtdParcela) {
		this.qtdParcela = qtdParcela;
	}

	public String getDtVencimento() {
		return dtVencimento;
	}

	public void setDtVencimento(String dtVencimento) {
		this.dtVencimento = dtVencimento;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public Conta getConta() {
		return conta;
	}

	public void setConta(Conta conta) {
		this.conta = conta;
	}

}
