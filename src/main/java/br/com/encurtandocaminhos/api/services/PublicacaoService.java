package br.com.encurtandocaminhos.api.services;

import br.com.encurtandocaminhos.api.model.Publicacao;
import br.com.encurtandocaminhos.api.model.Recurso;
import br.com.encurtandocaminhos.api.repository.PublicacaoRepository;
import br.com.encurtandocaminhos.api.repository.RecursoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PublicacaoService {

    @Autowired
    private PublicacaoRepository publicacaoRepository;

    @Autowired
    private RecursoRepository recursoRepository;

    // Criar uma nova publicação garantindo a ordem correta de salvamento
    public Publicacao salvarPublicacao(Publicacao publicacao) {
        // Primeiro, salva os recursos associados (se houverem)
        if (publicacao.getRecursos() != null && !publicacao.getRecursos().isEmpty()) {
            for (Recurso recurso : publicacao.getRecursos()) {
                recursoRepository.save(recurso);
            }
        }

        // Agora, salva a publicação já vinculada aos recursos salvos
        return publicacaoRepository.save(publicacao);
    }

    // Buscar todas as publicações
    public List<Publicacao> listarPublicacoes() {
        return publicacaoRepository.findAll();
    }

    // Buscar publicação por ID
    public Optional<Publicacao> buscarPorId(Long id) {
        return publicacaoRepository.findById(id);
    }

    // Excluir uma publicação
    public boolean excluirPublicacao(Long id) {
        if (publicacaoRepository.existsById(id)) {
            publicacaoRepository.deleteById(id);
            return true;
        }
        return false;
    }
}
