package br.com.encurtandocaminhos.api.dto;

import br.com.encurtandocaminhos.api.model.Usuario;

import java.time.LocalDate;
import java.time.LocalDateTime;

public record UsuarioCadastroDTO(String nomeCompleto, String nomeSocial, LocalDate dtNascimento, String documento, String profissao, String email, String senha, LocalDateTime dtCadastro) {
    public static UsuarioCadastroDTO fromEntity(Usuario usuario) {
        return new UsuarioCadastroDTO(
                usuario.getNomeCompleto(),
                usuario.getNomeSocial(),
                usuario.getDtNascimento(),
                usuario.getDocumento(),
                usuario.getProfissao(),
                usuario.getEmail(),
                usuario.getSenha(),
                usuario.getDtCadastro()
        );
    }
}
