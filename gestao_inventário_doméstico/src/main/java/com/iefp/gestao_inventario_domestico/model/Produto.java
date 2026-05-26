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

    @ManyToOne
    @JoinColumn(name = "localizacao_id")
    private Localizacao localizacao;

    public boolean expirado() {

        if (dataValidade == null) {
            return false;
        }

        return dataValidade.isBefore(LocalDate.now());
    }

    public boolean alerta3Dias() {

        if (dataValidade == null) {
            return false;
        }

        return !expirado()
                && dataValidade.isBefore(LocalDate.now().plusDays(3));
    }

    public boolean alerta7Dias() {

        if (dataValidade == null) {
            return false;
        }

        return !expirado()
                && !alerta3Dias()
                && dataValidade.isBefore(LocalDate.now().plusDays(7));
    }
}
