package com.qf.test;

import com.qf.dao.UserDao;
import com.qf.dao.impl.UserDaoImpl;
import com.qf.pojo.User;
import org.junit.Test;

import java.util.List;

public class UserTest {
    @Test
    public void test1(){
        UserDao userDao = new UserDaoImpl();
        User res = userDao.selectOne(1);
        System.out.println(res);
    }
}
