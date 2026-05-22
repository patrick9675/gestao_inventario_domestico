package com.iefp.gestao_inventario_domestico.service;

import com.iefp.gestao_inventario_domestico.model.Localizacao;
import com.iefp.gestao_inventario_domestico.repository.LocalizacaoRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LocalizacaoService {

    private final LocalizacaoRepository localizacaoRepository;

    public LocalizacaoService(LocalizacaoRepository localizacaoRepository) {
        this.localizacaoRepository = localizacaoRepository;
    }

    // Listar localizações
    public List<Localizacao> listarLocalizacoes() {
        return localizacaoRepository.findAll();
    }

    // Guardar localização
    public Localizacao guardarLocalizacao(Localizacao localizacao) {
        return localizacaoRepository.save(localizacao);
    }

    // Procurar localização por ID
    public Localizacao buscarPorId(Long id) {
        return localizacaoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Localização não encontrada"));
    }

    // Apagar localização
    public void apagarLocalizacao(Long id) {
        localizacaoRepository.deleteById(id);
    }
}
