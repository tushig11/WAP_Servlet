package model;

import java.util.ArrayList;
import java.util.List;

public class Cart {

    private List<Product> products;

    //constructors
    public Cart(){
        this.products = new ArrayList<>();
    }

    //getter methods
    public List<Product> getProducts() {
        return products;
    }

    //custom methods
    public void addToCart(Product product){
        this.products.add(product);
    }

    public void removeFromCart(Product product){
        this.products.remove(product);
    }

    public int getSize(){
        return this.products.size();
    }

    public double getTotal(){
        double sum = 0;
        for(Product p: products){
            sum += p.getPrice();
        }
        return sum;
    }

    @Override
    public String toString() {
        return "Total: " + this.getTotal();
    }
}
