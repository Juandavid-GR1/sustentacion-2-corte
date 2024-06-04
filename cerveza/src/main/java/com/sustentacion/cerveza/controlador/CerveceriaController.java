package com.sustentacion.cerveza.controlador;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.sustentacion.cerveza.Domain.Cerveceria;
import com.sustentacion.cerveza.repository.CervezaRepository;

@CrossOrigin(origins = "http://localhost:8081")
@RestController
@RequestMapping("/api")
public class CerveceriaController {
    @Autowired
    CervezaRepository cervezaRepository;

    @GetMapping("/Cervecerias")
    public ResponseEntity <List<Cerveceria>> getAllCervecerias(@RequestParam(required = false) String nombre){
        try{
            List<Cerveceria> cerveceria = new ArrayList<>();

            if(nombre==null)
                cerveceria.addAll(cervezaRepository.findAll());
            else
                cerveceria.addAll(cervezaRepository.findByNombre_cerveceria(nombre));
            return new ResponseEntity<>(cerveceria, HttpStatus.OK);
        } catch(Exception e){
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/tutorials/{id}")
    public ResponseEntity<Cerveceria> getTutorialById(@PathVariable("id") long id){
        Optional<Cerveceria> tutorialData = cervezaRepository.findById(id);

        if(tutorialData.isPresent()){
            return new ResponseEntity<>(tutorialData.get(), HttpStatus.OK);
        } else{
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping("/tutorials")
    public ResponseEntity<Cerveceria> crearCerveceria(@RequestBody Cerveceria cerveceria){
        try{
            Cerveceria _cerveceria = cervezaRepository
                    .save(new Cerveceria());
            return new ResponseEntity<>(cerveceria, HttpStatus.CREATED);
        } catch(Exception e){
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("/cervezas/{id}")
    public ResponseEntity<Cerveceria> GuardarCerveceria(@PathVariable("id") long id, @RequestBody Cerveceria cerveceria){
        Optional<Cerveceria> cervezaData = cervezaRepository.findById(id);

        if(cervezaData.isPresent()){
            Cerveceria _cerveceria = cervezaData.get();
            _cerveceria.setMarca(cerveceria.getMarca());
            _cerveceria.setNombre_cerveceria(cerveceria.getNombre_cerveceria());

            return new ResponseEntity<>(cervezaRepository.save(_cerveceria), HttpStatus.OK);
        } else{
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/cervezas/{id}")
    public ResponseEntity<HttpStatus> deleteTutorial (@PathVariable("id") long id){
        try{
            cervezaRepository.deleteById(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping("/cervezas")
    public ResponseEntity<HttpStatus> deleteAllTutorials(){
        try{
            cervezaRepository.deleteAll();
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch(Exception e){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/cerveceria/nombre")
    public ResponseEntity<List<Cerveceria>> findByNombre_cerveza(){
        try{
            List<Cerveceria> cervezas = cervezaRepository.findByMarca(marca);
        
            if(cervezas.isEmpty()){
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }
            return new ResponseEntity<>(cervezas, HttpStatus.OK);
         } catch(Exception e){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
         }
 }
}
