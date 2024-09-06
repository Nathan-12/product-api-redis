package com.project.productapiredis.product.exception;

import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;

@AllArgsConstructor
public class ProductAlreadyExistsException extends RuntimeException {

    private static final long serialVersionUID = 1;
    public final HttpStatus statusCode;
    public final String message;

    public ProductAlreadyExistsException() {
        this.statusCode = HttpStatus.CONFLICT;
        this.message = "Product already exists";
    }
}
