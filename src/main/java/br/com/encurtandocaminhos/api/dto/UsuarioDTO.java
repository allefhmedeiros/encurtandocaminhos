package br.com.encurtandocaminhos.api.dto;

import br.com.encurtandocaminhos.api.model.Usuario;

import java.time.LocalDate;
import java.time.LocalDateTime;

public record UsuarioDTO(Long id, String nomeCompleto, String nomeSocial, String profissao, LocalDateTime dtCadastro, LocalDate dtNascimento) {
    public static UsuarioDTO fromEntity(Usuario usuario) {
        return new UsuarioDTO(usuario.getId(), usuario.getNomeCompleto().toUpperCase(), usuario.getNomeSocial().toUpperCase(), usuario.getProfissao().toUpperCase(), usuario.getDtCadastro(), usuario.getDtNascimento());
    }
}
