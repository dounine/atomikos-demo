package com.dounine.jta.dao;

import com.dounine.jta.entity.User;

/**
 * Created by huanghuanlai on 2016/11/15.
 */
public interface IUserDao {

    void save(User user) throws Exception;

    void saveLoginLog(User user) throws Exception;

    void saveLoginInfo(User user) throws Exception;

}
