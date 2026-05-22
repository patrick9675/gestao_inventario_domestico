package com.iefp.gestao_inventario_domestico.repository;

import com.iefp.gestao_inventario_domestico.model.Localizacao;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LocalizacaoRepository extends JpaRepository<Localizacao, Long> {
}
