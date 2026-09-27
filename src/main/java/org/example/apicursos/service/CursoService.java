package org.example.apicursos.service;

import org.example.apicursos.model.Curso;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CursoService {

    private List<Curso> cursos = new ArrayList<>();

    private int proximoId = 1;

    public List<Curso> listarCursos(String tipoCurso, String modalidade, String periodo){
        List<Curso> resultado = new ArrayList<>();
        for(Curso curso : cursos){
            if ((tipoCurso == null || curso.getTipoCurso().equals(tipoCurso)) &&
                    (modalidade == null || curso.getModalidade().equals(modalidade)) &&
                    (periodo == null || curso.getPeriodo().equals(periodo))){
                resultado.add(curso);
            }
        }
        return resultado;
    }

    public Curso cadastrarCurso( Curso curso) {
        curso.setId(proximoId);
        proximoId++;
        cursos.add(curso);
        return curso;
    }

    public Curso buscarPorId(int id) {
        for (Curso curso : cursos) {
            if (curso.getId()==id){
                return curso;
            }
        }
        return null;
    }

    public Curso atualizarCurso(int id, Curso cursoAtualizado){
        for (Curso curso : cursos) {
            if (curso.getId() == id){
                curso.setNome(cursoAtualizado.getNome());
                curso.setDescricao(cursoAtualizado.getDescricao());
                curso.setCargaHoraria(cursoAtualizado.getCargaHoraria());
                curso.setTipoCurso(cursoAtualizado.getTipoCurso());
                curso.setModalidade(cursoAtualizado.getModalidade());
                curso.setDuracao(cursoAtualizado.getDuracao());
                curso.setPeriodo(cursoAtualizado.getPeriodo());
                return curso;
            }
        }
        return null;
    }

    public void excluirCurso(int id){
        for (Curso curso : cursos){
            if(curso.getId() == id){
                cursos.remove(curso);
                return;
            }
        }
    }
}


