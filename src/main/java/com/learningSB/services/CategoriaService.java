package com.learningSB.services;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

import com.learningSB.domain.Categoria;
import com.learningSB.dto.CategoriaDTO;
import com.learningSB.repositories.CategoriaRepository;
import com.learningSB.services.exception.DataIntegrityException;
import com.learningSB.services.exception.ObjectNotFoundException;

@Service
public class CategoriaService {
	
	
	//autowired é injeção de dependencia ou também chamada de inversão de controle
	@Autowired
	private CategoriaRepository repository;
	
	public Categoria find(Integer id) {
		Optional<Categoria> object = repository.findById(id);
		return object.orElseThrow(
				()-> new ObjectNotFoundException(
						"Objeto não encontrado! Id: "+id+" Tipo: "+Categoria.class.getName()
						));
	}

	public Categoria insert(Categoria obj) {
		// TODO Auto-generated method stub
		obj.setId(null); //se nao tiver null no id, o save vai atualizar um objeto e nao criar um novo
		return repository.save(obj);
	}
	 
	public List<Categoria> findAll() {
		return repository.findAll();
	}


	public Categoria update(Categoria obj) {
		find(obj.getId());
		// TODO Auto-generated method stub
		return repository.save(obj);  //veja que o metodo save é o mesmo, só que ele verifica se é nulo ou não, se é nulo ele insere, se não é nulo ele atualiza.
	}

	public void deleteById(Integer id) {
		find(id);
		try {
		repository.deleteById(id);
		// TODO Auto-generated method stub		
		}
		catch(DataIntegrityViolationException e) {
			throw new DataIntegrityException("Categoria possui produtos associados a ela, portanto não é possivel exclui-la");
			}
		}
	
	public  Page<Categoria> findPage(Integer page, Integer linesPerPage,String direction, String orderBy){
		return repository.findAll(PageRequest.of(page,linesPerPage, Direction.valueOf(direction),orderBy));
	}
	
	public Categoria fromDTO(CategoriaDTO objDTO) {
		return new Categoria(objDTO.getId(),objDTO.getNome());
		
	}
	
}
