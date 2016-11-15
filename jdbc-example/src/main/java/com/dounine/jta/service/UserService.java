package com.dounine.jta.service;

import com.dounine.jta.dao.IUserDao;
import com.dounine.jta.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by huanghuanlai on 2016/11/14.
 */
@Service
public class UserService implements IUserService{

    @Autowired
    protected IUserDao userDao;

    @Override
    public void register(User user) {
        try {
            userDao.save(user);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
