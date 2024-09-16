package com.jrbigmon.course.resources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.jrbigmon.course.entities.User;
import com.jrbigmon.course.services.UserService;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.net.URI;

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

  @PostMapping
  public ResponseEntity<User> insert(@RequestBody User entity) {
    entity = this.service.insert(entity);

    URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(entity.getId()).toUri();

    return ResponseEntity.created(uri).body(entity);
  }

  @DeleteMapping(value ="/{id}")
  public ResponseEntity<Void> deleteById(@PathVariable String id) {
    this.service.delete(id);

    return ResponseEntity.noContent().build();
  }
}
