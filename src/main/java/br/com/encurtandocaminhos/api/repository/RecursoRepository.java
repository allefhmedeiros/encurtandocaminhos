package br.com.encurtandocaminhos.api.repository;

import br.com.encurtandocaminhos.api.model.Recurso;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RecursoRepository extends JpaRepository<Recurso, Long> {
}
