package com.salesianostriana.dam.tareaclase_14_11.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Lob;
import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
public class Monumento {

    @Id @GeneratedValue
    private Long id;

    private String codigoPais;
    private String nombrePais;
    private String nombreCiudad;
    private double latitud;
    private double longitud;
    private String nombreMonumento;
    @Lob
    private String descripcion;
    private String urlFoto;

}
