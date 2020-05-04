package com.lin.mapper.impl;

import com.lin.mapper.UserMapper;
import com.lin.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class UserDao implements UserMapper {

    @Autowired
    private UserMapper userMapper;

    @Override
    public List<User> findAll() {
        return userMapper.findAll();
    }

    @Override
    public Long count() {
        return userMapper.count();
    }

    @Override
    public User findByNo(int uno) {
        return userMapper.findByNo(uno);
    }

    @Override
    public int addUser(User user) {
        return userMapper.addUser(user);
    }

    @Override
    public boolean update(User user) {
        return userMapper.update(user);
    }

    @Override
    public boolean removeUser(int uno) {
        return userMapper.removeUser(uno);
    }
}
