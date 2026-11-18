package org.example.todo.exceptions;

public class DuplicationResourceException extends RuntimeException {

    public DuplicationResourceException(String message) {
        super(message);
    }
}
