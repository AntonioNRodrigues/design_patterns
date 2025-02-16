# Spring Design Patterns Example

## Overview
This project is a demonstration of various design patterns implemented in a Spring Boot application. The application is a simplified e-commerce platform with basic functionalities like user management, product catalog, and order processing.

## Design Patterns
The following design patterns are implemented in this project:

### Creational Patterns
1. **Singleton**
    - **Location**: `com.example.designpatterns.config.SingletonConfig`
    - **Description**: Ensures a class has only one instance and provides a global point of access to it.
    - **Example**:
      ```java
      public class SingletonConfig {
          private static SingletonConfig instance;
 
          private SingletonConfig() {}
 
          public static SingletonConfig getInstance() {
              if (instance == null) {
                  instance = new SingletonConfig();
              }
              return instance;
          }
      }
      ```

2. **Builder**
    - **Location**: `com.example.designpatterns.model.ProductBuilder`
    - **Description**: Constructs complex objects step by step, allowing the creation process to be more flexible.
    - **Example**:
      ```java
      public class ProductBuilder {
          private String name;
          private double price;
          private String category;
 
          public ProductBuilder setName(String name) {
              this.name = name;
              return this;
          }
 
          public ProductBuilder setPrice(double price) {
              this.price = price;
              return this;
          }
 
          public ProductBuilder setCategory(String category) {
              this.category = category;
              return this;
          }
 
          public Product build() {
              return new Product(this);
          }
      }
      ```

3. **Factory Method**
    - **Location**: `com.example.designpatterns.factory.UserFactory`
    - **Description**: Defines an interface for creating an object but lets subclasses alter the type of object that will be created.
    - **Example**:
      ```java
      public abstract class UserFactory {
          public abstract User createUser(String type);
 
          public static UserFactory getFactory(String type) {
              if (type.equalsIgnoreCase("Admin")) {
                  return new AdminFactory();
              } else if (type.equalsIgnoreCase("Customer")) {
                  return new CustomerFactory();
              } else {
                  throw new IllegalArgumentException("Unknown type");
              }
          }
      }
 
      public class AdminFactory extends UserFactory {
          @Override
          public User createUser(String type) {
              return new AdminUser();
          }
      }
 
      public class CustomerFactory extends UserFactory {
          @Override
          public User createUser(String type) {
              return new CustomerUser();
          }
      }
      ```

4. **Abstract Factory**
    - **Location**: `com.example.designpatterns.factory.AbstractFactory`
    - **Description**: Provides an interface for creating families of related or dependent objects without specifying their concrete classes.
    - **Example**:
      ```java
      public interface ProductFactory {
          Product createProduct();
      }
 
      public class ElectronicsFactory implements ProductFactory {
          @Override
          public Product createProduct() {
              return new Electronics();
          }
      }
 
      public class FurnitureFactory implements ProductFactory {
          @Override
          public Product createProduct() {
              return new Furniture();
          }
      }
      ```

### Structural Patterns
5. **Adapter**
    - **Location**: `com.example.designpatterns.adapter.PaymentAdapter`
    - **Description**: Allows incompatible interfaces to work together by acting as a bridge.
    - **Example**:
      ```java
      public interface PaymentGateway {
          void processPayment(String amount);
      }
 
      public class PayPalPayment implements PaymentGateway {
          @Override
          public void processPayment(String amount) {
              System.out.println("Processing PayPal payment of " + amount);
          }
      }
 
      public class StripePayment {
          public void makePayment(String amount) {
              System.out.println("Processing Stripe payment of " + amount);
          }
      }
 
      public class StripePaymentAdapter implements PaymentGateway {
          private final StripePayment stripePayment;
 
          public StripePaymentAdapter(StripePayment stripePayment) {
              this.stripePayment = stripePayment;
          }
 
          @Override
          public void processPayment(String amount) {
              stripePayment.makePayment(amount);
          }
      }
      ```

6. **Composite**
    - **Location**: `com.example.designpatterns.model.CompositeProduct`
    - **Description**: Composes objects into tree structures to represent part-whole hierarchies, allowing individual objects and compositions to be treated uniformly.
    - **Example**:
      ```java
      public class CompositeProduct implements Product {
 
          private final List<Product> products = new ArrayList<>();
 
          public void addProduct(Product product) {
              products.add(product);
          }
 
          public void removeProduct(Product product) {
              products.remove(product);
          }
 
          @Override
          public double getPrice() {
              return products.stream().mapToDouble(Product::getPrice).sum();
          }
      }
      ```

