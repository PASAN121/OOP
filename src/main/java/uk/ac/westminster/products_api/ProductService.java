    package uk.ac.westminster.products_api;

    import org.springframework.stereotype.Service;
    import java.util.ArrayList;
    import java.util.List;
    import java.util.Optional;

    @Service
    public class ProductService {

        private List<Product> products = new ArrayList<>();
        private Long nextId = 1L;


        public ProductService() {
            addProduct(new PhysicalProduct(null, "Laptop", 250000.0, 1.8, "35x24x2 cm"));
            addProduct(new DigitalProduct(null, "Ebook", 1500.0, "https://example.com/ebook", 12.5));
        }

        public List<Product> getAllProducts() {
            return List.copyOf(products);
        }

        public List<PhysicalProduct> getPhysicalProducts() {
            return products.stream()
                    .filter(p -> p instanceof PhysicalProduct)
                    .map(p -> (PhysicalProduct) p)
                    .toList();
        }
        public List<DigitalProduct> getDigitalProducts() {
            return products.stream()
                    .filter(p -> p instanceof DigitalProduct)
                    .map(p -> (DigitalProduct) p)
                    .toList();
        }

        public Product addProduct(Product product) {
            product.setId(nextId++);
            products.add(product);
            return product;
        }

        public Optional<Product> getProductById(Long id) {
            return products.stream().filter(p -> p.getId().equals(id)).findFirst();
        }

        public void deleteProduct(Long id) {
            products.removeIf(p -> p.getId().equals(id));
        }

        public List<Product> findByName(String name) {
            return products.stream().filter(p -> p.getName().contains(name)).toList();
        }
    }