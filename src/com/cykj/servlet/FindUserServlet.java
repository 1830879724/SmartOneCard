package com.cykj.servlet;



import com.cykj.bean.PageBean;
import com.cykj.bean.PersonTb;
import com.cykj.service.FindUserService;
import com.cykj.utils.ObjectFactory;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;


@WebServlet("/findUserServlet")
public class FindUserServlet extends HttpServlet {
    private FindUserService findUserService = (FindUserService) ObjectFactory.getObject("com.cykj.service.impl.FindUserServiceImpl");
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String pname = request.getParameter("PNAME");
        String psection = request.getParameter("PSECTION");
        String prole = request.getParameter("PROLE");
        String pstate = request.getParameter("PSTATE");
        String paccount = request.getParameter("PACCOUNT");


        HashMap<String,Object> condition=new HashMap<>();
        String curPageStrr = request.getParameter("curPage");
        Integer curPage;
        if(curPageStrr==null)
        {
            curPage=1;
        }else{
            curPage=Integer.parseInt(curPageStrr);
        }
        if(pname!=null&&!"".equals(pname)){
            condition.put("pname",pname);
        }if(prole!=null&&!"".equals(prole)){
            condition.put("prole",prole);
        }if(pstate!=null&&!"".equals(pstate)){
            condition.put("pstate",pstate);
        }if(psection!=null&&!"".equals(psection)){
            condition.put("psection",psection);
        }if(paccount!=null&&!"".equals(paccount)){
            condition.put("paccount",paccount);
        }

        PageBean<PersonTb> pageBean = findUserService.findAll(condition,curPage,5);

        request.setAttribute("pageBean",pageBean);
        request.setAttribute("PNAME",pname);
        request.setAttribute("PROLE",prole);
        request.setAttribute("PSTATE",pstate);
        request.setAttribute("PACCOUNT",paccount);
        request.getRequestDispatcher("/jsp/PeopleManagement.jsp").forward(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
