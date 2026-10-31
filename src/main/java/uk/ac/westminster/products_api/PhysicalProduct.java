package uk.ac.westminster.products_api;
// A PhysicalProduct IS-A Product because it has everything a Product has (id, name, price and their getters), so it can be used anywhere a Product is expected.
// A ShoppingCart is NOT a Product, because a cart contains products rather than being one. That is HAS-A, so it holds a List<Product> as a field instead of using extends.

public class PhysicalProduct extends Product implements Discountable{
    private double weightKg;
    private String dimension;

    private double discountedPrice;

    public PhysicalProduct(){}

    public PhysicalProduct(Long id,String name,double price,double weightKg,String dimension)
    {
        super(id,name,price);
        this.weightKg=weightKg;
        this.dimension=dimension;
    }
    public double getWeightKg(){
        return this.weightKg;
    }
    public String getDimension(){
        return this.dimension;
    }

    @Override
    public String getSummary() {
        return "Physical: " + getName()
                + " | Weight: " + weightKg + " kg" + "| Dimension : " + dimension ;
    }

    @Override
    public void applyDiscount(double rate) {
        double capped = Math.min(rate, 0.20);
        this.discountedPrice = getPrice() * (1 - capped);
    }

    @Override
    public double getDiscountedPrice() {
        return discountedPrice;
    }
}
