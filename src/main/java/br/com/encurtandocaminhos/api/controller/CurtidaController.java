package br.com.encurtandocaminhos.api.controller;

import br.com.encurtandocaminhos.api.model.Curtida;
import br.com.encurtandocaminhos.api.services.CurtidaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/curtidas")
public class CurtidaController {

    @Autowired
    private CurtidaService curtidaService;

    // Endpoint para buscar uma curtida por usuário e publicação
    @GetMapping("/buscar")
    public ResponseEntity<Curtida> buscarCurtida(@RequestParam Long usuarioId, @RequestParam Long publicacaoId) {
        return curtidaService.buscarPorUsuarioEPublicacao(usuarioId, publicacaoId)
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    // Endpoint para excluir uma curtida de um usuário em uma publicação
    @DeleteMapping("/excluir")
    public ResponseEntity<Void> excluirCurtida(@RequestParam Long usuarioId, @RequestParam Long publicacaoId) {
        boolean sucesso = curtidaService.excluirCurtida(usuarioId, publicacaoId);
        return sucesso ? ResponseEntity.noContent().build() : ResponseEntity.notFound().build();
    }

    // Endpoint para alternar a curtida (inserir ou excluir dependendo da situação)
    @PostMapping("/alternar")
    public ResponseEntity<Curtida> alternarCurtida(@RequestParam Long usuarioId, @RequestParam Long publicacaoId) {
        Curtida curtida = curtidaService.alternarCurtida(usuarioId, publicacaoId);
        if (curtida != null) {
            return ResponseEntity.ok(curtida); // Retorna a nova curtida se foi criada
        } else {
            return ResponseEntity.noContent().build(); // Retorna 204 caso a curtida tenha sido excluída
        }
    }

    // Rota para contar o número de curtidas em uma publicação
    @GetMapping("/contar/{publicacaoId}")
    public ResponseEntity<Long> contarCurtidas(@PathVariable Long publicacaoId) {
        long totalCurtidas = curtidaService.contarCurtidasPorPublicacao(publicacaoId);
        return ResponseEntity.ok(totalCurtidas);
    }
}
