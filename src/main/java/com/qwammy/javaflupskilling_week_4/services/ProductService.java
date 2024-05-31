package com.qwammy.javaflupskilling_week_4.services;

import com.qwammy.javaflupskilling_week_4.entities.Product;
import com.qwammy.javaflupskilling_week_4.repositories.IProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.Optional;
import java.util.UUID;


/**
 * The ProductService class implements the IProductService interface, providing
 * methods for managing Product entities.
 */
@Service
public class ProductService implements IProductService {
    private final IProductRepository productRepository;

    /**
     * Constructs a new ProductService with the specified product repository.
     *
     * @param productRepository the product repository to be used
     */
    @Autowired
    public ProductService(IProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Product addProduct(Product product) {
        UUID uuid = UUID.randomUUID();
        product.setId(uuid.toString());
        return productRepository.save(product);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Collection<Product> getAllProducts() {
        return productRepository.findAll();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Optional<Product> getProductById(String id) {
        UUID uuid;
        try {
            uuid = UUID.fromString(id);
        } catch (IllegalArgumentException e) {
            return Optional.empty();
        }
        return productRepository.findById(uuid);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Product updateProduct(String id, Product updatedProduct) {
        UUID uuid;
        try {
            uuid = UUID.fromString(id);
        } catch (IllegalArgumentException e) {
            return null;
        }
        if (productRepository.findById(uuid).isPresent()) {
            updatedProduct.setId(uuid.toString());
            return productRepository.save(updatedProduct);
        }
        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void deleteProduct(String id) {
        UUID uuid;
        try {
            uuid = UUID.fromString(id);
        } catch (IllegalArgumentException e) {
            return;
        }
        productRepository.deleteById(uuid);
    }
}
