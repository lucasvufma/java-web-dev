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
import com.learningSB.domain.Cliente;
import com.learningSB.domain.Endereco;
import com.learningSB.domain.enums.TipoCliente;
import com.learningSB.dto.ClienteDTO;
import com.learningSB.dto.ClienteNewDTO;
import com.learningSB.repositories.ClienteRepository;
import com.learningSB.repositories.EnderecoRepository;
import com.learningSB.services.exception.DataIntegrityException;
import com.learningSB.services.exception.ObjectNotFoundException;

@Service
public class ClienteService {
		//autowired é injeção de dependencia ou também chamada de inversão de controle
		@Autowired
		private ClienteRepository repository;
		
		@Autowired
		private EnderecoRepository enderecoRepository;
		
		public Cliente find(Integer id) {
			Optional<Cliente> object = repository.findById(id);
			return object.orElseThrow(
					()-> new ObjectNotFoundException(
							"Objeto não encontrado! Id: "+id+" Tipo: "+Cliente.class.getName()
							));
		}
		
		public Cliente insert(Cliente obj) {
			obj.setId(null);   //se nao tiver null no id, o save vai atualizar um objeto e nao criar um novo
			obj = repository.save(obj);
			enderecoRepository.saveAll(obj.getEnderecos());
			return obj;
		}
		
		public List<Cliente> findAll() {
			return repository.findAll();
		}

/*
		public Cliente update(Cliente obj) {
			find(obj.getId()); //Apenas pra throw excpetion
			// TODO Auto-generated method stub
			return repository.save(obj);  //veja que o metodo save é o mesmo para put e post, só que ele verifica se é nulo ou não, se é nulo ele insere, se não é nulo ele atualiza.
		}
*/
		public Cliente update(Cliente obj) {
			Cliente newObj = find(obj.getId());
			updateData(newObj,obj);
			// TODO Auto-generated method stub
			return repository.save(newObj);  //veja que o metodo save é o mesmo, só que ele verifica se é nulo ou não, se é nulo ele insere, se não é nulo ele atualiza.
		}
		
		private void updateData(Cliente newObj,Cliente obj) {
			newObj.setEmail(obj.getEmail());
			newObj.setNome(obj.getNome());
		}
		
		public void deleteById(Integer id) {
			find(id);
			try {
			repository.deleteById(id);
			// TODO Auto-generated method stub		
			}
			catch(DataIntegrityViolationException e) {
				throw new DataIntegrityException("Cliente possui pedidos e endereços associados a ele, portanto não é possivel exclui-la");
				}
			}
		
		public  Page<Cliente> findPage(Integer page, Integer linesPerPage,String direction, String orderBy){
			return repository.findAll(PageRequest.of(page,linesPerPage, Direction.valueOf(direction),orderBy));
		}
		
		public Cliente fromDTO(ClienteDTO objDTO) {
			return new Cliente(null,null,objDTO.getId(),objDTO.getNome(),objDTO.getEmail(),null,null,null,null);
			
		}
		public Cliente fromDTO(ClienteNewDTO objDTO) {
			Cliente c1 = new Cliente(objDTO.getCidade(),objDTO.getCidade(),null, objDTO.getNome(),objDTO.getEmail(),objDTO.getCPF(),TipoCliente.toEnum(objDTO.getTipo()),objDTO.getTelefone1(), objDTO.getTelefone2());
		    Endereco end = new Endereco(null,objDTO.getLogradouro(),objDTO.getNumero(),objDTO.getComplemento(),objDTO.getBairro(),objDTO.getCep(),c1);
		    c1.getEnderecos().add(end);
		    return c1;
		}

	}

	
	
