package com.qwammy.javaflupskilling_week_4.repositories;

import com.qwammy.javaflupskilling_week_4.entities.Product;

import java.util.Collection;
import java.util.Optional;
import java.util.UUID;

/**
 * The IProductRepository interface provides methods for CRUD operations on Product entities.
 */
public interface IProductRepository {
    /**
     * Saves the specified product.
     *
     * @param product the product to be saved
     * @return the saved product
     */
    Product save(Product product);

    /**
     * Finds a product by its unique identifier.
     *
     * @param uuid the unique identifier of the product
     * @return an Optional containing the found product, or an empty Optional if no product is found
     */
    Optional<Product> findById(UUID uuid);

    /**
     * Returns a collection of all products.
     *
     * @return a collection of all products
     */
    Collection<Product> findAll();

    /**
     * Deletes the product with the specified unique identifier.
     *
     * @param uuid the unique identifier of the product to be deleted
     */
    void deleteById(UUID uuid);
}
