package org.example.apicursos.controller;
import org.example.apicursos.service.CursoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import org.example.apicursos.model.Curso;

import org.springframework.http.ResponseEntity;

@RestController
@RequestMapping("/cursos")
public class CursoController {

    @Autowired
    private CursoService service;

    @PostMapping()
    public ResponseEntity<Curso> cadastrarCurso(@RequestBody Curso curso) {
        Curso cursoCadastrado = service.cadastrarCurso(curso);
        return ResponseEntity.ok(cursoCadastrado);
    }

    @GetMapping()
    public ResponseEntity<List<Curso>> listarCursos(
            @RequestParam(required = false) String tipoCurso,
            @RequestParam(required = false) String modalidade,
            @RequestParam(required = false)String periodo){
        List<Curso> cursos = service.listarCursos(tipoCurso, modalidade, periodo);
        return ResponseEntity.ok(cursos);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Curso> buscarPorId(@PathVariable int id) {
        Curso curso = service.buscarPorId(id);
        return ResponseEntity.ok(curso);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Curso> atualizarCurso(@PathVariable int id, @RequestBody Curso cursoAtualizado){
        Curso curso = service.atualizarCurso(id, cursoAtualizado);
        return ResponseEntity.ok(curso);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> excluirCurso(@PathVariable int id){
        service.excluirCurso(id);
        return ResponseEntity.noContent().build();
    }
}