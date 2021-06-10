package com.cykj.servlet;


import com.cykj.bean.*;
import com.cykj.service.AdminService;
import com.cykj.utils.ObjectFactory;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;

@WebServlet("/adminServlet")
public class AdminServlet extends BaseServlet {

    private AdminService adminService = (AdminService) ObjectFactory.getObject("com.cykj.service.impl.AdminServiceImpl");
//入库删除
    public void deleuser(HttpServletRequest request, HttpServletResponse response) throws IOException {

        String pname = request.getParameter("pname");
        String s = adminService.deleuser(pname);
        response.getWriter().print(s);
    }
//入库重置密码
    public void setpwd(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String pname = request.getParameter("pname");
        String s = adminService.setpwd(pname);
        response.getWriter().print(s);

    }
//人员管理的带条件查询
    public String chaxun(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {

        String curPageStr = request.getParameter("curPage");
        Integer curPage = curPageStr == null ? 1 : Integer.parseInt(curPageStr);
        Integer pageSize = 5;

        HashMap<String, Object> condition = new HashMap<>();
        String pname = request.getParameter("pname");
        String psection = request.getParameter("psection");
        String prole = request.getParameter("prole");
        String pstate = request.getParameter("pstate");

        if (pname != null && !"".equals(pname)) {
            condition.put("pname", pname);
        }
        if (prole != null && !"".equals(prole)) {
            condition.put("prole", prole);
        }
        if (pstate != null && !"".equals(pstate)) {
            condition.put("pstate", pstate);
        }
        if (psection != null && !"".equals(psection)) {
            condition.put("psection", psection);
        }

        PageBean<PersonTb> pageBean = adminService.chaxun(condition, curPage, pageSize);

        request.setAttribute("pageBean", pageBean);
        request.setAttribute("pname", pname);
        request.setAttribute("prole", prole);
        request.setAttribute("pstate", pstate);
        request.setAttribute("psection",psection);
        return "/jsp/PeopleManagement.jsp";


    }
//新增人员
    public void addpeople(HttpServletRequest request, HttpServletResponse response) throws IOException {

        String pname = request.getParameter("pname");
        String psection = request.getParameter("psection");
        String prole = request.getParameter("prole");
        String ppassword = request.getParameter("ppassword");

        String s = adminService.addpeople(pname,psection,prole,ppassword);
        response.getWriter().print(s);
    }
//修改人员
    public void setpeople(HttpServletRequest request, HttpServletResponse response) throws IOException {

        String psection = request.getParameter("psection");
        String prole = request.getParameter("prole");
        String paccount = request.getParameter("paccount");

        Boolean s = adminService.setpeople(psection,prole,paccount);
        if(s){
            response.getWriter().print("成功");
        }else {
            System.out.println("这是servlet的=" + s);
            response.getWriter().print("失败");
        }
    }

//卡入库
    public void cardinsert(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {

        String curPageStr = request.getParameter("curPage");
        Integer curPage = curPageStr == null ? 1 : Integer.parseInt(curPageStr);
        Integer pageSize = 5;

        String cid = request.getParameter("cid");
        String cradid = request.getParameter("cradid");
        String cdate = request.getParameter("cdate");
        String cstate = request.getParameter("cstate");

        HashMap<String, Object> condition = new HashMap<>();

        if(cid!=null&&!"".equals(cid)){
            condition.put("cid",cid);
        }if(cradid!=null&&!"".equals(cradid)){
            condition.put("cradid",cradid);
        }if(cdate!=null&&!"".equals(cdate)){
            condition.put("cdate",cdate);
        }if(cstate!=null&&!"".equals(cstate)){
            condition.put("cstate",cstate);
        }

        PageBean<CardStorage> pageBean = adminService.cardinsert(condition,curPage,pageSize);

        request.setAttribute("pageBean",pageBean);
        request.setAttribute("cid",cid);
        request.setAttribute("cradid",cradid);
        request.setAttribute("cdate",cdate);
        request.setAttribute("cstate",cstate);
        request.getRequestDispatcher("/jsp/CardStorage.jsp").forward(request,response);
    }
//卡注销
    public void cardcancel(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {

        String curPageStr = request.getParameter("curPage");
        Integer curPage = curPageStr == null ? 1 : Integer.parseInt(curPageStr);
        Integer pageSize = 5;

        String sid = request.getParameter("sid");
        String scardid = request.getParameter("scardid");
        String ssellp = request.getParameter("ssellp");
        String sstate = request.getParameter("sstate");

        HashMap<String, Object> condition = new HashMap<>();

        if(sid!=null&&!"".equals(sid)){
            condition.put("sid",sid);
        }if(scardid!=null&&!"".equals(scardid)){
            condition.put("scardid",scardid);
        }if(ssellp!=null&&!"".equals(ssellp)){
            condition.put("ssellp",ssellp);
        }if(sstate!=null&&!"".equals(sstate)){
            condition.put("sstate",sstate);
        }

        PageBean<SaleTb> pageBean = adminService.cardcancel(condition,curPage,pageSize);


        request.setAttribute("pageBean",pageBean);
        request.setAttribute("sid",sid);
        request.setAttribute("scardid",scardid);
        request.setAttribute("ssellp",ssellp);
        request.setAttribute("sstate",sstate);
        request.getRequestDispatcher("/jsp/CardCancel.jsp").forward(request,response);
    }

    //卡查询
    public void CardInquire(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {

        String curPageStr = request.getParameter("curPage");
        Integer curPage = curPageStr == null ? 1 : Integer.parseInt(curPageStr);
        Integer pageSize = 5;

        String sid = request.getParameter("sid");
        String scardid = request.getParameter("scardid");
        String ssellp = request.getParameter("ssellp");
        String sstate = request.getParameter("sstate");
        String aname = request.getParameter("aname");


        HashMap<String, Object> condition = new HashMap<>();

        if(sid!=null&&!"".equals(sid)){
            condition.put("sid",sid);
        }if(scardid!=null&&!"".equals(scardid)){
            condition.put("scardid",scardid);
        }if(ssellp!=null&&!"".equals(ssellp)){
            condition.put("ssellp",ssellp);
        }if(sstate!=null&&!"".equals(sstate)){
            condition.put("sstate",sstate);
        }if(aname!=null&&!"".equals(aname)){
            condition.put("aname",aname);
        }

        PageBean<SaleTb> pageBean = adminService.CardInquire(condition,curPage,pageSize);


        request.setAttribute("pageBean",pageBean);
        request.setAttribute("sid",sid);
        request.setAttribute("scardid",scardid);
        request.setAttribute("ssellp",ssellp);
        request.setAttribute("sstate",sstate);
        request.setAttribute("aname",aname);
        request.getRequestDispatcher("/jsp/CardInquire.jsp").forward(request,response);
    }

    //领卡审批
    public void CardGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {

        String curPageStr = request.getParameter("curPage");
        Integer curPage = curPageStr == null ? 1 : Integer.parseInt(curPageStr);
        Integer pageSize = 5;

        String adate = request.getParameter("adate");
        String apeople = request.getParameter("apeople");
        String anum = request.getParameter("anum");
        String aauditdate = request.getParameter("aauditdate");
        String astate = request.getParameter("astate");

        HashMap<String, Object> condition = new HashMap<>();

        if (adate != null && !"".equals(adate)) {
            condition.put("adate", adate);
        }
        if (apeople != null && !"".equals(apeople)) {
            condition.put("apeople", apeople);
        }
        if (anum != null && !"".equals(anum)) {
            condition.put("anum", anum);
        }
        if (aauditdate != null && !"".equals(aauditdate)) {
            condition.put("aauditdate", aauditdate);
        }
        if (astate != null && !"".equals(astate)) {
            condition.put("astate", astate);
        }

        PageBean<ApplyTb> pageBean = adminService.CardGet(condition,curPage,pageSize);


        request.setAttribute("pageBean",pageBean);
        request.setAttribute("adate",adate);
        request.setAttribute("apeople",apeople);
        request.setAttribute("anum",anum);
        request.setAttribute("aauditdate",aauditdate);
        request.setAttribute("astate",astate);
        request.getRequestDispatcher("/jsp/CardGet.jsp").forward(request,response);
    }

    //卡入库的查询
    public String insertcx(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {

        String curPageStr = request.getParameter("curPage");
        Integer curPage = curPageStr == null ? 1 : Integer.parseInt(curPageStr);
        Integer pageSize = 5;

        String cid = request.getParameter("cid");
        String cradid1 = request.getParameter("cradid1");
        String cradid2 = request.getParameter("cradid2");
        String cdate1 = request.getParameter("cdate1");
        String cdate2 = request.getParameter("cdate2");
        String cstate = request.getParameter("cstate");

        HashMap<String, Object> condition = new HashMap<>();

        if (cid != null && !"".equals(cid)) {
            condition.put("cid", cid);
        }
        if (cradid1 != null && !"".equals(cradid1)) {
            condition.put("cradid1", cradid1);
        }
        if (cradid2 != null && !"".equals(cradid2)) {
            condition.put("cradid2", cradid2);
        }
        if (cdate1 != null && !"".equals(cdate1)) {
            condition.put("cdate1", cdate1);
        }
        if (cdate2 != null && !"".equals(cdate2)) {
            condition.put("cdate2", cdate2);
        }
        if (cstate != null && !"".equals(cstate)) {
            condition.put("cstate", cstate);
        }

        PageBean<CardStorage> pageBean = adminService.insertcx(condition, curPage, pageSize);

        request.setAttribute("pageBean", pageBean);
        request.setAttribute("cid", cid);
        request.setAttribute("cradid1", cradid1);
        request.setAttribute("cradid2", cradid2);
        request.setAttribute("cdate1", cdate1);
        request.setAttribute("cdate2", cdate2);
        request.setAttribute("cstate", cstate);
        return "/jsp/CardStorage.jsp";
    }

//卡注销的查询功能
    public String cardcancelcx(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {

        String curPageStr = request.getParameter("curPage");
        Integer curPage = curPageStr == null ? 1 : Integer.parseInt(curPageStr);
        Integer pageSize = 5;

        String sid = request.getParameter("sid");
        String scardid1 = request.getParameter("scardid1");
        String scardid2 = request.getParameter("scardid2");
        String sstate = request.getParameter("sstate");


        HashMap<String, Object> condition = new HashMap<>();

        if (sid != null && !"".equals(sid)) {
            condition.put("sid", sid);
        }
        if (scardid1 != null && !"".equals(scardid1)) {
            condition.put("scardid1", scardid1);
        }
        if (scardid2 != null && !"".equals(scardid2)) {
            condition.put("scardid2", scardid2);
        }
        if (sstate != null && !"".equals(sstate)) {
            condition.put("sstate", sstate);
        }

        PageBean<SaleTb> pageBean = adminService.cardcancelcx(condition, curPage, pageSize);

        request.setAttribute("pageBean", pageBean);
        request.setAttribute("sid", sid);
        request.setAttribute("scardid1", scardid1);
        request.setAttribute("scardid2", scardid2);
        request.setAttribute("sstate", sstate);
        return "/jsp/CardCancel.jsp";
    }


    //卡查询的带条件查询功能
    public String CardInquirecx(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {

        String curPageStr = request.getParameter("curPage");
        Integer curPage = curPageStr == null ? 1 : Integer.parseInt(curPageStr);
        Integer pageSize = 5;

        String scardid = request.getParameter("scardid");
        String sstate = request.getParameter("sstate");
        String ssellp = request.getParameter("ssellp");
        String aname = request.getParameter("aname");


        HashMap<String, Object> condition = new HashMap<>();

        if (scardid != null && !"".equals(scardid)) {
            condition.put("scardid", scardid);
        }
        if (sstate != null && !"".equals(sstate)) {
            condition.put("sstate", sstate);
        }
        if (ssellp != null && !"".equals(ssellp)) {
            condition.put("ssellp", ssellp);
        }
        if (aname != null && !"".equals(aname)) {
            condition.put("aname", aname);
        }

        PageBean<SaleTb> pageBean = adminService.CardInquirecx(condition, curPage, pageSize);

        request.setAttribute("pageBean", pageBean);
        request.setAttribute("scardid", scardid);
        request.setAttribute("sstate", sstate);
        request.setAttribute("ssellp", ssellp);
        request.setAttribute("aname", aname);
        return "/jsp/CardInquire.jsp";
    }

    //领卡审批的带条件查询功能
    public String CardGetcx(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {

        String curPageStr = request.getParameter("curPage");
        Integer curPage = curPageStr == null ? 1 : Integer.parseInt(curPageStr);
        Integer pageSize = 5;

        String adate1 = request.getParameter("adate1");
        String adate2 = request.getParameter("adate2");
        String apeople = request.getParameter("apeople");
        String anum = request.getParameter("anum");
        String aauditdate = request.getParameter("aauditdate");
        String astate = request.getParameter("astate");

        HashMap<String, Object> condition = new HashMap<>();

        if (adate1 != null && !"".equals(adate1)) {
            condition.put("adate1", adate1);
        }
        if (adate2 != null && !"".equals(adate2)) {
            condition.put("adate2", adate2);
        }
        if (apeople != null && !"".equals(apeople)) {
            condition.put("apeople", apeople);
        }
        if (anum != null && !"".equals(anum)) {
            condition.put("anum", anum);
        }
        if (aauditdate != null && !"".equals(aauditdate)) {
            condition.put("aauditdate", aauditdate);
        }
        if (astate != null && !"".equals(astate)) {
            condition.put("astate", astate);
        }

        PageBean<ApplyTb> pageBean = adminService.CardGetcx(condition,curPage,pageSize);


        request.setAttribute("pageBean",pageBean);
        request.setAttribute("adate1",adate1);
        request.setAttribute("adate2",adate2);
        request.setAttribute("apeople",apeople);
        request.setAttribute("anum",anum);
        request.setAttribute("aauditdate",aauditdate);
        request.setAttribute("astate",astate);
        return "/jsp/CardGet.jsp";
    }


    //领卡
    public void CardGets(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {

        String curPageStr = request.getParameter("curPage");
        Integer curPage = curPageStr == null ? 1 : Integer.parseInt(curPageStr);
        Integer pageSize = 5;

        String adate = request.getParameter("adate");
        String apeople = request.getParameter("apeople");
        String anum = request.getParameter("anum");
        String aauditdate = request.getParameter("aauditdate");
        String astate = request.getParameter("astate");
        String adate1 = request.getParameter("adate1");
        String adate2 = request.getParameter("adate2");

        HashMap<String, Object> condition = new HashMap<>();

        if (adate1 != null && !"".equals(adate1)) {
            condition.put("adate1", adate1);
        }
        if (adate2 != null && !"".equals(adate2)) {
            condition.put("adate2", adate2);
        }
        if (adate != null && !"".equals(adate)) {
            condition.put("adate", adate);
        }
        if (apeople != null && !"".equals(apeople)) {
            condition.put("apeople", apeople);
        }
        if (anum != null && !"".equals(anum)) {
            condition.put("anum", anum);
        }
        if (aauditdate != null && !"".equals(aauditdate)) {
            condition.put("aauditdate", aauditdate);
        }
        if (astate != null && !"".equals(astate)) {
            condition.put("astate", astate);
        }

        PageBean<ApplyTb> pageBean = adminService.CardGets(condition,curPage,pageSize);


        request.setAttribute("pageBean",pageBean);
        request.setAttribute("adate",adate);
        request.setAttribute("apeople",apeople);
        request.setAttribute("anum",anum);
        request.setAttribute("aauditdate",aauditdate);
        request.setAttribute("astate",astate);
        request.setAttribute("adate1",adate1);
        request.setAttribute("adate2",adate2);
        request.getRequestDispatcher("/jsp/CardGets.jsp").forward(request,response);
    }
}