package com.salesianostriana.dam.tareaclase_14_11.error;

public class MonumentoNotFoundException extends  RuntimeException{
    public MonumentoNotFoundException(String message) {super(message);}


    public MonumentoNotFoundException(Long id){
        super("No hay un monumento con ese ID: %d".formatted(id));
    }

    public MonumentoNotFoundException(){
        super("No hay monumentos con esos requisitos de búsqueda.");
    }

}
