package com.dounine.jta.service;

import com.dounine.jta.entity.User;

/**
 * Created by huanghuanlai on 2016/11/15.
 */
public interface IUserService {

    void register(User user) throws Exception;

    void login(User user) throws Exception;

}
