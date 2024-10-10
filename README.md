# SDP3

Subsystems
1. ProductCatalog
The ProductCatalog subsystem is responsible for managing the products available for purchase. It includes a collection of products that can be searched by product ID.

Functions:
findProductById(String productId): Searches for and returns a product based on the product ID. If the product does not exist, it returns null.

Purpose:
This subsystem is responsible for handling product data, including identifying and locating specific items within the catalog.

2. PaymentProcessor
The PaymentProcessor subsystem handles payment transactions. It verifies the payment details and processes the payment for the given order.

Functions:
processPayment(String paymentDetails, double amount): Processes a payment of a specified amount using the provided payment details. Returns true if the payment is successful; otherwise, returns false.

Purpose:
This subsystem is responsible for validating and completing payment transactions. In a real-world scenario, this could involve communicating with a payment gateway to authenticate and process payments.

3. InventoryManager
The InventoryManager subsystem manages the stock levels of each product and checks the availability of items.

Functions:
checkStock(String productId): Verifies whether a given product is in stock. Returns true if the product is available; otherwise, returns false.
reduceStock(String productId, int quantity): Reduces the available quantity of a product by a specified amount. This function is called when an order is successfully placed to update the inventory.

Purpose:
This subsystem ensures that customers can only purchase items that are in stock, preventing the sale of out-of-stock products.

4. ShippingService
The ShippingService subsystem calculates shipping costs and arranges for product shipment.

Functions:
calculateShipping(String address): Calculates the shipping charge based on the destination address. This could involve various factors in a real-world application, such as distance and shipment type.
shipOrder(String productId, String address): Processes the shipment of a product to the specified address.

Purpose:
This subsystem is responsible for determining shipping costs and handling the logistics of delivering the purchased items to the customer's address.

#ShoppingFacade Class

The ShoppingFacade class serves as the unified interface that simplifies the interactions with the various subsystems. By hiding the details of how the order is processed, the ShoppingFacade provides a straightforward interface for clients to place orders with minimal code.

Functions:
placeOrder(String productId, String paymentDetails, String address): This high-level function coordinates the actions of the subsystems to complete an order. It:

Finds the specified product.
Checks the inventory to ensure the product is in stock.
Processes the payment.
Reduces the stock in the inventory.
Arranges for shipping.
The method returns a message indicating the success or failure of the order. If any step fails, a corresponding error message is provided.

#Role of the Facade Pattern

The Facade Pattern simplifies the interaction between the client and the complex system of subsystems by providing a unified interface. Here’s how it benefits the Online Shopping System:

Encapsulation of Complexity: The ShoppingFacade abstracts the details of subsystems such as ProductCatalog, PaymentProcessor, InventoryManager, and ShippingService. The client does not need to know how each subsystem works or interacts with others. Instead, they only need to call placeOrder(), which internally handles all the necessary steps.

Ease of Use: Clients can place orders without dealing with the individual complexities of checking stock, processing payments, or calculating shipping. This makes the system user-friendly and reduces potential errors from directly managing these details.

Extensibility: The ShoppingFacade can be extended to support additional functionality (e.g., discount handling, order tracking) without impacting existing client code. For instance, adding a discount feature would involve adding a DiscountService subsystem and modifying placeOrder() to apply the discount before processing payment.

Loose Coupling: The client is decoupled from the specific implementations of subsystems, which enhances maintainability. Changes to subsystem implementations do not impact the client, as long as the ShoppingFacade interface remains consistent.
