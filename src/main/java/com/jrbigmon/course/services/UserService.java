package com.jrbigmon.course.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jrbigmon.course.entities.User;
import com.jrbigmon.course.repositories.IUserRepository;
import java.util.List;
import java.util.Optional;

@Service
public class UserService {

  @Autowired
  private IUserRepository userRepository;

  public List<User> findAll() {
    return userRepository.findAll();
  }

  public User findById(String id) {
    Optional<User> optional = userRepository.findById(id);

    return optional.get();
  }

  public User insert(User obj) {
    obj.genUUID();

    return userRepository.save(obj);
  }
}
