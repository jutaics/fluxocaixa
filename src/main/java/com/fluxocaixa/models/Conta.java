package com.fluxocaixa.models;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import org.hibernate.validator.constraints.NotEmpty;

@Entity
public class Conta implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long codigo;

	@NotEmpty
	private String nome;

	@NotEmpty
	private String email;

	@NotEmpty
	private String contato;

	@NotEmpty
	private String descricao;

	// @Column(name="total_credito", nullable = false, columnDefinition = "default
	// 0") //comentar quando a tabela não existe
	private long total_credito;

	// @Column(name="total_debito", nullable = false, columnDefinition = "default
	// 0") //comentar quando a tabela não existe
	private long total_debito;

	@OneToMany(cascade = CascadeType.REMOVE, orphanRemoval = true, mappedBy = "conta")
	private List<Transacao> transacao;

	public long getCodigo() {
		return codigo;
	}

	public void setCodigo(long codigo) {
		this.codigo = codigo;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getContato() {
		return contato;
	}

	public void setContato(String contato) {
		this.contato = contato;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public long getTotal_credito() {
		return total_credito;
	}

	public void setTotal_credito(long total_credito) {
		this.total_credito = total_credito;
	}

	public long getTotal_debito() {
		return total_debito;
	}

	public void setTotal_debito(long total_debito) {
		this.total_debito = total_debito;
	}

	public List<Transacao> getTransacao() {
		return transacao;
	}

	public void setTransacao(List<Transacao> transacao) {
		this.transacao = transacao;
	}

}
