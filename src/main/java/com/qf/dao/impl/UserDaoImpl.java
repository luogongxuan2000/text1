package com.qf.dao.impl;

import com.qf.dao.UserDao;
import com.qf.pojo.User;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UserDaoImpl implements UserDao {
    ResultSet resultSet = null;
    Connection connection = null;
    Statement statement = null;
    PreparedStatement ps = null;
    @Override
    public List<User> selectAll() {
        try {
            //1.加载驱动
            Class.forName("com.mysql.jdbc.Driver");
            //创建 连接
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/mishop?characterEncoding=utf8", "root", "root");
            //创建连接对象
            statement = connection.createStatement();
            //sql的编写
            String sql = "select * from user where 1=1";
            //执行sql
            resultSet = statement.executeQuery(sql);
            //声明返回的list
            List userlist = new ArrayList();
            //解析返回值

            while (resultSet.next()){
                User user = new User();
                user.setU_id(resultSet.getInt("u_id"));
                user.setU_name(resultSet.getString("u_name"));
                user.setU_email(resultSet.getString("u_email"));
                user.setU_pass(resultSet.getString("u_pass"));
                user.setU_gender(resultSet.getString("u_gender"));
                userlist.add(user);
            }
            return userlist;
        } catch (Exception e) {
            e.printStackTrace();
        }finally{
            try {
                resultSet.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }

            try {
                statement.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }

            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return null;
    }

    @Override
    public User selectOne(int id) {

        try {
            Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/mishop?characterEncoding=utf8", "root", "root");
            statement = connection.createStatement();
            String sql = "select * from user where u_id="+id;
            resultSet = statement.executeQuery(sql);
            User user = new User();
            while (resultSet.next()){
                user.setU_id(resultSet.getInt("u_id"));
                user.setU_name(resultSet.getString("u_name"));
                user.setU_email(resultSet.getString("u_email"));
                user.setU_pass(resultSet.getString("u_pass"));
                user.setU_gender(resultSet.getString("u_gender"));
            }
            return user;
        } catch (Exception e) {
            e.printStackTrace();
        }finally{
            try {
                resultSet.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }

            try {
                statement.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }

            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return null;
    }

    @Override
    public boolean update(User user) {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/mishop?characterEncoding=utf8", "root", "root");
            String sql = "update user set u_name=?,u_email=?,u_pass=?,u_gender=? where u_id=?";
            ps = connection.prepareStatement(sql);
            ps.setObject(1,user.getU_name());
            ps.setObject(2,user.getU_email());
            ps.setObject(3,user.getU_pass());
            ps.setObject(4,user.getU_gender());
            ps.setObject(5,user.getU_id());
            int i = ps.executeUpdate();
            if (i>0){
                return true;
            }else {
                return false;
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            try {
                ps.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return false;
    }

    @Override
    public int del(int id) {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/mishop?characterEncoding=utf8", "root", "root");
            statement = connection.createStatement();
            String sql="delete from user where u_id="+id;
            int res = statement.executeUpdate(sql);
            return res;//1 , 0
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }finally{
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
            try {
                statement.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return 0;
    }

    @Override
    public int add(User user) {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/mishop?characterEncoding=utf8", "root", "root");
            String sql = "insert into user values (null ,?,?,?,?)";
            ps = connection.prepareStatement(sql);
            ps.setObject(1,user.getU_name());
            ps.setObject(2,user.getU_email());
            ps.setObject(3,user.getU_pass());
            ps.setObject(4,user.getU_gender());
            int res = ps.executeUpdate();
            return res;

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
            try {
                ps.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        return 0;
    }
}
