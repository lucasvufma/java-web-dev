package com.learningSB.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.learningSB.domain.Pagamento;

public interface PagamentoRepository extends JpaRepository<Pagamento,Integer> {

}
