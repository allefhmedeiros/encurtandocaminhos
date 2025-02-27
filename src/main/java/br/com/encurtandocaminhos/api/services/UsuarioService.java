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
        // Verifica se o e-mail já está em uso
        if (usuarioRepository.existsByEmail(usuario.getEmail())) {
            throw new EmailJaExisteException("Este e-mail já está em uso.");
        }
        // Salva o usuário no banco de dados
        return usuarioRepository.save(usuario);
    }

    public Usuario buscarUsuarioPorId(Long id) {
        // Busca o usuário pelo ID, caso não encontre lança uma exceção
        Optional<Usuario> usuario = usuarioRepository.findById(id);
        return usuario.orElseThrow(() -> new RuntimeException("Usuário não encontrado com ID: " + id));
    }

    public List<Usuario> getAllUsuarios() {
        // Retorna todos os usuários do banco de dados
        return usuarioRepository.findAll();
    }

    public void deleteUsuario(Long id) {
        // Deleta o usuário com o ID fornecido
        usuarioRepository.deleteById(id);
    }
}
