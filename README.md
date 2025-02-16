## Design Patterns

The following design patterns are implemented in this project:

### Creational Patterns

1. **Singleton**
    - **Location**: `com.implementations.designpatterns.config.SingletonConfig`
    - **Description**: Ensures a class has only one instance and provides a global point of access to it.
        - **UML Diagram**:
          ```
          +------------------------------------+
          | SingletonConfig                    |
          +------------------------------------+
          | - instance: SingletonConfig        |
          | + getInstance(): SingletonConfig   |
          +------------------------------------+
          ```

2. **Builder**
    - **Location**: `com.implementations.designpatterns.model.ProductBuilder`
    - **Description**: Constructs complex objects step by step, allowing the creation process to be more flexible.
        - **UML Diagram**:
          ```
          +---------------------------------------------------+
          | ProductBuilder                                    |
          +---------------------------------------------------+
          | - name: String                                    |
          | - price: double                                   |
          | - category: String                                |
          | + setName(name: String): ProductBuilder           |
          | + setPrice(price: double): ProductBuilder         |
          | + setCategory(category: String): ProductBuilder   |
          | + build(): Product                                |
          +---------------------------------------------------+
          ```

3. **Factory Method**
    - **Location**: `com.implementations.designpatterns.factory.UserFactory`
    - **Description**: Defines an interface for creating an object but lets subclasses alter the type of object that
      will be created.
        - **UML Diagram**:
          ```
          +------------------------------+
          | UserFactory                  |
          +------------------------------+
          | + createUser(String type): User |
          +------------------------------+
                      ^
                      |
          +------------------------------+        +------------------------------+
          | AdminFactory                 |        | CustomerFactory              |
          +------------------------------+        +------------------------------+
          | + createUser(type: String): User |    | + createUser(type: String): User |
          +------------------------------+        +------------------------------+
          ```

4. **Abstract Factory**
    - **Location**: `com.implementations.designpatterns.factory.AbstractFactory`
    - **Description**: Provides an interface for creating families of related or dependent objects without specifying
      their concrete classes.
        - **UML Diagram**:
          ```
          +------------------------------+
          | ProductFactory               |
          +------------------------------+
          | + createProduct(): Product   |
          +------------------------------+
                      ^
                      |
          +------------------------------+        +------------------------------+
          | ElectronicsFactory           |        | FurnitureFactory             |
          +------------------------------+        +------------------------------+
          | + createProduct(): Product   |        | + createProduct(): Product   |
          +------------------------------+        +------------------------------+
          ```

### Structural Patterns

5. **Adapter**
    - **Location**: `com.implementations.designpatterns.adapter.PaymentAdapter`
    - **Description**: Allows incompatible interfaces to work together by acting as a bridge.
        - **UML Diagram**:
          ```
          +-----------------------------------+
          | PaymentGateway                    |
          +-----------------------------------+
          | + processPayment(amount: String)  |
          +-----------------------------------+
                      ^
                      |
          +-----------------------------------+        +----------------------------------+
          | PayPalPayment                     |        | StripePaymentAdapter             |
          +-----------------------------------+        +----------------------------------+
          | + processPayment(amount: String)  |        | - stripePayment: StripePayment   |
          +-----------------------------------+        | + processPayment(amount: String) |
                                                       +----------------------------------+
          ```

6. **Composite**
    - **Location**: `com.implementations.designpatterns.model.CompositeProduct`
    - **Description**: Composes objects into tree structures to represent part-whole hierarchies, allowing individual
      objects and compositions to be treated uniformly.
        - **UML Diagram**:
          ```
          +------------------------------+
          | Product                      |
          +------------------------------+
          | + getPrice(): double         |
          +------------------------------+
                      ^
                      |
          +------------------------------+        +------------------------------+
          | SimpleProduct                |        | CompositeProduct             |
          +------------------------------+        +------------------------------+
          | - name: String               |        | - products: List<Product>    |
          | - price: double              |        | + addProduct(Product)        |
          | + getPrice(): double         |        | + removeProduct(Product)     |
          +------------------------------+        | + getPrice(): double         |
          +------------------------------+        +------------------------------+
          ```

