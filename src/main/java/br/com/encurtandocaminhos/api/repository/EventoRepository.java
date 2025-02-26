package br.com.encurtandocaminhos.api.repository;

import br.com.encurtandocaminhos.api.model.Evento;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EventoRepository extends JpaRepository<Evento, Long> {

}
