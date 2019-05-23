package com.learningSB.repositories;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.learningSB.domain.Produto;
@Repository
public interface ProdutoRepository extends JpaRepository<Produto,Integer>{
 
}
