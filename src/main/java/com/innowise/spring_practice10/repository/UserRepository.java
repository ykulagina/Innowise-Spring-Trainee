package com.innowise.spring_practice10.repository;

import com.innowise.spring_practice10.model.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User, Long> {
    User findByUsername(String username);
}
