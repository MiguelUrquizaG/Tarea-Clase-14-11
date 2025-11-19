package com.salesianostriana.dam.tareaclase_14_11.controller;

import com.salesianostriana.dam.tareaclase_14_11.dto.EditMonumentoCommand;
import com.salesianostriana.dam.tareaclase_14_11.model.Monumento;
import com.salesianostriana.dam.tareaclase_14_11.services.MonumentoService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/monumento")
@RequiredArgsConstructor
@Tag(name = "Monumento Controller" ,description = "Es el controller que tiene los métodos de monumentos.")
public class MonumentoController {

    public final MonumentoService monumentoService;

    @Operation(description = "Este método se dedica a traer todos los monumentos")
    @GetMapping
    public List<Monumento> getAll(){
        return monumentoService.findAll();
    }

    @GetMapping("/{id}")
    public Monumento getById(@PathVariable Long id){
        return monumentoService.findById(id);
    }

    @PostMapping
    public ResponseEntity<Monumento> create(@RequestBody EditMonumentoCommand cmd){
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(monumentoService.save(cmd));
    }

    @PutMapping("/{id}")
    public Monumento edit(@RequestBody EditMonumentoCommand cmd, @PathVariable Long id){
        return monumentoService.edit(cmd,id);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id){
        monumentoService.delete(id);
        return ResponseEntity.noContent().build();
    }


}
