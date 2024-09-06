package com.project.productapiredis.product;

import com.project.productapiredis.product.exception.ProductAlreadyExistsException;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Objects;
import java.util.Optional;

@Service
@AllArgsConstructor
public class ProductService {

    private final ProductRepository productRepository;

    public Product saveProduct(ProductRequest productRequest) {
        if (existsProductWithThisName(productRequest.getName())) {
            throw new ProductAlreadyExistsException();
        }
        var model = productRequest.toModel();
        return productRepository.save(model);
    }

    private Boolean existsProductWithThisName(String productName) {
        Product product = productRepository.findProductByName(productName.toUpperCase());
        return Objects.nonNull(product);
    }

}
