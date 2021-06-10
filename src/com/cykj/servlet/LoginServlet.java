package com.cykj.servlet;

import com.cykj.bean.PersonTb;
import com.cykj.service.LoginService;
import com.cykj.utils.DBHelper;
import com.cykj.utils.ObjectFactory;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.swing.*;
import java.io.IOException;
import java.sql.Connection;
import java.util.List;
import java.util.Map;

@WebServlet("/l")
public class LoginServlet extends BaseServlet {

    private LoginService loginService = (LoginService) ObjectFactory.getObject("com.cykj.service.impl.LoginServiceImpl");

    public void login(HttpServletRequest request, HttpServletResponse response) throws IOException {
        System.out.println("执行login的方法");

        String paccount = request.getParameter("paccount");
        System.out.println("paccount="+paccount);
        String ppassword = request.getParameter("ppassword");
        System.out.println("ppassword="+ppassword);
        String pname = request.getParameter("pname");
//        System.out.println("prole="+prole);
        String vCode = request.getParameter("vCode");
//        System.out.println("vCode="+vCode);


        String svCode = (String) request.getSession().getAttribute("vCode");
        System.out.println("svCode="+svCode);
        request.getSession().removeAttribute("vCode");
        if (vCode.equalsIgnoreCase(svCode)) {
            PersonTb personTb = loginService.login(paccount,ppassword);
//            System.out.println(personTb);
            if (personTb!=null) {
                request.getSession().setAttribute("personTb", personTb);
                response.getWriter().print("登录成功");
            }else {
                response.getWriter().print("登录失败");
            }
        }else {
            response.getWriter().write("验证码错误");
        }
    }


}