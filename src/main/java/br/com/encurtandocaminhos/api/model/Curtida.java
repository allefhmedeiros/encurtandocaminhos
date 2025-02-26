package br.com.encurtandocaminhos.api.model;

import jakarta.persistence.*;

@Entity
@Table(name = "tbl_curtidas")
public class Curtida {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // Relacionamento muitos para um com Usuario e Publicacao
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "usuario_id", nullable = false)  // Definindo a chave estrangeira para Usuario
    private Usuario usuario;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "publicacao_id", nullable = false)  // Definindo a chave estrangeira para Publicacao
    private Publicacao publicacao;

    // Construtor
    public Curtida(Usuario usuario, Publicacao publicacao) {
        this.usuario = usuario;
        this.publicacao = publicacao;
    }

    public Curtida() {
    }

    // Getters e setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public Publicacao getPublicacao() {
        return publicacao;
    }

    public void setPublicacao(Publicacao publicacao) {
        this.publicacao = publicacao;
    }


    @Override
    public String toString() {
        return "Curtida{" +
                "id=" + id +
                ", usuario=" + usuario +
                ", publicacao=" + publicacao +
                '}';
    }
}
