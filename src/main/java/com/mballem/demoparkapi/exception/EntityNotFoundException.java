package com.mballem.demoparkapi.exception;

import lombok.Getter;

@Getter
public class EntityNotFoundException extends RuntimeException {
    private String codigo;
    private String recurso;
    public EntityNotFoundException(String message) {
        super(message);
    }

    public EntityNotFoundException(String codigo, String recurso) {
        this.codigo = codigo;
        this.recurso = recurso;
    }
}
