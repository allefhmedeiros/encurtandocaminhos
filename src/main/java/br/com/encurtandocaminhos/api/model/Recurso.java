package br.com.encurtandocaminhos.api.model;

public class Recurso {
    private Long id;
    private String link;

    private Publicacao publicacao;

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
                ", publicacao=" + publicacao +
                '}';
    }
}
