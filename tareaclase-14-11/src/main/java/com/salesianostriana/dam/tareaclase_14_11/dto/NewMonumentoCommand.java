package com.salesianostriana.dam.tareaclase_14_11.dto;

public record NewMonumentoCommand(

        Long id,
     String codigoPais,
     String nombrePais,
     String nombreCiudad,
     double latitud,
     double longitud,
     String nombreMonumento,
     String descripcion,
     String urlFoto
) {
}
