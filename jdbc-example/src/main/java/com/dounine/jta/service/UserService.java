package com.dounine.jta.service;

import com.dounine.jta.dao.IUserDao;
import com.dounine.jta.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by huanghuanlai on 2016/11/14.
 */
@Service
public class UserService implements IUserService{

    @Autowired
    protected IUserDao userDao;

    @Override
    public void register(User user) throws Exception {
        userDao.save(user);
    }

    @Transactional(rollbackFor = Exception.class)
    public void login(User user) throws Exception {
        userDao.saveLoginInfo(user);
        if(true){
            throw new Exception("尝试抛出的异常，看回滚情况");
        }
        userDao.saveLoginLog(user);
    }
}
