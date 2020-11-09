package com.qf.dao;

import com.qf.pojo.User;

import java.util.List;

public interface UserDao {
    //查询所有
    List<User> selectAll();
    //查单个
    User selectOne(int id);
    //修改
    boolean update(User user);
    //删除
    int del(int id);
    //新增
    int add(User user);
}
