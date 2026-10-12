package uk.ac.westminster.products_api;

import org.springframework.stereotype.Service;
import uk.ac.westminster.products_api.Product;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ProductService {

    private List<Product> products = new ArrayList<>();
    private Long nextId = 1L; // Client only sends name + price, never an id

    public List<Product> getAllProducts() {
        return List.copyOf(products);//to manage the later acces through the productcontroller
    }

    public Product addProduct(Product product) {
        product.setId(nextId++);   // use the value, then add one 
        products.add(product);
        return product;
    }

    public Optional<Product> getProductById(Long id) {
        return products.stream()
                .filter(p -> p.getId().equals(id))
                .findFirst();
    }

    public void deleteProduct(Long id) {
        products.removeIf(p -> p.getId().equals(id));
    }
    public List<Product> findByName(String name) {
        return products.stream()
                .filter(p -> p.getName().contains(name))
                .toList();
    }



} 