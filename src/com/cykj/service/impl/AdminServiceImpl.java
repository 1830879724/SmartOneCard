package com.cykj.service.impl;

import com.cykj.bean.*;
import com.cykj.dao.AdminDao;
import com.cykj.dao.LoginDao;
import com.cykj.service.AdminService;
import com.cykj.utils.ObjectFactory;

import java.util.HashMap;
import java.util.List;

public class AdminServiceImpl implements AdminService {

    private AdminDao adminDao = (AdminDao) ObjectFactory.getObject("com.cykj.dao.impl.AdminDaoImpl");
//人员管理的删除用户
    @Override
    public String deleuser(String pname) {
        String s = adminDao.deleuser(pname);
        return s;
    }
//人员管理的重置密码
    @Override
    public String setpwd(String pname) {
        String s = adminDao.setpwd(pname);
        return s;
    }
//人员管理的查询
    @Override
    public PageBean<PersonTb> chaxun(HashMap<String, Object> condition, Integer curPage, Integer pageSize) {
        Integer totalpage = adminDao.getTotal(condition);
        PageBean<PersonTb> pageBean = new PageBean<>(curPage,totalpage,pageSize);
        List<PersonTb> personTbList = adminDao.chaxun(condition,curPage,pageSize);
        pageBean.setList(personTbList);
        return pageBean;

    }
//新增人员
    @Override
    public String addpeople(String pname, String psection, String prole, String ppassword) {
        String s = adminDao.addpeople(pname, psection, prole, ppassword);
        return s;
    }
//修改人员
    @Override
    public Boolean setpeople(String psection, String prole, String paccount) {
        Boolean s = adminDao.setpeople(psection, prole, paccount);
        return s;
    }
//卡入库
    @Override
    public PageBean<CardStorage> cardinsert(HashMap<String, Object> condition, Integer curPage, Integer pageSize) {
        Integer totalpage = adminDao.getTotalcard(condition);
        PageBean<CardStorage> pageBean = new PageBean<>(curPage,totalpage,pageSize);
        List<CardStorage> cardStorageList = adminDao.cardinsert(condition,curPage,pageSize);
        pageBean.setList(cardStorageList);
        return pageBean;
    }
//卡注销
    @Override
    public PageBean<SaleTb> cardcancel(HashMap<String, Object> condition, Integer curPage, Integer pageSize) {
        Integer totalpage = adminDao.getTotalcardcancel(condition);
        PageBean<SaleTb> pageBean = new PageBean<>(curPage,totalpage,pageSize);
        List<SaleTb> saleTbList = adminDao.cardcancel(condition,curPage,pageSize);
        pageBean.setList(saleTbList);
        return pageBean;
    }
//卡查询
    @Override
    public PageBean<SaleTb> CardInquire(HashMap<String, Object> condition, Integer curPage, Integer pageSize) {
        Integer totalpage = adminDao.getTotalCardInquire(condition);
        PageBean<SaleTb> pageBean = new PageBean<>(curPage,totalpage,pageSize);
        List<SaleTb> saleTbList = adminDao.CardInquire(condition,curPage,pageSize);
        pageBean.setList(saleTbList);
        return pageBean;
    }
//领卡审批
    @Override
    public PageBean<ApplyTb> CardGet(HashMap<String, Object> condition, Integer curPage, Integer pageSize) {
        Integer totalpage = adminDao.getTotalCardGet(condition);
        PageBean<ApplyTb> pageBean = new PageBean<>(curPage,totalpage,pageSize);
        List<ApplyTb> applyTbList = adminDao.CardGet(condition,curPage,pageSize);
        pageBean.setList(applyTbList);
        return pageBean;
    }
//卡入库的带条件查询
    @Override
    public PageBean<CardStorage> insertcx(HashMap<String, Object> condition, Integer curPage, Integer pageSize) {
        Integer totalpage = adminDao.getTotalinsertcx(condition);
        PageBean<CardStorage> pageBean = new PageBean<>(curPage,totalpage,pageSize);
        List<CardStorage> cardStorageList = adminDao.insertcx(condition,curPage,pageSize);
        pageBean.setList(cardStorageList);
        return pageBean;
    }
//卡注销的查询功能
    @Override
    public PageBean<SaleTb> cardcancelcx(HashMap<String, Object> condition, Integer curPage, Integer pageSize) {
        Integer totalpage = adminDao.getTotalcardcancelcx(condition);
        PageBean<SaleTb> pageBean = new PageBean<>(curPage,totalpage,pageSize);
        List<SaleTb> saleTbList = adminDao.cardcancelcx(condition,curPage,pageSize);
        pageBean.setList(saleTbList);
        return pageBean;
    }
//卡查询的带条件查询功能
    @Override
    public PageBean<SaleTb> CardInquirecx(HashMap<String, Object> condition, Integer curPage, Integer pageSize) {
        Integer totalpage = adminDao.getTotalCardInquirecx(condition);
        PageBean<SaleTb> pageBean = new PageBean<>(curPage,totalpage,pageSize);
        List<SaleTb> saleTbList = adminDao.CardInquirecx(condition,curPage,pageSize);
        pageBean.setList(saleTbList);
        return pageBean;
    }
//领卡审批的查询
    @Override
    public PageBean<ApplyTb> CardGetcx(HashMap<String, Object> condition, Integer curPage, Integer pageSize) {
        Integer totalpage = adminDao.getTotalCardGetcx(condition);
        PageBean<ApplyTb> pageBean = new PageBean<>(curPage,totalpage,pageSize);
        List<ApplyTb> applyTbList = adminDao.CardGetcx(condition,curPage,pageSize);
        pageBean.setList(applyTbList);
        return pageBean;
    }
//领卡
    @Override
    public PageBean<ApplyTb> CardGets(HashMap<String, Object> condition, Integer curPage, Integer pageSize) {
        Integer totalpage = adminDao.getTotalCardGets(condition);
        PageBean<ApplyTb> pageBean = new PageBean<>(curPage,totalpage,pageSize);
        List<ApplyTb> applyTbList = adminDao.CardGets(condition,curPage,pageSize);
        pageBean.setList(applyTbList);
        return pageBean;
    }


}
