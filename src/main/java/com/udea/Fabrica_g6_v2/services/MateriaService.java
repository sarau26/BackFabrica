package com.udea.Fabrica_g6_v2.services;

import com.udea.Fabrica_g6_v2.dto.MateriaIdNameDto;
import com.udea.Fabrica_g6_v2.models.Materia;

import com.udea.Fabrica_g6_v2.repositories.MateriaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class MateriaService {
    @Autowired
    MateriaRepository materiaRepository;

    public List<Materia> findAll(){
        //capturar y enviar los elementos de la bas de datos
        return materiaRepository.findAll();
    }

    //crear un Nuevo elemento
    public ResponseEntity<Materia> save(Materia materia){
        //guardar
        Materia result= materiaRepository.save(materia);
        return  ResponseEntity.ok(result);
    }

    //buscar segun su id
    public ResponseEntity<Materia> findById(Integer id){
        //usamos siempre un optional para no tratar con excepciones de alcance por id, debido a un id incorrecto
        Optional<Materia> optionalMateria= materiaRepository.findById(id);
        if(optionalMateria.isPresent())
            //si existe lo devuelvo
            return  ResponseEntity.ok(optionalMateria.get());
        else
            //si no existe debolvemos un 404 con un response entity
            return ResponseEntity.notFound().build();
    }

    //borrar un elemento de la DB
    public ResponseEntity<Materia> delete(Integer id){

        if (!materiaRepository.existsById(id)) { //si el Id NO existe (NUMEO MUY GRANDE)
            return ResponseEntity.notFound().build();
        }
        materiaRepository.deleteById(id);
        return ResponseEntity.noContent().build();
    }

    //actualizar un elemento existente

    public ResponseEntity<Materia> update(Materia materia){
        if(materia.getIdMateria()==null){ //no le mande un id
            return ResponseEntity.badRequest().build();
        }
        if(!materiaRepository.existsById(materia.getIdMateria())){ //si el Id NO existe (NUMEO MUY GRANDE)
            return ResponseEntity.notFound().build();
        }
        //de lo contrario
        Materia result= materiaRepository.save(materia);
        return ResponseEntity.ok(result);
    }

    public ResponseEntity<List<MateriaIdNameDto>> getAllIdsNames(){
        List<Materia> materiaList = materiaRepository.findAll();
        List<MateriaIdNameDto> idNameList = new ArrayList<>();
        for (Materia materia: materiaList) {
            MateriaIdNameDto idNameDto = new MateriaIdNameDto();
            idNameDto.setId(materia.getIdMateria());
            idNameDto.setNombre(materia.getNombre());
            idNameList.add(idNameDto);
        }
        return ResponseEntity.ok(idNameList);
    }

}
