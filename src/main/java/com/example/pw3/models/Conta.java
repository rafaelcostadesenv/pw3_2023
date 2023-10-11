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
    static final boolean TIPO_DESPESA = true;
    static final boolean TIPO_RECEITA = false;
    static final boolean STATUS_OK = true;
    static final boolean STATUS_PENDENTE = false;

    @ManyToOne
    private Categoria categoria;

    private boolean tipo;
    private LocalDate data;
    private String descricao;
    private double valor;
    private String destinoOrigem;
    private boolean status;
}
