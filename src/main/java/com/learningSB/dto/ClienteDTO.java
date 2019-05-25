package com.learningSB.dto;

import java.io.Serializable;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;

import org.hibernate.validator.constraints.Length;

import com.learningSB.domain.Cliente;

public class ClienteDTO implements Serializable{
	private static final long serialVersionUID = 1L;
	
	
	private Integer id;
	@NotEmpty(message="Campo obrigatório")
	@Length(min=5,max=100,message="O nome deve conter entre 5 a 100 caracteres")
	private String nome;
	
	@NotEmpty(message="Campo obrigatório")
	@Email(message="Email invalido")
	private String email;
	
	@NotEmpty(message="Campo obrigatório")
	private String telefone1;
	
	

	public ClienteDTO(){
	}
	public ClienteDTO(Cliente obj) {
		this.id=obj.getId();
		this.nome=obj.getNome();
		this.email=obj.getEmail();
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
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
	public String getTelefone1() {
		return telefone1;
	}
	public void setTelefone1(String telefone1) {
		this.telefone1 = telefone1;
	}

	

}
