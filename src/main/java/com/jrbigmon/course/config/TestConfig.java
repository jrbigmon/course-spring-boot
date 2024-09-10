package com.jrbigmon.course.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.jrbigmon.course.entities.Category;
import com.jrbigmon.course.entities.Order;
import com.jrbigmon.course.entities.Product;
import com.jrbigmon.course.entities.User;
import com.jrbigmon.course.entities.enums.OrderStatus;
import com.jrbigmon.course.repositories.ICategoryRepository;
import com.jrbigmon.course.repositories.IOrderRepository;
import com.jrbigmon.course.repositories.IProductRepository;
import com.jrbigmon.course.repositories.IUserRepository;

import java.util.ArrayList;
import java.util.List;
import java.time.Instant;


@Configuration
@Profile("test")
public class TestConfig implements CommandLineRunner {

  @Autowired
  private IUserRepository userRepository;

  @Autowired
  private IOrderRepository orderRepository;

  @Autowired
  private ICategoryRepository categoryRepository;

  @Autowired
  private IProductRepository productRepository;

  @Override
  public void run(String... args) throws Exception {
    List<User> users = new ArrayList<>();
    List<Order> orders = new ArrayList<>();
    List<Category> categories = new ArrayList<>();
    List<Product> products = new ArrayList<>();

    User user1 = new User("Vagner", "vagner@mail.com", "11321123321", "123456");
    User user2 = new User("aretha", "aretha@mail.com", "11321123123", "321654");

    users.add(user1);
    users.add(user2);

    Order order1 = new Order(Instant.parse("2024-09-06T21:00:00Z"), user1, OrderStatus.PAID);
    Order order2 = new Order(Instant.parse("2024-09-07T10:00:00Z"), user2, OrderStatus.WAITING_PAYMENT);

    orders.add(order1);
    orders.add(order2);

    Category category1 = new Category("Electronics");
    Category category2 = new Category("Sports");

    categories.add(category1);
    categories.add(category2);

    Product product1 = new Product("Xbox", "loren ipsuem", 2000.00, "https://www.Xbox.com");
    Product product2 = new Product("Shirt", "loren ipsuem", 150.00, "https://www.sports.shirts.com");

    products.add(product1);
    products.add(product2);

    this.userRepository.saveAll(users);
    this.orderRepository.saveAll(orders);
    this.categoryRepository.saveAll(categories);
    this.productRepository.saveAll(products);
  }
}
