package com.demo.firt.service;

import com.demo.firt.model.User;

import java.util.List;

/**
 * 设计方法
 */
public interface UserService {
    //增加用户
     void add(User user);

    //删除用户
     void delete(int id);

    //更新用户
     void update(User user);

    //查询用户
     User get(int id );

    //查询多个用户
     List<User> getAllUsers();

    User login(User user);

     List<User> getByUsernameLike(String str);
}
