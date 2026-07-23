package ru.academy.bakery.service;

import ru.academy.bakery.model.Product;

import java.math.BigDecimal;
import java.util.Random;

public class ProductService {

    public Product[] getProducts() {
        Product classicCroissant = new Product(
                "Круассан классический",
                "Хрустящий снаружи, воздушный внутри - как в лучших парижских пекарнях.",
                BigDecimal.valueOf(180),
                "resources/images/croissant.jpg",
                true
        );

        Product bread = new Product(
                "Хлеб на закваске",
                "Плотный мякиш, хрустящая корочка и глубокий хлебный аромат.",
                BigDecimal.valueOf(350),
                "resources/images/hero.jpg",
                false
        );

        Product[] products = {
                classicCroissant,
                bread
        };

        return products;
    }

    public Product[] getRandomProducts(int count) {
        Product[] products = new Product[count];

        Random random = new Random();

        for (int i = 0; i < count; i++) {
            products[i] = new Product(
                    "Товар №" + (i + 1),
                    "Описание для товара...",
                    BigDecimal.valueOf(random.nextDouble() * 1000),
                    "resources/images/croissant.jpg",
                    random.nextBoolean()
            );
        }

        return products;
    }
}
