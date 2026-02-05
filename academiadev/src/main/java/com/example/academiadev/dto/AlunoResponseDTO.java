package com.example.academiadev.dto;

import java.time.LocalDate;

public class AlunoResponseDTO {
    private int id;
    private String nome;
    private String email;
    private LocalDate dataIngresso;


    public AlunoResponseDTO(int id, String nome, String email, LocalDate dataIngresso) {
        this.id = id;
        this.nome = nome;
        this.email = email;
        this.dataIngresso = dataIngresso;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public LocalDate getDataIngresso() {
        return dataIngresso;
    }

    public void setDataIngresso(LocalDate dataIngresso) {
        this.dataIngresso = dataIngresso;
    }


}
