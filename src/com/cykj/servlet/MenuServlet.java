package com.cykj.servlet;

import com.cykj.bean.MenuToal;
import com.cykj.bean.PersonTb;
import com.cykj.service.MenuService;
import com.cykj.utils.ObjectFactory;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;
import java.util.Map;


@WebServlet("/menuServlet")
public class MenuServlet extends BaseServlet {

    private MenuService menuService = (MenuService) ObjectFactory.getObject("com.cykj.service.impl.MenuServiceImpl");

    public void findMenuByRole(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("进入菜单");

        PersonTb personTb = (PersonTb) request.getSession().getAttribute("personTb");

        Map<String, List<MenuToal>> menuMap = menuService.findMenuByRole(personTb.getProle(),0);
        request.setAttribute("menuMap",menuMap);
        request.getRequestDispatcher("jsp/Main_Page.jsp").forward(request,response);

//        return "jsp/Main_Page.jsp";
    }


}
