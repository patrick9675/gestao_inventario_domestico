package com.iefp.gestao_inventario_domestico.repository;

import com.iefp.gestao_inventario_domestico.model.Produto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProdutoRepository extends JpaRepository<Produto, Long> {
}
