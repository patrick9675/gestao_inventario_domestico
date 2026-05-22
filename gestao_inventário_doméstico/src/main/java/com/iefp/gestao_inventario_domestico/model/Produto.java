package com.iefp.gestao_inventario_domestico.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


import java.time.LocalDate;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Produto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;

    private Integer quantidade;

    private LocalDate dataValidade;

    @ManyToOne
    @JoinColumn(name = "categoria_id")
    private Categoria categoria;
}
