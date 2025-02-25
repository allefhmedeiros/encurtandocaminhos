package br.com.encurtandocaminhos.api.model;

import java.time.LocalDate;

public class Servico {
    private Long id;
    private String titulo;
    private String resumo;
    private Double valor;
    private String contato;
    private String email;
    private LocalDate dtCadastro;
    private Usuario prestador;

    // Expressão regular para validação de email
    private static final String EMAIL_REGEX = "^[A-Za-z0-9+_.-]+@(.+)$";

    // Construtor que inicializa todos os campos, exceto o id
    public Servico(String titulo, String resumo, Double valor, String contato, String email, Usuario prestador) {
        this.titulo = titulo;
        this.resumo = resumo;
        this.valor = valor;
        this.contato = contato;
        this.setEmail(email); // Usando o setter que valida o email
        this.prestador = prestador;
        this.dtCadastro = LocalDate.now(); // A data de cadastro é a data atual
    }

    // Método para validar o formato do email
    private boolean validarEmail(String email) {
        return email != null && email.matches(EMAIL_REGEX);
    }

    // Setter para email com validação
    public void setEmail(String email) {
        if (validarEmail(email)) {
            this.email = email;
        } else {
            throw new IllegalArgumentException("Email inválido. O formato correto é 'exemplo@dominio.com'.");
        }
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getResumo() {
        return resumo;
    }

    public void setResumo(String resumo) {
        this.resumo = resumo;
    }

    public Double getValor() {
        return valor;
    }

    public void setValor(Double valor) {
        this.valor = valor;
    }

    public String getContato() {
        return contato;
    }

    public void setContato(String contato) {
        this.contato = contato;
    }

    public LocalDate getDtCadastro() {
        return dtCadastro;
    }

    public void setDtCadastro(LocalDate dtCadastro) {
        this.dtCadastro = dtCadastro;
    }

    public Usuario getPrestador() {
        return prestador;
    }

    public void setPrestador(Usuario prestador) {
        this.prestador = prestador;
    }

    @Override
    public String toString() {
        return "Servico{" +
                "id=" + id +
                ", titulo='" + titulo + '\'' +
                ", resumo='" + resumo + '\'' +
                ", valor=" + valor +
                ", contato='" + contato + '\'' +
                ", email='" + email + '\'' +
                ", dtCadastro=" + dtCadastro +
                ", prestador=" + prestador +
                '}';
    }
}
