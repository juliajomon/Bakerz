package com.bakerx.bakerz.exceptions;

public class ResourceNotFoundException extends RuntimeException{
    String resourceName;
    String field;
    String fieldName;
    Long id;

    public ResourceNotFoundException( String resourceName, String field, String fieldName) {
        super(String.format(" %s not found in %s: %s", resourceName,field, fieldName));
        this.resourceName = resourceName;
        this.field = field;
        this.fieldName= fieldName;
    }

    public ResourceNotFoundException( String resourceName, String fieldName, Long id) {
        super(String.format("%s not found in %s: %d", resourceName,fieldName, id));
        this.resourceName = resourceName;
        this.fieldName = fieldName;
        this.id = id;
    }
}
