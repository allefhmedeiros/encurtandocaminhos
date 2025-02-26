package br.com.encurtandocaminhos.api.repository;

import br.com.encurtandocaminhos.api.model.Servico;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ServicoRepository extends JpaRepository<Servico, Long> {

}
