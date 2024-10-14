package com.contactmanager.contact.helper;

public class ResourceNotFoundException extends RuntimeException{
   
    // constructor
    public ResourceNotFoundException(String message) {
        super(message);
    }

    public ResourceNotFoundException() {
        super("Resource not found");
    }

}
