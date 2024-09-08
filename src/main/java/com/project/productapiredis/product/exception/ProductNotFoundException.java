package com.project.productapiredis.product.exception;

import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;

@AllArgsConstructor
public class ProductNotFoundException extends RuntimeException {

    private static final long serialVersionUID = 1092233112L;
    public final HttpStatus statusCode;
    public final String message;

    public ProductNotFoundException() {
        this.statusCode = HttpStatus.NOT_FOUND;
        this.message = "Product not found";
    }
}
