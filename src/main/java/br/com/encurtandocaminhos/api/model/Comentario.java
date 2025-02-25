package br.com.encurtandocaminhos.api.model;

import java.time.LocalDate;

public class Comentario {
    private Long id;
    private String conteudo;
    private LocalDate dtCadastro;
    private Publicacao publicacao;
    private Usuario comentadoPor;

    public Comentario(String conteudo, Publicacao publicacao, Usuario comentadoPor) {
        this.conteudo = conteudo;
        this.dtCadastro = LocalDate.now();
        this.publicacao = publicacao;
        this.comentadoPor = comentadoPor;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getConteudo() {
        return conteudo;
    }

    public void setConteudo(String conteudo) {
        this.conteudo = conteudo;
    }

    public LocalDate getDtCadastro() {
        return dtCadastro;
    }

    public void setDtCadastro(LocalDate dtCadastro) {
        this.dtCadastro = dtCadastro;
    }

    public Publicacao getPublicacao() {
        return publicacao;
    }

    public void setPublicacao(Publicacao publicacao) {
        this.publicacao = publicacao;
    }

    public Usuario getComentadoPor() {
        return comentadoPor;
    }

    public void setComentadoPor(Usuario comentadoPor) {
        this.comentadoPor = comentadoPor;
    }

    @Override
    public String toString() {
        return "Comentario{" +
                "id=" + id +
                ", conteudo='" + conteudo + '\'' +
                ", dtCadastro=" + dtCadastro +
                ", publicacao=" + publicacao +
                ", comentadoPor=" + comentadoPor +
                '}';
    }
}
