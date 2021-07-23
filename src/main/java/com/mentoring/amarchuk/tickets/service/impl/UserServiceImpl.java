package com.mentoring.amarchuk.tickets.service.impl;


import com.mentoring.amarchuk.tickets.dao.UserAccountDao;
import com.mentoring.amarchuk.tickets.dao.UserDao;
import com.mentoring.amarchuk.tickets.model.User;
import com.mentoring.amarchuk.tickets.model.UserAccount;
import com.mentoring.amarchuk.tickets.service.UserService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;



@Service
@Transactional(readOnly = true)
public class UserServiceImpl implements UserService {

    private final UserDao userDao;

    private final UserAccountDao userAccountDao;

    public UserServiceImpl(UserDao userDao, UserAccountDao userAccountDao) {
        this.userDao = userDao;
        this.userAccountDao = userAccountDao;
    }

    @Override
    public User getUserById(long userId) {
        return userDao.findById(userId).get();
    }

    @Override
    public User getUserByEmail(String email) {
        return userDao.findByEmail(email);
    }

    @Override
    public List<User> getUsersByName(String name, int pageSize, int pageNum) {
        return userDao.findByName(name);
    }

    @Override
    @Transactional
    public User createUser(User user) {
        if (!user.getName().matches("[a-zA-Z]+")){
            throw new IllegalStateException("Name can contain only letters");
        }
        User save = userDao.save(user);
        UserAccount userAccount = new UserAccount();
        userAccount.setId(save.getId());
        userAccount.setPrepayment(0.0);
        userAccount.setUser(save);
        userAccountDao.save(userAccount);
        return save;
    }

    @Override
    @Transactional
    public User updateUser(User user) {
        if (!user.getName().matches("[a-zA-Z]+")){
            throw new IllegalStateException("Name can contain only letters");
        }
        User userUpdated=userDao.save(user);
        if(userUpdated==null){
            throw new NullPointerException("Error updating user "+user);
        }
        return userUpdated;
    }

    @Override
    @Transactional
    public void deleteUser(long userId) {
        userDao.deleteById(userId);
    }

    @Override
    public List<User> getAllUsers() {
        return userDao.findAll();
    }

    @Override
    public double findBalanceByUserId(long userId) {
        return userAccountDao.findPrepaymentById(userId);
    }

    @Override
    public void spendCash(int id, String cash)  {
        Optional<UserAccount> byId = userAccountDao.findById((long) id);
        if (byId.isPresent()) {
            UserAccount userAccount = byId.get();
            Double prepayment = userAccount.getPrepayment();
            if(prepayment-Double.parseDouble(cash)<0){
                throw new IllegalStateException ("You do not have enough money");
            }
            prepayment -= Double.parseDouble(cash);
            userAccount.setPrepayment(prepayment);
            userAccountDao.save(userAccount);
        }
    }

    @Override
    public void addMoney(int id, String add) {
        Optional<UserAccount> byId = userAccountDao.findById((long) id);
        if (byId.isPresent()) {
            UserAccount userAccount = byId.get();
            Double prepayment = userAccount.getPrepayment();
            if (prepayment == null) {
                prepayment = Double.parseDouble(add);
                userAccount.setPrepayment(prepayment);
                userAccountDao.save(userAccount);
                return;
            }
            prepayment += Double.parseDouble(add);
            userAccount.setPrepayment(prepayment);
            userAccountDao.save(userAccount);
        }
    }

    @Override
    public List<UserAccount> findAllPrepayment() {
        return userAccountDao.findAll();
    }
}
