package br.com.encurtandocaminhos.api.model;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Table(name = "tbl_eventos")
public class Evento {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false)
    private String titulo;
    @Column(nullable = false)
    private LocalDateTime dtInicio;
    @Column(nullable = false)
    private LocalDateTime dtFim;
    @Column(nullable = false)
    private String resumo;
    @Column(nullable = false)
    private Double valorEntrada;
    @ManyToOne
    @JoinColumn(name = "organizador_id", nullable = false)
    private Usuario organizador;
    @Column(nullable = false, updatable = false)
    private LocalDateTime dtCadastro;

    // Construtor que inicializa dtCadastro com a data atual
    public Evento() {
        this.dtCadastro = LocalDateTime.now(); // A data de cadastro é a data atual
    }

    public Evento(String titulo, LocalDateTime dtInicio, LocalDateTime dtFim, String resumo, Double valorEntrada, Usuario organizador) {
        this.titulo = titulo;
        this.dtInicio = dtInicio;
        this.dtFim = dtFim;
        this.resumo = resumo;
        setValorEntrada(valorEntrada); // Usando o setter para validar o valor de entrada
        this.organizador = organizador;
        this.dtCadastro = LocalDateTime.now(); // A data de cadastro é a data atual
    }

    // Validação para garantir que a data de início não seja posterior à data de fim
    private void validarDatas() {
        if (dtInicio != null && dtFim != null && dtInicio.isAfter(dtFim)) {
            throw new IllegalArgumentException("A data de início não pode ser posterior à data de fim.");
        }
    }

    // Setter para valorEntrada, garantindo que o valor não seja negativo
    public void setValorEntrada(Double valorEntrada) {
        if (valorEntrada < 0) {
            throw new IllegalArgumentException("O valor da entrada não pode ser negativo.");
        }
        this.valorEntrada = valorEntrada;
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

    public LocalDateTime getDtInicio() {
        return dtInicio;
    }

    public void setDtInicio(LocalDateTime dtInicio) {
        this.dtInicio = dtInicio;
        validarDatas(); // Valida a relação entre as datas
    }

    public LocalDateTime getDtFim() {
        return dtFim;
    }

    public void setDtFim(LocalDateTime dtFim) {
        this.dtFim = dtFim;
        validarDatas(); // Valida a relação entre as datas
    }

    public String getResumo() {
        return resumo;
    }

    public void setResumo(String resumo) {
        this.resumo = resumo;
    }

    public Double getValorEntrada() {
        return valorEntrada;
    }

    public Usuario getOrganizador() {
        return organizador;
    }

    public void setOrganizador(Usuario organizador) {
        this.organizador = organizador;
    }

    public LocalDateTime getDtCadastro() {
        return dtCadastro;
    }

    @Override
    public String toString() {
        return "Evento{" +
                "id=" + id +
                ", titulo='" + titulo + '\'' +
                ", dtInicio=" + dtInicio +
                ", dtFim=" + dtFim +
                ", resumo='" + resumo + '\'' +
                ", valorEntrada=" + valorEntrada +
                ", organizador=" + organizador +
                ", dtCadastro=" + dtCadastro +
                '}';
    }
}
