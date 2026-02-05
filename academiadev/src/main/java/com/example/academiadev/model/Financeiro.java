package com.example.academiadev.model;

import jakarta.persistence.*;

import java.util.List;

@Entity
public class Financeiro {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "financeiro_id")
    private int id;

    @OneToMany
    @JoinColumn(name = "matricula_id")
    private List<Matricula> matricula;
    private double valorPago;
    private double valorDevido;

    public Financeiro() {

    }

    public Financeiro(int id, List<Matricula> matricula, double valorPago, double valorDevido) {
        this.id = id;
        this.matricula = matricula;
        this.valorPago = valorPago;
        this.valorDevido = valorDevido;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public List<Matricula> getMatricula() {
        return matricula;
    }

    public void setMatricula(List<Matricula> matricula) {
        this.matricula = matricula;
    }

    public double getValorPago() {
        return valorPago;
    }

    public void setValorPago(double valorPago) {
        this.valorPago = valorPago;
    }

    public double getValorDevido() {
        return valorDevido;
    }

    public void setValorDevido(double valorDevido) {
        this.valorDevido = valorDevido;
    }
}
