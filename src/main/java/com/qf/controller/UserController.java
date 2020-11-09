package com.qf.controller;

import com.qf.dao.UserDao;
import com.qf.dao.impl.UserDaoImpl;
import com.qf.pojo.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/user")
public class UserController extends BaseController {

    UserDao udao = new UserDaoImpl();

    protected String noparam(HttpServletRequest req, HttpServletResponse resp){
        //查询所有用户
        List<User> all = udao.selectAll();
        //将数据设置到req中
        req.setAttribute("user",all);
        //设置跳转的页面
        return "hello";
    }

    protected String del(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String ids = req.getParameter("id");
        int id = Integer.valueOf(ids);
        int res = udao.del(id);
        if (res ==1){
            return noparam(req,resp);
        }
        return "err";
    }

    protected String update(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String ids = req.getParameter("id");
        Integer id = Integer.valueOf(ids);

        User res = udao.selectOne(id);
        req.setAttribute("user",res);

        return "update";
    }

    protected String subUpdate(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        //resp.setContentType("text/html;charset=UTF-8");

        String ids = req.getParameter("id");
        int id = Integer.valueOf(ids);
        String name = req.getParameter("name");

        String pass = req.getParameter("pass");
        String email = req.getParameter("email");
        String gender = req.getParameter("gender");
        name = new String(name.getBytes("iso-8859-1"),"utf-8");
        gender = new String(gender.getBytes("iso-8859-1"),"utf-8");



        User user = new User(id,name,email,pass,gender);
        boolean res = udao.update(user);
        if (res){
            return noparam(req,resp);
        }
        return "err";
    }

    protected String add(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String name = req.getParameter("name");
        String pass = req.getParameter("pass");
        String email = req.getParameter("email");
        String gender = req.getParameter("gender");
        User user = new User(name,email,pass,gender);
        int res = udao.add(user);
        if (res == 1){
            return noparam(req,resp);
        }
        return "err";
    }
}

