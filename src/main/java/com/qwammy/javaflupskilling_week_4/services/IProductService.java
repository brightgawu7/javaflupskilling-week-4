package com.qwammy.javaflupskilling_week_4.services;

import com.qwammy.javaflupskilling_week_4.entities.Product;

import java.util.Collection;
import java.util.Optional;


/**
 * The IProductService interface provides methods for managing Product entities.
 */
public interface IProductService {

    /**
     * Adds a new product.
     *
     * @param product the product to be added
     * @return the added product
     */
    Product addProduct(Product product);

    /**
     * Retrieves all products.
     *
     * @return a collection of all products
     */
    Collection<Product> getAllProducts();

    /**
     * Retrieves a product by its ID.
     *
     * @param id the ID of the product to retrieve
     * @return an Optional containing the found product, or an empty Optional if no product is found
     */
    Optional<Product> getProductById(String id);

    /**
     * Updates an existing product.
     *
     * @param id             the ID of the product to update
     * @param updatedProduct the updated product information
     * @return the updated product
     */
    Product updateProduct(String id, Product updatedProduct);

    /**
     * Deletes a product by its ID.
     *
     * @param id the ID of the product to delete
     */
    void deleteProduct(String id);
}
