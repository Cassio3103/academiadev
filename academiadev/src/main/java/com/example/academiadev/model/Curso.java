package com.example.academiadev.model;

import jakarta.persistence.*;

import java.util.List;

@Entity
public class Curso {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "curso_id")
    private int id;

    @OneToMany
    @JoinColumn(name = "matricula_id")
    private List<Matricula> matricula;
    private int cargaHoraria;
    private double valorInscricao;
    private boolean statusCurso;

    public Curso() {

    }

    public Curso(int id, int cargaHoraria, double valorInscricao, boolean statusCurso) {
        this.id = id;
        this.cargaHoraria = cargaHoraria;
        this.valorInscricao = valorInscricao;
        this.statusCurso = statusCurso;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getCargaHoraria() {
        return cargaHoraria;
    }

    public void setCargaHoraria(int cargaHoraria) {
        this.cargaHoraria = cargaHoraria;
    }

    public double getValorInscricao() {
        return valorInscricao;
    }

    public void setValorInscricao(double valorInscricao) {
        this.valorInscricao = valorInscricao;
    }

    public boolean isStatusCurso() {
        return statusCurso;
    }

    public void setStatusCurso(boolean statusCurso) {
        this.statusCurso = statusCurso;
    }
}
