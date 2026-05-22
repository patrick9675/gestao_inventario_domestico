package com.iefp.gestao_inventario_domestico.repository;

import com.iefp.gestao_inventario_domestico.model.Categoria;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoriaRepository extends JpaRepository<Categoria, Long> {
}
