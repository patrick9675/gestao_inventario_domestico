package com.iefp.gestao_inventario_domestico.controller;

import com.iefp.gestao_inventario_domestico.model.Categoria;
import com.iefp.gestao_inventario_domestico.service.CategoriaService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/categorias")
public class CategoriaController {

    private final CategoriaService categoriaService;

    public CategoriaController(CategoriaService categoriaService) {
        this.categoriaService = categoriaService;
    }

    // Listar categorias
    @GetMapping
    public String listarCategorias(Model model) {
        model.addAttribute("categorias", categoriaService.listarCategorias());
        return "categorias";
    }

    // Mostrar formulário
    @GetMapping("/novo")
    public String mostrarFormulario(Model model) {
        model.addAttribute("categoria", new Categoria());
        return "form-categoria";
    }

    // Guardar categoria
    @PostMapping
    public String guardarCategoria(@ModelAttribute Categoria categoria) {
        categoriaService.guardarCategoria(categoria);
        return "redirect:/categorias";
    }

    // Apagar categoria
    @GetMapping("/apagar/{id}")
    public String apagarCategoria(@PathVariable Long id) {
        categoriaService.apagarCategoria(id);
        return "redirect:/categorias";
    }
}
