package com.qwammy.javaflupskilling_week_4.entities;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;

/**
 * The Product class represents a product with an ID, name, and price.
 */
@Getter
@Setter
@NoArgsConstructor
public class Product {
    private String id;
    private String name;
    private BigDecimal price;
}
