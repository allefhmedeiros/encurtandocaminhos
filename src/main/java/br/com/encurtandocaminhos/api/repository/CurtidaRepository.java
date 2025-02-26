package br.com.encurtandocaminhos.api.repository;

import br.com.encurtandocaminhos.api.model.Curtida;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CurtidaRepository extends JpaRepository <Curtida, Long> {

    Optional<Curtida> findByUsuarioIdAndPublicacaoId(Long usuarioId, Long publicacaoId);

    long countByPublicacaoId(Long publicacaoId);
}
