package br.com.encurtandocaminhos.api.services;

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

    public Usuario salvarUsuario(Usuario usuario) {
        if (usuarioRepository.existsByEmail(usuario.getEmail())) {
            // Lidar com a situação do email já existente
            throw new EmailJaExisteException("Este e-mail já está em uso.");
        }

        // Continuação do processo de criação do usuário
        usuarioRepository.save(usuario);
        return usuario;
    }

    // Método para buscar um usuário por ID
    public Usuario buscarUsuarioPorId(Long id) {
        Optional<Usuario> usuario = usuarioRepository.findById(id);
        return usuario.orElseThrow(() -> new RuntimeException("Usuário não encontrado com ID: " + id));
    }

    public List<Usuario> getAllUsuarios() {
        return usuarioRepository.findAll();
    }

    public void deleteUsuario(Long id) {
        usuarioRepository.deleteById(id);
    }
}
