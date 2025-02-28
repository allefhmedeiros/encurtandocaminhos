package br.com.encurtandocaminhos.api.repository;

import br.com.encurtandocaminhos.api.model.Evento;
import br.com.encurtandocaminhos.api.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface EventoRepository extends JpaRepository<Evento, Long> {
    // Método para encontrar eventos por organizador
    List<Evento> findByOrganizador(Usuario organizador);

}
