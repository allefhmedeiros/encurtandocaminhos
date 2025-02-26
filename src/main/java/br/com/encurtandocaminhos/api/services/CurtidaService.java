package br.com.encurtandocaminhos.api.services;

import br.com.encurtandocaminhos.api.model.Curtida;
import br.com.encurtandocaminhos.api.model.Publicacao;
import br.com.encurtandocaminhos.api.model.Usuario;
import br.com.encurtandocaminhos.api.repository.CurtidaRepository;
import br.com.encurtandocaminhos.api.repository.PublicacaoRepository;
import br.com.encurtandocaminhos.api.repository.UsuarioRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CurtidaService {

    @Autowired
    private CurtidaRepository curtidaRepository;

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private PublicacaoRepository publicacaoRepository;

    // Método para buscar uma curtida por usuário e publicação
    public Optional<Curtida> buscarPorUsuarioEPublicacao(Long usuarioId, Long publicacaoId) {
        return curtidaRepository.findByUsuarioIdAndPublicacaoId(usuarioId, publicacaoId);
    }

    // Método para excluir uma curtida de um usuário em uma publicação
    @Transactional
    public boolean excluirCurtida(Long usuarioId, Long publicacaoId) {
        Optional<Curtida> curtida = curtidaRepository.findByUsuarioIdAndPublicacaoId(usuarioId, publicacaoId);
        if (curtida.isPresent()) {
            curtidaRepository.delete(curtida.get());
            return true;
        }
        return false;
    }

    // Método para alternar a curtida (se não existir, insere; se existir, exclui)
    @Transactional
    public Curtida alternarCurtida(Long usuarioId, Long publicacaoId) {
        Optional<Usuario> usuario = usuarioRepository.findById(usuarioId);
        Optional<Publicacao> publicacao = publicacaoRepository.findById(publicacaoId);

        if (usuario.isEmpty() || publicacao.isEmpty()) {
            throw new RuntimeException("Usuário ou publicação não encontrados");
        }

        // Verificar se já existe uma curtida
        Optional<Curtida> curtidaExistente = curtidaRepository.findByUsuarioIdAndPublicacaoId(usuarioId, publicacaoId);

        if (curtidaExistente.isPresent()) {
            // Se existir, exclui a curtida
            curtidaRepository.delete(curtidaExistente.get());
            return null; // Retorna null, pois a curtida foi excluída
        } else {
            // Se não existir, cria uma nova curtida
            Curtida novaCurtida = new Curtida(usuario.get(), publicacao.get());
            return curtidaRepository.save(novaCurtida);
        }
    }

    public long contarCurtidasPorPublicacao(Long publicacaoId) {
        return curtidaRepository.countByPublicacaoId(publicacaoId);
    }

}
