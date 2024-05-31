package com.qwammy.javaflupskilling_week_4.repositories;

import com.qwammy.javaflupskilling_week_4.entities.Product;
import org.springframework.stereotype.Repository;

import java.util.*;

/**
 * The ProductRepository class implements the IProductRepository interface, providing
 * methods for CRUD operations on Product entities using an in-memory map.
 */
@Repository
public class ProductRepository implements IProductRepository {
    private final Map<UUID, Product> productMap = new HashMap<>();

    /**
     * {@inheritDoc}
     */
    @Override
    public Product save(Product product) {
        UUID uuid = UUID.fromString(product.getId());
        productMap.put(uuid, product);
        return product;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Optional<Product> findById(UUID uuid) {
        return Optional.ofNullable(productMap.get(uuid));
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Collection<Product> findAll() {
        return productMap.values();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void deleteById(UUID uuid) {
        productMap.remove(uuid);
    }
}
