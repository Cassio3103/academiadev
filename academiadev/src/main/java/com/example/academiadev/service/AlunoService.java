package com.example.academiadev.service;

import com.example.academiadev.dto.AlunoRequestDTO;
import com.example.academiadev.dto.AlunoResponseDTO;
import com.example.academiadev.exception.AlunoDuplicadoException;
import com.example.academiadev.exception.AlunoNotFoundException;
import com.example.academiadev.model.Aluno;
import com.example.academiadev.repository.AlunoRepository;
import org.jspecify.annotations.Nullable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.net.PasswordAuthentication;
import java.time.LocalDate;

@Service
public class AlunoService implements UserDetailsService {

    @Autowired
    private AlunoRepository alunoRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    public AlunoResponseDTO cadastrarAluno(AlunoRequestDTO dto) {

        if (alunoRepository.existsByEmail(dto.getEmail())) {
            throw new AlunoDuplicadoException("Aluno já cadastrado!");
        }
        if (dto.getDataIngresso().isAfter(LocalDate.now())) {
            throw new IllegalArgumentException("Aluno com data inválida!");
        }

        Aluno aluno = new Aluno();
        aluno.setNome(dto.getNome());
        aluno.setEmail(dto.getEmail());
        aluno.setSenha(passwordEncoder.encode(dto.getSenha()));
        aluno.setDataDeIngresso(dto.getDataIngresso());

        aluno = alunoRepository.save(aluno);

        return new AlunoResponseDTO(aluno.getId(), aluno.getNome(), aluno.getEmail(), aluno.getDataDeIngresso());
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Aluno aluno = alunoRepository.findByEmail(username)
                .orElseThrow(() -> new UsernameNotFoundException("Usuário não encontrado"));

        return aluno;
    }

//    public AlunoResponseDTO atualizarAluno(int id, AlunoRequestDTO alunoRequestDTO) {
//
//    }
}
