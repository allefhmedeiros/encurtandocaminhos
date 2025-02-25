package br.com.encurtandocaminhos.api.model;

import java.time.LocalDate;

public class Usuario {
    private Long id;
    private String nomeCompleto;
    private String nomeSocial;
    private LocalDate dtNascimento;
    private String documento;
    private String profissao;
    private String email;
    private String senha;
    private LocalDate dtCadastro;

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
        this.dtCadastro = LocalDate.now(); // A data de cadastro é a data atual
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

    public LocalDate getDtCadastro() {
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
