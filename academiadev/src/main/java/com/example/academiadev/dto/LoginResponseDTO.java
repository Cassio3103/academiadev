package com.example.academiadev.dto;

public class LoginResponseDTO {
    private int id;
    private String email;
    private String token;

    public LoginResponseDTO(int id, String email, String token){
        this.id = id;
        this.email = email;
        this.token = token;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }


}
