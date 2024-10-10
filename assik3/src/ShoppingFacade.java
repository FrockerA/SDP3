public class ShoppingFacade {
    private ProductCatalog productCatalog;
    private PaymentProcessor paymentProcessor;
    private InventoryManager inventoryManager;
    private ShippingService shippingService;

    public ShoppingFacade() {
        this.productCatalog = new ProductCatalog();
        this.paymentProcessor = new PaymentProcessor();
        this.inventoryManager = new InventoryManager();
        this.shippingService = new ShippingService();
    }

    public String placeOrder(String productId, String paymentDetails, String address) {
        // Step 1: Find the product
        Product product = productCatalog.findProductById(productId);
        if (product == null) {
            return "Product not found!";
        }

        // Step 2: Check stock availability
        if (!inventoryManager.checkStock(productId)) {
            return "Product is out of stock!";
        }

        // Step 3: Process payment
        double amount = product.getPrice();
        if (!paymentProcessor.processPayment(paymentDetails, amount)) {
            return "Payment failed!";
        }

        // Step 4: Reduce inventory stock
        inventoryManager.reduceStock(productId, 1);

        // Step 5: Ship the product
        double shippingCharge = shippingService.calculateShipping(address);
        shippingService.shipOrder(productId, address);

        return "Order placed successfully! Shipping charge: $" + shippingCharge;
    }
}
