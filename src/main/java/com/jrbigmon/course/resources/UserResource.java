package com.jrbigmon.course.resources;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jrbigmon.course.entities.IUser;
import com.jrbigmon.course.entities.User;
import org.springframework.web.bind.annotation.GetMapping;


@RestController
@RequestMapping(value = "/users")
public class UserResource {

  @GetMapping
  public ResponseEntity<IUser> findAll() {
    IUser user = new User("1", "Vagner", "vagner.mail.com", "11956542095", "123321");

    return ResponseEntity.ok().body(user);
  }
}
