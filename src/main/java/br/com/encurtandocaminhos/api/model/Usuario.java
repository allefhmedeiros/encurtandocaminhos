package br.com.encurtandocaminhos.api.model;

import java.util.Date;

public class Usuario {
    private Long id;
    private String nomeCompleto;
    private String nomeSocial;
    private Date dtNascimento;
    private String documento;
    private String profissao;
    private String email;
    private String senha;
    private Date dtCadastro;

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

    public Date getDtNascimento() {
        return dtNascimento;
    }

    public void setDtNascimento(Date dtNascimento) {
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

    public Date getDtCadastro() {
        return dtCadastro;
    }

    public void setDtCadastro(Date dtCadastro) {
        this.dtCadastro = dtCadastro;
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
