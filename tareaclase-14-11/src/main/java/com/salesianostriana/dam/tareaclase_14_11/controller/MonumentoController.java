package com.salesianostriana.dam.tareaclase_14_11.controller;

import com.salesianostriana.dam.tareaclase_14_11.dto.EditMonumentoCommand;
import com.salesianostriana.dam.tareaclase_14_11.model.Monumento;
import com.salesianostriana.dam.tareaclase_14_11.services.MonumentoService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.ExampleObject;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
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


    @GetMapping
    @Operation(description = "Este método se dedica a traer todos los monumentos")
    @ApiResponses({

    })
    public List<Monumento> getAll(){
        return monumentoService.findAll();
    }


    @GetMapping("/{id}")
    @Operation(summary = "Obtiene el monumento que tu le indiques según el id.",description = "Devuelve un monumento.")
    @ApiResponses( {
            @ApiResponse(responseCode = "200",description = "Monumento encontrado correctamente"),
            @ApiResponse(responseCode = "404",description = "Monumento no encontado error" ,content =  @Content
                    ( mediaType = "application/json",schema = @Schema(implementation = Monumento.class),examples = @ExampleObject(value = """
            
                    {
                      "type": "about:blank",
                      "title": "Monumento no encontrado.",
                      "status": 404,
                      "detail": "No hay un monumento con ese ID: 5",
                      "instance": "/monumento/5"
                    }
            
            """)))
    })

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
