package com.learningSB.resources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.learningSB.domain.Pedido;
import com.learningSB.services.PedidoService;

@RestController
@RequestMapping(value="/pedidos")
public class PedidoResource {
		@Autowired
		private PedidoService service;
		
		@RequestMapping(value="/{id}",method=RequestMethod.GET)
		public ResponseEntity<?> list(@PathVariable Integer id){
			Pedido object = service.find(id);
			return ResponseEntity.ok().body(object);
		}

	}
	