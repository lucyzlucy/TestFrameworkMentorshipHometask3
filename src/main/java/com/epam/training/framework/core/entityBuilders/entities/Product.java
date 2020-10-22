package com.epam.training.framework.core.entityBuilders.entities;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter

public class Product {
    private String name;
    private double price;
    private int availableItems;
    private int quantity = 1;

    public Product() {
    }

    public Product(String name, double price) {
        this.name = name;
        this.price = price;
    }

    public Product(String name, double price, int availableItems) {
        this.name = name;
        this.price = price;
        this.availableItems = availableItems;
    }

    public Product(double price, int availableItems) {
        this.price = price;
        this.availableItems = availableItems;
    }
}
