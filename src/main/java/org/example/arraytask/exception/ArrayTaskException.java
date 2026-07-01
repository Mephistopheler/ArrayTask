package org.example.arraytask.exception;

public class ArrayTaskException extends Exception {
    public ArrayTaskException(String message) {
        super(message);
    }

    public ArrayTaskException(String message, Throwable cause) {
        super(message, cause);
    }
}