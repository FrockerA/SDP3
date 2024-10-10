public class PaymentProcessor {
    public boolean processPayment(String paymentDetails, double amount) {
        System.out.println("Processing payment of $" + amount + " with details: " + paymentDetails);
        return true; // Assume payment succeeds
    }
}
