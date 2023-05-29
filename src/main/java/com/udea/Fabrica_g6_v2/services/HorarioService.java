package com.udea.Fabrica_g6_v2.services;


import com.udea.Fabrica_g6_v2.models.Horario;
import com.udea.Fabrica_g6_v2.repositories.HorarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;
import java.util.Optional;
@Service
public class HorarioService {
    @Autowired
    HorarioRepository horarioRepository;
    public List<Horario> findAll(){
        //capturar y enviar los elementos de la bas de datos
        return horarioRepository.findAll();

    }



    //crear un Nuevo elemento

    public ResponseEntity<Horario> save(@RequestBody Horario horario){

        //guardar
        Horario result= horarioRepository.save(horario);

        return  ResponseEntity.ok(result);
    }




    //buscar segun su id

    public ResponseEntity<Horario> findById(@PathVariable String id){
        //usamos siempre un optional para no tratar con excepciones de alcance por id, debido a un id incorrecto
        Optional<Horario> optionalHorario= horarioRepository.findById(id);
        if(optionalHorario.isPresent())
            //si existe lo devuelvo
            return  ResponseEntity.ok(optionalHorario.get());
        else
            //si no existe debolvemos un 404 con un response entity
            return ResponseEntity.notFound().build();
    }




    //borrar un elemento de la DB

    public ResponseEntity<Horario> delete(@PathVariable String id){

        if (!horarioRepository.existsById(id)) { //si el Id NO existe (NUMEO MUY GRANDE)
            return ResponseEntity.notFound().build();
        }
        horarioRepository.deleteById(id);
        return ResponseEntity.noContent().build();

    }




    //actualizar un elemento existente

    public ResponseEntity<Horario> update(@RequestBody Horario horario){
        if(horario.getId()==null){ //no le mande un id
            return ResponseEntity.badRequest().build();
        }
        if(!horarioRepository.existsById(horario.getId())){ //si el Id NO existe (NUMEO MUY GRANDE)
            return ResponseEntity.notFound().build();
        }
        //de lo contrario
        Horario result= horarioRepository.save(horario);
        return ResponseEntity.ok(result);


    }


}

