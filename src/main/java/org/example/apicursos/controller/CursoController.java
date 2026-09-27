package org.example.apicursos.controller;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import org.example.apicursos.model.Curso;

import org.springframework.http.ResponseEntity;

@RestController
@RequestMapping("/cursos")
public class CursoController {

    private List<Curso> cursos = new ArrayList<>();
    private int proximoId = 1;

    @PostMapping()
    public ResponseEntity<Curso> cadastrarCurso(@RequestBody Curso curso) {
        curso.setId(proximoId);
        proximoId++;
        cursos.add(curso);
        return ResponseEntity.ok(curso);
    }

    @GetMapping()
    public ResponseEntity<List<Curso>> listarCursos(
            @RequestParam(required = false) String tipoCurso,
            @RequestParam(required = false) String modalidade,
            @RequestParam(required = false) String periodo) {

        List<Curso> resultado = new ArrayList<>();

        for (Curso curso : cursos) {

            if (
                    (tipoCurso == null || curso.getTipoCurso().equals(tipoCurso)) &&
                            (modalidade == null || curso.getModalidade().equals(modalidade)) &&
                            (periodo == null || curso.getPeriodo().equals(periodo))
            ) {
                resultado.add(curso);
            }
        }

        return ResponseEntity.ok(resultado);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Curso> buscarPorId(@PathVariable int id) {
        for (Curso curso : cursos) {
            if (curso.getId()==id){
                return ResponseEntity.ok(curso);
            }
        }
        return ResponseEntity.notFound().build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<Curso> atualizarCurso(@PathVariable int id, @RequestBody Curso cursoAtualizado){
        for (Curso curso : cursos) {
            if (curso.getId() == id){
                curso.setNome(cursoAtualizado.getNome());
                curso.setDescricao(cursoAtualizado.getDescricao());
                curso.setCargaHoraria(cursoAtualizado.getCargaHoraria());
                curso.setTipoCurso(cursoAtualizado.getTipoCurso());
                curso.setModalidade(cursoAtualizado.getModalidade());
                curso.setDuracao(cursoAtualizado.getDuracao());
                curso.setPeriodo(cursoAtualizado.getPeriodo());
                return ResponseEntity.ok(curso);
            }
        }
        return ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> excluirCurso(@PathVariable int id){
        for (Curso curso : cursos){
            if(curso.getId() == id){
                cursos.remove(curso);
                return ResponseEntity.noContent().build();
            }
        }
        return ResponseEntity.notFound().build();
    }
}