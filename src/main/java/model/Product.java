package model;

public class Product {
    private int id;
    private String name;
    private String description;
    private double price;
    private String picturePath;

    //constructors

    public Product(String name, double price){
        this.name = name;
        this.description = name;
        this.price = price;
        this.picturePath = "/products/"+name+".jpg";
    }

    public Product(int id, String name, double price){
        this.id = id;
        this.name = name;
        this.description = name;
        this.price = price;
        this.picturePath = "/products/"+name+".jpg";
    }

    //getter methods

    public int getId() {
        return id;
    }

    public double getPrice() {
        return price;
    }

    public String getDescription() {
        return description;
    }

    public String getName() {
        return name;
    }

    public String getPicturePath() {
        return picturePath;
    }

    //setter methods

    public void setId(int id) {
        this.id = id;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPicturePath(String picturePath) {
        this.picturePath = picturePath;
    }

    public void setPrice(double price) {
        this.price = price;
    }


    @Override
    public boolean equals(Object obj)
    {
        if(this == obj)
            return true;

        if(obj == null || obj.getClass()!= this.getClass())
            return false;

        Product prod = (Product) obj;

        return (prod.name == this.name && prod.id == this.id);
    }

    @Override
    public int hashCode()
    {
        return this.id;
    }
}
