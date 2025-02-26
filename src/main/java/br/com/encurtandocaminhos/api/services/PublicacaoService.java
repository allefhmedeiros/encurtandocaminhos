package br.com.encurtandocaminhos.api.services;

import br.com.encurtandocaminhos.api.model.Publicacao;
import br.com.encurtandocaminhos.api.model.Recurso;
import br.com.encurtandocaminhos.api.repository.PublicacaoRepository;
import br.com.encurtandocaminhos.api.repository.RecursoRepository;
import jakarta.transaction.Transactional;
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
    @Transactional
    public Publicacao salvarPublicacao(Publicacao publicacao) {
        // Salvar a publicação primeiro
        publicacao = publicacaoRepository.save(publicacao);

        // Agora que a publicação foi salva, associe os recursos a ela
        if (publicacao.getRecursos() != null) {
            for (Recurso recurso : publicacao.getRecursos()) {
                recurso.setPublicacao(publicacao);
                recursoRepository.save(recurso);  // Salvar cada recurso
            }
        }

        return publicacao;
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

    public Publicacao atualizarConteudo(Long id, String conteudo) {
        // Busca a publicação pelo ID
        Publicacao publicacao = publicacaoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Publicação não encontrada"));

        // Atualiza o conteúdo
        publicacao.setConteudo(conteudo);

        // Salva a publicação atualizada e retorna
        return publicacaoRepository.save(publicacao);
    }
}
