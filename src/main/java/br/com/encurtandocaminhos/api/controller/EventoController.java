package br.com.encurtandocaminhos.api.controller;

import br.com.encurtandocaminhos.api.model.Evento;
import br.com.encurtandocaminhos.api.model.Usuario;
import br.com.encurtandocaminhos.api.repository.EventoRepository;
import br.com.encurtandocaminhos.api.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/eventos")
public class EventoController {

    @Autowired
    private EventoRepository eventoRepository;

    @Autowired
    private UsuarioRepository usuarioRepository;

    // Endpoint para criar um novo evento
    @PostMapping
    public ResponseEntity<Evento> criarEvento(@RequestBody Evento evento) {
        // Verificar se o organizador existe
        Optional<Usuario> usuario = usuarioRepository.findById(evento.getOrganizador().getId());
        if (usuario.isEmpty()) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                    .body(null); // Retorna erro se o organizador não for encontrado
        }

        evento.setOrganizador(usuario.get()); // Atribui o organizador existente ao evento
        Evento novoEvento = eventoRepository.save(evento);
        return ResponseEntity.status(HttpStatus.CREATED).body(novoEvento);
    }

    // Endpoint para listar todos os eventos
    @GetMapping
    public ResponseEntity<List<Evento>> listarEventos() {
        List<Evento> eventos = eventoRepository.findAll();
        return ResponseEntity.ok(eventos);
    }

    // Endpoint para buscar um evento por ID
    @GetMapping("/{id}")
    public ResponseEntity<Evento> buscarEvento(@PathVariable Long id) {
        Optional<Evento> evento = eventoRepository.findById(id);
        if (evento.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
        return ResponseEntity.ok(evento.get());
    }

    // Endpoint para atualizar um evento
    @PutMapping("/{id}")
    public ResponseEntity<Evento> atualizarEvento(@PathVariable Long id, @RequestBody Evento eventoAtualizado) {
        Optional<Evento> eventoExistente = eventoRepository.findById(id);

        if (eventoExistente.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }

        Evento evento = eventoExistente.get();

        // Atualizar os campos do evento
        evento.setTitulo(eventoAtualizado.getTitulo());
        evento.setDtInicio(eventoAtualizado.getDtInicio());
        evento.setDtFim(eventoAtualizado.getDtFim());
        evento.setResumo(eventoAtualizado.getResumo());
        evento.setValorEntrada(eventoAtualizado.getValorEntrada());

        // Caso necessário, se você também estiver atualizando o organizador, descomente o seguinte
        // evento.setOrganizador(eventoAtualizado.getOrganizador());

        try {
            // Salva o evento atualizado
            Evento eventoSalvo = eventoRepository.save(evento);
            return ResponseEntity.ok(eventoSalvo);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }
    }

    // Endpoint para excluir um evento
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> excluirEvento(@PathVariable Long id) {
        Optional<Evento> evento = eventoRepository.findById(id);
        if (evento.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        eventoRepository.deleteById(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
}