7. **Decorator**
    - **Location**: `com.implementations.designpatterns.decorator.ProductDecorator`
    - **Description**: Adds behavior to objects dynamically, without affecting the behavior of other objects from the
      same class.
        - **UML Diagram**:
          ```
          +------------------------------+
          | Product                      |
          +------------------------------+
          | + getDescription(): String   |
          | + getPrice(): double         |
          +------------------------------+
                      ^
                      |
          +------------------------------+        +------------------------------+
          | BasicProduct                 |        | ProductDecorator             |
          +------------------------------+        +------------------------------+
          | - description: String        |        | - decoratedProduct: Product  |
          | - price: double              |        | + getDescription(): String   |
          +------------------------------+        | + getPrice(): double         |
          +------------------------------+        +------------------------------+
                      ^
                      |
          +------------------------------+
          | DiscountedProduct            |
          +------------------------------+
          | + getPrice(): double         |
          +------------------------------+
          ```

8. **Facade**
    - **Location**: `com.implementations.designpatterns.facade.OrderFacade`
    - **Description**: Provides a simplified interface to a complex subsystem, making it easier to use.
        - **UML Diagram**:
          ```
          +---------------------------------------------+
          | OrderFacade                                 |
          +---------------------------------------------+
          | - inventoryService: InventoryService        |
          | - paymentService: PaymentService            |
          | - shippingService: ShippingService          |
          | + placeOrder(productId: String, amount: double) |
          +---------------------------------------------+
          ```

### Behavioral Patterns

9. **Observer**
    - **Location**: `com.implementations.designpatterns.observer.OrderObserver`
    - **Description**: Defines a one-to-many dependency between objects so that when one object changes state, all its
      dependents are notified and updated automatically.
        - **UML Diagram**:
          ```
          +---------------------------------------------+
          | OrderSubject                                |
          +---------------------------------------------+
          | - observers: List<Observer>                 |
          | + registerObserver(observer: Observer)      |
          | + unregisterObserver(observer: Observer)    |
          | + notifyObservers(eventType: String, data: String) |
          +---------------------------------------------+
                      ^
                      |
          +---------------------------------------------+
          | OrderObserver                               |
          +---------------------------------------------+
          | + update(eventType: String, data: String)   |
          +---------------------------------------------+
          ```

10. **Strategy**
    - **Location**: `com.implementations.designpatterns.strategy.PaymentStrategy`
    - **Description**: Defines a family of algorithms, encapsulates each one, and makes them interchangeable. The
      strategy pattern allows the algorithm to vary independently from clients that use it.
        - **UML Diagram**:
          ```
          +---------------------------------------------+
          | PaymentStrategy                             |
          +---------------------------------------------+
          | + pay(amount: double)                       |
          +---------------------------------------------+
                     ^
                     |
          +---------------------------------------------+        +---------------------------------------------+
          | CreditCardPayment                           |        | PayPalPayment                               |
          +---------------------------------------------+        +---------------------------------------------+
          | + pay(amount: double)                       |        | + pay(amount: double)                       |
          +---------------------------------------------+        +---------------------------------------------+
                     ^
                     |
          +---------------------------------------------+
          | ShoppingCart                                |
          +---------------------------------------------+
          | - paymentStrategy: PaymentStrategy          |
          | + setPaymentStrategy(strategy: PaymentStrategy) |
          | + checkout(amount: double)                  |
          +---------------------------------------------+
          ```

11. **Command**
    - **Location**: `com.implementations.designpatterns.command.OrderCommand`
    - **Description**: Encapsulates a request as an object, allowing parameterization of clients with different
      requests, queuing of requests, and logging of requests.
        - **UML Diagram**:
          ```
          +------------------------------+
          | Command                      |
          +------------------------------+
          | + execute()                  |
          +------------------------------+
                     ^
                     |
          +------------------------------+        +------------------------------+
          | OrderCommand                 |        | OrderService                 |
          +------------------------------+        +------------------------------+
          | - orderService: OrderService |        | + placeOrder(orderId: String)|
          | - orderId: String            |        +------------------------------+
          | + execute()                  |
          +------------------------------+
          ```
12. **Template Method**
    - **Location**: `com.implementations.designpatterns.template.AbstractOrderProcessor`
    - **Description**: Defines the skeleton of an algorithm in a method, deferring some steps to subclasses. It lets
      subclasses redefine certain steps of an algorithm without changing its structure.
        - **UML Diagram**:
          ```
          +-----------------------------------+
          | AbstractOrderProcessor            |
          +-----------------------------------+
          | + processOrder(orderId: String)   |
          | + processPayment(orderId: String) |
          | + shipOrder(orderId: String)      |
          +-----------------------------------+
                   ^
                   |
          +-----------------------------------+
          | ConcreteOrderProcessor            |
          +-----------------------------------+
          | + processOrder(orderId: String)   |
          | + processPayment(orderId: String) |
          | + shipOrder(orderId: String)      |
          +-----------------------------------+
          ```

## Running the Application

To run the application, use the following command:

```bash
mvn spring-boot:run
