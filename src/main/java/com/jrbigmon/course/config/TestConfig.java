package com.jrbigmon.course.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.jrbigmon.course.entities.User;
import com.jrbigmon.course.repositories.IUserRepository;
import java.util.ArrayList;
import java.util.List;

@Configuration
@Profile("test")
public class TestConfig implements CommandLineRunner {
  
  @Autowired
  private IUserRepository userRepository;

  @Override
  public void run(String... args) throws Exception {
    List<User> users = new ArrayList<>();
    
    users.add(new User("Vagner", "vagner@mail.com", "11321123321", "123456"));
    users.add(new User("aretha", "aretha@mail.com", "11321123123", "321654"));

    this.userRepository.saveAll(users);
  }
}
