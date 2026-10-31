package uk.ac.westminster.products_api;

public class DigitalProduct extends Product implements Discountable{

        private String downloadUrl;
        private double fileSizeMb;

        private double discountedPrice;


        public DigitalProduct(){}

        public DigitalProduct(Long id,String name,double price,String downloadUrl,double fileSizeMb)
        {
            super(id,name,price);

            this.downloadUrl=downloadUrl;
            this.fileSizeMb=fileSizeMb;
        }

        public double getFileSizeMb(){
            return this.fileSizeMb;
        }
        public String getDownloadUrl(){
             return this.downloadUrl;
        }


    @Override
    public String getSummary() {
        return "Digital: " + getName()
                + " | Download: " + downloadUrl;
    }

    @Override
    public void applyDiscount(double rate) {
        this.discountedPrice = getPrice() * (1 - rate);
    }

    @Override
    public double getDiscountedPrice() {
        return discountedPrice;
    }

}
