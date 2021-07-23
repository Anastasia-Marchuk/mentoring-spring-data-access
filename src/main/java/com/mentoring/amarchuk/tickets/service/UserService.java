package com.mentoring.amarchuk.tickets.service;

import com.mentoring.amarchuk.tickets.model.User;
import com.mentoring.amarchuk.tickets.model.UserAccount;

import java.util.List;

public interface UserService {

    /**
     * Gets user by its id.
     *
     * @return User.
     */
    User getUserById(long userId);

    /**
     * Gets user by its email. Email is strictly matched.
     *
     * @return User.
     */
    User getUserByEmail(String email);

    /**
     * Get list of users by matching name. Name is matched using 'contains' approach.
     * In case nothing was found, empty list is returned.
     *
     * @param name     Users name or it's part.
     * @param pageSize Pagination param. Number of users to return on a page.
     * @param pageNum  Pagination param. Number of the page to return. Starts from 1.
     * @return List of users.
     */
    List<User> getUsersByName(String name, int pageSize, int pageNum);

    /**
     * Creates new user. User id should be auto-generated.
     *
     * @param user User data.
     * @return Created User object.
     */
    User createUser(User user);

    /**
     * Updates user using given data.
     *
     * @param user User data for update. Should have id set.
     * @return Updated User object.
     */
    User updateUser(User user);

    /**
     * Deletes user by its id.
     *
     * @param userId User id.
     */
    void deleteUser(long userId);

    /**
     * Get all users
     *
     * @return all users
     */
    List<User> getAllUsers();

    List<UserAccount> findAllPrepayment();

    double findBalanceByUserId(long userId);

    void spendCash(int id, String cash) throws Exception;

    void addMoney(int id, String add);
}
