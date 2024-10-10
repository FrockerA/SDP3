public class ShoppingClient {
    public static void main(String[] args) {
        ShoppingFacade shoppingFacade = new ShoppingFacade();

        // Example order
        String productId = "#12";
        String paymentDetails = "Visa 1234";
        String address = "Tole bi 12";

        String orderStatus = shoppingFacade.placeOrder(productId, paymentDetails, address);
        System.out.println(orderStatus);
    }
}
