package com.mysoap.soap;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Product implements Serializable {
    private static final long serialVersionUID = 1L;

    private static List<Product> products = new ArrayList<>(Arrays.asList(
            new Product("Lapiceros", 0.80),
            new Product("Cuadernos", 3.40),
            new Product("Hojas Bond", 10.50)));

    private String name;
    private double price;

    public Product() {
        super();
    }

    public Product(String name, double price) {
        this.name = name;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public static List<Product> getProducts() {
        return products;
    }

    @Override
    public String toString() {
        return "Product [name=" + name + ", price=" + price + "]";
    }
}
