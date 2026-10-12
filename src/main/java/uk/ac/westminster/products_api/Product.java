package uk.ac.westminster.products_api;

public class Product {

    private Long id;
    private String name;
    private double price;

    public Product() {}

    public Product(Long id, String name, double price) {
        this.id = id;
        this.name = name;
        this.price = price;
    }

    public Long getId() {
        return id;
    }

//    private String getName() {
//        return name;
//    }
    //name is private and has no getName(), so Jackson has no
    // way to read it and skips it. id and price still have getters, so they appear.


    public void setId(Long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getName(){
        return name;
    }

    public double getPrice() {
        return price;
    }
}