package com.learningSB.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.learningSB.domain.Pedido;

public interface PedidoRepository extends JpaRepository<Pedido,Integer> {

}
