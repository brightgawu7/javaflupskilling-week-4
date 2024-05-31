package com.qwammy.javaflupskilling_week_4.controllers;

import com.qwammy.javaflupskilling_week_4.entities.Product;
import com.qwammy.javaflupskilling_week_4.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.Optional;


/**
 * The ProductController class handles HTTP requests related to product operations.
 */
@RestController
@RequestMapping("/api/v1/products")
public class ProductController {
    private final ProductService productService;

    /**
     * Constructs a new ProductController with the specified product service.
     *
     * @param productService the product service to be used
     */
    @Autowired
    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    /**
     * Adds a new product.
     *
     * @param product the product to be added
     * @return a ResponseEntity containing the created product or an error response
     */
    @PostMapping
    public ResponseEntity<Product> addProduct(@RequestBody Product product) {
        Product createdProduct = productService.addProduct(product);
        return ResponseEntity.ok(createdProduct);
    }

    /**
     * Retrieves all products.
     *
     * @return a ResponseEntity containing a collection of all products
     */
    @GetMapping
    public ResponseEntity<Collection<Product>> getAllProducts() {
        Collection<Product> products = productService.getAllProducts();
        return ResponseEntity.ok(products);
    }

    /**
     * Retrieves a product by its ID.
     *
     * @param id the ID of the product to retrieve
     * @return a ResponseEntity containing the found product or a not found response
     */
    @GetMapping("/{id}")
    public ResponseEntity<Product> getProductById(@PathVariable String id) {
        Optional<Product> product = productService.getProductById(id);
        return product.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    /**
     * Updates an existing product.
     *
     * @param id      the ID of the product to update
     * @param product the updated product information
     * @return a ResponseEntity containing the updated product or a not found response
     */
    @PutMapping("/{id}")
    public ResponseEntity<Product> updateProduct(@PathVariable String id, @RequestBody Product product) {
        Product updatedProduct = productService.updateProduct(id, product);
        if (updatedProduct != null) {
            return ResponseEntity.ok(updatedProduct);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    /**
     * Deletes a product by its ID.
     *
     * @param id the ID of the product to delete
     * @return a ResponseEntity with no content
     */
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteProduct(@PathVariable String id) {
        productService.deleteProduct(id);
        return ResponseEntity.noContent().build();
    }
}
