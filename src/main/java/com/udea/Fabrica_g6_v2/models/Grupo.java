package com.udea.Fabrica_g6_v2.models;



import javax.persistence.*;

@Entity
@Table(name="grupo")

public class Grupo {
    @Column(name = "id_grupo", nullable=false )
    @Id
    private String id_grupo;


    @ManyToOne
    @JoinColumn(name="codigo_curso", referencedColumnName = "codigo_curso",insertable = false, updatable = false)
    private Curso codigo_curso;
    private Integer numero;
    private Integer cupos;
    @ManyToOne
    @JoinColumn(name="docente", referencedColumnName = "id_docente",insertable = false, updatable = false)
    private Docente docente;


    public Grupo() {
    }

    public Grupo( Curso codigo_curso, Integer numero, Integer cupos, Docente docente) {
        this.id_grupo = (codigo_curso.getCodigoCurso()+"-"+numero);
        this.codigo_curso = codigo_curso;
        this.numero = numero;
        this.cupos = cupos;
        this.docente = docente;
    }

    public String getId_grupo() {
        return (codigo_curso.getCodigoCurso()+"-"+numero);
    }

    public void setId_grupo() {
        this.id_grupo = (codigo_curso.getCodigoCurso()+"-"+numero);
    }

    public Curso getCodigo_curso() {
        return codigo_curso;
    }

    public void setCodigo_curso(Curso codigo_curso) {
        this.codigo_curso = codigo_curso;
        setId_grupo();
    }

    public Integer getNumero() {
        return numero;
    }

    public void setNumero(Integer numero) {
        this.numero = numero;
        setId_grupo();
    }

    public Integer getCupos() {
        return cupos;
    }

    public void setCupos(Integer cupos) {
        this.cupos = cupos;
    }

    public Docente getDocente() {
        return docente;
    }

    public void setDocente(Docente docente) {
        this.docente = docente;
    }
}
