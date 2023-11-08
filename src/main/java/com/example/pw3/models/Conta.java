package com.example.pw3.models;

import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class Conta extends AbstractEntity {
    public static final boolean TIPO_DESPESA = true;
    public static final boolean TIPO_RECEITA = false;
    public static final boolean STATUS_OK = true;
    public static final boolean STATUS_PENDENTE = false;

    @ManyToOne
    private Categoria categoria;
    private boolean tipo;
    private LocalDate data;
    private String descricao;
    private double valor;
    private String destinoOrigem;
    private boolean status;


    public Categoria getCategoria() {
        return this.categoria;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }

    public boolean isTipo() {
        return this.tipo;
    }

    public boolean getTipo() {
        return this.tipo;
    }

    public void setTipo(boolean tipo) {
        this.tipo = tipo;
    }

    public LocalDate getData() {
        return this.data;
    }

    public void setData(LocalDate data) {
        this.data = data;
    }

    public String getDescricao() {
        return this.descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public double getValor() {
        return this.valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public String getDestinoOrigem() {
        return this.destinoOrigem;
    }

    public void setDestinoOrigem(String destinoOrigem) {
        this.destinoOrigem = destinoOrigem;
    }

    public boolean isStatus() {
        return this.status;
    }

    public boolean getStatus() {
        return this.status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }
    
}
