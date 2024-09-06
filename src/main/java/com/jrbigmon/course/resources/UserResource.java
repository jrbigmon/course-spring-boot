package com.jrbigmon.course.resources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jrbigmon.course.entities.User;
import com.jrbigmon.course.services.UserService;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@RestController
@RequestMapping(value = "/users")
public class UserResource {

  @Autowired
  private UserService service;

  @GetMapping
  public ResponseEntity<List<User>> findAll() {

    List<User> results = this.service.findAll();

    return ResponseEntity.ok().body(results);
  }

  @GetMapping(value = "/{id}")
  public ResponseEntity<User> findById(@PathVariable String id) {
    User user = this.service.findById(id);

    return ResponseEntity.ok().body(user);
  }
}
