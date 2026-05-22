package com.iefp.gestao_inventario_domestico.service;

import com.iefp.gestao_inventario_domestico.model.Categoria;
import com.iefp.gestao_inventario_domestico.repository.CategoriaRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoriaService {

    private final CategoriaRepository categoriaRepository;

    public CategoriaService(CategoriaRepository categoriaRepository) {
        this.categoriaRepository = categoriaRepository;
    }

    // Listar categorias
    public List<Categoria> listarCategorias() {
        return categoriaRepository.findAll();
    }

    // Guardar categoria
    public Categoria guardarCategoria(Categoria categoria) {
        return categoriaRepository.save(categoria);
    }

    // Procurar categoria por ID
    public Categoria buscarPorId(Long id) {
        return categoriaRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Categoria não encontrada"));
    }

    // Apagar categoria
    public void apagarCategoria(Long id) {
        categoriaRepository.deleteById(id);
    }
}
