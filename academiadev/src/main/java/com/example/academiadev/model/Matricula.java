package com.example.academiadev.model;
import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.List;

@Entity

public class Matricula {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "matricula_id")
    private int id;
    @OneToOne
    @JoinColumn(name = "aluno_id")
    private Aluno aluno;

    @ManyToOne
    @JoinColumn(name = "curso_id")
    private Curso curso;
    private boolean statusMatricula;
    private LocalDate data;

    @OneToMany
    @JoinColumn(name = "financeiro_id")
    private List<Financeiro> financeiro;

    public Matricula() {

    }

    public Matricula(int id, Aluno aluno, Curso curso, boolean statusMatricula, LocalDate data) {
        this.id = id;
        this.aluno = aluno;
        this.curso = curso;
        this.statusMatricula = statusMatricula;
        this.data = data;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Aluno getAluno() {
        return aluno;
    }

    public void setAluno(Aluno aluno) {
        this.aluno = aluno;
    }

    public Curso getCurso() {
        return curso;
    }

    public void setCurso(Curso curso) {
        this.curso = curso;
    }

    public boolean isStatusMatricula() {
        return statusMatricula;
    }

    public void setStatusMatricula(boolean statusMatricula) {
        this.statusMatricula = statusMatricula;
    }

    public LocalDate getData() {
        return data;
    }

    public void setData(LocalDate data) {
        this.data = data;
    }

    public List<Financeiro> getFinanceiro() {
        return financeiro;
    }

    public void setFinanceiro(List<Financeiro> financeiro) {
        this.financeiro = financeiro;
    }
}
