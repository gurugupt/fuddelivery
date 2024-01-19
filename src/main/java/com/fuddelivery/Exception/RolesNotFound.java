package com.fuddelivery.Exception;

public class RolesNotFound extends RuntimeException{

    public RolesNotFound() {
    }

    public RolesNotFound(String message) {
        super(message);
    }

    public RolesNotFound(String message, Throwable cause) {
        super(message, cause);
    }
}
