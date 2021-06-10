package com.cykj.servlet;


import com.cykj.service.UpdateService;
import com.cykj.utils.ObjectFactory;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


@WebServlet("/updateServlet")
public class UpdateServlet extends HttpServlet {
    private UpdateService updateService= (UpdateService) ObjectFactory.getObject("com.cykj.service.impl.UpdateServiceImpl");
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(request.getInputStream(),"UTF-8"));
        String msg = bufferedReader.readLine();
        String pname = msg.split("&")[0];
        String pstate = msg.split("&")[1];

        Boolean flag = updateService.findUpdate(pname,pstate);
//        System.out.println(flag);
        if (flag==true){
            response.getWriter().print("修改成功");
        }else {
            response.getWriter().print("修改失败");
        }


    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
