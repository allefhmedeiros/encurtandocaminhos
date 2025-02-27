package br.com.encurtandocaminhos.api.model;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "tbl_comentarios")
public class Comentario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String conteudo;

    @Column(nullable = false)
    private LocalDateTime dtCadastro;

    // Relacionamento Muitos para Um com Publicacao
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "publicacao_id", nullable = false)
    private Publicacao publicacao;

    // Relacionamento Muitos para Um com Usuario
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "comentado_por_id", nullable = false)
    private Usuario comentadoPor;

    // Construtor
    public Comentario(String conteudo, Publicacao publicacao, Usuario comentadoPor) {
        this.conteudo = conteudo;
        this.publicacao = publicacao;
        this.comentadoPor = comentadoPor;
    }

    // Construtor vazio
    public Comentario() {
    }

    // Método que será chamado antes de persistir a entidade
    @PrePersist
    public void prePersist() {
        if (dtCadastro == null) {
            this.dtCadastro = LocalDateTime.now();
        }
    }

    // Getters e setters
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

    public LocalDateTime getDtCadastro() {
        return dtCadastro;
    }

    public void setDtCadastro(LocalDateTime dtCadastro) {
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
