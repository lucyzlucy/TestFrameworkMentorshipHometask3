package com.epam.training.framework.core.entityBuilders.builders;

import com.epam.training.framework.core.entityBuilders.entities.Product;
import com.epam.training.framework.core.entityBuilders.entities.User;

public class ProductBuilder {
    private Product product = new Product();

    public Product make() {
        return product;
    }

    public ProductBuilder setName(String name) {
        product.setName(name);
        return this;
    }

    public ProductBuilder setPrice(double price) {
        product.setPrice(price);
        return this;
    }

    public ProductBuilder setAvailableItems(int availableItems) {
        product.setAvailableItems(availableItems);
        return this;
    }

    public ProductBuilder setQuantity(int quantity) {
        product.setQuantity(quantity);
        return this;
    }
}
