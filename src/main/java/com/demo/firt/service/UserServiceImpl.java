package com.demo.firt.service;

import com.demo.firt.dao.UserDao;
import com.demo.firt.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 *
 * 实现接口service中的方法
 */
@Service("userService")
public class UserServiceImpl implements UserService{

    @Autowired
    private UserDao userdao;

    @Override
    public void add(User user) {
        userdao.save(user);
    }

    @Override
    public void delete(int id) {
        userdao.deleteById(id);
    }

    @Override
    public void update(User user) {
        userdao.saveAndFlush(user);
    }

    @Override
    public User get(int id) {
        return userdao.findById(id).get();
    }

    @Override
    public List<User> getAllUsers() {
        return userdao.findAll();
    }


    @Transactional
    @Override
    public User login(User user) {
        //根据用户名查询数据库是否存在对应的用户记录
        User user1 = userdao.getByUsername(user.getUsername());
        if(user1 == null){
            return null;
        }
        //再次判断密码是否正确
        if(!user1.getPassword().equals(user.getPassword())){
            return null;
        }
        return user1;
    }

    @Override
    public List<User> getByUsernameLike(String str) {
        return userdao.getByUsernameLike(str);
    }

}
