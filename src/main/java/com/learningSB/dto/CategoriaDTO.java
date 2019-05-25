package com.learningSB.dto;

import java.io.Serializable;

import com.learningSB.domain.Categoria;
import javax.validation.constraints.NotEmpty;
import org.hibernate.validator.constraints.Length;
 

public class CategoriaDTO implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private Integer id;
	
	@NotEmpty(message="Campo Obrigatório")
	@Length(min=2,max=50,message="Tamanho de 2 a 50 caracteres")
	private String nome;
	
	public CategoriaDTO() {
	}
	public CategoriaDTO(Categoria obj) {
		this.id=obj.getId();
		this.nome=obj.getNome();
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
	

}
