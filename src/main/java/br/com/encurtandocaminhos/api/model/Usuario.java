package br.com.encurtandocaminhos.api.model;

import jakarta.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Table(name = "tbl_usuarios")
public class Usuario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String nomeCompleto;

    @Column(nullable = false)
    private String nomeSocial;

    @Column(nullable = false)
    private LocalDate dtNascimento;

    @Column(nullable = false)
    private String documento;

    @Column(nullable = false)
    private String profissao;

    @Column(unique = true, nullable = false)
    private String email;

    @Column(nullable = false)
    private String senha;

    @Column(nullable = false, updatable = false)
    private LocalDateTime dtCadastro;

    public Usuario() {
    }

    // Construtor que exige o preenchimento de todos os campos, exceto o id
    public Usuario(String nomeCompleto, String nomeSocial, LocalDate dtNascimento, String documento,
                   String profissao, String email, String senha) {
        this.nomeCompleto = nomeCompleto;
        this.nomeSocial = nomeSocial;
        this.dtNascimento = dtNascimento;
        this.documento = documento;
        this.profissao = profissao;
        this.email = email;
        this.senha = senha;

    }

    @PrePersist
    public void prePersist() {
        // A data de cadastro é preenchida apenas uma vez, antes da persistência
        this.dtCadastro = LocalDateTime.now();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNomeCompleto() {
        return nomeCompleto;
    }

    public void setNomeCompleto(String nomeCompleto) {
        this.nomeCompleto = nomeCompleto;
    }

    public String getNomeSocial() {
        return nomeSocial;
    }

    public void setNomeSocial(String nomeSocial) {
        this.nomeSocial = nomeSocial;
    }

    public LocalDate getDtNascimento() {
        return dtNascimento;
    }

    public void setDtNascimento(LocalDate dtNascimento) {
        this.dtNascimento = dtNascimento;
    }

    public String getDocumento() {
        return documento;
    }

    public void setDocumento(String documento) {
        this.documento = documento;
    }

    public String getProfissao() {
        return profissao;
    }

    public void setProfissao(String profissao) {
        this.profissao = profissao;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public LocalDateTime getDtCadastro() {
        return dtCadastro;
    }

    @Override
    public String toString() {
        return "Usuario{" +
                "id=" + id +
                ", nomeCompleto='" + nomeCompleto + '\'' +
                ", nomeSocial='" + nomeSocial + '\'' +
                ", dtNascimento=" + dtNascimento +
                ", documento='" + documento + '\'' +
                ", profissao='" + profissao + '\'' +
                ", email='" + email + '\'' +
                ", senha='" + senha + '\'' +
                ", dtCadastro=" + dtCadastro +
                '}';
    }
}
