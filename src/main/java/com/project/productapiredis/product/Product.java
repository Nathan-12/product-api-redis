package com.project.productapiredis.product;

import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;
import java.util.UUID;

@Entity
@Table(name = "TB_PRODUCT")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Generated
public class Product implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "PROD_COD")
    private UUID id;

    @Column(name = "PROD_NAME")
    private String name;

    @Column(name = "PROD_REFERENCE")
    private String reference;

    @Column(name = "PROD_QUANTITY")
    private Integer quantity;

    @Column(name = "PROD_PRICE")
    private Double price;

    public ProductResponse toResponse() {
        return ProductResponse
                .builder()
                .name(name).reference(reference).quantity(quantity).price(price)
                .build();
    }
}
