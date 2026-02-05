package com.example.academiadev.service;

import com.example.academiadev.dto.LoginRequestDTO;
import com.example.academiadev.dto.LoginResponseDTO;
import com.example.academiadev.model.Aluno;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

@Service
public class AuthService {
    private final AuthenticationManager manager;
    private final TokenService tokenService;

    public AuthService(AuthenticationManager manager, TokenService tokenService){
        this.manager = manager;
        this.tokenService = tokenService;
    }

    public LoginResponseDTO login(LoginRequestDTO loginRequestDTO){
        Authentication tokenAuthentication = new UsernamePasswordAuthenticationToken(
                loginRequestDTO.email(), loginRequestDTO.senha()
        );
        Authentication authentication = manager.authenticate(tokenAuthentication);
        SecurityContextHolder.getContext().setAuthentication(authentication);
        Aluno aluno = (Aluno) authentication.getPrincipal();

        return new LoginResponseDTO(aluno.getId(), aluno.getEmail(), tokenService.generateToken(aluno));
    }

}
