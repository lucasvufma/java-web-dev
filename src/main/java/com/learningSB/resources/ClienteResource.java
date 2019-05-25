package com.learningSB.resources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.learningSB.domain.Cliente;
import com.learningSB.services.ClienteService;


@RestController
@RequestMapping(value="/Clientes")
public class ClienteResource {
		@Autowired
		private ClienteService service;
		
		@RequestMapping(value="/{id}",method=RequestMethod.GET)
		public ResponseEntity<?> list(@PathVariable Integer id){
			Cliente object = service.find(id);
			return ResponseEntity.ok().body(object);
		}

	}
	
	
	
