package com.learningSB.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.learningSB.domain.Cliente;
import com.learningSB.repositories.ClienteRepository;
import com.learningSB.services.exception.ObjectNotFoundException;

@Service
public class ClienteService {
		//autowired é injeção de dependencia ou também chamada de inversão de controle
		@Autowired
		private ClienteRepository repository;
		
		public Cliente find(Integer id) {
			Optional<Cliente> object = repository.findById(id);
			return object.orElseThrow(
					()-> new ObjectNotFoundException(
							"Objeto não encontrado! Id: "+id+" Tipo: "+Cliente.class.getName()
							));
		}

	}

	
	
