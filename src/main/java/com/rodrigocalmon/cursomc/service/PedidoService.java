package com.rodrigocalmon.cursomc.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rodrigocalmon.cursomc.domain.Pedido;
import com.rodrigocalmon.cursomc.repository.CategoriaRepository;
import com.rodrigocalmon.cursomc.repository.PedidoRepository;
import com.rodrigocalmon.cursomc.service.exception.ObjectNotFoundException;

@Service
public class PedidoService {

	@Autowired
	private PedidoRepository repo;

	public Pedido find(Integer id) { 
		 Optional<Pedido> obj = repo.findById(id); 
		return obj.orElseThrow(() -> new ObjectNotFoundException( 
		 "Objeto não encontrado! Id: " + id + ", Tipo: " + Pedido.class.getName())); 
		} 
}
