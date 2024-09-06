package com.project.productapiredis.product;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Getter
@AllArgsConstructor
@Builder
@NoArgsConstructor
public class ProductResponse implements Serializable {

    private static final long serialVersionUID = 1L;

    private String name;

    private String reference;

    private Integer quantity;

    private Double price;


}
