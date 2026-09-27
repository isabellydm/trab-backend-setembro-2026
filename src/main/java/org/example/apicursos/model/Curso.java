package org.example.apicursos.model;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Curso {
    private int id;
    private String nome;
    private String descricao;
    private int cargaHoraria;
    private String tipoCurso;
    private String modalidade;
    private String duracao;
    private String periodo;
}