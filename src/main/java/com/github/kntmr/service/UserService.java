package com.github.kntmr.service;

import com.github.kntmr.dao.UserDao;
import com.github.kntmr.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Component
@Transactional
public class UserService {

    @Autowired
    private UserDao userDao;

    public List<User> findAll() {
        return userDao.findAll();
    }

    public User find(long id) {
        return userDao.find(id);
    }

    public User insert(User user) {
        long id = userDao.insert(user);
        return userDao.find(id);
    }

    public User update(long id, User user) {
        user.setId(id);
        userDao.update(user);
        return userDao.find(id);
    }

    public int delete(long id) {
        return userDao.delete(id);
    }

}
