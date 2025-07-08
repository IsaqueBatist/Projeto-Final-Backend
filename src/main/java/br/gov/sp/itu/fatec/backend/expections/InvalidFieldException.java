package br.gov.sp.itu.fatec.backend.expections;

public class InvalidFieldException extends RuntimeException {
    public InvalidFieldException(String message) {
        super(message);
    }
}
