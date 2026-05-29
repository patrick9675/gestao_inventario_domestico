package com.iefp.gestao_inventario_domestico.controller;

import com.iefp.gestao_inventario_domestico.model.Produto;
import com.iefp.gestao_inventario_domestico.service.CategoriaService;
import com.iefp.gestao_inventario_domestico.service.LocalizacaoService;
import com.iefp.gestao_inventario_domestico.service.ProdutoService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

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
    public String home(

            @RequestParam(required = false) String filtro,
            @RequestParam(required = false) String pesquisa,

            Model model) {

        List<Produto> produtos =
                produtoService.listarProdutos();

        // PESQUISA

        if (pesquisa != null && !pesquisa.isEmpty()) {

            produtos = produtos.stream()

                    .filter(produto ->
                            produto.getNome()
                                    .toLowerCase()
                                    .contains(pesquisa.toLowerCase()))

                    .toList();
        }

        // FILTROS

        if (filtro != null && !filtro.isEmpty()) {

            // CATEGORIA

            if (filtro.startsWith("categoria-")) {

                Long categoriaId = Long.parseLong(
                        filtro.replace("categoria-", "")
                );

                produtos = produtos.stream()

                        .filter(produto ->
                                produto.getCategoria() != null
                                        && produto.getCategoria().getId()
                                        .equals(categoriaId))

                        .toList();
            }

            // LOCALIZAÇÃO

            else if (filtro.startsWith("localizacao-")) {

                Long localizacaoId = Long.parseLong(
                        filtro.replace("localizacao-", "")
                );

                produtos = produtos.stream()

                        .filter(produto ->
                                produto.getLocalizacao() != null
                                        && produto.getLocalizacao().getId()
                                        .equals(localizacaoId))

                        .toList();
            }

            // ALERTA 3 DIAS

            else if (filtro.equals("alerta-3")) {

                produtos = produtos.stream()
                        .filter(Produto::alerta3Dias)
                        .toList();
            }

            // ALERTA 7 DIAS

            else if (filtro.equals("alerta-7")) {

                produtos = produtos.stream()
                        .filter(Produto::alerta7Dias)
                        .toList();
            }

            // EXPIRADOS

            else if (filtro.equals("alerta-expirado")) {

                produtos = produtos.stream()
                        .filter(Produto::expirado)
                        .toList();
            }
        }

        model.addAttribute("produto",
                new Produto());

        model.addAttribute("produtos",
                produtos);

        model.addAttribute("categorias",
                categoriaService.listarCategorias());

        model.addAttribute("localizacoes",
                localizacaoService.listarLocalizacoes());

        return "index";
    }
}
