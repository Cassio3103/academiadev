package com.example.academiadev.repository;

import com.example.academiadev.model.Aluno;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;

public interface AlunoRepository extends JpaRepository<Aluno, Long>{
    boolean existsByEmail(String email);
    //Optional<Aluno> findById(int id);

    Optional<Aluno> findByEmail(String username);
}
