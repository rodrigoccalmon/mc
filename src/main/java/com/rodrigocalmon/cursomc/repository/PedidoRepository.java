package com.rodrigocalmon.cursomc.repository;



import javax.transaction.Transactional;

import org.springframework.boot.autoconfigure.data.web.SpringDataWebProperties.Pageable;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.rodrigocalmon.cursomc.domain.Cliente;
import com.rodrigocalmon.cursomc.domain.Pedido;

@Repository
public interface PedidoRepository extends JpaRepository<Pedido, Integer> {
	
	
	Page<Pedido> findByCliente(Cliente cliente, PageRequest pageRequest);
}
