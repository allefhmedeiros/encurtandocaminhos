package br.com.encurtandocaminhos.api.controller;

import br.com.encurtandocaminhos.api.model.Servico;
import br.com.encurtandocaminhos.api.services.ServicoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/servicos")
public class ServicoController {

    @Autowired
    private ServicoService servicoService;

    @GetMapping
    public ResponseEntity<List<Servico>> listarServicos(){
        return ResponseEntity.ok(servicoService.listarServicos());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Servico> buscarPorId(@PathVariable Long id){
        Optional<Servico> servico = servicoService.buscarPorId(id);
        return servico.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Servico> adicionarServico(@RequestBody Servico servico){
        Servico novoServico = servicoService.salvarServico(servico);
        return ResponseEntity.status(201).body(novoServico);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletarServico(@PathVariable Long id){
        servicoService.deletarServico(id);
        return ResponseEntity.noContent().build();
    }
}
