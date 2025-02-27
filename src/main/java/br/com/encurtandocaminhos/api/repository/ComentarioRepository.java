package br.com.encurtandocaminhos.api.repository;

import br.com.encurtandocaminhos.api.model.Comentario;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface ComentarioRepository extends JpaRepository<Comentario, Long> {

    // Buscar todos os comentários de uma publicação específica
    List<Comentario> findByPublicacaoId(Long publicacaoId);

    // Buscar um comentário pelo ID
    Optional<Comentario> findById(Long id);
}
