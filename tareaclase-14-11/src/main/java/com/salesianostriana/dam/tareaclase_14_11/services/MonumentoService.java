package com.salesianostriana.dam.tareaclase_14_11.services;

import com.salesianostriana.dam.tareaclase_14_11.dto.NewMonumentoCommand;
import com.salesianostriana.dam.tareaclase_14_11.error.MonumentoNotFoundException;
import com.salesianostriana.dam.tareaclase_14_11.model.Monumento;
import com.salesianostriana.dam.tareaclase_14_11.repository.MonumentoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class MonumentoService {

    private final MonumentoRepository monumentoRepository;

    public List<Monumento> findAll(){
        List<Monumento> result = monumentoRepository.findAll();

        if(result.isEmpty()){
            throw new MonumentoNotFoundException();
        }
        return  result;
    }

    public Monumento findById(Long id){
        return monumentoRepository.findById(id).orElseThrow(() -> new MonumentoNotFoundException(id));
    }

    public Monumento save (NewMonumentoCommand cmd){
        return monumentoRepository.save(
                Monumento.builder()
                        .codigoPais(cmd.codigoPais())
                        .nombrePais(cmd.nombrePais())
                        .nombreCiudad(cmd.nombreCiudad())
                        .nombreMonumento(cmd.nombreMonumento())
                        .longitud(cmd.longitud())
                        .latitud(cmd.latitud())
                        .descripcion(cmd.descripcion())
                        .urlFoto(cmd.urlFoto())
                        .build()
        );
    }

}
