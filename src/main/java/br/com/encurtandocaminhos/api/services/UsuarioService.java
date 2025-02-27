package br.com.encurtandocaminhos.api.services;

import br.com.encurtandocaminhos.api.dto.UsuarioDTO;
import br.com.encurtandocaminhos.api.exception.EmailJaExisteException;
import br.com.encurtandocaminhos.api.model.Usuario;
import br.com.encurtandocaminhos.api.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UsuarioService {
    @Autowired
    private UsuarioRepository usuarioRepository;

    public UsuarioDTO salvarUsuario(Usuario usuario) {
        if (usuarioRepository.existsByEmail(usuario.getEmail())) {
            throw new EmailJaExisteException("Este e-mail já está em uso.");
        }
        Usuario usuarioSalvo = usuarioRepository.save(usuario);
        return UsuarioDTO.fromEntity(usuarioSalvo);
    }

    public UsuarioDTO buscarUsuarioPorId(Long id) {
        Optional<Usuario> usuario = usuarioRepository.findById(id);
        return usuario.map(UsuarioDTO::fromEntity)
                .orElseThrow(() -> new RuntimeException("Usuário não encontrado com ID: " + id));
    }

    public List<UsuarioDTO> getAllUsuarios() {
        return usuarioRepository.findAll().stream()
                .map(UsuarioDTO::fromEntity)
                .toList();
    }

    public void deleteUsuario(Long id) {
        usuarioRepository.deleteById(id);
    }
}
