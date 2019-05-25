package com.learningSB.dto;

import java.io.Serializable;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;

import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.br.CPF;

public class ClienteNewDTO implements Serializable{
	private static final long serialVersionUID = 1L; 
	
	private String logradouro;
	private String numero;
	private String complemento;
	@NotEmpty(message="Campo obrigatório")
	private String bairro;
	@NotEmpty(message="Campo obrigatório")
	private String cep;
	
	@NotEmpty(message="Campo obrigatório")
	@Length(min=5,max=100,message="O nome deve conter entre 5 a 100 caracteres")
	private String nome;
	@NotEmpty(message="Campo obrigatório")
	@Email(message="Email invalido")
	private String email;
	@CPF
	private String CPF;
	private Integer tipo;
	@NotEmpty(message="Campo obrigatório")
	private String telefone1;
	private String telefone2;
	@NotEmpty(message="Campo obrigatório")
	private String cidade;
	@NotEmpty(message="Campo obrigatório")
	private String estado;
	
	public ClienteNewDTO() {
	}

	public String getLogradouro() {
		return logradouro;
	}

	public void setLogradouro(String logradouro) {
		this.logradouro = logradouro;
	}

	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	public String getComplemento() {
		return complemento;
	}

	public void setComplemento(String complemento) {
		this.complemento = complemento;
	}

	public String getBairro() {
		return bairro;
	}

	public void setBairro(String bairro) {
		this.bairro = bairro;
	}

	public String getCep() {
		return cep;
	}

	public void setCep(String cep) {
		this.cep = cep;
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

	public String getCPF() {
		return CPF;
	}

	public void setCPF(String cPF) {
		CPF = cPF;
	}

	public Integer getTipo() {
		return tipo;
	}

	public void setTipo(Integer tipo) {
		this.tipo = tipo;
	}

	public String getTelefone1() {
		return telefone1;
	}

	public void setTelefone1(String telefone1) {
		this.telefone1 = telefone1;
	}

	public String getTelefone2() {
		return telefone2;
	}

	public void setTelefone2(String telefone2) {
		this.telefone2 = telefone2;
	}

	public String getCidade() {
		return cidade;
	}

	public void setCidade(String cidade) {
		this.cidade = cidade;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}
	

}
