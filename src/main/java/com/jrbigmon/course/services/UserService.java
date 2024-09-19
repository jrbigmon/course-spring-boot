package com.jrbigmon.course.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.jrbigmon.course.entities.User;
import com.jrbigmon.course.repositories.IUserRepository;
import com.jrbigmon.course.services.exceptions.DatabaseException;
import com.jrbigmon.course.services.exceptions.ResourceNotFoundException;

import jakarta.persistence.EntityNotFoundException;

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

    return optional.orElseThrow(() -> new ResourceNotFoundException(id));
  }

  public User insert(User obj) {
    obj.genUUID();

    return userRepository.save(obj);
  }

  public void delete(String id) {
    try {
      userRepository.deleteById(id);
    } catch (EmptyResultDataAccessException e) {
      e.printStackTrace();
      throw new ResourceNotFoundException(id);
    } catch (DataIntegrityViolationException e) {
      e.printStackTrace();
      throw new DatabaseException(e.getMessage());
    }
  }

  public User update(String id, User obj) {
    try {
      User entity = this.userRepository.getReferenceById(id);
  
      this.updateData(entity, obj);
  
      return this.userRepository.save(entity);
    } catch (EntityNotFoundException e) {
      e.printStackTrace();
      throw new ResourceNotFoundException(id);
    }
  }

  private void updateData(User entity, User obj) {
    entity.setName(obj.getName() != null ? obj.getName() : entity.getName());
    entity.setEmail(obj.getEmail() != null ? obj.getEmail() : entity.getEmail());
    entity.setPhone(obj.getPhone() != null ? obj.getPhone() : entity.getPhone());
  }
}
