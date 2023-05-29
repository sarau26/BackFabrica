package com.udea.Fabrica_g6_v2.services;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.udea.Fabrica_g6_v2.dto.CursoDto;
import com.udea.Fabrica_g6_v2.dto.MateriaProgramaVersionDto;
import com.udea.Fabrica_g6_v2.models.Curso;
import com.udea.Fabrica_g6_v2.models.Materia;
import com.udea.Fabrica_g6_v2.repositories.CursoRepository;
import com.udea.Fabrica_g6_v2.repositories.MateriaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CursoService {
    @Autowired
    CursoRepository cursoRepository;

    @Autowired
    MateriaRepository materiaRepository;

    public List<Curso> findAll(){
        return cursoRepository.findAll();
    }

    public ResponseEntity<Curso> save(CursoDto cursoDto){

        //Validar que no existe
        MateriaProgramaVersionDto dto =
                new MateriaProgramaVersionDto(cursoDto.getMateria().getIdMateria(),
                        cursoDto.getProgramaAcademico(), cursoDto.getVersionPensum());
        if(getId(dto).hasBody())
            return ResponseEntity.status(409).build();

        Curso newCurso = newCursoFromDto(cursoDto);

        //Guardar
        try {
            Curso result= cursoRepository.save(newCurso);
            return ResponseEntity.ok(result);
        }catch (DataIntegrityViolationException e){
            return ResponseEntity.unprocessableEntity().build();
        }
    }

    public ResponseEntity<Curso> findById(Integer id){
        //usamos siempre un optional para no tratar con excepciones de alcance por id, debido a un id incorrecto
        Optional<Curso> optionalCurso = cursoRepository.findById(id);
        if(optionalCurso.isPresent())
            //si existe lo devuelvo
            return  ResponseEntity.ok(optionalCurso.get());
        else
            //si no existe debolvemos un 404 con un response entity
            return ResponseEntity.notFound().build();
    }

    //borrar un elemento de la DB
    public ResponseEntity<Curso> delete(MateriaProgramaVersionDto dto){
        //si el Id NO existe (NUMEO MUY GRANDE)
        ResponseEntity<Integer> id =  getId(dto);
        if (!id.hasBody()) {
            return ResponseEntity.notFound().build();
        }
        cursoRepository.deleteById(id.getBody());
        return ResponseEntity.accepted().build();
    }

    //actualizar un elemento existente
    public ResponseEntity<Curso> update(CursoDto inDto){
        //Encontrar id
        MateriaProgramaVersionDto dto =
                new MateriaProgramaVersionDto(inDto.getMateria().getIdMateria(),
                        inDto.getProgramaAcademico(), inDto.getVersionPensum());
        ResponseEntity<Integer> id = getId(dto);
        if(!id.hasBody())
            return ResponseEntity.notFound().build();

        //Dto a curso
        Curso newCurso = newCursoFromDto(inDto);
        newCurso.setCodigoCurso(id.getBody());

        //Guardar
        try {
            Curso result= cursoRepository.save(newCurso);
            return ResponseEntity.ok(result);
        }catch (DataIntegrityViolationException e){
            return ResponseEntity.unprocessableEntity().build();
        }
    }

    public ResponseEntity<Integer> getId(MateriaProgramaVersionDto dto){
        if(dto.hasNull()) return ResponseEntity.badRequest().build();
        Materia materia = materiaRepository.getById(dto.getIdMateria());
        Optional<Curso> curso = cursoRepository.findByMateriaAndProgramaAcademicoAndVersionPensum
                (materia, dto.getProgramaAcademico(), dto.getVersionPensum());
        if(!curso.isPresent()) return ResponseEntity.notFound().build();
        return ResponseEntity.ok(curso.get().getCodigoCurso());
    }

    private Curso newCursoFromDto(CursoDto dto){
        Curso newCurso = new Curso();

        Materia materia = materiaRepository.getById(dto.getMateria().getIdMateria());
        newCurso.setMateria(materia);
        newCurso.fillFromDto(dto);
        return newCurso;
    }
}
