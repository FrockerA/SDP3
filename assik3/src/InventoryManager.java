import java.util.HashMap;
import java.util.Map;

public class InventoryManager {
    private Map<String, Integer> stock;

    public InventoryManager() {
        stock = new HashMap<>();
        stock.put("#12", 10);
        stock.put("#1223", 5);
    }

    public boolean checkStock(String productId) {
        Integer availableStock = stock.get(productId);
        return availableStock != null && availableStock > 0;
    }

    public void reduceStock(String productId, int quantity) {
        if (checkStock(productId)) {
            stock.put(productId, stock.get(productId) - quantity);
        }
    }
}
