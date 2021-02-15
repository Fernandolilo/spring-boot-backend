package com.systempro.cursomc.resources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.systempro.cursomc.domain.Categoria;
import com.systempro.cursomc.services.CategoriaService;
import com.systempro.cursomc.services.exceptions.ObjectNotFoundException;

@RestController
@RequestMapping(value="/categorias")
public class CategoriaResource {
	@Autowired
	private CategoriaService service;
	
	@RequestMapping(value="/{id}",method=RequestMethod.GET)
	public ResponseEntity<?> find(@PathVariable Integer id) {
		
		Categoria obj = service.buscar(id);
		if(obj == null) { // verificar se identificador existe. caso haja mostra, caso não mostra o erro.
			
			throw new ObjectNotFoundException("Objeto não encontrado! Id: "+ id 
					+ " Tipo: " + Categoria.class.getName());
		}
		
		return ResponseEntity.ok().body(obj);
		
		
		
		
	}
	
}
