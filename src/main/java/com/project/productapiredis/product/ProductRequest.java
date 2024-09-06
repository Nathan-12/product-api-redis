package com.project.productapiredis.product;

import lombok.*;

import java.io.Serializable;
import java.util.UUID;

@Data
@Builder
@Generated
@NoArgsConstructor
@AllArgsConstructor
public class ProductRequest implements Serializable {

    private static final long serialVersionUID = 1L;

    private UUID id;

    private String name;

    private String reference;

    private Integer quantity;

    private Double price;

    public Product toModel() {
        return Product
                .builder()
                .id(id).name(name).reference(reference).quantity(quantity).price(price)
                .build();
    }
}
