package com.learningSB.services;
import com.learningSB.services.exception.ObjectNotFoundException;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.learningSB.domain.Categoria;
import com.learningSB.repositories.CategoriaRepository;

@Service
public class CategoriaService {
	
	
	//autowired é injeção de dependencia ou também chamada de inversão de controle
	@Autowired
	private CategoriaRepository repository;
	
	public Categoria buscar(Integer id) {
		Optional<Categoria> object = repository.findById(id);
		return object.orElseThrow(
				()-> new ObjectNotFoundException(
						"Objeto não encontrado! Id: "+id+" Tipo: "+Categoria.class.getName()
						));
	}

}
