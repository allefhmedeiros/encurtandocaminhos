package br.com.encurtandocaminhos.api.controller;

import br.com.encurtandocaminhos.api.model.Publicacao;
import br.com.encurtandocaminhos.api.services.PublicacaoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("/publicacoes")
public class PublicacaoController {

    @Autowired
    private PublicacaoService publicacaoService;

    // Endpoint para criar uma nova publicação
    @PostMapping
    public ResponseEntity<Publicacao> criarPublicacao(@RequestBody Publicacao publicacao) {
        Publicacao novaPublicacao = publicacaoService.salvarPublicacao(publicacao);
        return new ResponseEntity<>(novaPublicacao, HttpStatus.CREATED);
    }

    // Endpoint para listar todas as publicações
    @GetMapping
    public ResponseEntity<List<Publicacao>> listarPublicacoes() {
        List<Publicacao> publicacoes = publicacaoService.listarPublicacoes();
        return new ResponseEntity<>(publicacoes, HttpStatus.OK);
    }

    // Endpoint para buscar uma publicação por ID
    @GetMapping("/{id}")
    public ResponseEntity<Publicacao> buscarPorId(@PathVariable Long id) {
        Optional<Publicacao> publicacao = publicacaoService.buscarPorId(id);
        return publicacao.map(value -> new ResponseEntity<>(value, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    // Endpoint para excluir uma publicação
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> excluirPublicacao(@PathVariable Long id) {
        boolean excluida = publicacaoService.excluirPublicacao(id);
        return excluida ? new ResponseEntity<>(HttpStatus.NO_CONTENT)
                : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Publicacao atualizarConteudoPublicacao(@PathVariable Long id, @RequestBody Map<String, String> body) {
        String conteudo = body.get("conteudo");
        return publicacaoService.atualizarConteudo(id, conteudo);
    }

}