7. **Decorator**
    - **Location**: `com.example.designpatterns.decorator.ProductDecorator`
    - **Description**: Adds behavior to objects dynamically, without affecting the behavior of other objects from the same class.
    - **Example**:
      ```java
      public interface Product {
          String getDescription();
          double getPrice();
      }
 
      public class BasicProduct implements Product {
          private final String description;
          private final double price;
 
          public BasicProduct(String description, double price) {
              this.description = description;
              this.price = price;
          }
 
          @Override
          public String getDescription() {
              return description;
          }
 
          @Override
          public double getPrice() {
              return price;
          }
      }
 
      public abstract class ProductDecorator implements Product {
          protected Product decoratedProduct;
 
          public ProductDecorator(Product decoratedProduct) {
              this.decoratedProduct = decoratedProduct;
          }
 
          public String getDescription() {
              return decoratedProduct.getDescription();
          }
 
          public double getPrice() {
              return decoratedProduct.getPrice();
          }
      }
 
      public class DiscountedProduct extends ProductDecorator {
          public DiscountedProduct(Product decoratedProduct) {
              super(decoratedProduct);
          }
 
          @Override
          public double getPrice() {
              return decoratedProduct.getPrice() * 0.9;
          }
      }
      ```

8. **Facade**
    - **Location**: `com.example.designpatterns.facade.OrderFacade`
    - **Description**: Provides a simplified interface to a complex subsystem, making it easier to use.
    - **Example**:
      ```java
      public class OrderFacade {
 
          private final InventoryService inventoryService;
          private final PaymentService paymentService;
          private final ShippingService shippingService;
 
          public OrderFacade() {
              this.inventoryService = new InventoryService();
              this.paymentService = new PaymentService();
              this.shippingService = new ShippingService();
          }
 
          public void placeOrder(String productId, double amount) {
              if (inventoryService.checkStock(productId)) {
                  paymentService.processPayment(amount);
                  shippingService.shipProduct(productId);
              }
          }
      }
      ```

### Behavioral Patterns
9. **Observer**
    - **Location**: `com.example.designpatterns.observer.OrderObserver`
    - **Description**: Defines a one-to-many dependency between objects so that when one object changes state, all its dependents are notified and updated automatically.
    - **Example**:
      ```java
      public interface Observer {
          void update(String eventType, String data);
      }
 
      public class OrderObserver implements Observer {
 
          @Override
          public void update(String eventType, String data) {
              System.out.println("OrderObserver: " + eventType + " - " + data);
          }
      }
 
      public class OrderSubject {
          private final List<Observer> observers = new ArrayList<>();
 
          public void registerObserver(Observer observer) {
              observers.add(observer);
          }
 
          public void unregisterObserver(Observer observer) {
              observers.remove(observer);
          }
 
          public void notifyObservers(String eventType, String data) {
              for (Observer observer : observers) {
                  observer.update(eventType, data);
              }
          }
      }
      ```

10. **Strategy**
    - **Location**: `com.example.designpatterns.strategy.PaymentStrategy`
    - **Description**: Defines a family of algorithms, encapsulates each one, and makes them interchangeable. The strategy pattern allows the algorithm to vary independently from clients that use it.
    - **Example**:
      ```java
      public interface PaymentStrategy {
          void pay(double amount);
      }

      public class CreditCardPayment implements PaymentStrategy {

          @Override
          public void pay(double amount) {
              System.out.println("Paid " + amount + " using Credit Card.");
          }
      }

      public class PayPalPayment implements PaymentStrategy {

          @Override
          public void pay(double amount) {
              System.out.println("Paid " + amount + " using PayPal.");
          }
      }

      public class ShoppingCart {
          private PaymentStrategy paymentStrategy;

          public void setPaymentStrategy(PaymentStrategy paymentStrategy) {
              this.paymentStrategy = paymentStrategy;
          }

          public void checkout(double amount) {
              paymentStrategy.pay(amount);
          }
      }
      ```

11. **Command**
    - **Location**: `com.example.designpatterns.command.OrderCommand`
    - **Description**: Encapsulates a request as an object, allowing parameterization of clients with different requests, queuing of requests, and logging of requests.
    - **Example**:
      ```java
      public interface Command {
          void execute();
      }

      public class OrderCommand implements Command {

          private final OrderService orderService;
          private final String orderId;

          public OrderCommand(OrderService orderService, String orderId) {
              this