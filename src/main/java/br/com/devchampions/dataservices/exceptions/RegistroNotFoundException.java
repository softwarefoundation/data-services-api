package br.com.devchampions.dataservices.exceptions;

public class RegistroNotFoundException extends RuntimeException {
    
    public RegistroNotFoundException(String message) {
        super(message);
    }
}
