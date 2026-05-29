package com.iefp.gestao_inventario_domestico.controller;

import com.iefp.gestao_inventario_domestico.model.Produto;
import com.iefp.gestao_inventario_domestico.service.CategoriaService;
import com.iefp.gestao_inventario_domestico.service.LocalizacaoService;
import com.iefp.gestao_inventario_domestico.service.ProdutoService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/produtos")
public class ProdutoController {

    private final CategoriaService categoriaService;
    private final ProdutoService produtoService;
    private final LocalizacaoService localizacaoService;

    public ProdutoController(CategoriaService categoriaService, ProdutoService produtoService, LocalizacaoService localizacaoService) {
        this.categoriaService = categoriaService;
        this.produtoService = produtoService;
        this.localizacaoService = localizacaoService;
    }

    // Listar produtos
    @GetMapping
    public String listarProdutos(Model model) {
        model.addAttribute("produtos", produtoService.listarProdutos());
        return "redirect:/";
    }


    // Guardar produto
    @PostMapping
    public String guardarProduto(@ModelAttribute Produto produto) {
        produtoService.guardarProduto(produto);
        return "redirect:/";
    }

    // Apagar produto
    @GetMapping("/apagar/{id}")
    public String apagarProduto(@PathVariable Long id) {
        produtoService.apagarProduto(id);
        return "redirect:/";
    }

    // Editar produto
    @GetMapping("/editar/{id}")
    public String editarProduto(
            @PathVariable Long id,
            Model model) {

        Produto produto =
                produtoService.buscarPorId(id);

        model.addAttribute("produto", produto);

        model.addAttribute("produtos",
                produtoService.listarProdutos());

        model.addAttribute("categorias",
                categoriaService.listarCategorias());

        model.addAttribute("localizacoes",
                localizacaoService.listarLocalizacoes());

        return "index";
    }
}
