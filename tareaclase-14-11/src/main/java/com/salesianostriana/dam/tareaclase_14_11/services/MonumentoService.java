package com.salesianostriana.dam.tareaclase_14_11.services;

import com.salesianostriana.dam.tareaclase_14_11.dto.EditMonumentoCommand;
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

    public Monumento save (EditMonumentoCommand cmd){
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

    public Monumento edit(EditMonumentoCommand cmd,Long id){
        return monumentoRepository.findById(id)
                .map(m -> {
                    m.setNombreCiudad(cmd.nombreCiudad());
                    m.setDescripcion(cmd.descripcion());
                    m.setLatitud(cmd.latitud());
                    m.setLongitud(cmd.longitud());
                    m.setNombreMonumento(cmd.nombreMonumento());
                    m.setCodigoPais(cmd.codigoPais());
                    m.setNombrePais(cmd.nombrePais());
                    m.setUrlFoto(cmd.urlFoto());
                    return monumentoRepository.save(m);
                })
                .orElseThrow(() -> new MonumentoNotFoundException(id));
    }

    public void delete(Long id){
        monumentoRepository.deleteById(id);
    }

}
