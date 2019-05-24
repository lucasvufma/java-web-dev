package com.learningSB.services;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.learningSB.domain.Pedido;
import com.learningSB.repositories.PedidoRepository;
import com.learningSB.services.exception.ObjectNotFoundException;

@Service
public class PedidoService {
		//autowired é injeção de dependencia ou também chamada de inversão de controle
		@Autowired
		private PedidoRepository repository;
		
		public Pedido buscar(Integer id) {
			Optional<Pedido> object = repository.findById(id);
			return object.orElseThrow(
					()-> new ObjectNotFoundException(
							"Objeto não encontrado! Id: "+id+" Tipo: "+Pedido.class.getName()
							));
		}

	}

	
	