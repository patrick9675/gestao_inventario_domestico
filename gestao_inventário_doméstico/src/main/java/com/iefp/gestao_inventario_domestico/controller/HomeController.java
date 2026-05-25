package com.iefp.gestao_inventario_domestico.controller;

import com.iefp.gestao_inventario_domestico.model.Produto;
import com.iefp.gestao_inventario_domestico.service.CategoriaService;
import com.iefp.gestao_inventario_domestico.service.LocalizacaoService;
import com.iefp.gestao_inventario_domestico.service.ProdutoService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    private final ProdutoService produtoService;
    private final CategoriaService categoriaService;
    private final LocalizacaoService localizacaoService;

    public HomeController(
            ProdutoService produtoService,
            CategoriaService categoriaService,
            LocalizacaoService localizacaoService) {

        this.produtoService = produtoService;
        this.categoriaService = categoriaService;
        this.localizacaoService = localizacaoService;
    }

    @GetMapping("/")
    public String home(Model model) {

        model.addAttribute("produto", new Produto());

        model.addAttribute("produtos", produtoService.listarProdutos());

        model.addAttribute("categorias", categoriaService.listarCategorias());

        model.addAttribute("localizacoes", localizacaoService.listarLocalizacoes());

        return "index";
    }
}
