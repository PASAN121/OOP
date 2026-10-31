package uk.ac.westminster.products_api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController

public class ProductController {


    private final ProductService productService;
    @Autowired//optional controller has only one constructor
    public ProductController(ProductService productService){
        this.productService=productService;
    }

    //Activity2
    @GetMapping("/products")
    public List<Product> getAllProducts() {
        return productService.getAllProducts();
    }

    @GetMapping("/products/{id}")
    public Product getProductById(@PathVariable Long id) {
        return productService.getProductById(id).orElse(null);
    }
//Temporary: Product is abstract, Jackson can't build it from JSON, so we use a concrete subclass for now.
    @PostMapping("/products")
    public Product addProduct(@RequestBody DigitalProduct product) {

        return productService.addProduct(product);
    }


    @DeleteMapping("/products/{id}")
    public void deleteProduct(@PathVariable Long id) {
        productService.deleteProduct(id);
    }


    @GetMapping("/products/search")
    public List<Product> search(@RequestParam String name) {
        return productService.findByName(name);
    }



    @GetMapping("/physicalproduct")
    public List<PhysicalProduct> getPhysicalProducts() {
        return productService.getPhysicalProducts();
    }

    @GetMapping("/products/summaries")
    public List<String> getSummaries() {
        return productService.getAllSummaries();
    }


}
