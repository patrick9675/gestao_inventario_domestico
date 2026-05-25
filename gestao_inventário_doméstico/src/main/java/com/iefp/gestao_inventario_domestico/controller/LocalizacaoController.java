package com.iefp.gestao_inventario_domestico.controller;

import com.iefp.gestao_inventario_domestico.model.Localizacao;
import com.iefp.gestao_inventario_domestico.service.LocalizacaoService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/localizacoes")
public class LocalizacaoController {

    private final LocalizacaoService localizacaoService;

    public LocalizacaoController(LocalizacaoService localizacaoService) {
        this.localizacaoService = localizacaoService;
    }

    // Listar localizações
    @GetMapping
    public String listarLocalizacoes(Model model) {

        model.addAttribute("localizacoes",
                localizacaoService.listarLocalizacoes());

        return "redirect:/";
    }


    // Guardar localização
    @PostMapping
    public String guardarLocalizacao(
            @ModelAttribute Localizacao localizacao) {

        localizacaoService.guardarLocalizacao(localizacao);

        return "redirect:/";
    }

    // Apagar localização
    @GetMapping("/apagar/{id}")
    public String apagarLocalizacao(@PathVariable Long id) {

        localizacaoService.apagarLocalizacao(id);

        return "redirect:/";
    }
}
