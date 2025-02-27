package br.com.encurtandocaminhos.api.controller;

import br.com.encurtandocaminhos.api.model.Comentario;
import br.com.encurtandocaminhos.api.services.ComentarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/comentarios")
public class ComentarioController {

    @Autowired
    private ComentarioService comentarioService;

    // Criar comentário
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Comentario criarComentario(@RequestBody Comentario comentario) {
        return comentarioService.criarComentario(comentario);
    }

    // Deletar comentário
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deletarComentario(@PathVariable Long id) {
        if (!comentarioService.deletarComentario(id)) {
            throw new RuntimeException("Comentário não encontrado");
        }
    }

    // Buscar comentários por ID da publicação
    @GetMapping("/publicacao/{publicacaoId}")
    public List<Comentario> buscarComentariosPorPublicacao(@PathVariable Long publicacaoId) {
        return comentarioService.buscarComentariosPorPublicacao(publicacaoId);
    }

    // Buscar comentário por ID
    @GetMapping("/{id}")
    public Optional<Comentario> buscarComentarioPorId(@PathVariable Long id) {
        return comentarioService.buscarComentarioPorId(id);
    }
}
