package com.demo.firt.dao;

import com.demo.firt.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 *  接口实现JpaRepository中的方法
 */
public interface UserDao extends JpaRepository<User,Integer>{

    //默认接口中没有的方法,根据用户名查询
    public User getByUsername(String username);

    /**
     * 模糊查询的接口
     */
    public List<User> getByUsernameLike(String str);
}
