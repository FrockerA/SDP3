public class ShippingService {
    public double calculateShipping(String address) {
        System.out.println("Calculating shipping cost for address: " + address);
        return 15.0; // Flat rate for simplicity
    }

    public void shipOrder(String productId, String address) {
        System.out.println("Shipping product " + productId + " to address: " + address);
    }
}
