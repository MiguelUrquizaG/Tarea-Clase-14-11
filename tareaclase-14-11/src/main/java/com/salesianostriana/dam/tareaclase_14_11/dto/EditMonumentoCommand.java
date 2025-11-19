package com.salesianostriana.dam.tareaclase_14_11.dto;

import io.swagger.v3.oas.annotations.media.Schema;

public record EditMonumentoCommand(

     @Schema(description = "Código de país",examples = "EN") String codigoPais,
     @Schema(description = "Nombre del país", examples = "Inglaterra") String nombrePais,
     @Schema(description = "Nombre de la ciudad",examples = "Londres") String nombreCiudad,
     @Schema(description = "Latitud en la que se encuentra el monumento.",examples = "1231º") double latitud,
     @Schema(description = "Longitud en la que se encuentra el monumento.",examples = "4123") double longitud,
     @Schema(description = "Nombre del monumento",examples = "London Eye") String nombreMonumento,
     @Schema(description = "Descripción del monumento.",examples = "Es un monumento muy curioso y bonito.") String descripcion,
     @Schema(description = "Url de la imagen de la foto",examples = "www.wikipedia.org/imagen") String urlFoto
) {
}
