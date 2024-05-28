package com.mballem.demoparkapi.exception;

import lombok.Getter;

@Getter
public class ReciboNotFoundException extends RuntimeException {
    private String recurso;
    private String codigo;

    public ReciboNotFoundException(String message) {
        super(message);
    }

    public ReciboNotFoundException( String recurso, String codigo) {
        this.recurso = recurso;
        this.codigo = codigo;
    }
}
