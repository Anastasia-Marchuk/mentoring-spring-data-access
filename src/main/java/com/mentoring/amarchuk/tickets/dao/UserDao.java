package com.mentoring.amarchuk.tickets.dao;

import com.mentoring.amarchuk.tickets.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;


public interface UserDao extends JpaRepository<User, Long> {

    List<User> findByName(String name);

    User findByEmail(String email);

    User deleteUserById(long id);
}
