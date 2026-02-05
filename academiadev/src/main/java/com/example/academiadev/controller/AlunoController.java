package com.example.academiadev.controller;

import com.example.academiadev.dto.AlunoRequestDTO;
import com.example.academiadev.dto.AlunoResponseDTO;
import com.example.academiadev.service.AlunoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/aluno")
public class AlunoController {
    @Autowired
    AlunoService alunoService;

    @PostMapping("/criar")
    public ResponseEntity<AlunoResponseDTO> registrarAluno(@RequestBody AlunoRequestDTO alunoRequestDTO){
        return ResponseEntity.ok().body(alunoService.cadastrarAluno(alunoRequestDTO));
    }

//    @PutMapping("/editar/{id}")
//    public ResponseEntity<AlunoResponseDTO> editarAluno(@PathVariable int id, @RequestBody AlunoRequestDTO alunoRequestDTO){
//        return ResponseEntity.ok().body(alunoService.atualizarAluno(id, alunoRequestDTO));
//    }

    
}
