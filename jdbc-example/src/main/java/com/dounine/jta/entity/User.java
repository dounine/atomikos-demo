package com.dounine.jta.entity;

import java.io.Serializable;

/**
 * Created by huanghuanlai on 2016/11/14.
 */
public class User implements Serializable {

    private Integer id;
    private String username;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
}
