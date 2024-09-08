package com.project.productapiredis.product;

import com.project.productapiredis.product.exception.ProductNotFoundException;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@CrossOrigin("*")
@RestController
@RequestMapping("/v1/product")
@AllArgsConstructor
public class ProductController {

    private final ProductService productService;

    @PostMapping()
    public ResponseEntity<ProductResponse> saveProduct(
            @RequestBody ProductRequest productRequest) {
        return ResponseEntity.ok(productService.saveProduct(productRequest));
    }

    @GetMapping
    public ResponseEntity<List<ProductResponse>> getAllProducts() {
        return ResponseEntity.ok(productService.listAllProducts());
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getProductById(@PathVariable("id") UUID id) {
        try {
            return ResponseEntity.ok(productService.findProductById(id));
        } catch (ProductNotFoundException productNotFoundException) {
            return ResponseEntity.status(productNotFoundException.statusCode).body(productNotFoundException.message);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteProductById(@PathVariable("id") UUID id) {
        try {
            productService.deleteProduct(id);
            return ResponseEntity.ok("Product deleted successfully");
        } catch (ProductNotFoundException productNotFoundException) {
            return ResponseEntity.status(productNotFoundException.statusCode).body(productNotFoundException.message);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
        }
    }

}
