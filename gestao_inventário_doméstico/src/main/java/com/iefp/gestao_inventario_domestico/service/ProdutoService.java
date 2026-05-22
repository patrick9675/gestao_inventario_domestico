package com.iefp.gestao_inventario_domestico.service;

import com.iefp.gestao_inventario_domestico.model.Produto;
import com.iefp.gestao_inventario_domestico.repository.ProdutoRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProdutoService {

    private final ProdutoRepository produtoRepository;

    public ProdutoService(ProdutoRepository produtoRepository) {
        this.produtoRepository = produtoRepository;
    }

    // Listar todos os produtos
    public List<Produto> listarProdutos() {
        return produtoRepository.findAll();
    }

    // Guardar produto
    public Produto guardarProduto(Produto produto) {
        return produtoRepository.save(produto);
    }

    // Procurar produto por ID
    public Produto buscarPorId(Long id) {
        return produtoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Produto não encontrado"));
    }

    // Apagar produto
    public void apagarProduto(Long id) {
        produtoRepository.deleteById(id);
    }
}
