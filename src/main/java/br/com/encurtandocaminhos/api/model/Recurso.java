package br.com.encurtandocaminhos.api.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
@Entity
@Table(name = "tbl_recursos")
public class Recurso {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String link;

    @ManyToOne
    @JoinColumn(name = "publicacao_id", nullable = false)
    @JsonBackReference  // Adicionando aqui
    private Publicacao publicacao;

    // Construtores
    public Recurso() {}

    public Recurso(String link, Publicacao publicacao) {
        this.link = link;
        this.publicacao = publicacao;
    }

    // Getters e Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public Publicacao getPublicacao() {
        return publicacao;
    }

    public void setPublicacao(Publicacao publicacao) {
        this.publicacao = publicacao;
    }

    @Override
    public String toString() {
        return "Recurso{" +
                "id=" + id +
                ", link='" + link + '\'' +
                ", publicacao=" + (publicacao != null ? publicacao.getId() : "null") +
                '}';
    }
}