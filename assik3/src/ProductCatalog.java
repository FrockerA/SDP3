import java.util.HashMap;
import java.util.Map;

public class ProductCatalog {
    private Map<String, Product> products;

    public ProductCatalog() {
        products = new HashMap<>();
        products.put("#12", new Product("#12", "Laptop", 1200.0));
        products.put("#1223", new Product("#1223", "Smartphone", 800.0));
    }

    public Product findProductById(String productId) {
        return products.get(productId);
    }
}
