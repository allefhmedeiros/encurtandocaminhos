package br.com.encurtandocaminhos.api.model;

import java.time.LocalDate;

public class Publicacao {
    private Long id;
    private LocalDate dtPublicada;
    private Usuario criador;
    private String conteudo;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDate getDtPublicada() {
        return dtPublicada;
    }

    public void setDtPublicada(LocalDate dtPublicada) {
        this.dtPublicada = dtPublicada;
    }

    public Usuario getCriador() {
        return criador;
    }

    public void setCriador(Usuario criador) {
        this.criador = criador;
    }

    public String getConteudo() {
        return conteudo;
    }

    public void setConteudo(String conteudo) {
        this.conteudo = conteudo;
    }

    @Override
    public String toString() {
        return "Publicacao{" +
                "id=" + id +
                ", dtPublicada=" + dtPublicada +
                ", criador=" + criador +
                ", conteudo='" + conteudo + '\'' +
                '}';
    }
}
