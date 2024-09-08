package com.project.productapiredis.product;

import com.project.productapiredis.product.exception.ProductAlreadyExistsException;
import com.project.productapiredis.product.exception.ProductNotFoundException;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.UUID;

@Service
@AllArgsConstructor
@Slf4j
public class ProductService {

    public static final String CACHE_NAME_REDIS = "ProductResponse";

    private final ProductRepository productRepository;

    @CacheEvict(cacheNames = CACHE_NAME_REDIS, allEntries = true)
    public ProductResponse saveProduct(ProductRequest productRequest) {
        log.info("Call productRepository.save(productRequest)");
        if (existsProductWithThisName(productRequest.getName())) {
            throw new ProductAlreadyExistsException();
        }
        var model = productRequest.toModel();
        productRepository.save(model);
        return model.toResponse();
    }

    @Cacheable(cacheNames = CACHE_NAME_REDIS, key = "#root.method.name")
    public List<ProductResponse> listAllProducts() {
        log.info("Call productRepository.listAllProducts()");
        return productRepository.findAll().stream().map(Product::toResponse).toList();
    }

    @Cacheable(cacheNames = CACHE_NAME_REDIS, key = "#id")
    public ProductResponse findProductById(UUID id) {
        log.info("Call productRepository.findProductById(id)");
        Product product = productRepository.findById(id).orElseThrow(ProductNotFoundException::new);
        return product.toResponse();
    }

    @CacheEvict(cacheNames = CACHE_NAME_REDIS, allEntries = true)
    public void deleteProduct(UUID id) {
        log.info("Call productRepository.deleteById(id)");
        Optional<Product> productOptional = productRepository.findById(id);
        if (productOptional.isEmpty()) {
            throw new ProductNotFoundException();
        }
        productRepository.deleteById(id);
    }

    private Boolean existsProductWithThisName(String productName) {
        Product product = productRepository.findProductByName(productName.toUpperCase());
        return Objects.nonNull(product);
    }

}
