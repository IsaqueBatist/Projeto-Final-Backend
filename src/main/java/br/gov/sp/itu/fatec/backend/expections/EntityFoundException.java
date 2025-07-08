package br.gov.sp.itu.fatec.backend.expections;

public class EntityFoundException extends RuntimeException {
    public EntityFoundException(String message) {
        super(message);
    }
}