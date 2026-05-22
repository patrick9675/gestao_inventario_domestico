package com.iefp.gestao_inventario_domestico.controller;

import com.iefp.gestao_inventario_domestico.model.Produto;
import com.iefp.gestao_inventario_domestico.service.CategoriaService;
import com.iefp.gestao_inventario_domestico.service.ProdutoService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/produtos")
public class ProdutoController {

    private final CategoriaService categoriaService;
    private final ProdutoService produtoService;

    public ProdutoController(CategoriaService categoriaService, ProdutoService produtoService) {
        this.categoriaService = categoriaService;
        this.produtoService = produtoService;
    }

    // Listar produtos
    @GetMapping
    public String listarProdutos(Model model) {
        model.addAttribute("produtos", produtoService.listarProdutos());
        return "produtos";
    }

    // Mostrar formulário
    @GetMapping("/novo")
    public String mostrarFormulario(Model model) {

        model.addAttribute("produto", new Produto());

        model.addAttribute("categorias",
                categoriaService.listarCategorias());

        return "form-produto";
    }

    // Guardar produto
    @PostMapping
    public String guardarProduto(@ModelAttribute Produto produto) {
        produtoService.guardarProduto(produto);
        return "redirect:/produtos";
    }

    // Apagar produto
    @GetMapping("/apagar/{id}")
    public String apagarProduto(@PathVariable Long id) {
        produtoService.apagarProduto(id);
        return "redirect:/produtos";
    }
}
