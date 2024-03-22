package task5;

import java.util.*;

public class Task5 implements Basket {
    private Map<String, Integer> products;

    public Task5() {
        this.products = new HashMap<>();
    }

    @Override
    public void addProduct(String product, int quantity) {
        if (checkKey(product)) {
            throw new IllegalArgumentException("Такой продукт уже содержится, добавление невозможно");
        } else {
            products.put(product, quantity);
        }
    }

    @Override
    public void removeProduct(String product) {
        if (checkKey(product)) {
            products.remove(product);
        } else {
            throw new IllegalArgumentException("Продукт не был найден");
        }

    }

    @Override
    public void updateProductQuantity(String product, int quantity) {
        if (checkKey(product)) {
            products.put(product, quantity);
        } else {
            throw new IllegalArgumentException("Продукт не был найден");
        }
    }

    @Override
    public void clear() {
        products.clear();
    }

    @Override
    public List<String> getProducts() {
        return new ArrayList<>(products.keySet());
    }

    @Override
    public int ProductQuantity(String product) {
        return products.get(product);
    }

    private boolean checkKey(String product) {
        return products.containsKey(product);
    }
}

