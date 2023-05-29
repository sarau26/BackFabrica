package com.udea.Fabrica_g6_v2.services;



import com.udea.Fabrica_g6_v2.models.Calendario;
import com.udea.Fabrica_g6_v2.repository.CalendarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;
import java.util.Optional;

@Service
public class CalendarioService {
    @Autowired
    CalendarioRepository calendarioRepository;

    public List<Calendario> findAll(){
        //capturar y enviar los elementos de la bas de datos
        return calendarioRepository.findAll();

    }



    //crear un Nuevo elemento

    public ResponseEntity<Calendario> save(@RequestBody Calendario calendario){

        //guardar
        Calendario result=calendarioRepository.save(calendario);

        return  ResponseEntity.ok(result);
    }




    //buscar segun su id

    public ResponseEntity<Calendario> findById(@PathVariable String id){
        //usamos siempre un optional para no tratar con excepciones de alcance por id, debido a un id incorrecto
        Optional<Calendario> optionalCalendario=calendarioRepository.findById(id);
        if(optionalCalendario.isPresent())
            //si existe lo devuelvo
            return  ResponseEntity.ok(optionalCalendario.get());
        else
            //si no existe debolvemos un 404 con un response entity
            return ResponseEntity.notFound().build();
    }




    //borrar un elemento de la DB

    public ResponseEntity<Calendario> delete(@PathVariable String id){

        if (!calendarioRepository.existsById(id)) { //si el Id NO existe (NUMEO MUY GRANDE)
            return ResponseEntity.notFound().build();
        }
        calendarioRepository.deleteById(id);
        return ResponseEntity.noContent().build();

    }




    //actualizar un elemento existente

    public ResponseEntity<Calendario> update(@RequestBody Calendario calendario){
        if(calendario.getId()==null){ //no le mande un id
            return ResponseEntity.badRequest().build();
        }
        if(!calendarioRepository.existsById(calendario.getId())){ //si el Id NO existe (NUMEO MUY GRANDE)
            return ResponseEntity.notFound().build();
        }
        //de lo contrario
        Calendario result=calendarioRepository.save(calendario);
        return ResponseEntity.ok(result);


    }


}
