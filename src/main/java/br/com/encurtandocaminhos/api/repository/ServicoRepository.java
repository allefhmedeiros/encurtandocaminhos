package br.com.encurtandocaminhos.api.repository;

import br.com.encurtandocaminhos.api.model.Servico;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface ServicoRepository extends JpaRepository<Servico, Long> {
    @Query("SELECT s FROM Servico s JOIN FETCH s.prestador WHERE s.id = :id")
    Optional<Servico> buscarPorIdComPrestador(@Param("id") Long id);

    List<Servico> findByPrestadorId(Long prestadorId);
}
