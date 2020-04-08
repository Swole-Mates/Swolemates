package com.codeup.swolemates.repositories;

import com.codeup.swolemates.models.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserRepo extends JpaRepository<User, Long> {
    User findByUsername(String username);

    User findUserByUsername(String name);

    User findUserById(Long otherUserId);

    List<User> findAll();

}
