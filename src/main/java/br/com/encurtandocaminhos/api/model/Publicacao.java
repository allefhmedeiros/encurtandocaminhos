package br.com.encurtandocaminhos.api.model;

import jakarta.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "tbl_publicacoes")
public class Publicacao {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, updatable = false)
    private LocalDateTime dtPublicada;

    @ManyToOne
    @JoinColumn(name = "criador_id", nullable = false)
    private Usuario criador;

    @Column(nullable = false)
    private String conteudo;

    @OneToMany(mappedBy = "publicacao", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Recurso> recursos = new ArrayList<>();

    // Construtores
    public Publicacao() {
        this.dtPublicada = LocalDateTime.now();
    }

    public Publicacao(Usuario criador, String conteudo) {
        this.dtPublicada = LocalDateTime.now();
        this.criador = criador;
        this.conteudo = conteudo;
    }

    // Getters e Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDateTime getDtPublicada() {
        return dtPublicada;
    }

    public void setDtPublicada(LocalDateTime dtPublicada) {
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

    public List<Recurso> getRecursos() {
        return recursos;
    }

    public void setRecursos(List<Recurso> recursos) {
        this.recursos.clear();
        if (recursos != null) {
            for (Recurso recurso : recursos) {
                recurso.setPublicacao(this);
            }
            this.recursos.addAll(recursos);
        }
    }

    @Override
    public String toString() {
        return "Publicacao{" +
                "id=" + id +
                ", dtPublicada=" + dtPublicada +
                ", criador=" + criador +
                ", conteudo='" + conteudo + '\'' +
                ", recursos=" + recursos +
                '}';
    }
}
