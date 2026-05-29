package com.iefp.gestao_inventario_domestico.repository;

import com.iefp.gestao_inventario_domestico.model.Produto;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface ProdutoRepository extends JpaRepository<Produto, Long> {
    List<Produto> findByCategoriaId(Long categoriaId);

    List<Produto> findByLocalizacaoId(Long localizacaoId);

    List<Produto> findByNomeContainingIgnoreCase(String nome);
}
