package br.com.encurtandocaminhos.api.services;

import br.com.encurtandocaminhos.api.model.Comentario;
import br.com.encurtandocaminhos.api.repository.ComentarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ComentarioService {

    @Autowired
    private ComentarioRepository comentarioRepository;

    // Criar comentário
    public Comentario criarComentario(Comentario comentario) {
        return comentarioRepository.save(comentario);
    }

    // Deletar comentário por ID
    public boolean deletarComentario(Long id) {
        if (comentarioRepository.existsById(id)) {
            comentarioRepository.deleteById(id);
            return true;
        }
        return false;
    }

    // Buscar comentários por ID da publicação

    public List<Comentario> buscarComentariosPorPublicacao(Long publicacaoId) {
        return comentarioRepository.findByPublicacaoId(publicacaoId);
    }

    // Buscar comentário por ID
    public Optional<Comentario> buscarComentarioPorId(Long id) {
        return comentarioRepository.findById(id);
    }
}
