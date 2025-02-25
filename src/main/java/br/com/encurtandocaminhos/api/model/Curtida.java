package br.com.encurtandocaminhos.api.model;

public class Curtida {
    private Long id;
    private Usuario usuario;
    private Publicacao publicacao;
    private boolean curtida = false;

    public Curtida(Usuario usuario, Publicacao publicacao) {
        this.usuario = usuario;
        this.publicacao = publicacao;
    }

    public void alternarCurtida(){
        setCurtida(!getCurtida());
    }

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

    public boolean getCurtida() {
        return curtida;
    }

    public void setCurtida(boolean curtida) {
        this.curtida = curtida;
    }

    @Override
    public String toString() {
        return "Curtida{" +
                "id=" + id +
                ", usuario=" + usuario +
                ", publicacao=" + publicacao +
                ", curtida=" + curtida +
                '}';
    }
}
