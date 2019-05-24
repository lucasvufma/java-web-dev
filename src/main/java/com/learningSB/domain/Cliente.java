package com.learningSB.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.learningSB.domain.enums.TipoCliente;

@Entity
public class Cliente implements Serializable{
	private static final long serialVersionUID = 1L;
	
	@Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	private String nome;
	private String email;
	private String CPF;
	private Integer tipo;
	private String telefone1;
	private String telefone2;
	private String cidade;
	private String estado;
	
	@OneToMany(mappedBy="cliente")
	@JsonManagedReference
	private List<Endereco> enderecos = new ArrayList<>();
	
	@OneToMany(mappedBy="cliente")
	@JsonBackReference
	private List<Pedido>  pedidos= new ArrayList<>();
	
	public Cliente(String cidade,String estado,Integer id, String nome, String email, String cPF, TipoCliente tipo, String telefone1, String telefone2 ) {
		super();
		this.setCidade(cidade);
		this.setEstado(estado);
		this.id = id;
		this.nome = nome;
		this.email = email;
		CPF = cPF;
		this.tipo = tipo.getCod();
		this.telefone1 = telefone1;
		this.telefone2 = telefone2;
	}
	
	public Cliente() {
	}

	public Integer getId() {
		return id;
	}
	public List<Endereco> getEnderecos() {
		return enderecos;
	}

	public void setId(int id) {
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

	public String getCPF() {
		return CPF;
	}
	
	public void setEnderecos(List<Endereco> enderecos) {
		this.enderecos = enderecos;
	}

	public void setCPF(String cPF) {
		CPF = cPF;
	}

	public TipoCliente getTipo() {
		return TipoCliente.toEnum(this.tipo);
	}

	public void setTipo(TipoCliente tipo) {
		this.tipo = tipo.getCod();
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

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + id;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Cliente other = (Cliente) obj;
		if (id != other.id)
			return false;
		return true;
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
	public List<Pedido> getPedidos() {
		return pedidos;
	}

	

}
