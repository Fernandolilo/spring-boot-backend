package com.systempro.cursomc.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import com.systempro.cursomc.domain.Categoria;
import com.systempro.cursomc.repositories.CategoriaRepository;
import com.systempro.cursomc.services.exceptions.DataIntegrityException;
import com.systempro.cursomc.services.exceptions.ObjectNotFoundException;


@Service
public class CategoriaService {

	@Autowired
	private CategoriaRepository repo;

	public Categoria find (Integer id) {

		Optional<Categoria> obj = repo.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException(
		 "Objeto não encontrado! Id: " + id + ", Tipo: " + Categoria.class.getName()));
	}

	public Categoria insert(Categoria obj) {

		obj.setId(null);
		return repo.save(obj);
	}

	
	public Categoria update (Categoria obj) {
		find(obj.getId());
		return repo.save(obj);
	}
	
	public void delete(Integer id) {
		find(id);
		try {
		repo.deleteById(id);
		}
		catch (DataIntegrityViolationException e)  {			
			throw new  DataIntegrityException("Não é possivel excluir uma CATEGORIA, pois possui produtos: ");
		}
	}
	
	
	
	public List<Categoria> findAll(){
		return repo.findAll();
	}
}
