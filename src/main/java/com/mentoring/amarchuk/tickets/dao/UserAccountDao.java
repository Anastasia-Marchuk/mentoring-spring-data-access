package com.mentoring.amarchuk.tickets.dao;

import com.mentoring.amarchuk.tickets.model.UserAccount;
import org.springframework.data.jpa.repository.JpaRepository;



public interface UserAccountDao extends JpaRepository<UserAccount, Long> {
    double findPrepaymentById(long userId);
}
