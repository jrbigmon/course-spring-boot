package com.jrbigmon.course.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import com.jrbigmon.course.entities.User;

public interface IUserRepository extends JpaRepository<User, String> {

}
